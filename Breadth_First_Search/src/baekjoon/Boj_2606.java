package baekjoon;

import java.io.*;
import java.util.*;

public class Boj_2606 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		LinkedList<Integer>[] map = new LinkedList[num+1];
		boolean[] visited = new boolean[num+1];
		for(int i=0;i<num+1;i++) {
			map[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<edge;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
	
			map[y].add(x);
			map[x].add(y);
		}	
		
		int result = bfs(map,visited,1);
		
		bw.write(result+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int bfs(LinkedList<Integer>[] map, boolean[] visited, int start) {
		
		Queue<Integer> toVisit = new LinkedList<Integer>();
		toVisit.add(start);
		int infected = 0;
		visited[start] = true;
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll();
			
			for(int i : map[curr]) {
				if(!visited[i]) {
					toVisit.add(i);
					visited[i] = true;
					infected++;
				}
			}
		}
		
		return infected;
	}

}
