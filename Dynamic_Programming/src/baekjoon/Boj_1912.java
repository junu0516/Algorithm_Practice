package baekjoon;

import java.util.Scanner;

public class Boj_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] seq = new int[n];
		int[] max = new int[n];
		
		for(int i=0;i<seq.length;i++) {
			seq[i] = sc.nextInt();
		}
		
		max[0] = seq[0];
		int result = max[0];
		for(int i=1;i<n;i++) {
			max[i] = Math.max(max[i-1]+seq[i], seq[i]);
			if(result<max[i]) {
				result = max[i];
			}
		}
		
		System.out.println(result);
	}		
}
