import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) { 
        int ans = Integer.MAX_VALUE;
        
        if(s.length() == 1) return 1;
        
        for(int i = 1; i <= s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String prev = "";
            int count = 1;
            for(int j = 0; j <= s.length() - i; j += i){
                String cur = s.substring(j, j+i);
                if(cur.equals(prev)){
                    count++;
                }else {
                    sb.append(count>1 ? count : "").append(prev);
                    count = 1;
                }
                prev = cur; 
            }
            sb.append(count>1? count : "").append(prev);
            if(s.length()%i !=0){
                String last = s.substring(s.length() - s.length()%i, s.length());
                sb.append(last);
            }
            ans = Math.min(ans, sb.toString().length());
        }
        return ans;
        
    }
}