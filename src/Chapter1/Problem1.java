package Chapter1;

public class Problem1 {
	/**	1.1) Function to check if a string contains unique characters (no repeats).
	 * 	Runs O(1) since it checks at most 128 chars regardless of string size.
	 *  (Assuming string is ASCII)
	*/
	static boolean isUnique(String str){
		if(str.length() > 128)	{return false;}
		boolean[] chars = new boolean[128];
		for (int c : str.toCharArray()){
			if (chars[c])	{return false;}
			else	{chars[c] = true;}
		}
		return true;
	}
	
	public static void main(String[] args){
		String shouldpass = "abcdefg";
		String shouldfail = "abcdeff";
		System.out.println(isUnique(shouldpass));
		System.out.println(isUnique(shouldfail));
	}
}
