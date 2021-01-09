package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Boj_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] input = new String[n];
		
		for(int i=0;i<input.length;i++) {
			input[i] = sc.next();
		}
		
		for(int i=0;i<n;i++) {
			String curr = input[i];
			Stack<Character> stack = new Stack<>();
			char[] arr = curr.toCharArray();
			if(arr.length %2 ==0) { //문자열의 길이가 짝수가 아닌 경우는 무조건 VPS가 될 수 없음
				for(int j=0;j<arr.length;j++) {
					if(j==0) {
						if(arr[j]==')') {
							stack.push(arr[j]);
							break;
						}else {
							stack.push(arr[j]);
						}
					}else {
						if(arr[j]=='(') {
							stack.push(arr[j]);
						}else {
							if(stack.size() ==0) {
								stack.push(arr[j]);
								break;
							}else {
								stack.pop();
							}	
						}
					}
					//System.out.println(stack);
				}
				
				if(stack.size() != 0) {
					System.out.println("NO"); //하나라도 남아있으면 NO
				}else {
					System.out.println("YES"); //스택이 비어있으면 YES
				}
			}else {
				System.out.println("NO");
			}

		}
	}

}
