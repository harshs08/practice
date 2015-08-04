class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int result = 0;
        int[] count = new int[10];
        
        char[] digits = (""+N).toCharArray();
        int len = digits.length;
        for(char ch: digits){
            count[Character.getNumericValue(ch)] += 1; 
        }
        
        int den = 1;
        
        for(int i = 0; i<10; i++){
            den *= fact(count[i]); 
        }
        result = fact(len)/den;
         
        // System.out.println(fact(3));
        
        return result;
    }
    
    public static int fact(int n){
        int result = 1;
        if(n==0) return 1;
        for(int i= 1; i<=n;i++){
            result *= i;
        }
        return result;
    }
}
