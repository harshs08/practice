class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        int seq_count = 0;
        int count = 0;
        int diff_prev = 0;
        int diff = 0;
        diff_prev = A[1] - A[0];
        
        for(int i=2;i<len; i++){
            diff = A[i] - A[i-1];
            if(diff == diff_prev){
                count += 1;
            }
            else{
                seq_count += (count*(count+1))/2;
                count = 0;
            }
            diff_prev = diff;
        }
        seq_count += (count*(count+1))/2;
        if (seq_count > 1000000000) return -1; 
        return seq_count; 
    }
}
