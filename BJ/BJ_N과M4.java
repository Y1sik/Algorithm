package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_N°úM4 {
	static int N;
	static int M;
	static int[] src;
	static int[] tgt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		tgt = new int[M];
		
		int index = 0;
		
		for (int i = 1; i <= src.length; i++) {
			src[index++] = i;
		}
		
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
