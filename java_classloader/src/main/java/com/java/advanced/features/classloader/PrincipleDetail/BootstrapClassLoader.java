package com.java.advanced.features.classloader.PrincipleDetail;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Bootstrap ClassLoader
 * 称为启动类加载器，是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库
 *
 * @url		http://www.codeceo.com/article/java-classloader.html
 * @author 	Lian
 * @date 	2016/10/12
 * @since 	1.0
 */
public class BootstrapClassLoader {

	public static void main(String[] args) {
		URL[] urls = Launcher.getBootstrapClassPath().getURLs();

		for (URL url : urls) {
			System.out.println(url.toExternalForm());
		}

		// 其实上述结果也是通过查找sun.boot.class.path这个系统属性所得知的。
		System.out.println(System.getProperty("sun.boot.class.path"));
	}
}
