package algo;

import java.util.Arrays;

public class BASIC_Comb_FOR2 {

	static int COUNT = 0;
	static int[] src = {1, 2, 3, 4, 5};
	static int[] tgt = new int[3];
	
	// 以묐났 �닚�뿴 X
	// 以묐났 �뿀�슜 X
	
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		comb(0, 0);
		System.out.println(COUNT);
	}
	
	private static void comb(int srcIdx, int tgtIdx) {
		System.out.println(srcIdx + " " + tgtIdx);
		// 湲곗� 議곌굔
		if(tgtIdx == tgt.length) {
			// complete code!!
			// �닚�뿴 �븯�굹 �셿�꽦!! = 臾몄젣�뿉 留욌뒗 異붽� �옉�뾽
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		// src 濡쒕��꽣 紐⑤뱺 �닔瑜� 怨좊젮 �떒, �씠誘� �꽑�깮�맂 �닽�옄�뒗 �젣�쇅
		for (int i = srcIdx; i < src.length; i++) {
			
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1); 
			// 
		}
		
	}

}
