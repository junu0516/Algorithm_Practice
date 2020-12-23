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
				//�켱 ���� ����(i-1) -1 �� ���� ��,
				dp[i] = dp[i-1]+1;
				//2�� 3���� �������� ��쿡��, �������� ���� ���� ���̽��� ���ؼ� �ּҰ����� �־���
				if(i%2==0) {
					dp[i] = Math.min(dp[i], dp[i/2]+1);
				}
				//2�� 3���� �� �� ������ �� �ִ� ��찡 �����ϱ� ������ else if�� ���� �ʴ´�.
				if(i%3==0) {
					dp[i] = Math.min(dp[i], dp[i/3]+1);
				}
			}
		}
		System.out.println(dp[n]);
	}

}
