package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1167 {
	/*
	 *Integer : 정점 번호
	 *ArrayList : 인접 노드 정보
	 *int[] : 0번째 -> 인접 노드 번호, 1번째 -> 인접 노드까지의 거리 
	 * 
	 * */
	static HashMap<Integer,ArrayList<int[]>> tree = new HashMap<>(); 
	static int[] parent;
	static boolean[] visited;
	static int root;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(); //정점의 개수
		
		//1. 트리 생성
		for(int i=0;i<v;i++) {
			int n1 = sc.nextInt(); //정점 번호
			
			if(!tree.containsKey(n1)) {
				tree.put(n1, new ArrayList<>());
			}
			
			while(true) {
				int n2 = sc.nextInt(); //n1에 인접한 정점
				if(n2==-1) {
					break;
				}
				
				int distance = sc.nextInt(); //n1과 n2사이의 거리
				tree.get(n1).add(new int[] {n2,distance});
			}
		}
		
		//2. 임의의 정점에서 제일 긴 거리의 정점을 찾은 후, 그 정점을 기준으로 다시 제일 긴 거리의 정점을 찾아 거리 배열 초기화
		
		int start = 1;
		int[] distances = bfs(start,v);
		
		for(int i=2;i<=v;i++) {
			if(distances[i]>distances[start]) {
				start = i;
			}
		}
		
		distances = bfs(start,v);
		
		//3. 거리 배열에서 제일 큰 값을 출력
		Arrays.sort(distances);
		System.out.println(distances[v]);
	
	}
	
	private static int[] bfs(int start, int v) {
		
		visited = new boolean[v+1];
		int[] distances = new int[v+1];
		Queue<Integer> toVisit = new LinkedList<>();
		toVisit.add(start);
		visited[start] = true; //시작지점으 반드시 미리 방문처리 해야 함
		
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll();
			
			for(int[] neighbor : tree.get(curr)) {
				int next = neighbor[0];
				int distance = neighbor[1];
				if(visited[next] == false) {
					visited[next] = true;
					toVisit.add(next);
					distances[next] = distances[curr]+distance;
				}
				
			}
		}
		
		return distances;
	}

}
