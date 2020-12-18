package baekjoon;

import java.util.Scanner;

public class Boj_2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		/*
		 * n=1 : 0
		 * n=2 : 3
		 * n=3 : 0
		 * ...
		 * n�� Ȧ���� ��� ����� ���� ������ 0(1*1 �� ĭ�� ������ ���� ����)
		 * �ᱹ, ¦���� ��� ����� ���� � �������� �����ϴ� ���� ã�ƾ� �Ѵ�.
		 * */
		
		arr[0] = 1;
		if(n>=2) {
			arr[2] = 3;
			//Ȧ���� ��쿡�� ���� 0�̱� ������ ¦���� ��츸 ����Ѵ�.
			for(int i=4;i<=n;i+=2) {
				arr[i] = arr[i-2]*3; //3*2 �� ĭ ����� ����� �� 3���� * ������ 3*(i-2) ����� ����� ����� ��
				for(int j=0;j<i-2;j+=2) {
					arr[i] += arr[j]*2; //���� ���̽��鿡�� ��Ÿ�� Ư�� ���̽���*2�� ��� ������
				}
			}
		}
		
		int result = arr[n];
		System.out.println(result);
		
		
		
	}
}
