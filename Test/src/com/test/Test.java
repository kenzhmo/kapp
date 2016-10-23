package com.test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	
		public Test(){}
	
	    public static int solution(int M, int[] A) {
	    	
	    	int returnValue = 0;
	    	
	    	List intrimValue = new ArrayList();
	    	
			// map的key存放数组中存在的数字，value存放该数字在数组中出现的次数
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < A.length; i++) {
				if (map.containsKey(A[i])) {
					int temp = map.get(A[i]);

					map.put(A[i], temp + 1);
				} else {
					map.put(A[i], 1);
				}
			}

			Collection<Integer> count = map.values();

			// 找出map的value中最大的数字，也就是数组中数字出现最多的次数
			int maxCount = Collections.max(count);

			int maxNumber = 0;

			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				// 得到value为maxCount的key，也就是数组中出现次数最多的数字
				if (maxCount == entry.getValue()) {
					maxNumber = entry.getKey();
					intrimValue.add(maxNumber);
				}
			}

			if (intrimValue.size() > 1) {
				
				Collections.sort(intrimValue);
				
				return ((Integer)intrimValue.get(intrimValue.size() - 1)).intValue();
				
			} else if (intrimValue.size() == 1) {
				return ((Integer)intrimValue.get(0)).intValue();
			}
			
			return returnValue;
	    }
	    
	    public Record getRecord(int hh, int mm, int ss) {
	    	return new Record(hh, mm, ss);
	    }
	    
	    public Record getRecord(String hhmmssString, String receivedNo) {
	    	return new Record(hhmmssString, receivedNo);
	    }
	    
	    public class Record {
	    	
	    	public Record(int hh, int mm, int ss){
	    		this.duration = new Time(hh,mm,ss);
	    	};
	    	
	    	public Record(String hhmmssString, String receivedNo){
	    		this.duration = Time.valueOf(hhmmssString);
	    		this.receivedNo = receivedNo;
	    	};
	    	
	    	private Time duration;
	    	
	    	private String receivedNo;
	    	
	    	public Time getDuration() {
	    		return this.duration;
	    	}
	    	
	    	public String getReceivedNo() {
	    		return this.receivedNo;
	    	}
	    	
	    }

	public static void main(String[] args) {
		int[] A = {4,4,4,4,3,3,3,3,3};
		int M = 8;
		int result = Test.solution(M, A);
		
		System.out.println("result is [" + result + "]");
		
//		String string = "HAB C";
//		
//		char cha = string.charAt(0);
//		
//		int chaASSII = (int)cha;
		
//		char[] chaASCIIArray = {10};
		
//		String stringfromASCII = new String(chaASCIIArray);
//		
//		System.out.println("H equals to [" + chaASSII + "]");
//		
//		System.out.println("72 equals to string [" + stringfromASCII + "]");
		
//		Test test = new Test();
//		
//		test.solution(new String());
		
	}

	public class RecordComparator implements Comparator<Record> {

		public RecordComparator(){}
		
		@Override
		public int compare(Record arg0, Record arg1) {
			// TODO Auto-generated method stub
			return arg0.getReceivedNo().compareTo(arg1.getReceivedNo());
		}
		
	}
	
	public int solution(String S) {
		
		int returnInt = 0;
		
		char[] chaASCIIArray = {10};
		
		String[] recordStringArray = S.split(new String(chaASCIIArray));
		
		Test test = new Test();
		
		List<Record> recordList = new ArrayList<Record>();
		
		for (int i=0;i<recordStringArray.length;i++) {
			String recordString = recordStringArray[i];
			String[] recordStringDetails = recordString.split(",");
			Record record = test.getRecord(recordStringDetails[0], recordStringDetails[1]);
			recordList.add(record);
		}
		
		recordList.sort(new RecordComparator());
				
		return returnInt;
	}

}
