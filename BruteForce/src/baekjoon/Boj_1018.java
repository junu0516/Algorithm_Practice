package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1018 {
	public static void main(String[] args) {
		//체스판 다시 칠하기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] pan = new char[n][m]; //체스판
		
		for(int i=0;i<n;i++) {
			char[] colors = sc.next().toUpperCase().toCharArray();
			for(int j=0;j<m;j++) {
				pan[i][j] = colors[j];
			}
		}
		
		int count = 64;
		for(int i=0;i<n;i++) {
			if(i+8>n) { //체스판을 잘랐을 때 범위 초과되면 패스
				continue;
			}
			for(int j=0;j<m;j++) {
				if(j+8>m) { //체스판을 잘랐을 때 범위 초과되면 패스
					continue;
				}
				char[][] piece = copy(pan,i,j); //범위를 넘어가지 않는 경우에만 8*8 조각을 냄
			//	System.out.println("자르기 전 :");
			//	print(piece);
			//	System.out.println();
				int white = repaint(piece,'W','B'); //기준을 하얀색으로 잡고 다시 칠한 횟수 도출
				count = Math.min(count, white);
				piece = copy(pan,i,j);
				int black = repaint(piece,'B','W'); //기준을 검정색으로 잡고 다시 칠한 횟수 도출
				count = Math.min(count, black);
			}
		//	System.out.println("================");
		}
		System.out.println(count);
	}
	
	private static int repaint(char[][] piece, char color, char other) {
		// TODO Auto-generated method stub
		//너비우선탐색으로 진행
		Queue<int[]> toVisit = new LinkedList<>();
		boolean[][] visited = new boolean[8][8];
		toVisit.add(new int[] {0,0}); //0,0에서 시작
		int[] dy = new int[] {-1,1,0,0};
		int[] dx = new int[] {0,0,1,-1};
		int count = 0;
		
		while(!toVisit.isEmpty()){
			int[] curr = toVisit.poll();
			int currY = curr[0];
			int currX = curr[1];
			
			for(int i=0;i<4;i++) {
				int nextY = currY + dy[i];
				int nextX = currX + dx[i];
				if(nextY<0 || nextX<0 || nextY>=8 || nextX>=8) {
					continue;
				}
				
				if(visited[nextY][nextX] == true) {
					continue;
				}
				
				if(nextY%2==0 && nextX%2==0) {
					if(piece[nextY][nextX] != color) {
						piece[nextY][nextX] = color;
						count++;
					}
				}
				
				if(nextY%2==0 && nextX%2==1) {
					if(piece[nextY][nextX] == color) {
						piece[nextY][nextX] = other;
						count++;
					}
				}
				
				if(nextY%2==1 && nextX%2==1) {
					if(piece[nextY][nextX] != color) {
						piece[nextY][nextX] = color;
						count++;
					}
				}
				
				if(nextY%2==1 && nextX%2==0) {
					if(piece[nextY][nextX] != other) {
						piece[nextY][nextX] = other;
						count++;
					}
				}
				
				toVisit.add(new int[] {nextY,nextX});
				visited[nextY][nextX] = true;
			}
		}
	//	print(piece);
	//	System.out.println("count : "+count);
	//	System.out.println();
		return count;
	}

	public static char[][] copy(char[][] pan, int y, int x) {
		char[][] piece = new char[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				piece[i][j] = pan[y+i][x+j];
			}
		}
		return piece;
	}
	
	public static void print(char[][] piece) {
		for(int i=0;i<piece.length;i++) {
			char[] temp = piece[i];
			for(int j=0;j<temp.length;j++) {
				System.out.print(temp[j]+" ");
			}
			System.out.println();
		}
	}
}
