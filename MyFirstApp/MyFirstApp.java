/*
  Date: Sun Feb 18 23:12:51 CST 2018
*/

public class MyFirstApp {
    public static void main(String[] args) {
	System.out.println("Hello, World!");

	for (int i = 0; i < args.length; ++i) {
	    System.out.println("arg" + i + " is " + args[i]);
	}
    }
}
