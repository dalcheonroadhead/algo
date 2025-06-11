import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.putIfAbsent(num, 1);
        }
        int type = map.size();
        int count = (int) Math.ceil(nums.length / 2.0); 
        
        return type >= count? count : type; 
    }
}