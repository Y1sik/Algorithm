package algo;

import java.util.Arrays;

public class BASIC_KMP_PI {

	public static void main(String[] args) {
		String pattern = "ABAABAB";
		System.out.println(Arrays.toString(getPi(pattern)));
	}
	
	static int[] getPi(String p) {
		int[] pi = new int[p.length()];
		char[] pArray = p.toCharArray();
		
		int j = 0; // �젒�몢�궗 index
		// �젒誘몄궗 index i <- for 臾� �븞�뿉�꽌 怨꾩냽 利앷�
		for (int i = 1; i < pArray.length; i++) {
			
			while( j>0 && pArray[i] != pArray[j]) j = pi[j-1]; // �젒誘몄궗�� �씪移섑븯吏� �븡�쑝硫� �젒�몢�궗 index 議곗젙
			
			if(pArray[i] == pArray[j]) pi[i] = ++j;
		}
		return pi;
	}

}

/*
pi[0] = 0
pi[1] = 0
....

  i=1				pi[1] = 0 洹몃�濡� 蹂��솕 x
A B A A B A B
  A B A A B A B
  j=0

    i=2				pi[2] = 1 (++j)
A B A A B A B
    A B A A B A B
    j=0 => j=1

    *
A B A
*

      i=3				while : j = pi[j-1] = pi[0] = 0
A B A A B A B
    A B A A B A B
      j=1


      i=3				pi[3] = 1(++j)
A B A A B A B
      A B A A B A B
      j=0 => j=1
      
      *
A B A A
*

        i=4			pi[4] = 2(++j)
A B A A B A B
      A B A A B A B
        j=1 => j=2
          
      * *
A B A A B
* *

          i=5			pi[5] = 3(++j)
A B A A B A B
      A B A A B A B
          j=2 => j=3
          
      * * *
A B A A B A
* * *

            i=6			while : j = pi[j-1] = pi[2] = 1
A B A A B A B
      A B A A B A B
            j=3 

            i=6			pi[6] == 2(++j)
A B A A B A B
          A B A A B A B
            j=1






*/