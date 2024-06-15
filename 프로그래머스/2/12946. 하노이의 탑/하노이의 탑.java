import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<int[]> list = new ArrayList<>();
    
    public ArrayList<int[]> solution(int n) {
        
        hanoi(1,2,3,n);
        
        return list;
    }
    
    public void hanoi(int start, int mid, int end, int stack) {
        
        if(stack == 0){
            return;
        }
        hanoi(start, end, mid, stack-1);    // 최저 블록 제외 전부 start -> mid로 이동
        list.add(new int[]{start,end});     // 최저 블록 start -> end 이동 
        hanoi(mid,start,end,stack-1);       // 최저 블록 제외 전부 mid -> end 이동 
    }
    
}