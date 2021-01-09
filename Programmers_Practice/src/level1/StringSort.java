package level1;

import java.util.*;
public class StringSort {
	
	public static String[] solution(String[] strings, int n) {    
        Arrays.sort(strings,new Comparator<String>(){
            public int compare(String s1, String s2){
               if(s1.charAt(n)>s2.charAt(n)){
                   return 1;
               }else if(s1.charAt(n)==s2.charAt(n)){
                   return s1.compareTo(s2);
               }else{
                   return -1;
               }
            }
        });
        
        String[] answer = strings;
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = new String[] {"sun","bed","car"};
		strings = solution(strings,1);
		for(int i=0;i<strings.length;i++) {
			System.out.println(strings[i]);
		}
	}

}
