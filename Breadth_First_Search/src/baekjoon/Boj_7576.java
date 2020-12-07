package baekjoon;

import java.io.*;
import java.util.*;

public class Boj_7576 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int[][] box = new int[row][col];
		
		//토마토 박스 완성
		for(int i=0;i<row;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<col;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = bfs(box,row,col);
		bw.write(result+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int[][] box, int row, int col) {
		Queue<int[]> toVisit = new LinkedList<int[]>();		
		int[] dx = new int[] {-1,1,0,0};
		int[] dy = new int[] {0,0,1,-1};
		
		//시작 지점 찾기
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(box[i][j]==1) {
					toVisit.add(new int[] {i,j});
				}
			}
		}
		
		//각각의 시작지점부터 bfs 시작
		while(!toVisit.isEmpty()) {
			int[] point = toVisit.poll();
			int currY = point[0];
			int currX = point[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY + dy[i];
				int nextX = currX + dx[i];
				
				if(nextY<0||nextX<0||nextY>=row||nextX>=col) {
					continue;
				}
				if(box[nextY][nextX]!=0) {
					continue;
				}

				box[nextY][nextX] = box[currY][currX]+1; 
				toVisit.add(new int[] {nextY,nextX});
			}
		}
			
		//끝나면 최대값 찾아서 -1한 값을 리턴
		int max=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(box[i][j]==0) {
					return -1;
				}
				max = Math.max(box[i][j], max);
			}
		}	
		return max-1;
	}
}
