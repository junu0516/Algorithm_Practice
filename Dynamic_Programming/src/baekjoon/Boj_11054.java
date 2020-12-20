package baekjoon;

import java.util.Scanner;

public class Boj_11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * ������� ������ �� �� �ִ� ����
		 * 1) ó������ ������ ���� ����
		 * 2) ó������ ������ ���� ����
		 * 3) �����ϴٰ� �ٽ� �����ϴ� ����
		 * 
		 * �ᱹ,
		 * i��° ��ġ����, 
		 * 0~i���� �����ϴ� �κм��� �ִ� ���̿� 
		 * i+1~last ���� �����ϴ� �κм����� �ִ������ ���� ��, ������� ������ ���̰� �ȴ�.
		 * 
		 * ����, �� ���� �ִ밪�� ���ϵ��� �Ѵ�.
		 * */
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] seq = new int[size]; //��ü ����
		int[] asc = new int[size]; //���� �κм���
		int[] desc = new int[size]; //���� �κм���
		int[] bit = new int[size]; //������� ����
		
		for(int i=0;i<size;i++) {
			seq[i] = sc.nextInt(); //��ü ���� �� �ʱ�ȭ
		}
		
		
		for(int i=0;i<size;i++) {
			asc[i] = 1;
			for(int j=0;j<i;j++) {
				if(seq[j]<seq[i] && asc[i]<=asc[j]) {
					asc[i] = asc[j] +1;
				}
			}
		}
		
		//�����ϴ� �κм����� ��� �� ���������� ����
		//j�� �� ���������� i+1��° ������ ����(��, i��°�� ���� ��� ���ڸ� Ž��)
		for(int i=size-1;i>=0;i--) {
			desc[i] = 1;
			for(int j=size-1;j>i;j--) {
				if(seq[j]<seq[i] && desc[j]>=desc[i]) {
					desc[i] = desc[j]+1;
				}
			}
		}
		
		int result = 0;
		for(int i=0;i<size;i++) {
			bit[i] = asc[i]+desc[i] -1; //������� ������ ����
			result = Math.max(bit[i], result);
		}
		
		System.out.println(result);
	}
}
