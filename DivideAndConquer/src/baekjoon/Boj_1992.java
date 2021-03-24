package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_1992 {

	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String values = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(values.substring(j,j+1));
			}
		}
		
		divide(0,0,n);
		
		bw.write(sb.toString()+"");
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	public static void divide(int y, int x, int len) {
		
		int value = arr[y][x];
		
		if(isFull(y,x,len)) {
			sb.append(value);
		}else {

			sb.append("(");
			int newLen = len/2;
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					divide(y+newLen*i,x+newLen*j,newLen);
				}
			}
			sb.append(")");
		}
	}
	
	public static boolean isFull(int y, int x, int len) {
		int value = arr[y][x];
		
		for(int i=y;i<y+len;i++) {
			for(int j=x;j<x+len;j++) {
				if(value != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
