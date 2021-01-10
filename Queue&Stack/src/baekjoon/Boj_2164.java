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
			cards.poll(); //���� ���� �ִ� ī�� ������
			cards.add(cards.poll()); //�� ���� ���� ���� �ִ� ī�带 ���� �Ʒ��� �ű�
		}
		
		System.out.println(cards.poll());
	}
}
