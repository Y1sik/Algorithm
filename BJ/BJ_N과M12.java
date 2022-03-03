package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ_N°úM12 {
	static int N, M;
	static int[] src;
	static int[] tgt;
	static LinkedHashSet<String> result;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		tgt = new int[M];
		result = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		
		comb(0, 0);
		result.forEach(System.out :: println);

	}
	private static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tgt.length; i++) {
				sb.append(tgt[i]).append(' ');
			}
			result.add(sb.toString());
			return;
		}
		
		if(srcIdx == src.length) return;
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx, tgtIdx + 1);
		comb(srcIdx + 1,tgtIdx);
		
	}

}
