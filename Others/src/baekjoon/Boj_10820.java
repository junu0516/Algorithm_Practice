package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10820 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		while((str=br.readLine())!= null) {
			int bl = 0;
			int sl = 0;
			int num = 0;
			int space = 0;
			
			for(int i=0;i<str.length();i++) {
				char curr = str.charAt(i);
				int value = (int)curr;
				if(value>=(int)'0'&& value<=(int)'9') {
					num++;
				}else if(value>=(int)'a'&& value<=(int)'z') {
					sl++;
				}else if(value>=(int)'A'&& value<=(int)'Z') {
					bl++;
				}else {
					space++;
				}
			}
			bw.write(sl+" "+bl+" "+num+" "+space+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
