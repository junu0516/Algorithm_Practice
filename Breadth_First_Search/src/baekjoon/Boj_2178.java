package baekjoon;

import java.io.*;
import java.util.*;

public class Boj_2178 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int result=0;
		
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(input.substring(j,j+1));
			}
		}
		
		result = bfs(arr,visited,0,0,n,m);
		
		bw.write(result+"");
	
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int[][] arr, boolean[][] visited, int y, int x, int n, int m) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		Queue<int[]> toVisit = new LinkedList<int[]>();
		toVisit.add(new int[]{y,x});
		
		while(!toVisit.isEmpty()) {
			int[] point = toVisit.poll();
			int currY = point[0];
			int currX = point[1];
			for(int i=0;i<4;i++) {
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				if(nextX<0||nextY<0||nextX>=m||nextY>=n) continue;
				if(arr[nextY][nextX]==0||visited[nextY][nextX]==true) continue;
				toVisit.add(new int[]{nextY,nextX});
				visited[nextY][nextX] = true;
				arr[nextY][nextX] = arr[currY][currX]+1;
			}
		}
		return arr[n-1][m-1];
	}

}
