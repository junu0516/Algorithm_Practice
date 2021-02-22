package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_2331 {
	static int a;
	static int p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		p = sc.nextInt();
		
		ArrayList<Integer> graph = new ArrayList<>();
		boolean[] visited = new boolean[1000000];
		graph.add(a);
		int result = dfs(graph,visited,a);
		
		System.out.println(result);
	}
	
	public static int dfs(ArrayList<Integer> graph, boolean[] visited, int n) {

		while(visited[n]!=true) {
			
			visited[n] = true;
			String s = String.valueOf(n);
			int next = 0;
			for(int i=0;i<s.length();i++) {
				next += (int)Math.pow(Integer.parseInt(s.substring(i,i+1)), p);
			}
			graph.add(next);
			n = next;
		}
		
		graph.remove(graph.size()-1);
		int index = graph.indexOf(n);
		return index;
	}
}
