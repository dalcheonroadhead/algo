import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        ArrayDeque<Integer> a = new ArrayDeque<>();
        ArrayDeque<Integer> b = new ArrayDeque<>();
        
        long sumA = 0;
        long sumB = 0;
        int cnt  = 0;
        
        for(int i = 0; i < queue1.length; i++){
            a.add(queue1[i]);
            b.add(queue2[i]);
            sumA += queue1[i];
            sumB += queue2[i];
        }
        
        if((sumA+sumB)%2 == 1) return -1;
        
        while(sumA != sumB){
            // 기저 조건
            if(cnt > (queue1.length + queue2.length)+1) {
                cnt = -1; 
                break;
            }
            
            if(sumA > sumB){
                int now = a.poll();
                sumA -= now;
                sumB += now; 
                b.add(now);
            }
            
            else if(sumB > sumA){
                int now = b.poll();
                sumB -= now;
                sumA += now;
                a.add(now);
            }
            cnt++;
        }
        
        return cnt;
    }
}