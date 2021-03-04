package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Boj_1937 {
	/*
	 * 루트노드가 항상 1번노드라고 가정했을 때,
	 * 트리의 지름을 구하는 알고리즘
	 * 
	 * */
	static HashMap<Integer,ArrayList<int[]>> tree = new HashMap<>();
	static int maxNode = 0;
	static int maxSum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //노드의 개수
		
		if(n==1) { //입력범위에 1도 포함되기 때문에, n==1일대는 0을 출력하고 리턴
			System.out.println(0);
			return;
		}
		
		//트리 생성
		for(int i=1;i<n;i++) {
			int parent = sc.nextInt(); //부모노드
			int child = sc.nextInt(); //자식노드
			int weight = sc.nextInt(); //가중치
			
			if(!tree.containsKey(parent)) {
				tree.put(parent, new ArrayList<int[]>());
			}
			
			if(!tree.containsKey(child)) {
				tree.put(child,  new ArrayList<int[]>());
			}
			
			tree.get(parent).add(new int[] {child,weight});
			tree.get(child).add(new int[] {parent,weight});
		}
		
		
		/*
		 * 임의의 한 점에서 제일 멀리 떨어진 점을 구한 후,
		 * 그 점에서 다시 제일 멀리떨어진 점을 구해 두 지점사이의 거리를 도출
		 * */
		
		boolean[] visited = new boolean[n+1];
		dfs(1,0,visited);

		visited = new boolean[n+1];
		int start = maxNode; //제일 거리가 먼 지점을 다시 시작점으로 지정
		maxNode = 0;
		maxSum = 0;
		dfs(start,0,visited);

		System.out.println(maxSum);
	}
	
	public static void dfs(int node, int weight, boolean[] visited) {
	
		visited[node] = true;
		
		for(int[] child : tree.get(node)) {
			
			if(visited[child[0]] == false) {
				if(weight+child[1]>maxSum) { //거리 비교
					maxSum = weight+child[1];
					maxNode = child[0];
				}
				
				dfs(child[0],weight+child[1],visited);
			}	
		}
	}
}
