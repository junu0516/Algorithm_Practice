package baekjoon;

import java.util.Scanner;

public class Boj_2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		/*
		 * n=1 : 0
		 * n=2 : 3
		 * n=3 : 0
		 * ...
		 * n이 홀수일 경우 경우의 수는 무조건 0(1*1 한 칸이 무조건 남기 때문)
		 * 결국, 짝수일 경우 경우의 수가 어떤 패턴으로 증가하는 지를 찾아야 한다.
		 * */
		
		arr[0] = 1;
		if(n>=2) {
			arr[2] = 3;
			//홀수일 경우에는 값이 0이기 때문에 짝수인 경우만 고려한다.
			for(int i=4;i<=n;i+=2) {
				arr[i] = arr[i-2]*3; //3*2 한 칸 만드는 경우의 수 3가지 * 직전의 3*(i-2) 블록을 만드는 경우의 수
				for(int j=0;j<i-2;j+=2) {
					arr[i] += arr[j]*2; //직전 케이스들에서 나타난 특수 케이스들*2를 모두 더해줌
				}
			}
		}
		
		int result = arr[n];
		System.out.println(result);
		
		
		
	}
}
