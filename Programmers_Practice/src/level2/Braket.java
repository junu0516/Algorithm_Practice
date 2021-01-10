package level2;

import java.util.*;

public class Braket {
	static int position;
	static boolean isCorrect(String str) {
		boolean result = true;
		int left = 0; // (의 개수
		int right = 0; // )의 개수
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='(') {
				left++;
				stack.push(str.charAt(i));
			}else {
				right++;
				if(stack.isEmpty()) {
					result = false; //스택에 (가 없는 상태에서 )가 오면 균형잡힌 괄호가 아니기 때문에 false
				}else {
					stack.pop(); //스택에 (가 있는 상태에서 )가 오면 스택에 있던 (를 pop
				}
			}
			
			if(left==right) {
				position = i+1; //u와 v가 나뉘는 위치(u는 더이상 분리될 수 없는 균형잡힌 괄호)
				return result;
			}
		}
		return true;
	}
	
	public static String solution(String p) {
        if(p.isEmpty()) {
        	return p;
        }
        
        boolean correct = isCorrect(p); //u와 v로 나눠서 u가 균형잡힌 괄호인 지를 판별
        //isCorrect 함수를 실행하면 자연스레 u와 v가 나눠지는 위치인 position 변수도 초기화됨
        //position을 기준으로 u와 v를 각각 나눠줌
        String u = p.substring(0,position); 
        String v = p.substring(position,p.length());

        if(correct) {//u가 균형잡힌 괄호일 경우 v에 대해 다시 solution() 함수를 실행(재귀)
        	return u+solution(v);
        }
        //u가 균형잡힌 괄호가 아닌 경우 문제에서의 아래 3단계를 진행
        /* 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
         * 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
         * 4-3. ')'를 다시 붙입니다. */
        String answer = "("+solution(v)+")"; //
        
        //u의 첫번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 붙여줌(4-4)
    	for(int i=1;i<u.length()-1;++i) {
    		if(u.charAt(i)=='(') {
    			answer +=")";
    		}else {
    			answer+="(";
    		}
    	}
    	return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "()))((()";
		System.out.println(solution(str));
	}

}
