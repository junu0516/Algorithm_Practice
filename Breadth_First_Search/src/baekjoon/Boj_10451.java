package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_10451 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 0;
		
		while(count!=t) {
			int result = 0;
			int n = sc.nextInt();
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<Integer>());
			}
			boolean[] visited = new boolean[n+1];
			
			for(int i=1;i<=n;i++) {
				int v = sc.nextInt();
				graph.get(i).add(v);
			}
			
			for(int i=1;i<graph.size();i++) {
				if(visited[i]==false) {
					bfs(graph,visited,i);
					result++;
				}
			}
			
			System.out.println(result);
			
			count++;
		}
		
	}
	
	public static void bfs(ArrayList<ArrayList<Integer>>graph, boolean[] visited, int node) {
		Queue<Integer> toVisit = new LinkedList<>();
		toVisit.add(node);
		
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll();
			
			for(int neighbor : graph.get(curr)) {
				if(visited[neighbor]==false) {
					visited[neighbor] = true;
					toVisit.add(neighbor);
				}
			}
		}
	}
}
