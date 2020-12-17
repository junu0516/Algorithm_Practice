package baekjoon;

import java.util.Scanner;

public class Boj_2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		//arr[n][k]�� k���� ������ ������ ���� n�� ����� ����� ��
		int[][] arr = new int[201][201];
		
		//1���� ������ ������ ���� n�� ����� ����� ���� 1��
		for(int i=0;i<=n;i++) {
			arr[1][i] = 1;
		}
		
		//k���� ������ 0�� ����� ����� ���� 1��(n=0�� ���� ����)
		for(int i=1;i<=k;i++) {
			arr[i][0] = 1;
		}
		
		
		//�ᱹ arr[i][j]�� arr[i-1][j]+arr[i][j-1]���� �� �� ����
		for(int i=2;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000000;
			}
		}
		
		int result = arr[k][n];
		System.out.println(result);
	}
}
