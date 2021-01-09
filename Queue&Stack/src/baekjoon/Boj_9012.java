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
			if(arr.length %2 ==0) { //���ڿ��� ���̰� ¦���� �ƴ� ���� ������ VPS�� �� �� ����
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
					System.out.println("NO"); //�ϳ��� ���������� NO
				}else {
					System.out.println("YES"); //������ ��������� YES
				}
			}else {
				System.out.println("NO");
			}

		}
	}

}
