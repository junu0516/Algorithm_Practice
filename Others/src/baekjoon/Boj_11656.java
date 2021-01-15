package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] arr = new String[input.length()];
		
		for(int i=0;i<arr.length;i++) {
			String temp = input.substring(i);
			arr[i] = temp;
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
