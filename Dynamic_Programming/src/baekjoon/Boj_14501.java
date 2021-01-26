package baekjoon;

import java.util.Scanner;

public class Boj_14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n+10];
		int[] p= new int[n+10];
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		int[] dp = new int[20];
		int max = 0;
		for(int i=1;i<=n+1;i++) {
			dp[i] = Math.max(max, dp[i]);
			dp[i+t[i]] = Math.max(dp[i+t[i]],dp[i]+p[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
