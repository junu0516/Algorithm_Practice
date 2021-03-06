package baekjoon;

import java.io.*;

public class Boj_1904 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		arr[1] = 1;
		
		if(n>=2) {
			arr[2] = 2;
			for(int i=3;i<=n;i++) {
				int temp = arr[i-2]+arr[i-1];
				arr[i] = temp%15746;
			}
		}
		
		bw.write(arr[n]+"");
		
		br.close();
		bw.flush();
		bw.close();

	}

}
