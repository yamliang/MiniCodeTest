package org.yan.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class LetterCombinationTest {

	/**
	 * Test {@link LetterCombinationUtil#letterCombination(Integer[])}}
	 */
	@Test
	public void letterCombinationTest() {
		Integer input0[] = new Integer[] {0, 3, 1, 4};
		Integer input1[] = new Integer[] {0, 2, 5, 4, 7};
		Integer input2[] = new Integer[] {2, 3, 4, 0, 10, 11, 00, 20, 99};
		
		List<String> output0 = LetterCombinationUtil.letterCombination(input0);
		List<String> output1 = LetterCombinationUtil.letterCombination(input1);
		List<String> output2 = LetterCombinationUtil.letterCombination(input2);
		
		assertEquals(output0.size(), 3 * 3);
		assertEquals(output1.size(), 3 * 3 * 3 * 4);
		assertEquals(output2.size(), 3 * 3 * 3 * 3 * 4 * 4);
		
		System.out.println(output0);
		System.out.println(output1);
		System.out.println(output2);
	}

}
