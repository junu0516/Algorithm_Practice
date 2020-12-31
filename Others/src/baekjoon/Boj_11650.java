package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Boj_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(map.containsKey(x)) {
				map.get(x).add(y);
			}else {
				map.put(x,new ArrayList<Integer>());
				map.get(x).add(y);
			}
		}
		
		int[] xs = new int[map.size()];
		int count = 0;
		for(int i : map.keySet()) {
			xs[count] = i;
			count++;
		}
		
		Arrays.sort(xs); //x 오름차순 정렬
		for(int x : xs) {
			Collections.sort(map.get(x));//y 오름차순 정렬
			for(int y : map.get(x)) {
				System.out.println(x+" "+y);
			}
		}
		
		
		
	}
}
