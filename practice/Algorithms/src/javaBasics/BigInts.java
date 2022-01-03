package javaBasics;

import java.math.BigInteger;
import java.util.Scanner;

public class BigInts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger c = a.add(b);
		System.out.println(c);
		sc.close();
		

	}

	public static int add(int a, int b) {
		
		return a+b;
	}

}
