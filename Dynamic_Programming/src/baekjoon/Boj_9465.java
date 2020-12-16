package baekjoon;

import java.util.*;
import java.io.*;

public class Boj_9465 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//�׽�Ʈ ���̽��� �� �Է�
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			//������ ���� �Է�
			int n = Integer.parseInt(br.readLine());
			
			//��ƼĿ���� 2*n ������ 2���� �迭�� ����, ������ ��ġ �湮 ���θ� �������� 2���� �迭 ����
			int[][] sticker = new int[2][n];
			boolean[][] visited = new boolean[2][n];
			ArrayList<int[]> points = new ArrayList<int[]>();
			
			//������ ��츦 ���� �迭�� ���� n�� 1���� �迭�� ����
			int[] cases = new int[n];
			
			//��ƼĿ�ǿ� �Է¹��� �������� ���� �Ҵ�
			for(int j=0;j<2;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0;k<n;k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			//��� �� �ִ� ��ƼĿ�� ����� �� : 1,2,3,4,5 ������ ���� -> 1~n������ �� ����
			//1���� ��� : ��ƼĿ�ǿ��� ���� �ִ�
			//2���� ��� : 1���� ��� + ���� �������� �ʴ� ��ġ�� �� �ִ�
			//3���� ��� : 2���� ��� + ���� �������� �ʴ� ��ġ�� �� �ִ�
			// .....
			//n���� ��� : n-1���� ��� + ���� �������� �ʴ� ��ġ�� �� �ִ�
			
			cases[0] = getMax(sticker,visited,points);
			for(int j=1;j<n;j++) {
				cases[j] = cases[j-1]+getMax(sticker,visited,points);
			}
			
			bw.write(cases[n-1]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int getMax(int[][] sticker, boolean[][] visited, ArrayList<int[]> points) {	
		int max=0;
		for(int i=0;i<sticker.length;i++) {
			for(int j=0;j<sticker[i].length;j++) {
				
				if(sticker[i][j]>max) {
					if(visited[i][j]){
						continue;
					}
					//���ο� �ִ� �߰��ϸ� ������ ������ ��ġ���� ����Ʈ���� ����
					if(points.size()!=0) {
						points.remove(points.size()-1);
					}
					//�ִ� �ʱ�ȭ
					max = sticker[i][j];
					//���� ��ġ���� ����Ʈ�� �߰�
					points.add(new int[] {i,j});				
				}
			}
		}
		
		int[] point = points.get(points.size()-1);
		visited[point[0]][point[1]] = true;
		
		if(!(point[0]+1>=2)) {
			visited[point[0]+1][point[1]] = true;
		}
		if(point[1]+1 < sticker[0].length) {
			visited[point[0]][point[1]+1] = true;	
		}
		if(!(point[0]-1<0)) {
			visited[point[0]-1][point[1]] = true;
		}
		if(!(point[1]-1<0)) {
			visited[point[0]][point[1]-1] = true;
		}	
		
		return max;
	}
}
