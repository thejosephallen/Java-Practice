package Chapter1;

public class Problem6 {
	/** 1.6) Implement a method to perform basic string compression using the counts of repeated
	 * characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed"
	 * string would not become smaller than the original string, your method should return the
	 * original string. You can assume the string only has uppercase and lowercase letters(a-z).
	 * 
	 *   5          10				Compressed form = num letters * 2
	 * abcde -> a1b1c1d1e1
	 *    10	->		10
	 * aabbccddee -> a2b2c2d2e2
	 * 		15					10
	 * aaabbbcccdddeee ->	a3b3c3d3e3
	 */
	public static String compressor(String str){
		char[] chars = str.toCharArray();
		int[] counts = new int[128];		// Inefficient, try it iterating through string
		int count = 0;
		int numLetters = 1;
		for (int i = 0; i < chars.length; i++){
			count++;
			if (i + 1 == chars.length || chars[i] != chars[i+1]){	//if end of string or char sequence
				counts[(int)chars[i]] = count;
				numLetters++;
				count = 0;
			}
		}
		if ((2 * numLetters) >= chars.length) return str;	//no improvement
		StringBuilder st = new StringBuilder();
		for (int j = 0; j < counts.length; j++){
			if (counts[j] != 0){
				st.append((char)j).append(counts[j]);
			}
		}
		return st.toString();

	}
	
	public static void main(String[] args){
		System.out.println(compressor("aabbccddee"));		
		System.out.println(compressor("aaabbbcccdddeee"));
	}
	
	
}
