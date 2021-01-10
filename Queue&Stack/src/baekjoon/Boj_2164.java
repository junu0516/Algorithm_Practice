package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> cards = new LinkedList<Integer>();
		
		for(int i=0;i<n;i++) {
			cards.add(i+1);
		}
		
		while(cards.size()!=1) {
			cards.poll(); //제일 위에 있는 카드 버리기
			cards.add(cards.poll()); //그 다음 제일 위에 있는 카드를 제일 아래로 옮김
		}
		
		System.out.println(cards.poll());
	}
}
