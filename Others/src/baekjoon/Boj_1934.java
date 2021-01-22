package baekjoon;

import java.util.Scanner;

public class Boj_1934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int gcd = get(a,b);
			int lcd = a*b/gcd;
			
			System.out.println(lcd);
		}
	}
	
	public static int get(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return get(b,a%b);
		}
	}
}
