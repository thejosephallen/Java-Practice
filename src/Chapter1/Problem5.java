package Chapter1;

public class Problem5 {
	/** 1.5) There are three types of edits that can be performed on strings: insert a 
	 * character, remove a character, or replace a character. Given two strings, write a
	 * function to check if they are one (or zero) edits away.
	 * Example:
	 * pale, ple -> true (insert an a)						
	 * pales, pale -> true (remove an s)					
	 * pale, bale -> true	(replace p with b or b with s)	
	 * pale, bake -> false									
	 * 
	 * - My solution first narrows down the possibilities for the strings by checking if
	 * they are equal (0 edits away) or differ in length by more than 1 (more than 1 edit
	 * away). Next, I handle the two remaining cases of the length of the strings being equal
	 * or off by one. For strings of the same length, they should only have one different
	 * character. For strings with length off by one, the smaller should be the same as the
	 * larger, but missing one character. All other cases show that the strings are not
	 * 0 or 1 edits away.
	 * - 
	 * 
	 */
	public static boolean isOneAway(String str1, String str2){
		if (str1.equals(str2)) return true;
		//not the same
		if (Math.abs(str1.length() - str2.length()) > 1) return false;
		//must be same size or off by 1
		boolean sameLength = (str1.length() - str2.length() == 0) ? true : false;
		if (sameLength){
			// true if only one different char
			int numDiff = 0;
			for (int i = 0; i < str1.length(); i++) if (str1.charAt(i) != str2.charAt(i)) numDiff++;
			return numDiff == 1 ? true : false;
		} else {
			//true if smaller is one missing char away from larger.
			String larger = (str1.length() > str2.length()) ? str1 : str2;
			String smaller = (str1.length() < str2.length()) ? str1 : str2;
			boolean foundDiff = false;
			for (int i = 0; i < smaller.length(); i++){
				if (foundDiff){
					if (larger.charAt(i) == smaller.charAt(i - 1)) continue;
					else return false;	//found second difference; game over
				} else if (larger.charAt(i) == smaller.charAt(i)) continue;
				else foundDiff = true;
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		System.out.println(isOneAway("pale", "ple"));
		System.out.println(isOneAway("pales", "pale"));
		System.out.println(isOneAway("pale", "bale"));
		System.out.println(isOneAway("pale", "bake"));
	}
}
