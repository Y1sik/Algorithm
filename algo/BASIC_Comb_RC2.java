package algo;

import java.util.Arrays;

public class BASIC_Comb_RC2 {
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3];
	static int cnt = 0;
	
	public static void main(String[] args) {
		comb(0,0);
		System.out.println(cnt);
	}

	private static void comb(int srcIdx, int tgtIdx) {
		// TODO Auto-generated method stub
		if(tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			cnt++;
			return;
		}
		if(srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}

	
	
	

}
