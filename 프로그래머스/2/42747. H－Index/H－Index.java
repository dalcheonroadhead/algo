import java.util.*;

class Solution {
    public int solution(int[] citations) {        
        int max = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            int right = citations.length - i;
            if(citations[i] >= right) {
                max = right;
                break;
            }
        }
        return max;
    }
}