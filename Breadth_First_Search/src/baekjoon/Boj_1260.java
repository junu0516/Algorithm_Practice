package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boj_1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //노드의 개수
		int m = sc.nextInt(); //간선의 개수
		int v = sc.nextInt(); //시작 노드 번호
		
		int[][] graph = new int[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		
		dfs(graph,n,v);
		System.out.println();
		bfs(graph,n,v);
	}
	
	public static void dfs(int[][] graph, int n, int v) {
		Stack<Integer> toVisit = new Stack<>();
		boolean[] visited = new boolean[n+1];
		boolean flag = true;
		toVisit.add(v);
		visited[v] = true;
		System.out.print(v+" ");
		
		while(!toVisit.isEmpty()) {
			v = toVisit.peek();
			flag = false;
			
			for(int i=1;i<=graph.length;i++) {
				if(graph[v][i] == 0 || visited[i] == true) {
					continue;
				}
				toVisit.push(i);
				System.out.print(i+" ");
				visited[i] = true;
				flag = true;
				break;
			}
			
			if(flag==false) {
				toVisit.pop();
			}
		}
		
	}
	
	public static void bfs(int[][] graph, int n, int v) {
		Queue<Integer> toVisit = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		toVisit.add(v);
		visited[v] = true;
		
		while(!toVisit.isEmpty()) {
			v = toVisit.poll();
			System.out.print(v+" ");
			for(int i=1;i<=graph.length;i++) {
				if(visited[i] == true || graph[v][i] == 0) {
					continue;
				}
				toVisit.add(i);
				visited[i] = true;
			}
		}
	}

}
