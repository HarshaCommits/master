package javaBasics;

import java.util.Scanner;

public class PyramidStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int n =sc.nextInt();
		Pyramid (n);
		sc.close();
		
		

	}


public static void Pyramid (int n)
{
	for (int i =1; i<=n; i++)
	{
		for (int j=0; j<i; j++)
		{
			System.out.print("*");
		}
		System.out.println("");
	}
}
}
