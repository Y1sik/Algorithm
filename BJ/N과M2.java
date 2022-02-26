package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N°úM2 {
	static int N;
	static int M;
	static int[] tgt;
	static int[] src;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tgt = new int[M];
		src = new int[N];
		
		int index = 0;
		
		for (int i = 1; i <= N; i++) {
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
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
		
	}
	

}
