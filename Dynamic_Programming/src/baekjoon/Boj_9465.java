package baekjoon;

import java.util.Scanner;

public class Boj_9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//테스트 케이스의 수 입력
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			//정수의 갯수 입력
			int n = sc.nextInt();
			
			//스티커판은 2*n 형태의 2차원 배열로 선언, 각각의 위치 방문 여부를 지정해줄 2차원 배열 선언
			//maxScore[i][j]는 해당 위치에 오기까지 나올 수 있는 점수 합계의 최대값
			int[][] sticker = new int[2][n+1];
			int[][] maxScore = new int[2][n+1];
						
			//스티커판에 입력받은 점수들을 각각 할당
			for(int j=0;j<2;j++) {
				for(int k=1;k<=n;k++) {
					sticker[j][k] = sc.nextInt();
				}
			}
						
			// 시작지점은 총 2가지 경우의 수가 존재
			// 각각의 시작지점에 올 수 있는 최대값은 해당 지점에 적힌 점수와 동일
			maxScore[0][1] = sticker[0][1];
			maxScore[1][1] = sticker[1][1];
			
			//시작지점에서 이동할 수 있는 경우의 수는, 대각선 정방향과 대각선방향 오른쪽 한칸의 총 두가지 경우의 수가 존재
			for(int j=2;j<=n;j++) {
				maxScore[0][j] = Math.max(maxScore[1][j-1],maxScore[1][j-2])+sticker[0][j];
				maxScore[1][j] = Math.max(maxScore[0][j-1],maxScore[0][j-2])+sticker[1][j];						
			}
			
			System.out.println(Math.max(maxScore[0][n], maxScore[1][n]));					
		}
	}
}
