package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Boj_1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashSet<String> set = new HashSet<String>();
		for(int i=0;i<n;i++) {
			set.add(sc.next());
		}
		
		
		String[] arr = new String[set.size()];
		Iterator iterator = set.iterator();
		
		int index = 0;
		while(iterator.hasNext()) {
			arr[index] = (String)iterator.next();
			index++;
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length()<s2.length()) {
					return -1;
				}else if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}else {
					return 1;
				}
			}
			
		});
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}

	}
}
