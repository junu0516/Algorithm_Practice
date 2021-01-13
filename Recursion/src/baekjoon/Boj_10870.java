package baekjoon;

import java.util.Scanner;

public class Boj_10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		arr[0] = 0;
		
		if(n>0) { //n은 0이 될 수도 있음에 유의
			arr[1] = 1;
			for(int i=2;i<=n;i++) {
				arr[i] = fibonacci(i, arr);
			}
		}
				
		System.out.println(arr[n]);
	}
	
	public static int fibonacci(int i, int[] arr) {
		return arr[i-2]+arr[i-1];
	}

}
