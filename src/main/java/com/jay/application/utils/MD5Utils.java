package com.jay.application.utils;

import java.security.MessageDigest;

/**
 * MD5加密算法
 * @author jay
 *
 */
public class MD5Utils {
	public final static String calc(String str) {
		String temp = str == null ? "" : str; // 如果为空，则返回 ""
		char hexDigists[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' }; // 字典
		try {
			byte[] strTemp = temp.getBytes(); // 获取二进制
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp); // 执行加密
			byte[] md = mdTemp.digest(); // 加密结果
			int j = md.length; // 结果长度
			char chars[] = new char[j * 2]; // 字符数组
			int k = 0;
			for (int i = 0; i < j; i++) { // 将二进制加密结果转化为字符
				byte byte0 = md[i];
				chars[k++] = hexDigists[byte0 >>> 4 & 0xf];
				chars[k++] = hexDigists[byte0 & 0xf];
			}
			return new String(chars);// 输出加密后的字符
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
