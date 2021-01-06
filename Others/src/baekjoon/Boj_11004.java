package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_11004 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list= new ArrayList<>();
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			list.add(i, Integer.parseInt(st.nextToken())); 		
		}
		
		Collections.sort(list);
		bw.write(list.get(k-1)+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
