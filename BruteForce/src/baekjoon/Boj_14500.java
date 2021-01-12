package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_14500 {
	static int result=0;
	static int n;
	static int m;
	static int[][] graph;
	static boolean[][] visited;
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visited[i][j] = true;
				dfs(i,j,0,0);
				visited[i][j] = false;
				getSpecialSum(i,j);
			}
		}
		
		bw.write(result+"");
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int y, int x, int length, int sum) {
		if(length==4) {
			result = Math.max(result, sum);
			return;
		}
		
		
		for(int i=0;i<4;i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];			
			
			if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
                continue;
            }
            if (visited[nextY][nextX]) {
                continue;
            }
            
            visited[nextY][nextX] = true;
			dfs(nextY,nextX,length+1,sum+graph[nextY][nextX]);
			visited[nextY][nextX] = false;
			
		}
	}
	
	public static void getSpecialSum(int y, int x) {
		//ㅗ ㅜ ㅏ ㅓ 네가지 모양 검사해보기
		
		if(x-1>=0 && y-1>=0 && x+1<m) {
			int first = graph[y][x]+graph[y][x-1]+graph[y][x+1]+graph[y-1][x];
			result = Math.max(result, first);
		}
		
		if(x-1>=0 && y+1<n && x+1<m) {
			int second = graph[y][x]+graph[y][x-1]+graph[y][x+1]+graph[y+1][x];
			result = Math.max(second, result);
		}
		
		if(x+1<m && y+1<n && y-1>=0) {
			int third = graph[y][x+1]+graph[y-1][x]+graph[y+1][x]+graph[y][x];
			result = Math.max(third, result);
		}
		
		if(x-1>=0 && y-1>=0 && y+1<n) {
			int forth = graph[y][x-1]+graph[y-1][x]+graph[y+1][x]+graph[y][x];
			result = Math.max(forth, result);
		}
	
	}
}
