package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Boj_11651 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(map.containsKey(y)) {
				map.get(y).add(x);
			}else {
				map.put(y,new ArrayList<Integer>());
				map.get(y).add(x);
			}
		}
		
		int[] ys = new int[map.size()];
		int count = 0;
		for(int i : map.keySet()) {
			ys[count] = i;
			count++;
		}
		
		Arrays.sort(ys); //y 오름차순 정렬
		for(int y : ys) {
			Collections.sort(map.get(y));//x 오름차순 정렬
			for(int x : map.get(y)) {
				System.out.println(x+" "+y);
			}
		}
		
	}

}
