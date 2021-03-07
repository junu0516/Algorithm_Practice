package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1920 {
	static int[] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		//오름차순 정렬
		Arrays.sort(a);
		
		StringBuilder sb = new StringBuilder();
		int m = sc.nextInt();
		for(int i=0;i<m;i++) {
			int b = sc.nextInt();
			//입력한 정수 b가 a배열 내에 존재하는 지 판별
			int result = find(b);

			sb.append(result+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int find(int b) {
		
		int low = 0;
		int high = a.length-1;
		int mid = 0;
		
		while(low<=high) {
			mid = low+((high-low)/2);
			
			if(b<a[mid]) {
				high = mid-1;
			}else if(b>a[mid]) {
				low = mid+1;
			}else {
				return 1;
			}
		}	
		return 0;
	}
}
