package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1238 {
	
	//���(����) Ŭ���� ����
	static class Node implements Comparable<Node>{
		int index; // ��� ��ȣ
		int distance; // �Ҵ�� �Ÿ���
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int compareTo(Node node) {
			// TODO Auto-generated method stub
			return this.distance - node.distance ;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //������ ����
		int m = Integer.parseInt(st.nextToken());; //������ ����
		int x = Integer.parseInt(st.nextToken());; //��������
		
		ArrayList<Node>[] graph = new ArrayList[n+1]; //��ü �׷���
		ArrayList<Node>[] graphRev = new ArrayList[n+1]; //������ �׷���
		int[] distance = new int[n+1];
		int[] distanceRev = new int[n+1];
		
		//�Ÿ� �迭 �ʱ�ȭ, �׷����� �� ����Ʈ �Ҵ�
		for(int i=1;i<=n;i++) {
			distance[i] = 1000000000;
			distanceRev[i] = 1000000000;
			graph[i] = new ArrayList<Node>();
			graphRev[i] = new ArrayList<Node>();
		}		
		
		//�׷��� �ʱ�ȭ
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //���� ��� ��ȣ
			int b = Integer.parseInt(st.nextToken()); //�̿� ��� ��ȣ
			int weight = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,weight));
			graphRev[b].add(new Node(a,weight));
		}
		
		//x�� �������� �� ������ ���� �ִ� ��� Ž��
		dijkstra(x,graph,distance,n);
		
		//�׷����� �����, �� �������� x�� ������ ���� �ִ� ��� Ž��
		dijkstra(x,graphRev,distanceRev,n);
		
		int result = 0;
		for(int i=1;i<=n;i++) {
			//distance[i]�� distanceRev[i]�� ���ؾ� �պ� �Ÿ��� ����� �� ����
			result = Math.max(result, distance[i]+distanceRev[i]);
		}
		
		bw.write(result+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra(int start, ArrayList<Node>[] graph, int[] distance, int n) {
		boolean[] visited = new boolean[n+1]; //�湮����	
		PriorityQueue<Node> toVisit = new PriorityQueue<>();
		distance[start] = 0; //���� ����� �Ÿ����� 0���� ���� �ʱ�ȭ
		toVisit.offer(new Node(start,distance[start]));
		
		while(!toVisit.isEmpty()) {
			Node curr = toVisit.poll();
			int currIdx = curr.index;
			
			if(visited[currIdx] == true) {
				continue;
			}
			
			visited[currIdx] = true;
			
			for(Node node : graph[currIdx]) {
				//�Ÿ��� �ʱ�ȭ
				if(distance[node.index] > distance[currIdx] + node.distance) {
					distance[node.index] = distance[currIdx] + node.distance;
					toVisit.add(new Node(node.index,distance[node.index]));
				}
			}
		}
	}

}
