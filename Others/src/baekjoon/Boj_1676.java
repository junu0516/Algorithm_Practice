package baekjoon;

import java.util.Scanner;

public class Boj_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 직접 factorial 연산을 구해서 접근할 수 없음
		 * 이유 : 500!은 long 변수로도 감당할 수 없는 큰 수이기 때문
		 * 
		 * 접근:
		 * 
		 * 3! = 3*2*1 = 6
		 * 4! = 4*3*2*1 = 24
		 * 5! = 5*4*3*2*1 = 120
		 * 6! = 720
		 * 7! = 5040
		 * 8! = 40320
		 * 9! = 362880
		 * 10! = 3628800
		 * 
		 * 3,4는 0이 0개..
		 * 5~9까지는 0이 1개
		 * 10은 0이 2개?
		 * 
		 * -> 결국, 소인수분해 했을 때, 5개 몇개 곱해져있는 지에 따라 0의 개수가 결정됨
		 * -> 5~9까지는 5가 한 번 곱해졌기 때문에 1개
		 * -> 10의 경우 10 = 2*5이므로 5가 2번 곱해져서 2개
		 * -> 5가 곱해진 횟수를 찾으면 됨
		 * 
		 * */
		
		int n = sc.nextInt();
		
		int result = 0;
		for(int i=5;i<=n;i*=5) {
			result += n/i;
		}
		
		System.out.println(result);
		
	}

}
