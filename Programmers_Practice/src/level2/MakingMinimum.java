package level2;

import java.util.Arrays;

public class MakingMinimum {
	/*
	 * 길이가 같은 두 배열에서 각각 한 개의 숫자를 뽑아 두 수를 곱해서
	 * 배열의 길이만큼 이러한 과정을 반복하며 곱한 값들으 누적시켰을 때,
	 * 최종 누적합이 최소가 되도록 만들기
	 * 
	 * 접근 :
	 * 제일 작은 수 * 제일 큰수로 반복하면 될까?
	 * 
	 * */
	public static int solution(int[]A, int[]B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		int idx = B.length-1;
		for(int i=0;i<A.length;i++) {
			sum += A[i]*B[idx];
			idx--;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,4,2};
		int[] B = new int[] {5,4,4};
		System.out.println(solution(A,B));
		
		A = new int[] {1,2};
		B = new int[] {3,4};
		System.out.println(solution(A,B));

	}

}
