package baekjoon;

import java.util.Scanner;

public class Boj_1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt(); //서쪽 다리의 수
			int m = sc.nextInt(); //동쪽 다리의 수 (서쪽 다리의 수보다 같거나 큼)
			//mCn의 결과값을 DP를 통해 구현
			//기존에 재귀호출 방식은 중복되는 계산이 많아서인지 시간호출이 뜸
			int[][] dp = new int[n+1][m+1];
			
			for(int j=2;j<=n;j++) {
				dp[n][1] = 0;
			}
			
			for(int j=1;j<=m;j++) {
				dp[1][j] = j;
			}
			
			for(int j=2;j<=n;i++) {
				for(int k=2;k<=m;k++) {
					dp[j][k] = dp[j][k-1]+dp[j-1][k-1];
				}
			}
			System.out.println(dp[n][m]);
		}
	}
}
