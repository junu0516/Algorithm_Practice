package baekjoon;

import java.io.*;
import java.util.*;

public class Boj_1149 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[][] cost = new int[num+1][4];
		int[][] cases = new int[num+1][4];
		
		for(int i=1;i<=num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			cost[i][1] = red;
			cost[i][2] = green;
			cost[i][3] = blue;
		}
		
		cases[1][1] = cost[1][1];
		cases[1][2] = cost[1][2];
		cases[1][3] = cost[1][3];
		
		for(int i=2;i<=num;i++) {
			cases[i][1] = Math.min(cases[i-1][2],cases[i-1][3])+cost[i][1];
			cases[i][2] = Math.min(cases[i-1][1],cases[i-1][3])+cost[i][2];
			cases[i][3] = Math.min(cases[i-1][1],cases[i-1][2])+cost[i][3];
		}
		
		int result = Math.min(Math.min(cases[num][1],cases[num][2]), cases[num][3]);
		bw.write(result+"");
		br.close();
		bw.flush();
		bw.close();
	}

}
