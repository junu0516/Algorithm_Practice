package level2;

import java.util.HashSet;

public class Ending {
	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int count = 0;
		int cycle = 0;
		HashSet<String> usedWords = new HashSet<>();
		String curr = words[0];
		String prev = words[0];
		
		while(true) {
			if(count>=words.length) {//모든 턴이 끝나면 반복문을 빠져나감
				break;
			}
			
			int person = (count+1)%n==0? n:(count+1)%n; //현재 몇번째 주자가 단어를 말하는 지 판별
			cycle = (count)/n; //해당 주자가 몇번째로 단어를 말하는 지 판별
			prev = curr; //이전 count에 언급된 단어
			curr = words[count]; //현재 언급된 단어
			
			if(count>=1) { //두번째 사람이 단어를 언급할 때부터, 게임 규칙 위반 여부를 판단하면 됨
				if(curr.charAt(0) != prev.charAt(prev.length()-1)) {//다음 단어의 첫번째 글자가, 이전 단어의 마지막 글자와 일치하지 않으면 반복문을 빠져나감
					answer[0] = person;
					answer[1] = cycle+1;
					break; 
				}
				
				if(usedWords.contains(curr)) {//이미 사용된 단어 목록에 다음 단어가 포함되어 있으면 반복문을 빠져나감
					answer[0] = person;
					answer[1] = cycle+1;
					break;
					
				}
			}

			usedWords.add(curr); //이미 사용된 단어 목록에 현재 언급된 단어를 추가
			count++;
			
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String[] words = new String[] {"tank","kick","know","wheel","land","dream","mother","robot","tank"};
		int[] answer = solution(3,words);
		System.out.println();
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.println();
		System.out.println("======================");
		words=  new String[] {"hello","one","even","never","now","world","draw"};
		answer = solution(2,words);
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}

}
