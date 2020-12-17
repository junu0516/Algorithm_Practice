package baekjoon;

import java.util.Scanner;

public class Boj_2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] wines = new int[n+1];
		int[] maximum = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			wines[i] = sc.nextInt();
		}
		
		maximum[1] = wines[1];
		if(n>=2) {
			maximum[2] = maximum[1]+wines[2];
			if(n>=3) {
				for(int i=3;i<=n;i++) {
					maximum[i] = Math.max(maximum[i-1],Math.max(maximum[i-2]+wines[i], maximum[i-3]+wines[i-1]+wines[i]));
				}

			}
		}
		
		int result = maximum[n];
		System.out.println(result);
	}
}
