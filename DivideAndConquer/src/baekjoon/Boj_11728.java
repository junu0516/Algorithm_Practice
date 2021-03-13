package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_11728 {
	static int[] a;
	static int[] b;
	static int[] c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //배열 a의 크기
		int m = sc.nextInt(); //배열 b의 크기
		
		a = new int[n];
		b = new int[m];
		c = new int[n+m];
		
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		
		for(int i=0;i<m;i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(b);
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<n && j<m) {
			if(a[i] > b[j]) {
				c[k++] = b[j++];
			}else {
				c[k++] = a[i++];
			}
		}
		
		while(j<m) {
			c[k++] = b[j++];
		}
		
		while(i<n) {
			c[k++] = a[i++];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int p=0;p<c.length;p++) {
			sb.append(c[p]+" ");
		}
		
		System.out.println(sb.toString());
	}

}
