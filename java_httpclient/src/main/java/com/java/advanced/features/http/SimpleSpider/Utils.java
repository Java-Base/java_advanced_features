package com.java.advanced.features.http.SimpleSpider;

import java.io.*;

/**
 * 工具类
 *
 * @author 	Lian
 * @date 	2016/10/12
 * @since 	1.0
 */
public class Utils {

	/**
	 * 保存到文件
	 *
	 * @param in
	 * @param path
	 */
	public static void writeToFile(InputStream in, String path){
		File file = new File(path);
		System.out.println("是否为文件："+file.isFile());
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len;
			while((len=in.read(buffer))>0){
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("================文件写入失败==================");
		}
	}

	/**
	 * InputStream流转换为String
	 *
	 * @param in
	 * @return
	 */
	public static String convertStreamToString(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "/n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();

	}
}
