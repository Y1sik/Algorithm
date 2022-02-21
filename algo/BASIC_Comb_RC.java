package algo;

import java.util.Arrays;

public class BASIC_Comb_RC {

	static int COUNT = 0;
	static int[] src = {1, 2, 3, 4, 5};
	static int[] tgt = new int[3];
	
	// 以묐났 �닚�뿴 X
	// 以묐났 �뿀�슜 X
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		comb(0, 0);
		System.out.println(COUNT);
	}
	
	private static void comb(int srcIdx, int tgtIdx) {
		// 湲곗� 議곌굔
		if(tgtIdx == tgt.length) {
			// complete code!!
			// �닚�뿴 �븯�굹 �셿�꽦!! = 臾몄젣�뿉 留욌뒗 異붽� �옉�뾽
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		if(srcIdx == src.length) return;
		
		// 媛� 吏��젙
		tgt[tgtIdx] = src[srcIdx];
		// YES
		comb(srcIdx + 1, tgtIdx + 1);
		// NO
		comb(srcIdx + 1, tgtIdx);
		
		
	}

}
