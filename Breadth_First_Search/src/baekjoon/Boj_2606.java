package baekjoon;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2606 {
	static int n;
	static int e;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //노드의 개수
		e = sc.nextInt(); //엣지의 개수
		
		LinkedList<Integer>[] map = new LinkedList[n+1];
		/*
		 * 주의 : LinkedList<>로 배열을 선언했을 때, 초기값이 null이기 때문에 반드시 배열의 처음부터 끝까지 빈 리스트를 할당해줘야 함
		 * 그렇지 않을 경우, NullPointerException 발생
		 * */
		for(int i=0;i<map.length;i++) {
			map[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<e;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			map[start].add(end);
			map[end].add(start);
		}
		
		int result = bfs(map);
		System.out.println(result-1); //1번 노드는 제외
	}
	
	public static int bfs(LinkedList<Integer>[] map) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> toVisit = new LinkedList<>();
		toVisit.add(1);
		int count = 0;
		
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll();
			
			for(int i : map[curr]) {
				if(!visited[i]) {
					visited[i] = true;
					toVisit.add(i);
					count++;
				}
			}
			
		}
		return count;
	}
	

}
