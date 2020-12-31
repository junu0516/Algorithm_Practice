package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Boj_10814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		HashMap<Integer,ArrayList<String>> map = new HashMap<>(); 
		for(int i=0;i<n;i++) {
			int age = sc.nextInt();
			String name = sc.nextLine();
			
			if(map.containsKey(age)) {
				map.get(age).add(name);
			}else {
				map.put(age, new ArrayList<String>());
				map.get(age).add(name);
			}
		}
		
		int[] ages = new int[map.size()];
		int index = 0;
		for(int i : map.keySet()) {
			ages[index] = i; 
			index++;
		}
		
		Arrays.sort(ages);
		for(int age : ages) {
			for(String name : map.get(age)) {
				System.out.println(age+""+name);
			}
		}
	}
}
