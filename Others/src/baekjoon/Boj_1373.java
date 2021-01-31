package baekjoon;

import java.util.Scanner;

public class Boj_1373{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		/*
		 * 2진수를 8진수로 바꾸는 법
		 * 
		 * 2진수를 3자리(8 = 2^3) 단위로 쪼개서,
		 * 3자리로 쪼갠 각각의 숫자에 2진수의 자리값들을 곱해서 더한다.
		 * 
		 * */
		int len = input.length();
		
		StringBuilder sb = new StringBuilder();
		//우선, 2진수가 3자리로 완벽히 쪼개지지 않는 경우를 처리한다.
		if(len%3==1) {
			//3자리로 끊었을 때 맨 앞에 1자리만 남는 경우
			sb.append(input.charAt(0));
		}else if(len%3==2) {
			//3자리로 끊었을 때 맨 앞에 2자리만 남는 경우
			sb.append((input.charAt(0)-'0')*2+(input.charAt(1)-'0'));
		}
		//나머지 3자리 단위로 쪼개지는 경우들
		for(int i = len%3;i<len;i+=3) {
			sb.append((input.charAt(i)-'0')*4+(input.charAt(i+1)-'0')*2+(input.charAt(i+2)-'0'));
		}
		
		System.out.println(sb.toString());
	}

}
