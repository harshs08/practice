// Given a string you need to print longest possible substring that has exactly M unique characters.
// If there are more than one substring of longest possible length, then print any one of them.

// Examples:

// "aabbcc", k = 1
// Max substring can be any one from {"aa" , "bb" , "cc"}.

// "aabbcc", k = 2
// Max substring can be any one from {"aabb" , "bbcc"}.

// "aabbcc", k = 3
// There are substrings with exactly 3 unique characters
// {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
// Max is "aabbcc" with length 6.

// "aaabbb", k = 3
// There are only two unique characters, thus show error message.

public class MaxLenSubString{
	
	//checks if total number of elements are less than or equal to k. To maintain the window size.
	public static boolean isValid(int[] count,int val){
		try{
			int v = 0;
			for(int i = 0;i < count.length ; i++){
				if(count[i] > 0){
					v++;
				}
			}
			return (val >=v);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static void countMaxUniquCharecter(String str,int k){
		try{
			int unique_count = 0;
			int current_start = 0;
			int current_end = 1;
			int max_window_size=0;
			int max_start = 0;
			int[] count = new int[str.length()];

			for(int i = 0 ; i< str.length() ; i++){
				if(count[str.charAt(i) - 'a'] == 0){
					unique_count++;
				}
				count[str.charAt(i) - 'a']++;
			}
			if(unique_count < k){
				System.out.println("Not enough unique characters!");
				return;
			}
			count = new int[str.length()];
			count[str.charAt(0) - 'a']++;
			for(int i = 1;i<str.length();i++){
				count[str.charAt(i) - 'a']++;
				current_end++;
				while(!isValid(count,k)){
					count[str.charAt(current_start) - 'a']--;
					current_start++;
				}
				int size = current_end - current_start;
				if(size > max_window_size){
					max_window_size = size;
					max_start = current_start;
				}
			}
			String opt = str.substring(max_start,(max_start+max_window_size));
			System.out.println( "The max substring of "+ k +" unique characters is: \'"+ opt +"\' with size= "+max_window_size);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try{
			String str = "caabbc";//"aabacbebebe";
			int k = 2; // MAX Length of unique character in the string
			countMaxUniquCharecter(str, k);
		}catch(Exception ex){
			ex.printStackTrace();
		}
 
	}

}