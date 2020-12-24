package baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1916 {
	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //도시의 개수 -> 노드의 개수
		int m = sc.nextInt(); //버스의 개수 -> 간선의 개수
		ArrayList<Node>[] map = new ArrayList[n+1]; //전체 그래프
		int[] costs = new int[n+1]; //시작지점에서 각 노드까지의 비용 배열
		
		//그래프와 배열 초기화
		for(int i=1;i<=n;i++) {
			map[i] = new ArrayList<>();
			costs[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt(); //기준지점
			int b = sc.nextInt(); //인접지점
			int cost = sc.nextInt(); //버스 비용(a에서 b까지)
			
			map[a].add(new Node(b,cost));
		}
		
		int start = sc.nextInt(); //시작지점 번호
		int goal = sc.nextInt(); //도착지점 번호
		
		//다익스트라 탐색
		dijkstra(start,goal,map,costs);
		
		//탐색 후 costs[goal]이 목적지까지의 최소비용이 됨
		int result = costs[goal];
		System.out.println(result);
		
	}
	
	public static void dijkstra(int start, int goal, ArrayList<Node>[] map, int[] costs) {
		boolean[] visited = new boolean[map.length];
		PriorityQueue<Node> toVisit = new PriorityQueue<Node>();
		costs[start] = 0;
		toVisit.add(new Node(start,costs[start]));
		
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll().end;
			
			if(visited[curr]!=false) {
				continue;
			}
			visited[curr] = true; //방문 처리
			
			for(Node node : map[curr]) {
				if(costs[node.end] > costs[curr]+node.weight) { //정상적인 경우라면 costs[node.end]는 inf이기 때문에 더 클 수 밖에 없을 것
					costs[node.end] = costs[curr]+node.weight;
					toVisit.add(new Node(node.end,costs[node.end]));
				}
			}
		}		
	}
}
