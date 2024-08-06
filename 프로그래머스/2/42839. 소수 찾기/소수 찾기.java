import java.io.*;
import java.util.*;

class Solution {
    // 1. np 써서 모든 조합 다 구하기 
    // 2. 해당 조합 수에 대한 소수 판별 하기 
    
    static int cnt = 0;
    static HashSet<Integer> values = new HashSet<>();
    
    public int solution(String numbers) {
        int [] num = new int [numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            num[i] = numbers.charAt(i) - 48;
        }
        Arrays.sort(num);
        for(int i = 1; i <= num.length; i ++) {
            permutation(num, new boolean [num.length], 0, i, 0);
        }
        
        return cnt;
    }
    
    public void permutation(int [] num, boolean [] isVisited, int depth, int end, int now) {           
        // 기저 조건
        if(depth == end){
            
            if(now == 1) return;
            
            if(isPrime(now) && !values.contains(now)) {
                values.add(now);
                cnt++;
            }
            return;
        }
        // 계산식 
        for(int i = 0; i < num.length; i++){
            
            if(depth == 0 && num[i] == 0) continue;
            
            if(!isVisited[i]){
                isVisited[i] = true; 
                now = now*10 + num[i];
                permutation(num, isVisited, depth+1, end, now);
                now = now/10;
                isVisited[i] = false; 
            }
        }
    }
    
    public boolean isPrime(int v) {
        for(int i = 2; i <= Math.sqrt(v); i ++){
            if(v%i == 0) return false;
        }
        return true;
    }
}