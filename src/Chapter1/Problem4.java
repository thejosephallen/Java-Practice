package Chapter1;
import java.util.*;

public class Problem4 {
	/** 1.4) Given a string, write a function to check if it is a permutation of a palindrome.
	 * It does not need to be limited to just dictionary words.
	 * Example
	 * Input:	Tact Coa
	 * Output:	True (permutations: "taco cat", "atco cta", etc.)
	 * 
	 * My solution removes spaces before sorting the string as a char array, and then uses a 
	 * stack to determine whether the character counts are those of a palindrome. That is, if the 
	 * string is even in length then there must be even numbers of all letters for it to be a 
	 * palindrome. Similarly, if the string is odd in length, then only one letter may have an odd
	 * count and the others must all be even. The stack pushes if the stack is empty and pops if a 
	 * letter has a pair on top of the stack. This results in an easy check of how many letters have 
	 * odd counts.
	 * 
	 * Solution is case sensitive and ignores spaces.
	 */
	public static boolean permOfPal(String str){
		char[] chars = str.replace(" ", "").toCharArray();
		Arrays.sort(chars);									//O(NlogN)
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < chars.length; i++){				//O(N)
			try {
				if (stack.peek() == chars[i]) stack.pop();
				else stack.push(chars[i]);
			}
			catch (EmptyStackException ese) {stack.push(chars[i]);}
		}
		if (chars.length % 2 == 0 ) return stack.isEmpty() ? true : false;
		else {
			stack.pop();
			return stack.isEmpty() ? true : false;
		}
	}
	
	public static void main(String[] args){
		System.out.println(permOfPal("taco cat"));
		System.out.println(permOfPal("Attack!Attack!"));
		System.out.println(permOfPal("tacosandcats"));
	}
}
