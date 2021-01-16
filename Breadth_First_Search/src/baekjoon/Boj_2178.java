package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2178 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String input = sc.next();
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(input.substring(j,j+1));
			}
		}
		
		int result = bfs(map,n,m);
		System.out.println(result);
	}
	
	public static int bfs(int[][] map, int n, int m) {
		Queue<int[]> toVisit = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][m];
		toVisit.add(new int[] {0,0});
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		while(!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				
				if(nextY<0 || nextX<0 || nextY>=n || nextX>=m) {
					continue;
				}
				
				if(visited[nextY][nextX]==true || map[nextY][nextX]==0) {
					continue;
				}
				
				toVisit.add(new int[] {nextY,nextX});
				visited[nextY][nextX] = true;
				map[nextY][nextX] = map[currY][currX]+1;
			}
		}		
		return map[n-1][m-1];
	}

}
