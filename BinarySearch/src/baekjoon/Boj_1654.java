package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		long n = sc.nextLong(); // n의 범위가 int를 벗어나기 때문에 long으로 선언
		long[] arr = new long[k];
		
		for(int i=0;i<k;i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		
		long low = 1; //자를 수 있는 최소 길이(길이는 자연수이기 때문에 1부터 시작)
		long high = arr[k-1]; //자를 수 있는 최대 길이
		while(low<=high) {
			long mid = (low+high)/2;
			long totalCount = 0;
			
			for(int i=0;i<k;i++) {
				totalCount += arr[i] / mid; //만들 수 있는 모든 랜선의 개수의 합
			}
			
			//totalCount값을 n과 비교
			if(totalCount>=n) {
				low = mid+1; //개수가 너무 많기 때문에 mid값을 늘려서 totalCount를 줄여야 함
			}else if(totalCount<n) {
				high = mid-1; //개수가 부족하기 때문에 mid값을 줄여서 totalCount를 높여야 함
			}
			
			/*
			 * 이런 식으로 low<=high를 만족하는 동안 계속해서 low~high 범위를 줄여나간 후,
			 * 반복문을 빠져나왔을 때의 high값이 자를 수 있는 최대 길이가 됨
			 * 
			 * */
		}
		
		System.out.println(high);

	}

}
