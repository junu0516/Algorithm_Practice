package level2;

import java.util.*;

public class Braket {
	static int position;
	static boolean isCorrect(String str) {
		boolean result = true;
		int left = 0; // (�� ����
		int right = 0; // )�� ����
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='(') {
				left++;
				stack.push(str.charAt(i));
			}else {
				right++;
				if(stack.isEmpty()) {
					result = false; //���ÿ� (�� ���� ���¿��� )�� ���� �������� ��ȣ�� �ƴϱ� ������ false
				}else {
					stack.pop(); //���ÿ� (�� �ִ� ���¿��� )�� ���� ���ÿ� �ִ� (�� pop
				}
			}
			
			if(left==right) {
				position = i+1; //u�� v�� ������ ��ġ(u�� ���̻� �и��� �� ���� �������� ��ȣ)
				return result;
			}
		}
		return true;
	}
	
	public static String solution(String p) {
        if(p.isEmpty()) {
        	return p;
        }
        
        boolean correct = isCorrect(p); //u�� v�� ������ u�� �������� ��ȣ�� ���� �Ǻ�
        //isCorrect �Լ��� �����ϸ� �ڿ����� u�� v�� �������� ��ġ�� position ������ �ʱ�ȭ��
        //position�� �������� u�� v�� ���� ������
        String u = p.substring(0,position); 
        String v = p.substring(position,p.length());

        if(correct) {//u�� �������� ��ȣ�� ��� v�� ���� �ٽ� solution() �Լ��� ����(���)
        	return u+solution(v);
        }
        //u�� �������� ��ȣ�� �ƴ� ��� ���������� �Ʒ� 3�ܰ踦 ����
        /* 4-1. �� ���ڿ��� ù ��° ���ڷ� '('�� ���Դϴ�. 
         * 4-2. ���ڿ� v�� ���� 1�ܰ���� ��������� ������ ��� ���ڿ��� �̾� ���Դϴ�.
         * 4-3. ')'�� �ٽ� ���Դϴ�. */
        String answer = "("+solution(v)+")"; //
        
        //u�� ù��°�� ������ ���ڸ� �����ϰ�, ������ ���ڿ��� ��ȣ ������ ����� �ٿ���(4-4)
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
