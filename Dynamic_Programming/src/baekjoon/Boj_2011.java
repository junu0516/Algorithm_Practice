package baekjoon;

import java.util.Scanner;

public class Boj_2011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//1���� ���ڸ� ����, 2���� ���ڸ� ������ ���
		int[][] dp = new int[input.length()+1][2];
		
		
		
		/*
		 * �� �ڸ��� ���ڰ�(2,5,1,1,4) ������ ������ ��츦 ���� ������� ��,
		 * 1�� : �ش� ���ڰ� ���ڸ� ���� ���
		 * 2�� : �ش� ���ڰ� ���ڸ� ���� ���
		 * 
		 * ex) ���� �Է� 25114����  
		 * dp[1][0] : 2�� �� ���̸鼭 �� �ڸ� ���� �̷����
		 * dp[1][1] : 2�� �� ���̸鼭 �� �ڸ� ���� �̷���� -> 2�� �� ó���̱� ������, �� �ڸ����� �� �� �����Ƿ� ����� ���� 0�� ��
		 * 
		 * ...
		 * dp[2][0] : 5�� �� ���̸鼭 �� �ڸ����� �̷����
		 * dp[2][1] : 5�� �� ���̸鼭 �� �ڸ����� �̷���� -> 5�� �ٷ� ���� 2�̱� ������ 25<26�̹Ƿ� ���ĺ��� �� �� �ֱ� ������ ����� ���� 1�� ��
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
			 * ��ȣ�� �߸��� ���
			 * 
			 * 1. 0���� �����ϴ� ���
			 * 2. ���� 0�̸鼭, ���� �ڸ��� ����ϴ� ���
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
				dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000; //���� �ڸ� ���ڿ� �ش� �ڸ��� �ϳ��� �����ָ� ��
				
				//���ڸ� ���� ��쿡�� 26������ ���� ��쿡�� ����
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
