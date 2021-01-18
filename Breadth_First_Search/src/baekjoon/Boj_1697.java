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
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		if(n>=k) { //목적지가 출발지보다 뒤에 있는 경우는 무조건 1칸씩 걸어야 하기 때문에, 인덱스 차이값을 출력
			bw.write(n-k+"");
		}else { //목적지가 출발지보다 앞에 있는 경우에만 bfs를 진행
			int[] graph = new int[100001]; //배열 내 특정 인덱스에 도달하기 까지 걸리는 최소시간을 할당
			int result = bfs(graph,n,k);
			bw.write(result+"");
			
		}		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int[] graph,int start, int goal) {
		Queue<Integer> toVisit = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.length];
		toVisit.add(start);
		
		graph[start] = 0; //시작지점에 가는 시간은 0
		
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll();
			int[] dx = new int[] {-1,1,curr};
			
			if(curr==goal) { //목적지에 도달하면 반복문을 빠져나감
				break;
			}
			for(int i=0;i<3;i++) {
				int next = curr+dx[i];
				
				if(next<0 || next>=graph.length || visited[next]==true) {
					continue;
				}
				
				toVisit.add(next);
				graph[next] = graph[curr]+1;
				visited[next] = true; //특정 지점에 도달하기까지 '최소 시간'만을 할당해야 하므로, 반드시 방문처리를 따로 하도록 해야 함
			}
		}
		
		return graph[goal]; //목적지에 도달하는데 걸리는 최소 시간을 리턴
	}
	
}
