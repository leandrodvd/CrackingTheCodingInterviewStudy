package com.leandrodavid.crackinthecodinginterview.solutions;

import java.util.BitSet;
import java.util.Collection;
import java.util.Hashtable;

public class Arrays_1_4 {

	public static void main(String[] args) {
		
		System.out.println("Test isPPHash");
		System.out.println(isPPHash("Tact Coa")); //true
		System.out.println(isPPHash("Tact Coa o")); //true
		System.out.println(isPPHash("Tact Coa oo x")); //false

		System.out.println("Test isPPBitSet");
		System.out.println(isPPBitSet("Tact Coa")); //true
		System.out.println(isPPBitSet("Tact Coa o")); //true
		System.out.println(isPPBitSet("Tact Coa oo x")); //false
		
		System.out.println("Test isPPBitArray");
		System.out.println(isPPBitArray("Tact Coa")); //true
		System.out.println(isPPBitArray("Tact Coa o")); //true
		System.out.println(isPPBitArray("Tact Coa oo x")); //false
	}
	
	
	public static boolean isPPHash(String input){
		if(input== null) throw new IllegalArgumentException("input can't be null");
		if(input.isEmpty()) return false;
		input = input.toLowerCase().replace(" ", "");
		BitSet bs = new BitSet();
		for (int i = 0 ; i < input.length(); i++){
			bs.flip(input.charAt(i));
		}
		if(input.length()%2==0){
			if(bs.cardinality()!=0) return false;
		}else{
			if(bs.cardinality()>1) return false;
		}
		return true;
	}
	
	
	public static boolean isPPBitSet(String input){
		if(input== null) throw new IllegalArgumentException("input can't be null");
		if(input.isEmpty()) return false;
		input = input.toLowerCase().replace(" ", "");
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		for (int i = 0 ; i < input.length(); i++){
			if (ht.containsKey(input.charAt(i))){
				int newValue = ht.get(input.charAt(i)) + 1;
				ht.replace(input.charAt(i), newValue);
			}
			else{
				ht.put(input.charAt(i), 1);
			}
		}
		boolean foundOdd = false;
		for (Integer value : ht.values()){
			if(input.length() % 2 == 0){
				if (value % 2 != 0) return false;
			}else{
				if(foundOdd){
					if (value % 2 != 0) return false;
				} else{
					if (value % 2 != 0) foundOdd = true;
				}
			}
		}
		return true;
	}
	
	public static boolean isPPBitArray(String input){
		if(input== null) throw new IllegalArgumentException("input can't be null");
		if(input.isEmpty()) return false;
		input = input.toLowerCase().replace(" ", "");
		int bitArray = 0;
		for (int i = 0 ; i < input.length(); i++){
			int mask = 1 << input.charAt(i);
			bitArray =  bitArray ^ mask;
		}
	
		if(input.length() % 2 == 0){
			if (bitArray != 0) return false;
		}else{
			for (int k = 0 ; k<= 32; k++){
				if (bitArray == 1) return true;
				else {
					bitArray = bitArray >>> 1;
				}
					
			}
			return false;
		}
		
		return true;
	}

}
