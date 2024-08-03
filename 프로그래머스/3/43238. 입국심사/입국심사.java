import java.io.*;
import java.util.*;

class Solution {
    // 10^9 -> 시간 복잡도 O(n*log n) 이하로 
    public long solution(int n, int[] times) {
        // 1. 시간이 제일 적게 걸리는 심사대 순으로 정렬 
        // 2. int start, int end 설정 
        // 3. 이분탐색을 통해, 최소로 걸리는 시간 찾기 (출력)
        Arrays.sort(times); 
        return binary_search(0, (long)times[times.length-1] * n, times, n);
    }
    
    public long binary_search(long start, long end, int [] times, int n) {
        long S = start;
        long E = end;
        
        while(S<=E){
            // 중간 값 구하기
            long M = (S+E)/2; // 총 걸리는 시간
            // 중간 값을 이용한 다음 행동 계산
            long people = 0;
            for(int i = 0; i< times.length; i++){
                people += M/times[i]; // 각 심사대가 정해진 시간에서 처리하는 사람의 수 
            }
            // 처리하는 사람의 수가 같은 시간(분)에 대해서 제일 최소 시간을 구해야 하므로 lower bound 
            if(people >= n){
                E = M-1;
            }else {
                S = M+1;
            }
        }
        return S;
    }
}