package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2805 {
	
	public static void main(String[] args) throws IOException {
		//TODO : 적어도 m미터의 나무를 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구할 것
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //나무의 수
		int m = Integer.parseInt(st.nextToken()); //집으로 가져갈 나무의 길이
		
		int[] trees = new int[n]; //나무의 높이들
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<trees.length;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		//이분탐색을 통해 설정할 수 있는 절단기의 최대 높이 도출
		Arrays.sort(trees);
		
		long low = 1;
		long high = trees[trees.length-1];
		long mid = 0;
		while(low<=high) {
			mid = (low+high)/2;
			long totalHeight = 0;
			
			for(int i=0;i<trees.length;i++) {
				if(trees[i]>=mid) {
					totalHeight += trees[i] - mid;
				}else {
					totalHeight += 0; 
				}
			}
			
			if(totalHeight>=m) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		bw.write(high+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
