package com.leandrodavid.crackinthecodinginterview.solutions;

import java.util.BitSet;
import java.util.Hashtable;

public class Arrays1_1 {

	public static void main(String[] args) {
		System.out.println("isUniqueHashtable");
		System.out.println(isUniqueHashtable("abcx"));
		System.out.println(isUniqueHashtable("xx"));
		
		System.out.println("\nisUniqueNoDataStructure");
		System.out.println(isUniqueNoDataStructure("abcx"));
		System.out.println(isUniqueNoDataStructure("xx"));
		
		System.out.println("\nisUniqueBitSet");
		System.out.println(isUniqueBitSet("abcx"));
		System.out.println(isUniqueBitSet("xx"));
	}
	
	public static boolean isUniqueHashtable(String word){
		if (word == null) throw new IllegalArgumentException("String word can't be null");
		if (word.isEmpty()) return true;
		Hashtable<Character,Boolean> ht = new Hashtable<Character,Boolean>();
		for (int i = 0; i < word.length(); i++){
			if(ht.containsKey(word.charAt(i))) return false;
			ht.put(word.charAt(i), true);
		}
		return true;
	}
	
	public static boolean isUniqueNoDataStructure(String word){
		if (word == null) throw new IllegalArgumentException("String word can't be null");
		if (word.isEmpty()) return true;
		for (int i =0; i< word.length() -1; i++){
			for(int j = i+1; j<word.length();j++){
				if(word.charAt(i) == word.charAt(j)) return false;
			}
		}
		return true;		
	}
	
	public static boolean isUniqueBitSet(String word){
		if (word == null) throw new IllegalArgumentException("String word can't be null");
		if (word.isEmpty()) return true;
		BitSet bs = new BitSet();
		for (int i=0; i< word.length(); i++){
			if(bs.get(word.charAt(i))) return false;
			bs.set(word.charAt(i));
		}
		return true;
	}

}
