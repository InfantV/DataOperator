package com.det;

import java.util.Scanner;

public class DemoOperator {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		int k = s.nextInt();
		for(int i = 0; i<=q+k; i++) {
			if(i==10) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
		}
	}

}
