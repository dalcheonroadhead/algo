import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int A = (int) Arrays.stream(nums).distinct().count();
        int B = nums.length/2;
        
        return A >= B? B : A;
    }
}