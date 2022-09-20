import java.util.Arrays;

public class programmers����ū�� {
	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		String result = solution(numbers);
		System.out.println(result);
	}

	public static String solution(int[] numbers) {
		String answer = "";
		
		//���� int[]�� string[]���� ��ȯ
		String[] s = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			s[i] = String.valueOf(numbers[i]);
		}
		//����� ã�ƺô�... 
		//sort �ϱ� ���Ͽ� comparator�� ����� ��
		//34, 30, 3�� ������ 34, 3, 30�� �Ǿ�� �ϴµ� 34, 30, 3�� �Ǳ� ������
		//�ƽ�Ű�ڵ尪�� ��
		Arrays.sort(s, (a,b)->{
            return (a+b).compareTo(b+a);
        });
		
		//���ڿ� ���� 
		for(int i=numbers.length-1; i>=0; i--){
            answer+=s[i];
        }
		
		//�Է� �����Ͱ� ��� 0�̸� ����ó��
		if(s[0].equals("0")) 
			answer = "0";
		
		return answer;
	}

}
