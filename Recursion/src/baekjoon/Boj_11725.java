package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Boj_11725 {
	
	static HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<n;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			if(!tree.containsKey(v1)) {
				tree.put(v1, new ArrayList<>());
			}
			
			tree.get(v1).add(v2);
			
			if(!tree.containsKey(v2)) {
				tree.put(v2, new ArrayList<>());
			}
			
			tree.get(v2).add(v1);
		}
		
		visited = new boolean[n+1];
		answer = new int[n+1];
		
		//깊이 우선탐색을 통해 각 노드마다 부모노드 표시
		for(int i=1;i<=n;i++) {
			if(visited[i] == false) {
				dfs(i);
			}
		}
		
		for(int i=2;i<=n;i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void dfs(int v) {
		
		visited[v] = true;
		for(int i : tree.get(v)) {
			if(visited[i]==false) {
				answer[i] = v;
				dfs(i);
			}
		}
	}
}
