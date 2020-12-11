package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10844 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 * ���� ��ܼ�
		 * 
		 * 45656�̶� ���� ����
		 * �� ���� ������ ��� �ڸ����� ���̰� 1�� ����. �̷� ���� ��� ����� �Ѵ�.
		 * �����̴� ���� ���̰� N�� ��� ���� �� �� �ִ��� �ñ�������.
		 * N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. (0���� �����ϴ� ���� ����.)
		 * 
		 * �Է� : ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �ڿ����̴�
		 * ��� : ù° �ٿ� ������ 1,000,000,000���� ���� �������� ����Ѵ�.
		 * 
		 * ���� �Է� 1 : 1 
		 * ���� ��� 1 : 9
		 * 
		 * ���� �Է� 2 : 2
		 * ���� ��� 2 : 17
		 * */
		int num = Integer.parseInt(br.readLine());
		long[][] arr = new long[100][9];
		long result = 0;
		
		for(int i=0;i<9;i++) {
			arr[0][i] = 1;
			if(i==8) {
				arr[1][i] = 1;
			}else {
				arr[1][i] = 2;
			}
		}
		
		if(num>2) {
			for(int i=2;i<num;i++) {
				
				for(int j=0;j<9;j++) {
					
					if(j==0) {
						arr[i][j] = (arr[i-2][j]+arr[i-1][j+1]) % 1000000000;
					}else if(j==8) {
						arr[i][j] = arr[i-1][j-1] % 1000000000;
					}else {
						arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
					}
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			result += arr[num-1][i];
		}
		
		bw.write(result+"");	
		
		br.close();
		bw.flush();
		bw.close();
	}

}
