package level2;

import java.util.Stack;

public class VPS {
	public static boolean solution(String s) {
		char[] arr = s.toCharArray();
        if(arr[0]==')'||arr.length %2 != 0){
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            char curr = arr[i];
            
            if(curr=='('){
                stack.add(curr);
            }else if(curr==')'){
                if(stack.isEmpty()){
                    stack.add(curr);
                }else{
                    stack.pop();
                }
            }
        }
        
        boolean answer = true;
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()()";
		System.out.println(solution(s));
		s=")()(";
		System.out.println(solution(s));
	}
}
