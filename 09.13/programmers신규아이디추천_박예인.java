import java.util.*;

public class programmers�űԾ��̵���õ_�ڿ��� {
	public static String new_id = "=.=";
	public static String new_id2 = "";
	public static void main(String[] args) {
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		//�빮�ڸ� �ҹ��ڷ�
		new_id = new_id.toLowerCase();
//		System.out.println(new_id);
		//�ҹ���, ����, ����, ����, ��ħǥ ���� �� ����
		new_id = new_id.replaceAll("[^a-zA-Z0-9-_.]", "");
//		System.out.println(new_id);
		//.. �� .���� ��ü
		while (new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
//		System.out.println(new_id);
		//�Ǿ� or �ǵڰ� .�̸� ����
		if (new_id.charAt(0) == '.')
			new_id = new_id.substring(1);
		
		if (!new_id.equals("") && new_id.charAt(new_id.length()-1) == '.')
			new_id = new_id.substring(0, new_id.length()-1);
//		System.out.println(new_id);
		
		//������� a����
		if (new_id.length() == 0)
			new_id = "a";
//		System.out.println(new_id);
		//16�� �̻��̸� 15���� ¥���� 15��°�� .�� ��� �װ͵� �ڸ�
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(14) == '.')
				new_id = new_id.substring(0, 14);
		}
//		System.out.println(new_id);
		// new_id.length�� 2������ ��� ������ ���� ��� ���̱�
		while (new_id.length() <= 2)
			new_id += new_id.charAt(new_id.length() - 1);
		
//		System.out.println(new_id);
		
		return new_id;
	}
}
