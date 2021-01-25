package org.yan.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A util program to convert the digits from 0 to 9 into letters
 * @author mingyan
 */
public class LetterCombinationUtil {
	public static void main(String args[]) {
		Integer input[];
		//input = new Integer[] {2, 3, 99, 73};
		//System.out.println(letterCombination(input).size() == (3 * 3 * 4 * 4 * 4 * 3));
		
		input = new Integer[] {21};
		System.out.println(letterCombination(input).size() == (3));
		
		input = new Integer[] {12};
		System.out.println(letterCombination(input).size() == (3));
		
		input = new Integer[] {213};
		System.out.println(letterCombination(input).size() == (3 * 3));
		
		input = new Integer[] {99};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {97};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {77};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {79};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {719};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {71};
		System.out.println(letterCombination(input).size() == (4));
		
		input = new Integer[] {17};
		System.out.println(letterCombination(input).size() == (4));
		
		input = new Integer[] {919};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {717};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {179};
		System.out.println(letterCombination(input).size() == (4 * 4));
		
		input = new Integer[] {791};
		System.out.println(letterCombination(input).size() == (4 * 4));
	}
	
	private static final ArrayList<String> EMPTY_RESULT = new ArrayList<String>();
	//a two-dimensional array used as a mapping of 0-9 digit to letters
	private static final char[][] char_map = {
            {}, // 0
            {}, //1
            {'a', 'b', 'c'}, //2
            {'d', 'e', 'f'},    //3
            {'g', 'h', 'i'},    //4
            {'j', 'k', 'l'},    //5
            {'m', 'n', 'o'},    //6
            {'p', 'q', 'r', 's'},   //7
            {'t', 'u', 'v'},    //8
            {'w', 'x', 'y', 'z'} //9
    };
	
	/**
	 * convert every digit in an integer array from 0 to 99 into letters
	 * @param input a integer array
	 * @return
	 */
	public static List<String> letterCombination(Integer input[]) {
        if (input == null || input.length == 0){
            return EMPTY_RESULT;
        }
        
        List<String> result = null;
        for (int i = 0; i < input.length; i += 1) {
        	result = combine(result, input[i]);
        }
		
        return result;
    }
	
	/**
	 * first, convert a digit from 0 to 99 into letters, 
	 * and then combine its letters result with the result of the last combination
	 * 
	 * @param result
	 * @param digit
	 * @return
	 */
	public static List<String> combine(List<String> result, Integer digit){
		ArrayList<String> mResult = new ArrayList<String>();
		combine(digit.toString(), mResult, "", 0);
		if (0 == mResult.size()) {
			if (null == result || 0 == result.size()) {
	            return mResult;
			}
            return result;
		}
		if (null == result || 0 == result.size()) {
            return mResult;
		}
		
		ArrayList<String> combinationResult = new ArrayList<String>();
		for (String before : result) {
			for (String e : mResult) {
				String combines = before + e;
				combinationResult.add(combines);
			}
		}
		
		return combinationResult;
	}
	
	/**
	 * convert a digit from 0 to 99 into letters
	 * 
	 * @param digits the String represent a digit from 0 to 99
	 * @param result the result letters
	 * @param beforeString
	 * @param nowIndex
	 */
	public static void combine(String digits, List<String> result, String beforeString, int nowIndex){
		if(nowIndex >= digits.length()){
			//search to the end of the digits
			result.add(beforeString);
			return;
		}
		int index = Integer.parseInt("" + digits.charAt(nowIndex));
		char[] nowChars = char_map[index];
		if (0 == nowChars.length) {
			//some digit do not map to any letter
			combine(digits, result, beforeString, nowIndex+1);
			return ;
		}
		for(int i = 0;i < nowChars.length;i++){
			String newStr = beforeString + nowChars[i];
			combine(digits, result, newStr, nowIndex+1);
		}
	}

}