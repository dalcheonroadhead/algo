import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer [] nums = new Integer [numbers.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = numbers[i];
        }
        
        Arrays.sort(nums,             
            (a,b) -> {
                StringBuilder candi1 = new StringBuilder();
                StringBuilder candi2 = new StringBuilder();
                candi1.append(a).append(b);
                candi2.append(b).append(a);
                return Integer.parseInt(candi2.toString()) - Integer.parseInt(candi1.toString());
            });
        
        StringBuilder answer = new StringBuilder();
        for(int temp : nums){
            answer.append(temp);
        }
        if(answer.charAt(0) == '0') {
            answer.setLength(0);
            answer.append(0);
        }
        return answer.toString();
    }
}