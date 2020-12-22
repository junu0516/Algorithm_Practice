package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1238 {
	
	//노드(정점) 클래스 생성
	static class Node implements Comparable<Node>{
		int index; // 노드 번호
		int distance; // 할당된 거리값
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int compareTo(Node node) {
			// TODO Auto-generated method stub
			return this.distance - node.distance ;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //정점의 개수
		int m = Integer.parseInt(st.nextToken());; //간선의 개수
		int x = Integer.parseInt(st.nextToken());; //도착지점
		
		ArrayList<Node>[] graph = new ArrayList[n+1]; //전체 그래프
		ArrayList<Node>[] graphRev = new ArrayList[n+1]; //뒤집힌 그래프
		int[] distance = new int[n+1];
		int[] distanceRev = new int[n+1];
		
		//거리 배열 초기화, 그래프에 빈 리스트 할당
		for(int i=1;i<=n;i++) {
			distance[i] = 1000000000;
			distanceRev[i] = 1000000000;
			graph[i] = new ArrayList<Node>();
			graphRev[i] = new ArrayList<Node>();
		}		
		
		//그래프 초기화
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //기준 노드 번호
			int b = Integer.parseInt(st.nextToken()); //이웃 노드 번호
			int weight = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,weight));
			graphRev[b].add(new Node(a,weight));
		}
		
		//x번 마을에서 각 마을로 가는 최단 경로 탐색
		dijkstra(x,graph,distance,n);
		
		//그래프를 뒤집어서, 각 마을에서 x번 마을로 가는 최단 경로 탐색
		dijkstra(x,graphRev,distanceRev,n);
		
		int result = 0;
		for(int i=1;i<=n;i++) {
			//distance[i]와 distanceRev[i]를 더해야 왕복 거리를 계산할 수 있음
			result = Math.max(result, distance[i]+distanceRev[i]);
		}
		
		bw.write(result+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra(int start, ArrayList<Node>[] graph, int[] distance, int n) {
		boolean[] visited = new boolean[n+1]; //방문여부	
		PriorityQueue<Node> toVisit = new PriorityQueue<>();
		distance[start] = 0; //시작 노드의 거리값을 0으로 먼저 초기화
		toVisit.offer(new Node(start,distance[start]));
		
		while(!toVisit.isEmpty()) {
			Node curr = toVisit.poll();
			int currIdx = curr.index;
			
			if(visited[currIdx] == true) {
				continue;
			}
			
			visited[currIdx] = true;
			
			for(Node node : graph[currIdx]) {
				//거리값 초기화
				if(distance[node.index] > distance[currIdx] + node.distance) {
					distance[node.index] = distance[currIdx] + node.distance;
					toVisit.add(new Node(node.index,distance[node.index]));
				}
			}
		}
	}

}
