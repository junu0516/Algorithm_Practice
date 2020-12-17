package baekjoon;

import java.util.Scanner;

public class Boj_2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		//arr[n][k]는 k개의 정수의 합으로 정수 n을 만드는 경우의 수
		int[][] arr = new int[201][201];
		
		//1개의 정수의 합으로 정수 n을 만드는 경우의 수는 1개
		for(int i=0;i<=n;i++) {
			arr[1][i] = 1;
		}
		
		//k개의 정수로 0을 만드는 경우의 수도 1개(n=0인 경우는 제외)
		for(int i=1;i<=k;i++) {
			arr[i][0] = 1;
		}
		
		
		//결국 arr[i][j]는 arr[i-1][j]+arr[i][j-1]임을 알 수 있음
		for(int i=2;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000000;
			}
		}
		
		int result = arr[k][n];
		System.out.println(result);
	}
}
