package baekjoon;

import java.io.*;
import java.util.*;
public class Boj_1012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine()); //테스트케이스의 수 T
		for(int i=0;i<t;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken()); //가로의 길이 M
			int row = Integer.parseInt(st.nextToken()); //세로의 길이 N
			int numCab = Integer.parseInt(st.nextToken()); //배추의 개수 K
			int result = 0;
			
			int[][] farm = new int[row][col];
			boolean[][] visited = new boolean[row][col];
			for(int j=0;j<numCab;j++) {
				//배추심을 위치 입력
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1; //배추 심기
			}
			
			for(int j=0;j<row;j++) {
				for(int k=0;k<col;k++) {
					if(farm[j][k]==1&&visited[j][k]==false) {
						result += bfs(farm,visited,j,k,row,col);
					}
				}
			}
			bw.write(result+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int[][] farm, boolean[][] visited, int y, int x, int row, int col) {
		Queue<int[]>toVisit = new LinkedList<int[]>();
		toVisit.add(new int[] {y,x});
		int[] dy = new int[] {0,0,1,-1};
		int[] dx = new int[] {-1,1,0,0};
		
		while(!toVisit.isEmpty()) {
			int[] point = toVisit.poll();
			int currY = point[0];
			int currX = point[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY + dy[i];
				int nextX = currX + dx[i];
				
				//다음 방문할 위치가 farm의 범위를 넘어설 경우 pass
				if(nextY<0||nextX<0||nextY>=row||nextX>=col) {
					continue;
				}
				//이미 방문한 지점이거나, 배추가 심어져 있지 않은 지점일 경우 pass
				if(visited[nextY][nextX]==true||farm[nextY][nextX]==0) {
					continue;
				}
				toVisit.add(new int[] {nextY,nextX});
				visited[nextY][nextX] = true;
			}
		}
		return 1;
	}

}
