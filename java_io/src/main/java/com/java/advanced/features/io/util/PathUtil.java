package com.java.advanced.features.io.util;

import java.io.File;
import java.io.IOException;

/**
 * 获取相对路径
 *
 * @author 	Lian
 * @time	2016年7月11日
 *
 */
public class PathUtil {
	
	private static File file = new File("");

	/**
	 * 根据System.getProperty()函数获取用户当前的工作目录
	 * 
	 * @return	用户当前的工作目录, 截止到项目名称目录
	 */
	public static String getPathByUseSystem() {
		// user.dir指定了当前工作路径
		return System.getProperty("user.dir");
	}

	/**
	 * 获取规范路径
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static String getCanonicalPath() throws IOException {
		return file.getCanonicalPath();
	}

	/**
	 * 获取绝对路径
	 * 
	 * @return
	 */
	public static String getAbsolutePath() {
		return file.getAbsolutePath();
	}
}
