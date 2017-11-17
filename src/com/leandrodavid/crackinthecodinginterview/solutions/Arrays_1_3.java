package com.leandrodavid.crackinthecodinginterview.solutions;

public class Arrays_1_3 {

	public static void main(String[] args) {
		String testStr = "Mr John Smith                    ";
		char[] testArray = testStr.toCharArray();
		char[] result = URLfy(testArray, 13);
		char[] resultStr = URLfy(testArray, 13);
		System.out.println(testStr);
		System.out.println(resultStr);

	}

	public static char[] URLfy(char[] s, int n){
		int remSpace = 0;
		for (int i = 0; i < n; i++){
			if( s[i]==' '){
				remSpace++;
			}
		}
		for (int j = n-1; j > 0; j--){
			if(s[j] != ' '){
				s[j + remSpace*2] = s[j];
			}
			else{
				s[j + remSpace*2  ] = '%';
				s[j + remSpace*2-1] = '0';
				s[j + remSpace*2-2] = '2';
				if (remSpace == 1){
					return s;
				}
				else {
					remSpace -= 1;
				}
			}
			
		}
		return s;
	}
}
