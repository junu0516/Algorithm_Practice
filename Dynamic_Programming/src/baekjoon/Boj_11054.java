package baekjoon;

import java.util.Scanner;

public class Boj_11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 바이토닉 수열이 될 수 있는 조건
		 * 1) 처음부터 끝까지 증가 패턴
		 * 2) 처음부터 끝까지 감소 패턴
		 * 3) 증가하다가 다시 감소하는 패턴
		 * 
		 * 결국,
		 * i번째 위치에서, 
		 * 0~i까지 증가하는 부분수열 최대 길이와 
		 * i+1~last 까지 감소하는 부분수열의 최대길이의 합이 곧, 바이토닉 수열의 길이가 된다.
		 * 
		 * 따라서, 이 합의 최대값을 구하도록 한다.
		 * */
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] seq = new int[size]; //전체 수열
		int[] asc = new int[size]; //증가 부분수열
		int[] desc = new int[size]; //감소 부분수열
		int[] bit = new int[size]; //바이토닉 수열
		
		for(int i=0;i<size;i++) {
			seq[i] = sc.nextInt(); //전체 수열 값 초기화
		}
		
		
		for(int i=0;i<size;i++) {
			asc[i] = 1;
			for(int j=0;j<i;j++) {
				if(seq[j]<seq[i] && asc[i]<=asc[j]) {
					asc[i] = asc[j] +1;
				}
			}
		}
		
		//감소하는 부분수열의 경우 맨 마지막에서 시작
		//j는 맨 마지막부터 i+1번째 까지를 참조(즉, i번째의 우측 모든 숫자를 탐색)
		for(int i=size-1;i>=0;i--) {
			desc[i] = 1;
			for(int j=size-1;j>i;j--) {
				if(seq[j]<seq[i] && desc[j]>=desc[i]) {
					desc[i] = desc[j]+1;
				}
			}
		}
		
		int result = 0;
		for(int i=0;i<size;i++) {
			bit[i] = asc[i]+desc[i] -1; //바이토닉 수열의 길이
			result = Math.max(bit[i], result);
		}
		
		System.out.println(result);
	}
}
