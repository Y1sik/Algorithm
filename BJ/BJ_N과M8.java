package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_N°úM8 {
	static int N, M;
	static int[] src;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		tgt = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		
		comb(0, 0);
	}

	private static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			for (int i = 0; i < tgt.length; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(srcIdx == src.length) return;
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
		
	}

}
