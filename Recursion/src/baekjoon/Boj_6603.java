package baekjoon;

import java.util.Scanner;

public class Boj_6603 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			
			if(n==0) {
				break;
			}
			
			int[] arr = new int[n];
			boolean[] visited = new boolean[n];
			
			for(int i=0;i<arr.length;i++) {
				arr[i] = sc.nextInt();
			}
			
			dfs(arr,visited,0,0);
			System.out.println();
		}
	}
	

	public static void dfs(int[] arr,boolean[] visited, int num, int depth) {
		//재귀 호출을 통한 깊이우선 탐색
		if(depth==6) {
			for(int i=0;i<arr.length;i++) {
				if(visited[i]==true) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		for(int i=num;i<arr.length;i++) {
			visited[i] = true;
			dfs(arr,visited,i+1,depth+1);
			visited[i] = false;//바닥찍고 다시 돌아온 후 방문처리 false로 바꿔줘야 함
		}		
	}
}
