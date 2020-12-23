package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt(); //������ ����
			int m = sc.nextInt(); //�� ��°�� �μ�Ǿ����� �ñ��� ������ Queue���� �� ��°�� �����ִ� ���� ��Ÿ���� ����
			Queue<int[]> toPrint = new LinkedList<int[]>(); //����� ���� ����Ʈ
			
			for(int j=0;j<n;j++) {
				int weight = sc.nextInt();
				int[] doc = new int[2]; //���� : �ε���, �߿䵵
				doc[0] = j;
				doc[1] = weight;
				
				toPrint.add(doc);
			}
			
			int count = 0;
			while(!toPrint.isEmpty()) {
				int[] curr = toPrint.poll(); //������ �ϴ� ť���� ��
				boolean print = true; //��� ����
				
				for(int[] doc : toPrint) {
					if(doc[1] > curr[1]) {
						print = false; //�߿䵵�� ������ ��¿��θ� false�� ����
					}
				}
				
				if(print==true) {
					count++; //����ϰ� ���� count +1
					if(curr[0] == m) {
						break; //����� ������ �ε����� m�� ��ġ�ϸ� ���� ���Ա� ������ break;
					}
				}else {
					toPrint.add(curr); //������� ������ �߿䵵���� �и����̱� ������ ��¸���Ʈ ���� �ٽ� �߰�
				}
			}
			System.out.println(count);
		}
	}
}
