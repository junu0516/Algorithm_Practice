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
		if(low>=high) { //�� �̻� ����Ʈ�� ���� �� ���� �� ����
			return;
		}
		
		int mid = partition(arr,low,high);
		//mid�� �������� �� ���� ����Ʈ�� ������ �ٽ� �� ���� ����(���� �� ��� �ݺ�)
		quickSort(arr,low,mid-1);
		quickSort(arr,mid,high);
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[(low+high)/2];
		//pivot���� �������� ������ �� ��������, �������� �� ū���� �Դ��� ������� ����
		while(low<=high) {
			while(arr[low] < pivot) {
				low++;
			}
			while(arr[high]>pivot) {
				high--;
			}
			/*
			 * ���� �� �ݺ����� ���� ������ ��ġ�� ����, 
			 * arr[low]�� pivot���� ũ��
			 * arr[high]�� pivot���� ���� ���°� ��
			 * 
			 * */
			if(low<=high) {
				//�� ���¿��� low < high�� ��쿡(������ �������� Ȯ��), arr[low]�� arr[high]�� ��ġ�� ���� �ٲ���
				//low>high�� ���� �� �� �ϳ��� �ش� ���� �������� �� partition�� ����� ���ĵ� ���̱� ������ swap�� �� �ʿ䰡 ������
				swap(arr,low,high);
				//swap ���Ŀ� low�� high�� ���� �� ĭ�� �Űܾ� �ٽ� ������ �� ����
				low++;
				high--;
			}
		}
		//��ġ�� �ٲ� �� ���ο� low �ε������� ����, ���ϰ��� �������� �ٽ� ����/���������� ����Ʈ�� ����
		//���ϵ� ���� mid������ �Ͽ� �ٽ� �� ���� ��Ƽ������ ���� ���� �� ������ �����ϰ� �� ��
		return low;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
