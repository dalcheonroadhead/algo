import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 1. 각 배열의 GCD 구하기 
        int GCD_A = arrayA[0]; int GCD_B = arrayB[0]; 
        
        for(int i = 1; i<arrayA.length; i++){
            GCD_A = getGCD(GCD_A, arrayA[i]); // 모두에게 통하는 GCD로 갱신됨. 
        }
        
        for(int i = 1; i<arrayB.length; i++){
            GCD_B = getGCD(GCD_B, arrayB[i]);
        }
        // 2. Cross 해서 남의 GCD로 나눠지는 수가 있는지 체크 있으면 fail 
        for(int i = 0; i<arrayB.length; i++){
            if(arrayB[i]%GCD_A == 0) { GCD_A = 0; break;}
        }
        
        for(int i = 0; i<arrayA.length; i++){
            if(arrayA[i]%GCD_B == 0) { GCD_B = 0; break;} 
        }
        
        // 3, 살아남은 GCD 중 가장 큰 값 출력
        int ans = Math.max(GCD_A, GCD_B);
        return ans;
    }
    
    public int getGCD(int a, int b){
        if(a%b == 0) return b;
        else return getGCD(b, a%b);
    }
}