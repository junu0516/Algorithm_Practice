package level2;

public class Fibonacci {
	public int solution(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        if(n>=2){
            for(int i=2;i<=n;i++){
                arr[i] = (arr[i-2]+arr[i-1])%1234567;
            }
        }
        
        int answer = arr[n];
        
        return answer;
    }
}
