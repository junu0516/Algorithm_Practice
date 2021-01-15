package baekjoon;

import java.util.Scanner;

public class Boj_11655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length();i++) {
			char curr = input.charAt(i);
	
			if(curr==' ' ||(curr<=(int)'9' && curr>=(int)'0')) {
				sb.append(curr);
			}else {
				int value;
				int standard;
				
				if(curr>='a') {
					standard = (int)'a';
				}else {
					standard = (int)'A';
				}
				
				value = (int)curr - standard;
				char changed;
				
				if(value+13>=26) { //범위 초과
					changed = (char)(value+standard-13);
				}else {
					changed = (char)(value+standard+13);
				}
				
				sb.append(changed);
			}			
		}
		System.out.println(sb.toString());
	}

}
