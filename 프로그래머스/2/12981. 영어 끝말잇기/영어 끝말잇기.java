import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int [] answer = new int []{};
        
        if(words[0].length() == 1){
            return new int[]{1,1};
        }
        
        map.put(words[0], 1);
        
        for(int i = 1; i < words.length; i++){
            answer = new int[] {(i%n)+1, (i/n) + 1};
            // 1. 끝말잇기 규칙 실패
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                return answer;
            }
            // 2. 이미 썼던 단어 사용  
            if(map.get(words[i]) != null){
                return answer;
            }else {
                map.put(words[i],1);
            }
            // 3. 단어 길이가 1
            if(words[i].length() == 1) {
                return answer;
            }
        }
        

        answer = new int [] {0,0};
        return answer;
    }
}