package baekjoon;

import java.util.Scanner;

public class Boj_15649 {
	static int[] seq;
	static boolean[] visited;	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		seq = new int[m];
		visited = new boolean[n];		
		dfs(n,m,0);
		System.out.println(sb.toString());
		
	}
	
	public static void dfs(int n, int m, int depth) {
		if(depth==m) {
			for(int i=0;i<m;i++) {
				sb.append(seq[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				visited[i] = true;
				seq[depth] = i+1;
				dfs(n,m,depth+1);
				visited[i] = false;
			}
		}
	}
}
