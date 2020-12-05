package baekjoon;

import java.io.*;
import java.util.*;
public class Boj_1932 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<int[]> triangle = new ArrayList<int[]>();
		ArrayList<int[]> max = new ArrayList<int[]>(); 
		
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			int[] curr = new int[i];
			max.add(curr);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<i;j++) {
				curr[j] = Integer.parseInt(st.nextToken());
			}
			triangle.add(curr);
		}
		
		for(int i=0;i<n;i++) {
			max.get(n-1)[i] = triangle.get(n-1)[i];
		}
		
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				max.get(i)[j] = Math.max(max.get(i+1)[j], max.get(i+1)[j+1]) + triangle.get(i)[j];
			}
		}
				
		int result = max.get(0)[0];
		bw.write(result+"");
		
	
		br.close();
		bw.flush();
		bw.close();
	}

}
