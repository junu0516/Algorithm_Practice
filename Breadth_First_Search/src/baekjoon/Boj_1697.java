package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int[] map = new int[100001];
		
		int result = start<goal? bfs(start,goal,map):start-goal;
		bw.write(result+"");
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int start, int goal, int[] map) {
		Queue<Integer>toVisit = new LinkedList<Integer>();
		boolean[] visited = new boolean[100001];
		map[start]=0;
		
		toVisit.add(start);
	
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll();
			
			if(curr==goal) {
				return map[curr];
			}
			
			for(int i=0;i<3;i++) {
				int next;
				
				if(i==0) {
					next = curr+1;
				}else if(i==1) {
					next = curr-1;
				}else {
					next = curr*2;
				}
				
				if(next<0||next>100000) {//next>goal의 조건을 추가하게 되면 목표지점보다 1칸 초과한 후 다시 1칸 뒤로 가는 경우가 최소일 때를 제외하므로 넣어주면 안됨
					continue;
				}
				
				if(visited[next]==false) {
					toVisit.add(next);
					map[next] = map[curr]+1;
					visited[next] = true;
				}
			}
		}
		return 0;
	}
}
