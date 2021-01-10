package level1;
import java.util.*;

public class DescSort {
	 public static String solution(String s) {
		 char[] arr = s.toCharArray();
	        Arrays.sort(arr);
	        StringBuilder sb= new StringBuilder();
	        for(int i=arr.length-1;i>=0;i--){
	            sb.append(arr[i]);
	        }
	        String answer = sb.toString();
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Zbcdefg";
		s = solution(s);
		System.out.println(s);
	}

}
