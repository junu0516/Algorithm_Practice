package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_11005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		
		//10진법으로 표현된 수 n을 b진법으로 변환
		//n을 b로 나눠서 나머지를 표시하고 더 이상 나눌 수 없을때까지 반복해서 표기하면 됨
		/*
		 * ex) 5를 3진법으로 바꿀 경우
		 *
		 * 5%3=2, 5/3=1 -> 12
		 *
		 */
		List<Character> list = new ArrayList<>();
		while(n>0) {
			if(n%b<10) {
				list.add((char)(n%b+'0'));
			}else {
				list.add((char)(n%b-10+'A'));
			}
			
			n /= b;
			System.out.println(n);
		}
		
		for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i));
		}
	}
}
