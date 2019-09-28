package com.jay.application.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jay.application.annotation.NoToken;
import com.jay.application.annotation.YesToken;
import com.jay.application.pojo.Users;
import com.jay.application.services.UsersService;

/**
 * token验证
 * @author jay
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
	
	@Autowired
	private UsersService usersService;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取token
        String token = request.getHeader("token");
        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(NoToken.class))
        {
        	NoToken noToken = method.getAnnotation(NoToken.class);
            if(noToken.required()){
                return true;
            }
        }
        String userId = null;
        if(method.isAnnotationPresent(YesToken.class))
        {
        	YesToken yesToken = method.getAnnotation(YesToken.class);
            if(yesToken.required()){
              if(token == null){
                  throw new RuntimeException("无token，请重新登录");
              }
              //获取token的userid
                try{
                    userId = JWT.decode(token).getAudience().get(0);
                }
                catch (JWTDecodeException e){
                    throw new RuntimeException("401");
                }
                Users user = usersService.getUsersById(Integer.valueOf(userId));
                if(null == user){
                    throw new RuntimeException("用户不存在");
                }
                //验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUserPassword())).build();
                try{
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    throw new RuntimeException("401");
                }
 
                return true;
            }
        }
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //方法处理之后但是并未渲染视图的时候进行的操作
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //渲染视图之后进行的操作
    }
}
