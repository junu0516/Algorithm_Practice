package baekjoon;

import java.util.Scanner;

public class Boj_10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		long result1 = (a+b)%c;
		long result2 = ((a%c)+(b%c))%c;
		long result3 = (a*b)%c;
		long result4 = ((a%c)*(b%c))%c;
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
}
