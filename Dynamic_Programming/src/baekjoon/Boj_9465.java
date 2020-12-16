package baekjoon;

import java.util.Scanner;

public class Boj_9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//�׽�Ʈ ���̽��� �� �Է�
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			//������ ���� �Է�
			int n = sc.nextInt();
			
			//��ƼĿ���� 2*n ������ 2���� �迭�� ����, ������ ��ġ �湮 ���θ� �������� 2���� �迭 ����
			//maxScore[i][j]�� �ش� ��ġ�� ������� ���� �� �ִ� ���� �հ��� �ִ밪
			int[][] sticker = new int[2][n+1];
			int[][] maxScore = new int[2][n+1];
						
			//��ƼĿ�ǿ� �Է¹��� �������� ���� �Ҵ�
			for(int j=0;j<2;j++) {
				for(int k=1;k<=n;k++) {
					sticker[j][k] = sc.nextInt();
				}
			}
						
			// ���������� �� 2���� ����� ���� ����
			// ������ ���������� �� �� �ִ� �ִ밪�� �ش� ������ ���� ������ ����
			maxScore[0][1] = sticker[0][1];
			maxScore[1][1] = sticker[1][1];
			
			//������������ �̵��� �� �ִ� ����� ����, �밢�� ������� �밢������ ������ ��ĭ�� �� �ΰ��� ����� ���� ����
			for(int j=2;j<=n;j++) {
				maxScore[0][j] = Math.max(maxScore[1][j-1],maxScore[1][j-2])+sticker[0][j];
				maxScore[1][j] = Math.max(maxScore[0][j-1],maxScore[0][j-2])+sticker[1][j];						
			}
			
			System.out.println(Math.max(maxScore[0][n], maxScore[1][n]));					
		}
	}
}
