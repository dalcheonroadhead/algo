import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i ++){
            map.putIfAbsent(nums[i], 1);
        }
        
        if(map.size() < nums.length/2) {
            return map.size();
        }else{
            return nums.length/2;
        }
        
        

        
    }
}