package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_4963 {
	static int w;
	static int h;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			w = sc.nextInt();
			h = sc.nextInt();
			if(w==0 && h==0) {
				break;
			}
			
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						bfs(map,visited,i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}
	
	public static void bfs(int[][] map, boolean[][] visited, int y, int x) {
	
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.add(new int[] {y,x});
		//상하좌우 + 대각선 방향으로 움직이는 경우의 수는 총 8개
		int[] dx = new int[] {-1,1,0,1,-1,-1,0,1};
		int[] dy = new int[] {0,0,1,1,1,-1,-1,-1};
		
		while(!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];

			for(int i=0;i<8;i++) {
				
				int nextX = currX+dx[i];
				int nextY = currY+dy[i];
				
				if(nextY<0 || nextX<0 || nextY>=h || nextX>=w) {
					continue;
				}
				
				if(map[nextY][nextX]==0 || visited[nextY][nextX]==true) {
					continue;
				}
				
				visited[nextY][nextX] = true;
				toVisit.add(new int[] {nextY,nextX});
			}
		}
	}
}
