package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1707 {

	static int red = 1;
	static int blue = -1;
	
	public static void main(String[] args) {
		
		/*
		 * 이분그래프 : 그래프의 정점의 집합을 둘로 분할했을 때, 각 집합에 속한 정점끼리 서로 인접하지 않도록 분할하는 경우
		 * 
		 * 쉽게 얘기해서, 모든 정점에 색을 칠한다 했을 때, 인접한 정점끼리는 서로 다른색으로 칠해져야 함
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt(); //테스트 케이스의 개수
	
		for(int i=1;i<=k;i++) {
			int v = sc.nextInt(); //정점의 개수
			int e = sc.nextInt(); //간선의 개수
			
			List<Integer>[] graph = new ArrayList[v+1];
			int[] colors = new int[v+1];
			
			for(int j=0;j<graph.length;j++) {
				graph[j] = new ArrayList<Integer>();
			}
			
			int count = e;
			while(count>0) {
				//이어줄 정점 입력
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				//그래프상에서 두 정점 이어주기
				graph[a].add(b);
				graph[b].add(a);
				count--;
			}
			
			//그래프가 이분그래프인지 판별
			String result = bfs(graph,colors);
			System.out.println(result);
		}
	}
	
	public static String bfs(List<Integer>[] graph, int[] colors) {
		Queue<Integer> toVisit = new LinkedList<Integer>();
		
		for(int i=1;i<graph.length;i++) {
			//일단 색이 칠해져 있지 않은 정점을 판별 = 일반적인 bfs에서 visited[i]==false인 경우를 찾는 것과 같음
			if(colors[i]==0) { //색칠하지 않은 정점들을 큐에 먼저 넣어줌
				toVisit.add(i);
				colors[i] = red;
			}
			
			while(!toVisit.isEmpty()) {
				int curr = toVisit.poll();
				
				for(int j=0;j<graph[curr].size();j++) {
					int neighbor = graph[curr].get(j);
					
					if(colors[neighbor]==0) {
						toVisit.add(neighbor);
					}
					
					if(colors[neighbor] == colors[curr]) {
						//현재 정점에 칠해진 색과, 인접한 정점에 칠해진 색이 같은 경우가 하나라도 발견되면 바로 NO를 리턴
						return "NO";
					}
					
					//올바른 경우라면, 인접한 정점에 현재 정점과 다른 색을 칠해주면 됨
					if(colors[curr] == red && colors[neighbor]==0) {
						colors[neighbor] = blue;
					}else if(colors[curr] == blue && colors[neighbor]==0){
						colors[neighbor] = red;
					}
				}
			}
		}
		
		return "YES";
		
	}
}
