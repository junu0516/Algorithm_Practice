package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Boj_1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 * 관건:
		 * 배열 , 리스트 등을 사용할 경우 요소의 삽입/삭제에서 O(N)이기 때문에 무조건 시간초과
		 * (배열/리스트의 크기가 N이면, 해당 자료구조에 자료를 삽입/삭제하는 데 걸리는 시간도 N에 비례해서 걸림)
		 * 따라서, 인덱스 기반 자료구조는 사용하면 안됨
		 * 
		 * LinkedList, Stack, Deque 등은 요소의 삽입/삭제에서 O(1)이기 때문에 더 적합
		 * (자료구조의 크기에 상관없이 한 번에 처리할 수 있음)
		 * ...그래서 큐/스택 카테고리에 할당된 문제인 것 같음
		 * */
		
		String str = br.readLine();
		Deque<Character> deque1 = new LinkedList<>(); //커서 왼쪽 문자들
		Deque<Character> deque2 = new LinkedList<>(); //커서 오른쪽 문자들

		for(int i=0;i<str.length();i++) { //먼저 커서 왼쪽에 모든 문자를 넣고 시작 
			deque1.add(str.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String order = br.readLine();
			if(order.equals("L")) {
				if(deque1.isEmpty()) {
					continue; //커서가 문장의 맨 앞인 경우
				}else {
					deque2.addFirst(deque1.pollLast());//커서 왼쪽의 문자를 커서 오른쪽으로 이동
				}
			}else if(order.equals("D")) {
				if(deque2.isEmpty()) {
					continue; //커서가 문장의 맨 뒤인 경우
				}else {
					deque1.addLast(deque2.pollFirst());
				}
			}else if(order.equals("B")) {
				if(deque1.isEmpty()) {
					continue; //커서가 문장의 맨 앞인 경우
				}else {
					deque1.pollLast();//커서 왼쪽의 문자를 삭제
				}
			}else {
				char input = order.charAt(2);
				deque1.addLast(input);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!deque1.isEmpty()) {
			sb.append(deque1.pollFirst());
		}
		while(!deque2.isEmpty()) {
			sb.append(deque2.pollFirst());
			
		}
		
		bw.write(sb.toString()+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
