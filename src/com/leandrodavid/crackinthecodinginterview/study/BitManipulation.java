package com.leandrodavid.crackinthecodinginterview.study;

public class BitManipulation {

	public static void main(String[] args) {
		bitInversion();
		shift();

	}
	
	public static void bitInversion(){
		System.out.println("Bit Inversion");
		byte b = 1;
		byte b2 = (byte) ~b;
		System.out.println(b);
		System.out.println(b2);
	}
	
	public static void shift(){
		System.out.println("\nShift");
		System.out.println("int");
		int b = 1;
		System.out.println(b); //1
		System.out.println(b<<1);//2
		System.out.println(b<<2);//4
		System.out.println(b<<3);//8
		System.out.println(b<<8);//258
		System.out.println(b<<30);//1073741824 (2^30)
		System.out.println(b<<31);//-2147483648
		System.out.println(b<<32);//1
		System.out.println("\nlong");
		long l = 1;
		System.out.println(l); //1
		System.out.println(l<<1);//2
		System.out.println(l<<2);//4
		System.out.println(l<<3);//8
		System.out.println(l<<8);//258
		System.out.println(l<<30);//1073741824 (2^30)
		System.out.println(l<<31);//2147483648
		System.out.println(l<<32);//4294967296
		System.out.println(l<<62);//4611686018427387904
		System.out.println(l<<63);//-9223372036854775808
		System.out.println(l<<64);//1
		
	}

}
