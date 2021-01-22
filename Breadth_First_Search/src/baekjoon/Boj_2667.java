package baekjoon;

import java.util.*;

public class Boj_2667 {
	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			String input = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(input.substring(j,j+1));
			}
		}
		
		int total = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j]==false && map[i][j]==1) {
					bfs(map,visited,i,j);
					total++;
				}
			}
		}
		
		System.out.println(total);
		list.sort(null);
		for(int i : list) {
			System.out.println(i);
		}
		
	}
	
	public static void bfs(int[][] map, boolean[][] visited, int y, int x) {
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.add(new int[] {y,x});
		int[] dy = new int[] {-1,1,0,0};
		int[] dx = new int[] {0,0,-1,1};
		
		int count = 0;
		while(!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];
			
			for(int i=0;i<4;i++){
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				
				if(nextY<0 || nextX<0 || nextY>=n || nextX>=n) {
					continue;
				}
				
				if(map[nextY][nextX]==0 || visited[nextY][nextX]) {
					continue;
				}
				
				toVisit.add(new int[] {nextY,nextX});
				visited[nextY][nextX] = true;
				count++;
			}
 		}
		
		//단지 내에 존재하는 집의 수가 1개일 경우에는, nextY, nextX가 존재하지 않기 때문에 1개를 카운트할 수 없음
		//일단 bfs함수에 들어왔다는 것은 곧 집이 적어도 1개이상 존재한다는 뜻이기 때문에, 반복문을 빠져나왔을 때 count=0이면 count++ 해주면 됨
		if(count==0) {
			count++;
		}
		
		list.add(count);
	}

	
	
}
