package baekjoon;

import java.util.Scanner;

public class Boj_1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		
		if(n>=2) {
			dp[2] = 1;
			for(int i=3;i<=n;i++) {
				//우선 직전 숫자(i-1) -1 을 넣은 후,
				dp[i] = dp[i-1]+1;
				//2나 3으로 나눠지는 경우에는, 나눠졌을 때의 숫자 케이스와 비교해서 최소값으로 넣어줌
				if(i%2==0) {
					dp[i] = Math.min(dp[i], dp[i/2]+1);
				}
				//2와 3으로 둘 다 나눠질 수 있는 경우가 존재하기 때문에 else if로 하지 않는다.
				if(i%3==0) {
					dp[i] = Math.min(dp[i], dp[i/3]+1);
				}
			}
		}
		System.out.println(dp[n]);
	}

}
