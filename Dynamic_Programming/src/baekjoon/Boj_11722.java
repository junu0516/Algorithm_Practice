package baekjoon;

import java.util.Scanner;

public class Boj_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] seq = new int[size];
		int[] min = new int[size];
		for(int i=0;i<size;i++) {
			seq[i] = sc.nextInt();
		}
		
		min[0] = 1;
		int result = 1;
		for(int i=1;i<size;i++) {
			min[i] = 1; //초기 부분수열의 길이값은 1로 고정
			for(int j=0;j<i;j++) {
				//이전 위치값들을 모두 참조해서,
				//현재 seq[i]보다 이전 seq[j]가 더 크고, 부분수열의 길이 min[i]가 min[j]보다 작을 경우에는
				//감소하는 부분수열 조건을 만족한다고 간주할 수 있음
				
				//따라서 이 경우 min[i] 길이는 (감소하는 부분수열 조건을  만족하는)min[j]에 1을 더한 값이 됨
				if(seq[j]>seq[i] && min[i]<=min[j]) {
					min[i] = min[j]+1;
				}
			}
			result = Math.max(result, min[i]);
		}
		
		System.out.println(result);
	}
}
