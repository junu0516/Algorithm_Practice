package baekjoon;

import java.util.Scanner;

public class Boj_9466 {
	static int[] graph;
	static boolean[] visited; //단순 방문 여부 판별
	static boolean[] finished; //한 사이클에 포함되는 지 여부를 판별
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count=0;
		
		while(count!=t) {
			int n = sc.nextInt();
			graph = new int[n+1];
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			
			for(int i=1;i<=n;i++) {
				int v = sc.nextInt();
				graph[i] = v;
			}
			
			result = 0;
			for(int i=1;i<=n;i++) {
				dfs(i);
			}
			
			System.out.println(n-result); //전체 노드의 개수에서, 사이클을 이루는 노드의 개수를 뺀 값을 출력
			
			count++;
		}

	}
	
	public static void dfs(int curr) {
		if(visited[curr]==true) {//이미 방문했으면 탐색할 필요가 없음
			return;
		}
		
		visited[curr] = true; //방문처리
		int next = graph[curr]; //다음 방문할 노드 지정
		
		if(visited[next]==false) {
			dfs(next); //방문할 노드가 아니면 다시 탐색(재귀)
		
		}else {//다음 노드가 이미 방문했다면, 이번에는 사이클을 이루는 지를 살펴봄
			if(finished[next]==false) {//사이클을 이루는 노드가 아닐 경우
				result++; //1개 더하고 시작
				for(int i=next;i!=curr;i=graph[i]) { //그래프 연결을 쭉 따라가면서 탐색
					result++; //연결된 노드가 존재할때마다 하나씩 누적해서 세줌
				}
			}
		}
		finished[curr] = true; //모든 과정이 끝나면 현재 노드를 더 이상 사용하지 않는 것으로 처리
	}

}
