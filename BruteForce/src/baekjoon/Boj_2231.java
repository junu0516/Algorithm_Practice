package baekjoon;

import java.util.Scanner;

public class Boj_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//������
		
		int constructor = 0;//�ּһ�����
		
		while(constructor <= n) {
			char[] numbers = String.valueOf(constructor).toCharArray();
			int sumSample = constructor;//������ ����
			
			for(int i=0;i<numbers.length;i++) {
				sumSample += Integer.parseInt(String.valueOf(numbers[i]));
			}
			
			if(sumSample == n) {
				System.out.println(constructor);
				return;
			}else {
				constructor++;
			}
		}
		//�ݺ����� �������� ��쿡�� �����ڸ� ã�� ���� ����̱� ������ 0�� ���
		System.out.println(0);
	}
}
