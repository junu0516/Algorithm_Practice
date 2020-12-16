package baekjoon;

import java.util.*;
import java.io.*;

public class Boj_9465 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//테스트 케이스의 수 입력
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			//정수의 갯수 입력
			int n = Integer.parseInt(br.readLine());
			
			//스티커판은 2*n 형태의 2차원 배열로 선언, 각각의 위치 방문 여부를 지정해줄 2차원 배열 선언
			int[][] sticker = new int[2][n];
			boolean[][] visited = new boolean[2][n];
			ArrayList<int[]> points = new ArrayList<int[]>();
			
			//각각의 경우를 담을 배열은 길이 n인 1차원 배열로 선언
			int[] cases = new int[n];
			
			//스티커판에 입력받은 점수들을 각각 할당
			for(int j=0;j<2;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0;k<n;k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			//떼어낼 수 있는 스티커의 경우의 수 : 1,2,3,4,5 가지가 있음 -> 1~n까지의 수 존재
			//1개일 경우 : 스티커판에서 점수 최댓값
			//2개일 경우 : 1개일 경우 + 변을 공유하지 않는 위치들 중 최댓값
			//3개일 경우 : 2개일 경우 + 변을 공유하지 않는 위치들 중 최댓값
			// .....
			//n개일 경우 : n-1개일 경우 + 변을 공유하지 않는 위치들 중 최댓값
			
			cases[0] = getMax(sticker,visited,points);
			for(int j=1;j<n;j++) {
				cases[j] = cases[j-1]+getMax(sticker,visited,points);
			}
			
			bw.write(cases[n-1]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int getMax(int[][] sticker, boolean[][] visited, ArrayList<int[]> points) {	
		int max=0;
		for(int i=0;i<sticker.length;i++) {
			for(int j=0;j<sticker[i].length;j++) {
				
				if(sticker[i][j]>max) {
					if(visited[i][j]){
						continue;
					}
					//새로운 최댓값 발견하면 기존에 저장한 위치값을 리스트에서 제거
					if(points.size()!=0) {
						points.remove(points.size()-1);
					}
					//최댓값 초기화
					max = sticker[i][j];
					//현재 위치값을 리스트에 추가
					points.add(new int[] {i,j});				
				}
			}
		}
		
		int[] point = points.get(points.size()-1);
		visited[point[0]][point[1]] = true;
		
		if(!(point[0]+1>=2)) {
			visited[point[0]+1][point[1]] = true;
		}
		if(point[1]+1 < sticker[0].length) {
			visited[point[0]][point[1]+1] = true;	
		}
		if(!(point[0]-1<0)) {
			visited[point[0]-1][point[1]] = true;
		}
		if(!(point[1]-1<0)) {
			visited[point[0]][point[1]-1] = true;
		}	
		
		return max;
	}
}
