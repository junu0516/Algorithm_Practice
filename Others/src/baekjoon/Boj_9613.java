package baekjoon;

import java.util.Scanner;

public class Boj_9613 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int j=0;j<arr.length;j++) {
				arr[j] = sc.nextInt();
			}
			
			long gcd = 0;
			for(int j=0;j<arr.length;j++) {
				for(int k=j+1;k<arr.length;k++) {
					gcd += get(arr[j],arr[k]);
				}
			}
			System.out.println(gcd);
		}
	}
	
	public static int get(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return get(b,a%b);
		}
	}
}
