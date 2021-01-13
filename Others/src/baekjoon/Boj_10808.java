package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10808 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

				String word = br.readLine();
				int[] alphabet = new int[26];
				
				for(int i=0; i<word.length(); i++)
					alphabet[word.charAt(i)-'a']++;
				
				for(int i=0; i<alphabet.length; i++)
					bw.write(alphabet[i] + " ");
				
				br.close();
				bw.flush();
				bw.close();
	}
}
