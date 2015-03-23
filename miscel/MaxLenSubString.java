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

	public static void main(String[] args){
		String s = "aabbcc";
		int k = 1;
		char[] arr = s.toCharArray();
		int count = 1;
		int size = 1;
		StringBuffer sb =null;
		int i =0;
		for (char ch : arr ) {
			for (int j=i+1; j<s.length(); j++) {
				sb = new StringBuffer(s.length());
				sb.append(arr[i]);
				if( size <= k && arr[i] == arr[j]){
					count++;
					sb.append(arr[j]);
					size++;
				}
			}
			i++;
		}
		System.out.println("The max substring containing: "+ k + " unique characters is: "+ sb);
	}

}