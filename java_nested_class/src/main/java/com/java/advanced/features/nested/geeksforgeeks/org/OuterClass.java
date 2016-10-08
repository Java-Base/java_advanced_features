package com.java.advanced.features.nested.geeksforgeeks.org;

/**
 * Java program to demonstrate how to implement static and non-static classes in a java program
 *
 * @author 	Lian
 * @time	2016年7月20日
 * @url		http://www.geeksforgeeks.org/static-class-in-java/
 * @sine	1.0
 */
class OuterClass {

	private static String msg = "GeeksForGeeks";
	private String no_static_msg = "No-static-msg";

	/**
	 * Static nested class
	 *
	 */
	public static class NestedStaticClass {

		/**
		 * Only static members of Outer class is directly accessible in nested static class
		 */
		public void printMessage() {

			/**
			 * Try making 'message' a non-static variable, there will be : compiler error
			 * Error is: Cannot make a static reference to the non-static field no_static_msg
			 */
//			System.out.println("Message from non-static nested class: " + no_static_msg);

			System.out.println("Message from nested static class: " + msg);
		}
	}


	/**
	 * Non-static nested class - also called Inner class
	 */
	public class InnerClass {

		/**
		 * Both static and non-static members of Outer class are accessible in this Inner class
		 */
		public void display() {

			System.out.println("Message from no-static nested class: " + no_static_msg);

			System.out.println("Message from static nested class: " + msg);
		}

	}
}
