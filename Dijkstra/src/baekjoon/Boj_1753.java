package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753 {
	
	static class Node implements Comparable<Node>{
		int end; //이웃 노드 번호
		int weight; //이웃 노드 까지의 거리(가중치)
		
		public Node(int index, int weight) {
			this.end = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inf = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); //정점의 개수
		int e = Integer.parseInt(st.nextToken()); //간선의 개수
		int k = Integer.parseInt(br.readLine()); //시작 정점 번호
		
		ArrayList<Node>[] graph = new ArrayList[v+1];
		int[] distance = new int[v+1];
		for(int i=1;i<=v;i++) {
			graph[i] = new ArrayList<>();
			distance[i] = inf; //INF
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,w)); //a에서 b까지의 거리가 w
		}
		
		dijkstra(graph,distance,k); //다익스트라 탐색을 통해 distance 배열값 할당
		
		for(int i=1;i<=v;i++) {
			if(distance[i]<inf) {
				bw.write(distance[i]+"\n");
			}else {
				bw.write("INF"+"\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	private static void dijkstra(ArrayList<Node>[] graph, int[] distance, int start) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[distance.length];
		PriorityQueue<Node> toVisit = new PriorityQueue<Node>();
		distance[start] = 0;
		toVisit.offer(new Node(start,distance[start]));
		
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll().end;
			
			if(visited[curr]!=false) {
				continue;
			}
			
			visited[curr] = true;
			
			for(Node node : graph[curr]) {
				if(distance[node.end]>distance[curr]+node.weight) {
					distance[node.end] = distance[curr]+node.weight;
					toVisit.offer(new Node(node.end,distance[node.end]));
				}
			}			
		}
	}
}
