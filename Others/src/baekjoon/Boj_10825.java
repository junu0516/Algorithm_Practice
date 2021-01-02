package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_10825 {
	static class Entry implements Comparable<Entry>{
		String name;
		int korean;
		int math;
		int english;
		
		Entry(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.math = math;
			this.english = english;
		}
		
		@Override
		public int compareTo(Entry other) {
			// TODO Auto-generated method stub
			if(this.korean !=other.korean) {
				return other.korean-this.korean;
			}else if(this.english != other.english) {
				return this.english - other.english;
			}else if(this.math != other.math) {
				return other.math - this.math;
			}else {
				for(int i=0;i<this.name.length();i++) {
					if(this.name.charAt(i) != other.name.charAt(i)) {
						return (int)this.name.charAt(i) - (int)other.name.charAt(i);
					}
				}
			}
			return 0;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name;
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Entry> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String name = sc.next();
			int korean = sc.nextInt();
			int english = sc.nextInt();
			int math = sc.nextInt();
			
			Entry entry = new Entry(name,korean,english,math);
			list.add(entry);
			
		}
		
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
