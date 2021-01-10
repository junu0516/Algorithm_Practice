package baekjoon;

import java.util.Scanner;

public class Boj_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//분해합
		
		int constructor = 0;//최소생성자
		
		while(constructor <= n) {
			char[] numbers = String.valueOf(constructor).toCharArray();
			int sumSample = constructor;//분해합 샘플
			
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
		//반복문을 빠져나온 경우에는 생성자를 찾지 못한 경우이기 때문에 0을 출력
		System.out.println(0);
	}
}
