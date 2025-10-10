 import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int light = 0;
        for(int heavy = people.length - 1; heavy >= light; heavy--){
            if(people[light] + people[heavy] <= limit){
                answer++;
                light++;
            }else answer++;
        }
        
        
        return answer;
    }
}