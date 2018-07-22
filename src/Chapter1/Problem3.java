package Chapter1;

public class Problem3 {
	/**	1.3 Write a method to replace all spaces in a string with '%20'. You may assume that
	 * the string has sufficient space at the end to hold the additional characters, and that
	 * you are given the "true" length of the string. (Perform in place)
	 * Example
	 * Input:	"Mr John Smith    ",13
	 * Output:	"Mr%20John%20Smith"
	 * 
	 * My Solution calculates the size the final string should be, then iterates through the
	 * chars, replacing spaces with '%20' and shifting the remaining chars 2 to the right.
	 * 
	 * Performance: At most size/2 spaces assuming no consecutive spaces. So shifting
	 * occurs at most (size-1)/2 times and shifts an average of (size-1)/2 chars per space. So there are
	 * about ((size-1)^2)/4 shifts or O(n^2)
	 * 
	 * "M r J o h n S m i t h                    " n = 21 and 100 shifts
	 */
	public static char[] urlify(char[] str, int size){
		int numSpaces = 0;
		int shiftCount = 0;
		int shiftHere = 0;	//shiftCount and shiftHere prevent shifting the trailing spaces
		for (int i = 0; i < size; i++) if (str[i] == ' ') numSpaces++; //Count spaces
		int fullSize = size + numSpaces * 2; //As we need 2 more spaces for each space
		for (int j = 0; j < fullSize; j++){
			if (str[j] == ' '){
				shiftHere = (size + 1) + (2 * shiftCount);
				for (int k = shiftHere; k > (j + 2); k--) str[k] = str[k-2]; //shift 2 right
				str[j] = '%';
				str[j+1] = '2';
				str[j+2] = '0';
				j += 2;		//skip indices of new '%20'
				shiftCount++;
				//System.out.println(String.copyValueOf(str)+'*');
			}
		}
		return str;
	}
	
	public static void main(String[] args){
		//System.out.println(urlify("M r J o h n S m i t h                    ".toCharArray(), 21));
		System.out.println(urlify("Mr John Smith    ".toCharArray(), 13));
		System.out.println(urlify("Joseph Allen wrote this program        ".toCharArray(), 31));
	}
}
