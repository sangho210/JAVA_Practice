class Test3 {

	public static void main(String[] args) {

		int r = 10;
		//float area;
		//float length;
		float area, length; //�ڷ��� float

		area = r * r * 3.14f; // 3.14�� double�̹Ƿ� f�� �ٿ� float�� ������ �ش�.
		length = r * 2 * 3.14f;
		
		System.out.printf("������: %d, ����: %f\n", r, area);
		System.out.printf("������: %d, ����: %.2f\n", r, area);
		System.out.printf("�ѷ�: %.2f\n", length);
	}
}