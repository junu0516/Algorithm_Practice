package baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1916 {
	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //������ ���� -> ����� ����
		int m = sc.nextInt(); //������ ���� -> ������ ����
		ArrayList<Node>[] map = new ArrayList[n+1]; //��ü �׷���
		int[] costs = new int[n+1]; //������������ �� �������� ��� �迭
		
		//�׷����� �迭 �ʱ�ȭ
		for(int i=1;i<=n;i++) {
			map[i] = new ArrayList<>();
			costs[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt(); //��������
			int b = sc.nextInt(); //��������
			int cost = sc.nextInt(); //���� ���(a���� b����)
			
			map[a].add(new Node(b,cost));
		}
		
		int start = sc.nextInt(); //�������� ��ȣ
		int goal = sc.nextInt(); //�������� ��ȣ
		
		//���ͽ�Ʈ�� Ž��
		dijkstra(start,goal,map,costs);
		
		//Ž�� �� costs[goal]�� ������������ �ּҺ���� ��
		int result = costs[goal];
		System.out.println(result);
		
	}
	
	public static void dijkstra(int start, int goal, ArrayList<Node>[] map, int[] costs) {
		boolean[] visited = new boolean[map.length];
		PriorityQueue<Node> toVisit = new PriorityQueue<Node>();
		costs[start] = 0;
		toVisit.add(new Node(start,costs[start]));
		
		while(!toVisit.isEmpty()) {
			int curr = toVisit.poll().end;
			
			if(visited[curr]!=false) {
				continue;
			}
			visited[curr] = true; //�湮 ó��
			
			for(Node node : map[curr]) {
				if(costs[node.end] > costs[curr]+node.weight) { //�������� ����� costs[node.end]�� inf�̱� ������ �� Ŭ �� �ۿ� ���� ��
					costs[node.end] = costs[curr]+node.weight;
					toVisit.add(new Node(node.end,costs[node.end]));
				}
			}
		}		
	}
}
