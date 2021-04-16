package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10610 {
	
	/*
	 * 입력받은 숫자를 섞어,
	 * 30의 배수가 되는 가장 큰 수를 도출하기
	 * 
	 * 
	 * point
	 * 30의 배수가 되기 위한 조건
	 * 1. 0을 최소 1개이상 포함하고 있어야 함
	 * 2. 각 자리 숫자의 합이 3의 배수여야 함
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int total = 0;
		
		//각 자리 숫자의 합 도출
		for(int i=0;i<n.length();i++) {
			total += Integer.parseInt(n.substring(i,i+1));
		}
		
		//30의 배수가 되지 않을 경우에는 -1을 출력하고 리턴
		if(!n.contains("0") || total%3 != 0) {
			System.out.println("-1");
			return;
		}
		
		//일단 위의 조건문을 만족하지 않는 모든 경우의 수는 30의 배수라는 것을 알 수 있음
		//따라서 입력받은 숫자들 중 제일 큰 것부터 내림차순으로 정렬하여 출력하면 됨
		int[] arr = new int[n.length()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(n.substring(i,i+1));
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=arr.length-1;i>=0;i--) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb.toString());
	}
}
