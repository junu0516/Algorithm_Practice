package baekjoon;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
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
		System.out.println();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
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
		Queue<int[]> head = new LinkedList<>();
		Deque<int[]> tail = new LinkedList<>();
		int count = -1;
		head.add(new int[] {1,1}); //맨 처음 머리의 위치
		tail.add(new int[] {1,1}); //맨 처음 꼬리의 위치
		
		//게임 시작
		while(true) {
			count++; //매턴마다 1초씩 count
			
			System.out.println(count+"초 전");
			//머리 이동
			int[] currHead = head.poll();
			System.out.println("현재 머리 : "+currHead[0]+","+currHead[1]);
			
			int[] nextHead = new int[] {}; //다음 턴에 머리가 향할 위치
			if(direction.containsKey(count)) {//방향전환 타이밍인지 판별
				char value = direction.get(count);
				if(value=='D') { //오른쪽으로 90도 회전
					System.out.println("오른쪽으로 90도 회전");
					
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
					System.out.println("왼쪽으로 90도 회전");
					
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
				System.out.println("오른쪽으로 전진");
	
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
			
			System.out.println("다음 머리 : "+nextHead[0]+","+nextHead[1]);
			head.add(nextHead);
			
			if(nextHead[0]<=0 || nextHead[1]<=0 || nextHead[0]>n || nextHead[1]>n ) {
				count++;
				break; //벽에 부딪히는 경우 = 다음 위치가 board의 범위를 초과
			}
			
			//꼬리 이동
			if(board[currHead[0]][currHead[1]] == 1) {//만일 머리가 이동한 칸에 사과가 존재할 경우
				System.out.println("사과 존재");
				board[currHead[0]][currHead[1]] = 0; //사과를 없애줌
				tail.addLast(currHead); //꼬리가 움직이지 않은채 몸길이가 늘어났기 때문에, 꼬리 덱의 마지막 인덱스에 현재 머리의 위치를 넣어줌
			}else { //머리가 이동한 칸에 사과가 존재하지 않을 경우
				//몸길이를 줄여서 꼬리가 위치한 칸을 비워야 함 = 덱의 맨 처음 인덱스(사실상 꼬리의 맨 끝부분)에 위치한 값을 없애주면 됨
				if(tail.size()>1) {
					tail.pollFirst();
					tail.addLast(currHead);
				}
			}
			print(tail);
			System.out.println(tail.contains(nextHead));
			
			if(tail.contains(nextHead)) {
				break;//자기 자신의 몸과 부딪히는 경우
			}	
						
		}		
		
		return count;
	}
	
	public static void print(Deque<int[]> tail) {
		int len = tail.size();
		System.out.print("꼬리 상태 : [");
		for(int i=0;i<len;i++) {
			int[] curr = tail.pollFirst();
			System.out.print("("+curr[0]+","+curr[1]+") ");
			tail.addLast(curr);
		}
		System.out.print("]");
		System.out.println();
	}
}
