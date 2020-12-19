package baekjoon;

import java.util.Scanner;

public class Boj_11055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] seq = new int[n];
		int[] max = new int[n];
		
		for(int i=0;i<n;i++) {
			seq[i] = sc.nextInt();
		}
		
		max[0] = seq[0];
		for(int i=1;i<n;i++) {
			max[i] = seq[i];
			for(int j=0;j<i;j++) {
				if(seq[j]<seq[i] && max[j]+seq[i]>max[i]) {
					max[i] = max[j] + seq[i];
				}
			}
		}
		
		int result = 0;
		for(int i : max) {
			if(i>result) {
				result = i;
			}
		}
		
		System.out.println(result);
	}

}
