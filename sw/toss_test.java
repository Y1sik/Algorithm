package sw;

public class toss_test {
	static int k;
	static int m;
	static String[] names = {"msLEE", "jsKim", "jsKIM", "jskiM", "jskim", "John", "john", "John", "msLEE", "msLEE", "jsKIM", "roy"};
	static int[] amounts = {50000, 52524, 50000, 6055, 10000, 4512, 512, 52000, 9000, 49000, 1400, 50000};
	public static void main(String[] args) {
		k = 3; // k���̻� ���� �۱�
		m = 50000; // m�� �̻�
		String prev = "";
		int cnt = 1; // ���� �۱�
		int result = 0; // ���� ���� Ƚ��
		
		for (int i = 0; i < names.length; i++) {
			String name = names[i].toLowerCase();
			if(i == 0) { // i�� 0 �� ��, ù ��
				prev = name; // prev�� ���� names[i]�� ����
				if(amounts[i] >= m) { // �۱� ���� �ݾ��� m �̻��� ��� ���� �߼�
					result++;
				}
			}
			else { // i�� 0 �� �ƴ� ��, �ι� �� ��
				if(prev.equals(name)) { // ���� �۱� �޴� �̸��� ���� �۱� �޴� �̸��� ���� ���
					cnt++; // ���� �۱� ī��Ʈ ����
					if(cnt >= k) { // ���� �۱� ī��Ʈ�� k �̻��� ��� ���� �߼�
						result++;
						prev = name;
						continue; // ���ڸ� �߼� �߱� ������ �۱ݵ� ������ m �̻��̾ ���� �Ⱥ����� ��
					}
					prev = name; // prev�� names[i]�� ����
					
				}else { // ���� �۱� �޴� �̸��� ���� �۱� �޴� �̸��� �ٸ� ���
					cnt = 1; // ���� �۱� ī��Ʈ 1�� �ʱ�ȭ
					prev = name; // prev�� ���� names[i]�� ����
				}
				
				if(amounts[i] >= m) { // �۱� ���� �ݾ��� m �̻��� ��� ���� �߼�
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
