package com.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
	
	public static void main(String[] args) {

		int[] array = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 };

		// map��key��������д��ڵ����֣�value��Ÿ������������г��ֵĴ���
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				int temp = map.get(array[i]);

				map.put(array[i], temp + 1);
			} else {
				map.put(array[i], 1);
			}
		}

		Collection<Integer> count = map.values();

		// �ҳ�map��value���������֣�Ҳ�������������ֳ������Ĵ���
		int maxCount = Collections.max(count);

		int maxNumber = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			// �õ�valueΪmaxCount��key��Ҳ���������г��ִ�����������
			if (maxCount == entry.getValue()) {
				maxNumber = entry.getKey();
				System.out.println("���ִ�����������Ϊ��" + maxNumber);
				System.out.println("������һ������" + maxCount + "��");
			}
		}

	}

}
