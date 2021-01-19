package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1012 {
	static int n;
	static int m;
	static int k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); 
		for(int i=0;i<t;i++) {
			m = sc.nextInt(); //가로의 길이
			n = sc.nextInt(); //세로의 길이
			k = sc.nextInt(); //배추가 심어져 있는 위치의 개수
			
			int[][] farm = new int[n][m];
			boolean[][] visited = new boolean[n][m];
			
			for(int j=0;j<k;j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				farm[y][x] = 1;//배추심기
			}
			
			int count = 0;
			for(int j=0;j<n;j++) {
				for(int l=0;l<m;l++) {
					if(visited[j][l]==false && farm[j][l] ==1) {
						count += bfs(farm, visited, j, l);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static int bfs(int[][] farm, boolean[][] visited, int y, int x) {
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.add(new int[] {y,x});
		int[] dy = new int[] {0,0,-1,1};
		int[] dx = new int[] {-1,1,0,0};
		
		while(!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				
				if(nextY<0||nextX<0||nextY>=n||nextX>=m) {
					continue;
				}
				
				if(visited[nextY][nextX] == true || farm[nextY][nextX]==0) {
					continue;
				}
				
				toVisit.add(new int[] {nextY,nextX});
				visited[nextY][nextX] = true;
			}
		}
		
		return 1;
	}

}
