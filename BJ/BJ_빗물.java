package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_ºø¹° {
	static int H, W;
	static int[] wall;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		wall = new int[W];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			wall[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(rain());
	}

	private static int rain() {
		int result = 0;
		for (int i = 1; i < W - 1; i++) {
			int now = wall[i];
			int prev = wall[i];
			int next = wall[i];
			
			for (int j = i - 1; j >= 0; j--) {
				if(wall[j] > now) {
					prev = Math.max(prev, wall[j]);
				}
			}
			
			for (int j = i + 1; j < W; j++) {
				if(wall[j] > now) {
					next = Math.max(next, wall[j]);
				}
			}
			
			if(Math.min(prev, next) > now) {
				result += (Math.min(prev, next) - now);
			}
			
			
		}
		return result;
		
	}

}
