package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_프린터큐 {
	static int T;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			
			Queue<int []> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			while(!q.isEmpty()) {
				int[] now = q.poll();
				boolean check = true;
				for (int[] que : q) {
					if(que[1] > now[1]) {
						check = false;
						break;
					}
				}
				
				if(check) {
					cnt++;
					if(now[0] == M) break;
				} else {
					q.add(now);
				}
			}
			System.out.println(cnt);
			
		}

	}

}
