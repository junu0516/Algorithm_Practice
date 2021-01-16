package baekjoon;

import java.util.Scanner;

public class Boj_11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int count = (int)(Math.pow(2, n)-1);
		sb.append(count+"\n");
		move(n,1,2,3); //옮길 원판의 개수, 출발지, 중간 경유지, 최종 목적지(재귀호출)
		//여기서는 n개의 원판을 1번에서 출발하여, 2번을 경유해서 3번으로 옮기는 함수라는 것
		
		/*
		 * 원판 1개일 경우 -> 1번 수행
		 * 원판 2개일 경우 -> 3번 수행(1 중간에 놓기 -> 2 맨 끝에 놓기 -> 1 맨 끝에 놓기)
		 * 원판이 3개일 경우 -> 7번 수행
		 * 원판이 4개일 경우 -> (원판 3개를 중간으로 이동) + (4번 원판 맨 끝으로 이동) + (3번 원판 맨 끝으로 이동) = 15번 수행
		 * 
		 * ... 원판이 n개일 경우 -> 2*(n-1개일 떄의 횟수) + 1
		 * n-1개의 원판을 중간으로 이동시킨 후, 맨 밑의 원판을 맨 끝으로 이동하고, 중간에 있는 원판들을 다시 맨 끝으로 놓는 패턴이 반복되기 때문!
		 * 
		 * */
		System.out.println(sb.toString());
	}
	
	public static void move (int n, int start, int middle, int end) {
		if(n==1) { //마지막 원판을 시작에서 끝으로 옮겨줌(원판의 개수가 1만 남았을 경우)
			sb.append(start+" "+end+"\n");
			return;
		}
		
		move(n-1,start,end,middle); //맨 아래를 제외한 n-1개의 원판을 맨 끝을 거쳐 중간 지점으로 우선 옮겨야 함
		sb.append(start+" "+end+"\n");
		
		move(n-1,middle,start,end); //다시 중간에 있는 n-1개의 원판을 처음을 거쳐 맨 끝 지점으로 옮겨줌
		
	}

}
