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
		 * 쉬운 계단수
		 * 
		 * 45656이란 수를 보자
		 * 이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.
		 * 세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.
		 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)
		 * 
		 * 입력 : 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다
		 * 출력 : 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
		 * 
		 * 예제 입력 1 : 1 
		 * 예제 출력 1 : 9
		 * 
		 * 예제 입력 2 : 2
		 * 예제 출력 2 : 17
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
