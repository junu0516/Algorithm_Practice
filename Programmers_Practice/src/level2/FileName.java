package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FileName {
	
	/*
	 * 파일명이 크게 HEAD, NUMBER, TAIL의 세 부분으로 구성되어있음
	 * 
	 * 1) HEAD는 숫자가 아닌 문자로 이루어져 있음(-와 같은 문자도 포함)
	 * 2) NUMBER은 1~5글자 사이의 연속된 숫자이며 앞에 0이 올 수 있음
	 * 3) TAIL은 나머지 부분으로 숫자와 글자 모두 가능하며, 아무것도 없을 수도 있음
	 * 
	 * 이 경우, 아래의 조건에 맞게 파일명을 정렬하기
	 * 
	 * -- 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬
	 * -- 문자열 비교시에는 대소문자는 구분하지 않음
	 * -- HEAD부분이 같을 경우에 NUMBER을 기준으로 정렬
	 * -- 단, 여기서 맨 앞의 0은 무시하도록 함
	 * -- HEAD와 NUMBER이 모두 같으면 입력 순서를 그대로 유지한 채로 놔둠
	 * 
	 * 
	 * */
	
	public static String[] solution(String[] files) {
		
		HashMap<String, ArrayList<String>> names = new HashMap<>();
		for(String key : files) {
			
			if(!names.containsKey(key)) {
				names.put(key, new ArrayList<>());
				
				int[] index = getNumberIndexes(key);
				int	numFirst = index[0]; //NUMBER의 시작 인덱스
				int numLast = index[1]; //NUMBER의 마지막 인덱스
				
				String head = key.substring(0,numFirst);
				String number = key.substring(numFirst,numLast+1);
				//System.out.println("head : "+head+", number : "+number);
				//value에 속한 배열에서 0번째는 HEAD, 1번째는 NUMBER을 넣도록 함	
				names.get(key).add(head);
				names.get(key).add(number);
			}			
		}
		
		Arrays.sort(files,new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				
				String head1 = names.get(s1).get(0).toLowerCase();
				String head2 = names.get(s2).get(0).toLowerCase();
				
				if(head1.compareTo(head2)!=0) {
					return head1.compareTo(head2);					
				}else {
					String number1 = names.get(s1).get(1);
					String number2 = names.get(s2).get(1);
					
					if(number1.charAt(0)=='0' && number1.length()>=2) {
						number1 = number1.substring(1,number1.length());
					}
					
					if(number2.charAt(0)=='0' && number2.length()>=2) {
						number2 = number2.substring(1,number2.length());
					}
					
					return Integer.parseInt(number1) - Integer.parseInt(number2);
				}
				
			}
		});
		
		return files;
	}
	
	public static int[] getNumberIndexes(String key) {
		
		int[] index = new int[2];
		
		for(int i=0;i<key.length();i++) {
			char curr = key.charAt(i);
			
			//만일 문자가 숫자가 아니라면 pass
			if((int)curr<(int)'0' || (int)curr>(int)'9') {
				continue;
			}else {
				index[0] = i;
				index[1] = i;
				break;
			}			
		}
		
		for(int i=index[0]+1;i<key.length();i++) {
			char curr = key.charAt(i);
		
			//만일 문자가 숫자일 경우에는 pass
			if((int)curr>=(int)'0' && (int)curr<=(int)'9') {
				
				//tail이 존재하지 않는 경우에는 else문을 거치지 않기 때문에 여기서 따로 판별
				if(i==key.length()-1) {
					index[1] = i;
				}
				
				continue;
			}else {
				//System.out.println("i : "+i);
				index[1] = i-1;
				break;
			}
		
		}
		//System.out.println("index[0] : "+index[0]);
		//System.out.println("index[1] : "+index[1]);
		
		return index;
	}

	public static void main(String[] args) {
		
		String[] files = new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] result = solution(files);
		for(String s : result) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println();
		files = new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		result = solution(files);
		for(String s : result) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println();
		//tail이 존재하지 않는 경우의 케이스
		files = new String[] {"A10","A9","A55"};
		result = solution(files);
		for(String s : result) {
			System.out.print(s+" ");
		}
	}

}
