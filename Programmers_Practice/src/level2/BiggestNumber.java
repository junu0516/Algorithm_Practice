package level2;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
	
	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		for(int i=0;i<arr.length;i++) {
			arr[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int n1 = Integer.parseInt(o1+o2);
				int n2 = Integer.parseInt(o2+o1);
				
				if(n1>n2) {//o1 -> o2 순서로 배치
					return -1;
				}else if(n1<n2) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			if(arr[0].equals("0")) {
				return "0";
			}
			sb.append(arr[i]);
		}		
		
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {6,10,2}));
		System.out.println(solution(new int[] {3,30,34,5,9}));
		System.out.println(solution(new int[] {9,998,999}));
		System.out.println(solution(new int[] {0,0,0,0}));
	}

}
