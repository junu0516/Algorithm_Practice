package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt(); //문서의 개수
			int m = sc.nextInt(); //몇 번째로 인쇄되었는지 궁금한 문서가 Queue에서 몇 번째에 놓여있는 지를 나타내는 정수
			Queue<int[]> toPrint = new LinkedList<int[]>(); //출력할 문서 리스트
			
			for(int j=0;j<n;j++) {
				int weight = sc.nextInt();
				int[] doc = new int[2]; //문서 : 인덱스, 중요도
				doc[0] = j;
				doc[1] = weight;
				
				toPrint.add(doc);
			}
			
			int count = 0;
			while(!toPrint.isEmpty()) {
				int[] curr = toPrint.poll(); //문서를 일단 큐에서 뺌
				boolean print = true; //출력 여부
				
				for(int[] doc : toPrint) {
					if(doc[1] > curr[1]) {
						print = false; //중요도가 낮으면 출력여부를 false로 설정
					}
				}
				
				if(print==true) {
					count++; //출력하고 나면 count +1
					if(curr[0] == m) {
						break; //출력한 문서의 인덱스가 m과 일치하면 답이 나왔기 때문에 break;
					}
				}else {
					toPrint.add(curr); //출력하지 않으면 중요도에서 밀린것이기 때문에 출력리스트 끝에 다시 추가
				}
			}
			System.out.println(count);
		}
	}
}
