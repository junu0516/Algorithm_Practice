package baekjoon;

import java.util.*;

public class Boj_2667 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[][] area = new int[size][size];
		boolean[][] visited = new boolean[size][size];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<size;i++) {
			String input = sc.next();
			for(int j=0;j<size;j++) {
				area[i][j] = Integer.parseInt(input.substring(j,j+1));
			}
		}
		
		int total = 0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(area[i][j]==1&&visited[i][j]==false) {
					int num = bfs(area,visited,i,j);
					list.add(num);
					total++;
				}
			}
		}
		
		list.sort(null);
		
		System.out.println(total);
		for(int i:list) {
			System.out.println(i);
		}
	}

	public static int bfs(int[][]area, boolean[][]visited, int y, int x) {
		Queue<int[]> toVisit = new LinkedList<int[]>();
		int[] dx = new int[] {-1,1,0,0};
		int[] dy = new int[] {0,0,-1,1};
		int[] start = new int[] {y,x};
		toVisit.add(start);
		
		int count=0;
		while(!toVisit.isEmpty()) {
			int[] point = toVisit.poll();
			int currX = point[1];
			int currY = point[0];
		
			for(int i=0;i<4;i++) {
				int nextY = currY+dy[i];
				int nextX = currX+dx[i];
				
				if(nextX<0||nextY<0||nextX>=visited.length||nextY>=visited.length) {
					continue;
				}
				
				if(visited[nextY][nextX]==true||area[nextY][nextX]==0) {
					continue;
				}
				
				toVisit.add(new int[] {nextY,nextX});
				visited[nextY][nextX] = true;
				count++;
			}
		}
		
		if(count==0) {
			count++;
		}
		
		return count;
	}
	
}
