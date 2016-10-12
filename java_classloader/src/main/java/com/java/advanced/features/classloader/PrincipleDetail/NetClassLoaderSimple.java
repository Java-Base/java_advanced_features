package com.java.advanced.features.classloader.PrincipleDetail;

/**
 *
 *
 * @author 	Lian
 * @date 	2016/10/12
 * @since 	1.0
 */
public class NetClassLoaderSimple {

	private NetClassLoaderSimple instance;

	public void setInstance(Object obj) {
		this.instance = (NetClassLoaderSimple)obj;
	}
}
