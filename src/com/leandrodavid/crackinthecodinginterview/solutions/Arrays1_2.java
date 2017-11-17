package com.leandrodavid.crackinthecodinginterview.solutions;

import java.util.Arrays;
import java.util.Hashtable;

public class Arrays1_2 {

	public static void main(String[] args) {
		String str1 = "casa";
		String str2 = "saca";
		String str3 = "aacs";
		String str4 = "chicha";
		String str5 = "chica";
		String str6 = "xxyyzz";
		String str7 = "chicacasa";
		
		//test isPermutationBasic - O(nˆ2)
		System.out.println("Test isPermutationBasic");
		System.out.println("Test: " + str1 + "-" + str2 + " isPermutation:" + 
				isPermutationBasic(str1, str2));
		System.out.println("Test: " + str1 + "-" + str3 + " isPermutation:" + 
				isPermutationBasic(str1, str3));
		System.out.println("Test: " + str1 + "-" + str4 + " isPermutation:" + 
				isPermutationBasic(str1, str4));
		System.out.println("Test: " + str1 + "-" + str6 + " isPermutation:" + 
				isPermutationBasic(str1, str6));
		System.out.println("Test: " + str1 + "-" + str7 + " isPermutation:" + 
				isPermutationBasic(str1, str7));
		System.out.println("Test: " + str4 + "-" + str5 + " isPermutation:" + 
				isPermutationBasic(str4, str5));
		System.out.println("Test: " + str4 + "-" + str6 + " isPermutation:" + 
				isPermutationBasic(str4, str6));
		System.out.println("Test: " + str4 + "-" + str7 + " isPermutation:" + 
				isPermutationBasic(str4, str7));
				
				
		//test isPermutationHash  - O(n)
		System.out.println("\n\nTest isPermutationHash");
		System.out.println("Test: " + str1 + "-" + str2 + " isPermutation:" + 
							isPermutationHash(str1, str2));
		System.out.println("Test: " + str1 + "-" + str3 + " isPermutation:" + 
				isPermutationHash(str1, str3));
		System.out.println("Test: " + str1 + "-" + str4 + " isPermutation:" + 
				isPermutationHash(str1, str4));
		System.out.println("Test: " + str1 + "-" + str6 + " isPermutation:" + 
				isPermutationHash(str1, str6));
		System.out.println("Test: " + str1 + "-" + str7 + " isPermutation:" + 
				isPermutationHash(str1, str7));
		System.out.println("Test: " + str4 + "-" + str5 + " isPermutation:" + 
				isPermutationHash(str4, str5));
		System.out.println("Test: " + str4 + "-" + str6 + " isPermutation:" + 
				isPermutationHash(str4, str6));
		System.out.println("Test: " + str4 + "-" + str7 + " isPermutation:" + 
				isPermutationHash(str4, str7));
		
		//test isPermutationSort  - O(n log n)
		System.out.println("\n\nTest isPermutationSort");
		System.out.println("Test: " + str1 + "-" + str2 + " isPermutation:" + 
				isPermutationSort(str1, str2));
		System.out.println("Test: " + str1 + "-" + str3 + " isPermutation:" + 
				isPermutationSort(str1, str3));
		System.out.println("Test: " + str1 + "-" + str4 + " isPermutation:" + 
				isPermutationSort(str1, str4));
		System.out.println("Test: " + str1 + "-" + str6 + " isPermutation:" + 
				isPermutationSort(str1, str6));
		System.out.println("Test: " + str1 + "-" + str7 + " isPermutation:" + 
				isPermutationSort(str1, str7));
		System.out.println("Test: " + str4 + "-" + str5 + " isPermutation:" + 
				isPermutationSort(str4, str5));
		System.out.println("Test: " + str4 + "-" + str6 + " isPermutation:" + 
				isPermutationSort(str4, str6));
		System.out.println("Test: " + str4 + "-" + str7 + " isPermutation:" + 
				isPermutationSort(str4, str7));

	}
	public static boolean isPermutationBasic(String str1, String str2){
		if (str1 == null || str2 == null){
			throw new IllegalArgumentException("arguments can't be null");
		}
		if(str1.length() != str2.length()){
			return false;
		}
		StringBuilder sb = new StringBuilder(str2);
		for (int i = 0; i < str1.length(); i++){
			for (int j = 0; j < sb.length(); j++){
				if(str1.charAt(i) == sb.charAt(j)){
					sb.replace(j, j+1, "");
					break;
				}
				else {
					if(j == sb.length()-1){
						return false;
					}
				}
			}	
		}
		return sb.length() == 0;
	}
	
	public static boolean isPermutationHash(String str1, String str2){
		if (str1 == null || str2 == null){
			throw new IllegalArgumentException("arguments can't be null");
		}
		if(str1.length() != str2.length()){
			return false;
		}
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		for (int i = 0; i < str1.length(); i++){
			if(!ht.containsKey(str1.charAt(i))){
				ht.put(str1.charAt(i), 1);
			}
			else{
				int newValue = ht.get(str1.charAt(i)) + 1;
				ht.replace(str1.charAt(i), newValue);
			}
		}
		for (int j = 0; j < str2.length(); j++){
			if(!ht.containsKey(str2.charAt(j))){
				return false;
			}
			else {
				int value = ht.get(str2.charAt(j));
				if(value==1){
					ht.remove(str2.charAt(j));
				}
				else {
					ht.replace(str2.charAt(j), value - 1);
				}
			}
		}
		return ht.size()==0;
		
	}
	
	public static boolean isPermutationSort(String str1, String str2){
		if (str1 == null || str2 == null){
			throw new IllegalArgumentException("arguments can't be null");
		}
		if(str1.length() != str2.length()){
			return false;
		}
		char[] str1CharArray = str1.toCharArray();
		char[] str2CharArray = str2.toCharArray();
		
		Arrays.sort(str1CharArray);
		Arrays.sort(str2CharArray);
		
		String str1Sorted = new String(str1CharArray);
		String str2Sorted = new String(str2CharArray);
		
		return str1Sorted.equalsIgnoreCase(str2Sorted);	
	}
}
