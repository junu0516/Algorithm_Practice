package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1517 {
	
	static int n;
	static long[] arr;
	static long[] temp;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		temp = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * 버블정렬이라고 하지만, O(N^2)로 할 경우 시간초과가 발생
		 * 
		 * 문제에서는 단순히 값을 서로 바꿔주는 횟수만을 요구했기 때문에,
		 * 병합정렬을 수행하면서 바꿔주는 횟수만 세주면 됨
		 * 병합정렬의 시간복잡도는 O(NlogN)이기 떄문에 더 효율적
		 * 
		 * */
		mergeSort(0,arr.length-1);
		
		bw.write(result+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void mergeSort(int start, int end){
		
		if(start<end) {
			int mid = (start+end)/2;
			
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start,mid,end);
		}
	}
	
	public static void merge(int start, int mid, int end) {
		
		for(int i=start;i<=end;i++) {
			temp[i] = arr[i];
		}
		
		int front = start;
		int back = mid+1;
		int index = start;
		
		while(front<=mid && back<=end) {
			
			if(temp[front]<=temp[back]) {
				arr[index] = temp[front];
				front++;
			}else { //앞의 값이 더 큰 경우에 swap을 count해야 함
				arr[index] = temp[back];
				back++;
				result+=(mid+1-front); //버블 정렬을 가정했을 때, 앞쪽 배열에 남아있는 숫자만큼 swap이 발생
			}
			
			index++;
		}
		
		for(int i=0;i<=mid-front;i++) {
			arr[index+i] = temp[front+i];
		}
		
	}

}
