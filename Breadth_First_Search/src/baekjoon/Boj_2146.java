package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2146 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int n;
	static int[][] graph;
	static int[][] continents;
	static int[][] distances;
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//1. 그래프 입력
		n = Integer.parseInt(br.readLine());
		graph = drawGraph();
		
		//2. 각 대륙을 그룹화(1~n까지)
		continents = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int name = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j] == false && graph[i][j]==1) {
					sort(visited,name,i,j);
					name++; //sort 함수 호출할 때마다, 대륙 이름을 구별하기 위해 name에 1을 더해줌
				}
			}
		}
		
		//3. 바다의 각 좌표에서 육지까지의 최소 거리를 표시
		distances = new int[n][n];
		Queue<int[]> toVisit = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				distances[i][j] = -1; //거리값은 일단 -1로 모두 초기화
				if(graph[i][j] == 1) { //육지가 발견될 경우
					toVisit.add(new int[] {i,j}); //큐에 좌표를 넣고,
					distances[i][j] = 0; //거리값을 0으로 변경
				}
			}
		}
		
		//4. 대륙의 위치 좌표와, 바다의 각 좌표에서 육지까지의 최소거리를 가지고 다리길이를 도출
		int result = getDistances(toVisit);

		bw.write(result+" ");
		
		br.close();
		bw.flush();
		bw.close();

	}

	private static int getDistances(Queue<int[]> toVisit) {
		/*
		 * 여기서는 너비우선탐색시 방문여부를 굳이 판별할 필요가 없음
		 * 
		 * */
		while(!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				
				if(nextY<0 || nextX<0 || nextY>=n || nextX>=n) {
					continue;
				}
				
				if(distances[nextY][nextX] != -1) { //좌표가 육지에 있거나, 이미 거리를 판별(배열값이 자연수)했을 경우 continue
					continue;
				}

				distances[nextY][nextX] = distances[currY][currX]+1;
				continents[nextY][nextX] = continents[currY][currX]; //바다상의 해당 좌표에서 가리키는 최소 거리값이 어느 육지와의 거리인지를 판별하기 위한 것
				toVisit.add(new int[] {nextY,nextX}); 
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				int currY = i;
				int currX = j;
				
				for(int k=0;k<4;k++) {
					int nextY = currY + dy[k];
					int nextX = currX + dx[k];
					
					if(nextY<0 || nextX<0 || nextY>=n || nextX>=n) {
						continue;
					}
					
					if(continents[currY][currX] == continents[nextY][nextX]) { //배열값이 서로 다르다는 것은, 각각 서로 다른 육지와의 거리값을 할당받았음을 의미
						continue;
					}
					
					result = Math.min(result, distances[currY][currX]+distances[nextY][nextX]);
					
				}
			}
		}
		
		return result;
	}

	private static void sort(boolean[][] visited, int name,int y, int x) {
		
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.add(new int[] {y,x});
		
		while(!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				
				if(nextY<0 || nextX<0 || nextY>=n || nextX>=n) {
					continue;
				}
				
				if(visited[nextY][nextX] == true || graph[nextY][nextX] == 0) {
					continue;
				}
				
				toVisit.add(new int[] {nextY,nextX});
				continents[nextY][nextX] = name;
				visited[nextY][nextX] = true;
			}
		}
		
		continents[y][x] = name; //만일 육지의 크기가 한 칸일 경우에는, 위의 반복문이 nextY, nextX 판별 없이 바로 종료되기 때문에 표시를 하지 못하므로, 반드시 시작점은 따로 표시해주도록 함 
	}

	private static int[][] drawGraph() throws IOException {
		
		int[][] graph = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		return graph;
	}
	

}
