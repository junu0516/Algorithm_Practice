package baekjoon;

import java.io.*;
import java.util.*;

public class Boj_1931 {
	
	/*
	 *
	 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
	 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
	 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
	 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 
	 * 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
	 * 
	 * */
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<int[]> times = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int[] time = new int[2];
			time[0] = Integer.parseInt(st.nextToken());
			time[1] = Integer.parseInt(st.nextToken());
			times.add(time);
		}
		
		//종료시간 기준으로 회의 배열을 정렬
		times.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] t1, int[] t2) {
				
				//종료시간이 같을 경우에는 시작시간 기준으로 정렬
				if(t1[1] == t2[1]) {
					return t1[0] - t2[0];
				}
				
				return t1[1]-t2[1];
			}
		});
		
		int count = 0; //회의의 개수
		int prev = 0; //이전 회의 종료시간
		
		/*
		 * prev = 0인 이유,
		 * 
		 * 이전회의의 종료시간과 겹치지 않는 선에서 최대한 많은 활동을 선택해야 하는 경우이기 때문에		 * 
		 * 종료시간 기준으로 오름차순 정렬되어 있을 때
		 * 제일 먼저 오는 활동부터 최대한 선택되어야 최대의 개수를 도출할 수 있기 때문
		 * 
		 * */
		
		//이전 회의의 종료시간이 다음 회의의 시작시간 이하인 경우에 count+1
		for(int i=0;i<times.size();i++) {
			if(prev<=times.get(i)[0]) {
				prev = times.get(i)[1]; //이전 회의 종료시간을 다시 갱신해줘야 함
				count++;
			}
		}
		
		bw.write(count+"");
		
		br.close();
		bw.flush();
		bw.close();

	}

}
