package baekjoon;

import java.util.Scanner;

public class Boj_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] seq = new int[size];
		int[] min = new int[size];
		for(int i=0;i<size;i++) {
			seq[i] = sc.nextInt();
		}
		
		min[0] = 1;
		int result = 1;
		for(int i=1;i<size;i++) {
			min[i] = 1; //�ʱ� �κм����� ���̰��� 1�� ����
			for(int j=0;j<i;j++) {
				//���� ��ġ������ ��� �����ؼ�,
				//���� seq[i]���� ���� seq[j]�� �� ũ��, �κм����� ���� min[i]�� min[j]���� ���� ��쿡��
				//�����ϴ� �κм��� ������ �����Ѵٰ� ������ �� ����
				
				//���� �� ��� min[i] ���̴� (�����ϴ� �κм��� ������  �����ϴ�)min[j]�� 1�� ���� ���� ��
				if(seq[j]>seq[i] && min[i]<=min[j]) {
					min[i] = min[j]+1;
				}
			}
			result = Math.max(result, min[i]);
		}
		
		System.out.println(result);
	}
}
