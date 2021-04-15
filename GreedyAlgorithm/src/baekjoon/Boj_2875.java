package baekjoon;

import java.util.Scanner;

public class Boj_2875 {
	
	/*
	 * 대회에 나갈 여학생의 수를 n, 남학생의 수를 m이라고 하고
	 * 대회에 나가지 않고 인턴십에 참가할 인원을 k라고 했을 때,
	 * 
	 * 대회 참가시 만들 수 있는 최대의 팀 수를 구하기
	 * 한 팀은 2명의 여자와, 1명의 남자로 구성하는 것을 원칙으로 함
	 * 
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //여자 인원수
		int m = sc.nextInt(); //남자 인원수
		int k = sc.nextInt(); //인턴십에 참여해야 하는 인원
		
		int t = n+m;
		int result = 0;
		while(true) {
			if(t-3<k|| n<2 || m<1) {
				break;
			}
			n -= 2;
			m -= 1;
			t -= 3;
			result += 1;
		}
		
		System.out.println(result);
	}

}
