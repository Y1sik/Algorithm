package sw;

public class toss_test {
	static int k;
	static int m;
	static String[] names = {"msLEE", "jsKim", "jsKIM", "jskiM", "jskim", "John", "john", "John", "msLEE", "msLEE", "jsKIM", "roy"};
	static int[] amounts = {50000, 52524, 50000, 6055, 10000, 4512, 512, 52000, 9000, 49000, 1400, 50000};
	public static void main(String[] args) {
		k = 3; // k번이상 연속 송금
		m = 50000; // m원 이상
		String prev = "";
		int cnt = 1; // 연속 송금
		int result = 0; // 문자 보낸 횟수
		
		for (int i = 0; i < names.length; i++) {
			String name = names[i].toLowerCase();
			if(i == 0) { // i가 0 일 때, 첫 값
				prev = name; // prev에 지금 names[i]를 저장
				if(amounts[i] >= m) { // 송금 보낸 금액이 m 이상일 경우 문자 발송
					result++;
				}
			}
			else { // i가 0 이 아닐 때, 두번 쨰 값
				if(prev.equals(name)) { // 이전 송금 받는 이름과 현재 송금 받는 이름이 같을 경우
					cnt++; // 연속 송금 카운트 증가
					if(cnt >= k) { // 연속 송금 카운트가 k 이상일 경우 문자 발송
						result++;
						prev = name;
						continue; // 문자를 발송 했기 때문에 송금된 가격이 m 이상이어도 문자 안보내도 됨
					}
					prev = name; // prev에 names[i]를 저장
					
				}else { // 이전 송금 받는 이름과 현재 송금 받는 이름이 다를 경우
					cnt = 1; // 연속 송금 카운트 1로 초기화
					prev = name; // prev에 지금 names[i]를 저장
				}
				
				if(amounts[i] >= m) { // 송금 보낸 금액이 m 이상일 경우 문자 발송
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
