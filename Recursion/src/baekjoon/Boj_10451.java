package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_10451 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		int count=0;
		
		while(count!=t) {
			int answer = 0;
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<Integer>());
			}
			boolean[] visited = new boolean[n+1];
			
			for(int i=1;i<=n;i++) {
				int v = sc.nextInt();
				graph.get(i).add(v); //단방향으로 연결
			}
			
			for(int i=1;i<graph.size();i++) {
				if(visited[i]==false) {
					dfs(graph,visited,i);
					answer++;
				}
			}
			
			System.out.println(answer);
			count++;
		}	
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node) {
		
		visited[node] = true; //방문
		
		for(int neighbor : graph.get(node)) {
			if(visited[neighbor] == false) {
				dfs(graph,visited,neighbor);
			}
		}
	}
}
