package com.java.advanced.features.md5.blogjava.amigoxie;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 *
 * @url	 	http://www.blogjava.net/amigoxie/archive/2014/06/01/414299.html
 * @auth 	Lian
 * @date 	2016/10/8
 * @since 	1.0
 */
public class MD5Util {

	/**
	 *     对MD5算法简要的叙述可以为：MD5以512位分组来处理输入的信息，且每一分组又被划分为16个32位子分组，
	 * 经过了一系列的处理后，算法的输出由四个32位分组组成，将这四个32位分组级联后将生成一个128位散列值。
	 *
	 *     在MD5算法中，首先需要对信息进行填充，使其位长对512求余的结果等于448。因此，信息的位长（Bits Length）将被扩展至N*512+448，N为一个非负整数，N可以是零。
	 * 填充的方法如下，在信息的后面填充一个1和无数个0，直到满足上面的条件时才停止用0对信息的填充。然后，在这个结果后面附加一个以64位二进制表示的填充前信息长度。
	 * 经过这两步的处理，信息的位长=N*512+448+64=(N+1）*512，即长度恰好是512的整数倍。这样做的原因是为满足后面处理中对信息长度的要求。
	 */

	/**
	 * MD5加密生成32位md5码
	 *
	 * @param inStr	待加密的字符串
	 * @return		返回32位md5码
	 * @throws UnsupportedEncodingException
	 */
	public static String md5Encode(String inStr) throws UnsupportedEncodingException {
		MessageDigest md5 = null;

		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}

		byte[] byteArr = inStr.getBytes("UTF-8");
		byte[] md5Bytes = md5.digest(byteArr);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0XFF;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * 测试主函数
	 *
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "amigoxiexiexingxing";
		System.out.println("before: " + str);
		System.out.println("after: " + md5Encode(str));
	}

}
