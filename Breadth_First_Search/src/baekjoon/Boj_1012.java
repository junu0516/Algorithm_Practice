package baekjoon;

import java.io.*;
import java.util.*;
public class Boj_1012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine()); //�׽�Ʈ���̽��� �� T
		for(int i=0;i<t;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken()); //������ ���� M
			int row = Integer.parseInt(st.nextToken()); //������ ���� N
			int numCab = Integer.parseInt(st.nextToken()); //������ ���� K
			int result = 0;
			
			int[][] farm = new int[row][col];
			boolean[][] visited = new boolean[row][col];
			for(int j=0;j<numCab;j++) {
				//���߽��� ��ġ �Է�
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1; //���� �ɱ�
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
				
				//���� �湮�� ��ġ�� farm�� ������ �Ѿ ��� pass
				if(nextY<0||nextX<0||nextY>=row||nextX>=col) {
					continue;
				}
				//�̹� �湮�� �����̰ų�, ���߰� �ɾ��� ���� ���� ������ ��� pass
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
