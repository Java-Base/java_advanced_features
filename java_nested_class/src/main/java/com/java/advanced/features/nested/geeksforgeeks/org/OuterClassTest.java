package com.java.advanced.features.nested.geeksforgeeks.org;

/**
 * 
 *
 * @author 	Lian
 * @time	2016年7月20日
 *
 */
public class OuterClassTest {

	// How to create instance of static and non-static nested class?
	public static void main(String[] args) {

		// Create instance of nested static class
		OuterClass.NestedStaticClass nestedStaticClass = new OuterClass.NestedStaticClass();

		// Call non static method of nested static class
		nestedStaticClass.printMessage();

		// In order to create instance of Inner class we need an Outer class instance.
		// Let's create Outer class instance for creating non-static nested class
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass innerClass = outer.new InnerClass();

		// Calling non-static method of Inner class
		innerClass.display();

		// We can also combine above steps in one step to create instance of
		// Inner class
		OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

		// Similarly we can now call Inner class method
		innerObject.display();
	}
}
