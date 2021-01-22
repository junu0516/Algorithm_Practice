package baekjoon;

import java.util.Scanner;

public class Boj_1850 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long gcd = get(a,b);
		StringBuilder sb = new StringBuilder();
		for(long i=0;i<gcd;i++) {
			sb.append("1");
		}
		
		System.out.println(sb.toString());		
	}
	
	public static long get(long a, long b) {
		if(b==0) {
			return a;
		}else {
			return get(b,a%b);
		}
	}
}
