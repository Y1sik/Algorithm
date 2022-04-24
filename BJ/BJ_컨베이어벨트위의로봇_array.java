package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_�����̾Ʈ���Ƿκ�_array {
	public static int N;
    public static int K;
    public static int[] A;
    public static boolean[] robot;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(conveyor_belt(0) + "\n");

        br.close();
        bw.flush();
        bw.close();

	}

	private static int conveyor_belt(int cnt) {
		while (isOK()) {
            int temp = A[A.length - 1]; // 1. ��Ʈ �� ĭ ȸ��
            for (int i = A.length - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = temp;

            for (int i = robot.length - 1; i > 0; i--) {    // �κ��� ��Ʈ�� ���� ȸ��
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false;
            for (int i = N - 1; i > 0; i--) {   // 2. �κ� �̵������ϸ� �̵�
                if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    A[i]--;
                }
            }

            if (A[0] > 0) {     // 3. �ö󰡴� ��ġ�� �κ� �ø���
                robot[0] = true;
                A[0]--;
            }
            
            cnt++;
        }

        return cnt;
	}
	 public static boolean isOK() {
	        int cnt = 0;

	        for (int i = 0; i < A.length; i++) {
	            if (A[i] == 0) {
	                cnt++;
	            }
	            if (cnt >= K) {
	                return false;
	            }
	        }
	        return true;
	    }

}
