package Chapter1;

public class Problem2 {
	/** 1.2 Given two strings, write a method to decide if one is a permutation of the other.
	 *	
	 *	My solution creates a counter object to count the occurrences of each character in
	 * 	a given string. Once two counter objects have been created, they can be compared using
	 *  the compareCounts method. If the counts differ, then the two strings are not
	 *  permutations of each other. 
	 *  
	 *  Performance is O(n+m) to count chars in both strings and O(1) to compare them
	 *  as only 128 comparisons must be made each time. (Assuming ASCII charset)
	*/
	public static void main(String[] args){
		Counter dog = new Counter("dog");
		Counter god = new Counter("god");	
		System.out.println(dog.compareCounts(god));
		
		Counter afro = new Counter("afro");
		Counter afar = new Counter("afar");
		System.out.println(afro.compareCounts(afar));	
	}
}
class Counter{
	int[] counts;
	String str;
	
	public Counter(String s){
		counts = new int[128];
		str = s;
		for (int i : str.toCharArray()) counts[i]++;
	}
		
	public boolean compareCounts(Counter c2){
		if (this.str.length() != c2.str.length()) return false;
		for (int i = 0; i < 128; i++){
			if (this.counts[i] != c2.counts[i])	return false;
		}
		return true;
	}
}