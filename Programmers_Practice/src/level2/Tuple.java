package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple {
	public static int[] solution(String s) {
		String[] arr = s.split("\\}\\,\\{");
		arr[0] = arr[0].substring(2);
		arr[arr.length-1] = arr[arr.length-1].substring(0,arr[arr.length-1].indexOf("}"));
			
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
				
		});
			
		ArrayList<String> temp = new ArrayList<>();
		temp.add(arr[0]);
		for(int i=1;i<arr.length;i++) {
			String[] curr = arr[i].split(",");
			for(int j=0;j<curr.length;j++) {
				if(!temp.contains(curr[j])) {
					temp.add(curr[j]);
				}
			}
		}
			
		int[] answer = new int[temp.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i] = Integer.parseInt(temp.get(i));
		}
	    return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] answer = solution(s);
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]);
		}
		s="{{1,2,3},{2,1},{1,2,4,3},{2}}";
		answer = solution(s);
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]);
		}
	}	

}
