package baekjoon;

import java.util.Scanner;

public class Boj_2011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//1열은 한자리 숫자, 2열은 두자리 숫자인 경우
		int[][] dp = new int[input.length()+1][2];
		
		
		
		/*
		 * 각 자리의 숫자가(2,5,1,1,4) 마지막 숫자인 경우를 각각 고려했을 때,
		 * 1열 : 해당 숫자가 한자리 수인 경우
		 * 2열 : 해당 숫자가 두자리 수인 경우
		 * 
		 * ex) 예제 입력 25114에서  
		 * dp[1][0] : 2가 맨 끝이면서 한 자리 수로 이루어짐
		 * dp[1][1] : 2가 맨 끝이면서 두 자리 수로 이루어짐 -> 2는 맨 처음이기 때문에, 두 자리수가 될 수 없으므로 경우의 수는 0이 됨
		 * 
		 * ...
		 * dp[2][0] : 5가 맨 끝이면서 한 자리수로 이루어짐
		 * dp[2][1] : 5가 맨 끝이면서 두 자리수로 이루어짐 -> 5의 바로 앞이 2이기 때문에 25<26이므로 알파벳이 될 수 있기 때문에 경우의 수는 1이 됨
		 * 
		 * */
		
		dp[0][0] = 1;
		dp[1][0] = 1;
		
		if(input.charAt(0) =='0') {
			System.out.println(0);
			return;
		}
		
		for(int i=2;i<=input.length();i++) {
			int curr = Integer.parseInt(String.valueOf(input.charAt(i-1)));
			int prev = Integer.parseInt(String.valueOf(input.charAt(i-2)));
			/*
			 * 암호가 잘못된 경우
			 * 
			 * 1. 0으로 시작하는 경우
			 * 2. 끝이 0이면서, 단일 자리만 고려하는 경우
			 * 
			 * */
			if(curr==0) {
				if(prev==0) {
					System.out.println(0);
					return;
				}else {
					dp[i][0] = 0;
					if(prev==1 || prev==2) {
						dp[i][1] = (dp[i-2][0]+dp[i-2][1]) % 1000000;
					}
				}				
			}else {
				dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000; //이전 자리 숫자에 해당 자리수 하나만 더해주면 됨
				
				//두자리 수인 경우에는 26이하의 수인 경우에만 가능
				if(prev ==1) {
					if(curr>=0 && curr<=9) {
						dp[i][1] = (dp[i-2][0]+dp[i-2][1]) % 1000000;
					}
				}else if(prev ==2) {
					if(curr>=0 && curr<=6) {
						dp[i][1] = (dp[i-2][0]+dp[i-2][1]) % 1000000;
					}
				}else {
					dp[i][1] = 0;
				}
			}			
		}
		
		int result = (dp[input.length()][0] + dp[input.length()][1])% 1000000;
		System.out.println(result);
	}
}
