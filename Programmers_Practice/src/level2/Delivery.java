package level2;

import java.util.PriorityQueue;

public class Delivery {
	
	static class Vertex implements Comparable<Vertex>{
		int index; //정점 번호
		int weight; //정점간의 거리
		
		public Vertex(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex v) {
			
			return this.weight - v.weight;
		}
	}
	
	public static int solution(int n, int[][] road, int k) {
		int answer = 0;
		
		int[][] map = new int[n+1][n+1]; //마을을 나타내는 그래프
		int[] distances = new int[n+1]; //1번 정점에서 각 정점까지의 거리들
		boolean[] visited = new boolean[n+1]; //각 정점의 방문여부를 나타냄
		
		//그래프 초기화
		for(int i=0;i<road.length;i++) {
			int v1 = road[i][0];
			int v2 = road[i][1];
			int distance = road[i][2];
			
			if(map[v1][v2]>0) {
				map[v1][v2] = Math.min(distance, map[v1][v2]);
			}else {
				map[v1][v2] = distance;
			}
			
			if(map[v2][v1]>0) {
				map[v2][v1] = Math.min(distance, map[v2][v1]);
			}else {
				map[v2][v1] = distance;
			}
			
		}
		
		for(int i=1;i<distances.length;i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		
		//1번 정점에서 시작하여, 다익스트라 탐색을 수행하면서 거리배열을 초기화
		PriorityQueue<Vertex> toVisit = new PriorityQueue<>();
		distances[1] = 0;
		toVisit.add(new Vertex(1,distances[1]));
		
		while(!toVisit.isEmpty()) {
			Vertex curr = toVisit.poll();
			int index = curr.index;
			int weight = curr.weight;
			
			if(weight>distances[index]) {
				continue;
			}
			
			if(visited[index] == true) {
				continue;
			}
			
			visited[index] = true;
			
			for(int i=1;i<distances.length;i++) {
			
				if(map[index][i] !=0 && distances[i] > distances[index]+map[index][i]) {
					distances[i] = distances[index] + map[index][i];
					toVisit.add(new Vertex(i,distances[i]));
				}
			}
		
		}
		
		//초기화된 거리배열에서 값이 k이하인 인덱스의 개수를 모두 세줌
		for(int i=1;i<distances.length;i++) {
			if(distances[i]<=k) {
				answer++;
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int k = 3;
		
		System.out.println(solution(n,road,k));
	}

}
