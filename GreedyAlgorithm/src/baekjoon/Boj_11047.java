package baekjoon;

import java.util.Scanner;

public class Boj_11047 {
	/*
	 * 
	 * N개의 종류의 동전이 있을 때,
	 * 동전 가치의 합 K를 만족시키는 최소 동전 개수를 구하기
	 * (단, 동전의 가치는 오름차순으로 주어짐)
	 * */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //동전의 종류의 수
		int k = sc.nextInt(); //가치의 합
		
		int[] a  = new int[n]; //동전의 종류 배열
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		//k원을 만드는 데 필요한 동전 개수의 최솟값
		int result = 0;
		for(int i=a.length-1;i>=0;i--) {
			if(k<=0) {
				break;
			}
			if(a[i]>k) {
				continue;
			}
			result += k/a[i];
			k = k-((k/a[i])*a[i]);
		}
		
		System.out.println(result);
	}

}
