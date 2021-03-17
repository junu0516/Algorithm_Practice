package baekjoon;

import java.util.Scanner;

public class Boj_1780 {
	
	/*
	 * n*n의 행렬이 있을 때, 각각의 칸에는 -1,0,1의 세 값 중 하나가 저장되어 있음
	 * 아래의 규칙과 같이 행렬을 자른다고 가정
	 * 1) 모두 같은 수로 되어 있으면 그대로 사용
	 * 2) 그렇지 않을 경우에는, 다시 같은 크기의 9개의 행렬로 자르고 1)의 과정을 반복
	 * 
	 * 위의 과정을 반복했을 때, -1, 0, 1로만 이루어진 칸의 개수를 각각 출력
	 * */
	
	static int n; //행렬의 크기 n
	static int[][] arr; //행렬
	static int[] result = new int[3]; //인덱스는 각각 -1, 0, 1에 대응 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n의 값은 1이상 3^7 이하이며, 3의 거듭제곱 형태임(3,9,27 ...)
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt()+1; //result의 인덱스가 0,1,2이기 때문에 입력값에 +1을 해줘서 인덱스값과 맞춰줘야 함
			}
		}
		
		//임의로 length 변수 생성해서 n의 값을 할당
		int length = n;
		//최초의 분할은 (행,열) 기준으로 (0,0)에서 시작
		divide(0,0,length);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public static void divide(int row, int col, int length) {
		
		if(check(row,col,length) == true) { //잘린 행렬 내의 각 칸의 값들이 모두 같은지를 확인
			//같으면 행렬상에서 해당값의 개수를 1개 누적(result 배열에서, 해당값과 일치하는 인덱스상의 값에 1 추가)
			result[arr[row][col]] += 1;
		}else {
			//그렇지 않을 경우에는 다시 행렬을 분할해야 함(2)의 과정)
			int newLen = length/3; //새로운 행렬을 9개로 잘라야 하기 때문에, length/3을 기준으로 잘라야 함
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					//기준점, 기준점+3, 기준점+6 에 해당하는 위치를 기준으로 다시 분할을 진행하는 것
					divide(row+newLen*i,col+newLen*j,newLen); //새로운 값을 기준으로 다시 divde 함수를 재귀호출하면서 행렬을 자름
				}
			}	
		}
	}
	
	public static boolean check(int row, int col, int length) {	
		int value = arr[row][col]; //기준점의 값을 value 변수에 할당
		
		//기준점에서 시작하여 잘린 행렬에 존재하는 모든 값이 value와 같은 지를 확인
		for(int i=row;i<row+length;i++) { 
			for(int j=col;j<col+length;j++) {
				if(value != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
