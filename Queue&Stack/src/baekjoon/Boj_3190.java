package baekjoon;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Boj_3190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //보드의 크기
		int k = sc.nextInt(); //사과의 개수
		int[][] board = new int[n+1][n+1];
		
		for(int i=0;i<k;i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			board[y][x] = 1; //사과의 위치
		}
		
		int l = sc.nextInt(); //뱀의 방향 변환 정보
		HashMap<Integer,Character> direction = new HashMap<>();
		for(int i=0;i<l;i++) {
			int x = sc.nextInt(); //x초가 지난 후
			char c = sc.next().toUpperCase().charAt(0); //해당 방향으로 90도 회전(D: 오른쪽, L: 왼쪽)
			direction.put(x, c);
		}
		
		int result = move(direction,board,n);
		System.out.println(result);
	}
	
	public static int move(HashMap<Integer,Character> direction, int[][] board, int n) {
		int pointer = 1; //1: 동 , 2: 서 , 3: 남 , 4 : 북
		Deque<int[]> snake = new LinkedList<>();
		int count = -1;
		snake.add(new int[] {1,1}); //맨 처음 뱀의 위치
		
		//게임 시작
		while(true) {
			count++; //매턴마다 1초씩 count
			
			//현재 머리 위치
			int[] currHead = snake.peekLast();
			
			int[] nextHead = new int[] {}; //다음 턴에 머리가 향할 위치
			if(direction.containsKey(count)) {//방향전환 타이밍인지 판별
				char value = direction.get(count);
				if(value=='D') { //오른쪽으로 90도 회전
					
					if(pointer==1) {//동쪽을 바라볼 경우
						nextHead = new int[] {currHead[0]+1,currHead[1]};
						pointer = 3;
					}else if(pointer==2) {//서쪽을 바라볼 경우
						nextHead = new int[] {currHead[0]-1,currHead[1]};
						pointer = 4;
					}else if(pointer==3) {//남쪽을 바라볼 경우
						nextHead = new int[] {currHead[0],currHead[1]-1};
						pointer = 2;
					}else if(pointer==4) {//북쪽을 바라볼 경우
						nextHead = new int[] {currHead[0],currHead[1]+1};
						pointer = 1;
					}
					
				}else if(value=='L') {//왼쪽으로 90도 회전
					
					if(pointer==1) {//동쪽을 바라볼 경우
						nextHead = new int[] {currHead[0]-1,currHead[1]};
						pointer = 4;
					}else if(pointer==2) {//서쪽을 바라볼 경우
						nextHead = new int[] {currHead[0]+1,currHead[1]};
						pointer = 3;
					}else if(pointer==3) {//남쪽을 바라볼 경우
						nextHead = new int[] {currHead[0],currHead[1]+1};
						pointer = 1;
					}else if(pointer==4) {//북쪽을 바라볼 경우
						nextHead = new int[] {currHead[0],currHead[1]-1};
						pointer = 2;
					}
				}
			}else {//오른쪽으로 전진
	
				if(pointer==1) {//동쪽을 바라볼 경우
					nextHead = new int[] {currHead[0],currHead[1]+1};
				}else if(pointer==2) {//서쪽을 바라볼 경우
					nextHead = new int[] {currHead[0],currHead[1]-1};
				}else if(pointer==3) {//남쪽을 바라볼 경우
					nextHead = new int[] {currHead[0]+1,currHead[1]};
				}else if(pointer==4) {//북쪽을 바라볼 경우
					nextHead = new int[] {currHead[0]-1,currHead[1]};
				}
			}
						
			if(nextHead[0]<=0 || nextHead[1]<=0 || nextHead[0]>n || nextHead[1]>n ) {
				count++;
				return count; //벽에 부딪히는 경우 = 다음 위치가 board의 범위를 초과
			}

			for(int[] point : snake) { //몸통과 부딪히는 지를 판별
				if(point[0]==nextHead[0] && point[1]==nextHead[1]) {
					count++;
					return count;
				}
			}
			
			if(board[nextHead[0]][nextHead[1]] == 1) {//머리가 이동한 칸에 사과가 존재할 경우
				System.out.println("사과 존재");
				board[nextHead[0]][nextHead[1]] = 0; //사과를 없애줌
				snake.addLast(nextHead); //몸의 길이가 늘어났기 때문에, 기존 덱 + 머리의 새로운 위치로 덱을 초기화
			}else { //머리가 이동한 칸에 사과가 존재하지 않을 경우
				snake.addLast(nextHead);
				snake.pollFirst(); //꼬리를 제거
			}
		}			
	}
}
