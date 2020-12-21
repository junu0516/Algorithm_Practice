package baekjoon;

import java.util.Scanner;

public class Boj_2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] stairs = new int[size+1];
		int[] score = new int[size+1];
		
		for(int i=1;i<=size;i++) {
			stairs[i] = sc.nextInt();
		}
		
		score[1] = stairs[1];
		
		if(size>=2) {
			score[2] = stairs[1]+stairs[2];		
			for(int i=3;i<=size;i++) {
				score[i] = Math.max(score[i-2]+stairs[i], score[i-3]+stairs[i-1]+stairs[i]);
			}		
		}
		
		int result = score[size];
		System.out.println(result);
	}
}
