package baekjoon;

import java.util.Scanner;

public class Boj_1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		arr[1] = 1;
		if(n>=2) {
			arr[2] = 2;
			for(int i=3;i<=n;i++) {
				arr[i] = i;
				for(int j=1;j*j<=i;j++) {
					arr[i] = Math.min(arr[i-(j*j)]+1, arr[i]);
				}
			}
		}
		int result = arr[n];
		System.out.println(result);
	}

}
