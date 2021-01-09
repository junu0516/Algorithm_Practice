package level2;

public class Triangle {
	
	public static int[] solution(int n) {
		/*
		 * 
		 * n=5일 때,
		 * 삼각형의 모양은 아래와 같음..
		 * 1
		 * 2 12
		 * 3 13 11
		 * 4 14 15 10
		 * 5  6  7  8  9
		 * 
		 * 정리하면,
		 * (아래 -> 오른쪽 -> 대각선 위) 세가지패턴을 반복하면서 움직이고 있음
		 * 이동횟수는 총 n번이며 첫 방향으로 n개의 칸을 이동하면, 다음 방향은 n-1개의 칸을 이동(방향이 바뀔 때마다 이동하는 칸수가 1개씩 줄어듦)
		 * 따라서 이차원 배열 그래프를 만들어서 위의 방향대로 그래프를 탐색하면서 숫자를 하나씩 넣어주면 됨
		 * 
		 * */
		int[][] triangle = new int[n][n];
        int y=-1; //0,0부터 시작해야 하기 때문에 y의 초기값은 -1이어야 함(일단 무조건 좌표값을 +1하고 시작하기 때문)
        int x=0;
        int value = 1;
        
        for(int i=0;i<n;i++){//총 n번을 이동하는데, 아래 -> 오른쪽 -> 대각선 위 의 세가지 패턴으로 움직여야 함
            //i번째 이동이 어느 방향으로 이동해야 하는 것인지를 판별 
        	for(int j=i;j<n;j++){//이동하는 칸수는 패턴이 반복될때마다 점점 줄어듦
                if(i%3==1){//오른쪽으로 갈 때
                    x++;
                }else if(i%3==2){//대각선 위로 올라갈 때
                    x--;
                    y--;
                }else if(i%3==0){//아래로 내려갈 때
                    y++;
                }
                triangle[y][x] = value++;    
            }
        }
        
        int[] answer = new int[(n*(n+1))/2];
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(triangle[i][j]==0){
                    break;
                }
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int[] result = solution(n);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
		
		n=5;
		result = solution(n);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
		
		n=6;
		result = solution(n);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}

}
