package level2;

public class GroundPicking {
	public static int solution(int[][] land) {
		int answer = 0;
        
		for(int i=1;i<land.length;i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));        
            land[i][2] += Math.max(land[i-1][1],Math.max(land[i-1][0],land[i-1][3]));        
            land[i][3] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][0]));        
        }
        
        int lastIndex = land.length-1;
        for(int i=0;i<4;i++){
            answer = Math.max(answer,land[lastIndex][i]);   
        }
        return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));
		int[][]land2 = {{1,2,5,6},{5,6,7,6},{4,2,1,8},{1,2,3,4}};
		System.out.println(solution(land2));
	}
}
