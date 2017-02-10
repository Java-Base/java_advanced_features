package com.java.advanced.features.nested.cnblogs.nerxious;

/**
 * 内部类实例
 *
 * @author 	Lian
 * @date 	2017/2/10
 * @since 	1.0
 */
public class Demo {

	public static void main(String[] args) {
//		Out.In in = new Out().new In();
//		in.print();

		// 或采用下列方式访问
		Out out = new Out();
		Out.In in = out.new In();
		in.print();
	}
}

/**
 * 外部类
 */
class Out {

	private int age = 12;

	/**
	 * 内部类
	 */
	class In {
		public void print() {
			System.out.println(age);
		}
	}
}
