package level2;

import java.util.HashMap;

public class PhoneNumber {
	public static boolean solution(String[] phone_book) {
		for(int i=0;i<phone_book.length;i++){
			String curr= phone_book[i];
	            
	        for(int j=0;j<phone_book.length;j++){
	        	if(i==j){
	        		continue;
	            }
	            String other = phone_book[j];
	            if(other.indexOf(curr)==0){
	            	return false;
	            }
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = new String[] {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
		System.out.println(solution(new String[] {"123","456","789"}));
	}

}
