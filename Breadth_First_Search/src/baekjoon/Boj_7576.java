package baekjoon;

import java.util.*;

public class Boj_7576 {
	static int col;
	static int row;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		col = sc.nextInt();
		row = sc.nextInt();
		int[][] box = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		int result = bfs(box);
		System.out.println(result);
		
	}
	
	public static int bfs(int[][] box) {
		Queue<int[]> toVisit = new LinkedList<>();
		int[] dy = new int[] {-1,1,0,0};
		int[] dx = new int[] {0,0,1,-1};
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(box[i][j]==1) {
					toVisit.add(new int[] {i,j});
				}
			}
		}
		
		while(!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				
				if(nextY<0||nextX<0||nextY>=row||nextX>=col) {
					continue;
				}
				
				if(box[nextY][nextX] != 0) {
					continue;
				}
				
				box[nextY][nextX] = box[currY][currX] +1;
				toVisit.add(new int[] {nextY,nextX});
			}
		}
		
		int result = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(box[i][j]==0) {
					return -1;
				}
				result = Math.max(result, box[i][j]);
			}
		}
		
		return result-1; //box[i][j]=1부터 시작했기 때문에, 결과값-1로 리턴해야 함
	}
	
}
