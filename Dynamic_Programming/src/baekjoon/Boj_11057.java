package baekjoon;

import java.util.Scanner;

public class Boj_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] arr = new long[n+1][10];
		
		for(int i=0;i<=9;i++) {
			arr[1][i] = 1;
		}
		
		if(n>=2) {
			for(int i=2;i<=n;i++) {
				for(int j=0;j<=9;j++) {
					long sum = 0;
					for(int k=j;k<=9;k++) {
						sum += arr[i-1][k]%10007;
					}
					arr[i][j] = sum;
				}				
			}
		}
		
		long result = 0;
		for(int i=0;i<10;i++) {
			result += arr[n][i];
		}
		System.out.println(result%10007);
	}
}
