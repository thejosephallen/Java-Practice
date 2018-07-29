package Chapter1;

/**1.9) Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g.,"waterbottle" is a rotation of "erbottlewat").
 * 
 * @author joseph
 *
 * If string 1 is a rotation of string 2, then string 1 will be a substring of string 2
 * concatenated to itself. For ex: "waterbottle" (string1) is a substring of 
 * "erbottlewaterbottlewat" (2 * string2). This can be used to check if string 1 is a 
 * rotation of string 2 with only one call to isSubstring. My function isRotationV1 below 
 * implements this.
 * 
 * Another way (implemented in isRotationV2) would be to iterate through one string and to 
 * compare its characters to a fixed index of the second string. If the chars match, increment 
 * both indices and count how many we have matched so far. If they differ, set the counter to 0. 
 * Do this process until we've looped through one string twice. If at any point the number of 
 * characters we've matched equals the length of either string, return true.
 *
 * Performance of V1 and V2 is similar.
 *
 */
public class Problem9 {
	
	public static boolean isRotationV1(String str1, String str2) {
		if (str1.length() == 0 || str1.length() != str2.length()) return false;
		return isSubstring(str1, (str2.concat(str2)));
	}
	
	public static boolean isSubstring(String str1, String str2) {
		return (str2.indexOf(str1) == -1) ? false : true;
	}
	
	public static boolean isRotationV2(String str1, String str2) {
		int string1Size = str1.length();
		if (string1Size == 0 || string1Size != str2.length()) return false;
		int numSame = 0;
		for (int i = 0, j = 0; i < 2 * (string1Size + 1); i++) {
			if (str1.charAt(i % string1Size) == str2.charAt(j % string1Size)) {
				numSame++;
				j++;
				if (numSame == string1Size) return true;
			} else numSame = 0;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String string1 = "ttlewaterbo";
		String string2 = "terbottlewa";
		
		//Alternate test strings
		//string1 = "abcdefghijklmnopqrstuvwxyz";
		//string2 = "bcdefghijklmnopqrstuvwxyza";
		
		long startTime, endTime, duration;
		
		//Clean implementation
		startTime = System.nanoTime();
		System.out.printf("'%s' is a rotation of '%s': %b", string1, string2, isRotationV1(string1, string2));
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.printf("\nClean method took %d nanoseconds", duration);
		
		/*
		//Thoughtful implementation
		startTime = System.nanoTime();
		System.out.printf("\n'%s' is a rotation of '%s': %b", string1, string2, isRotationV2(string1, string2));
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.printf("\nThoughtful method took %d nanoseconds", duration);
		*/
	}
}
