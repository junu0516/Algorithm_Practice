package baekjoon;

import java.io.*;
import java.util.*;

public class Boj_11004 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr,0,n-1);
        bw.write(arr[k-1]+"");
        br.close();
        bw.flush();
        bw.close();
	}
	
	public static void quickSort(int[]arr, int low, int high) {
		if(low>=high) { //더 이상 리스트를 나눌 수 없을 때 종료
			return;
		}
		
		int mid = partition(arr,low,high);
		//mid를 기준으로 두 개의 리스트로 나눠서 다시 퀵 정렬 실행(분할 후 재귀 반복)
		quickSort(arr,low,mid-1);
		quickSort(arr,mid,high);
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[(low+high)/2];
		//pivot값을 기준으로 왼쪽은 더 작은값이, 오른쪽은 더 큰값이 왔는지 순서대로 점검
		while(low<=high) {
			while(arr[low] < pivot) {
				low++;
			}
			while(arr[high]>pivot) {
				high--;
			}
			/*
			 * 위의 두 반복문을 통해 점검을 마치고 나면, 
			 * arr[low]는 pivot보다 크고
			 * arr[high]는 pivot보다 작은 상태가 됨
			 * 
			 * */
			if(low<=high) {
				//이 상태에서 low < high일 경우에(비정렬 상태임을 확인), arr[low]와 arr[high]의 위치를 서로 바꿔줌
				//low>high인 경우는 둘 중 하나라도 해당 값을 기준으로 본 partition이 제대로 정렬된 것이기 때문에 swap을 할 필요가 없어짐
				swap(arr,low,high);
				//swap 이후에 low와 high를 각각 한 칸씩 옮겨야 다시 시작할 수 있음
				low++;
				high--;
			}
		}
		//위치를 바꾼 후 새로운 low 인덱스값을 리턴, 리턴값을 기준으로 다시 왼쪽/오른쪽으로 리스트를 분할
		//리턴된 값을 mid값으로 하여 다시 두 개의 파티션으로 나눠 각기 퀵 정렬을 실행하게 될 것
		return low;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
