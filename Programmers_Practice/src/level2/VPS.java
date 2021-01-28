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
            /*
             * 코드 수정
             * 
             * 기존 코드로 돌릴 경우
             * ())) 와 같은 경우도 올바른 괄호로 판단함
             * 따라서, stack.peek() ==')'인 경우를 따로 판단하도록 수정해야 함
             * 
             * */
            if(curr=='('){
                stack.add(curr);
            }else if(curr==')'){
            	if(stack.isEmpty()){
                    stack.add(curr);
                }else{
                    if(stack.peek()=='('){ 
                        stack.pop();                        
                    }else{
                        continue; //) 하나만 남은 경우에는 )를 만나고 pop해주면 잘못된 결과를 도출할 수 있음!
                    }
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
		s="()))"; //테스트 케이스 추가
		System.out.println(solution(s));

	}
}
