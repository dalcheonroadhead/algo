import java.io.*;
import java.util.*;

class Solution {
    // index = 행, value = 열  
    static int [] board;
    static int cnt = 0;
    public int solution(int n) {
        board = new int [n];
        backTracking(0);
        return cnt;
    }
    
    public void backTracking(int depth) {
        
        if(depth == board.length){
            cnt++;
            return;
        }
        
        
        for(int i = 0; i < board.length; i++){
            board[depth] = i;
            if(possibility(depth)){backTracking(depth+1);}
        }   
    }
    
    // 현재 행에 퀸이 들어간 값이 되는지 안되는지 체크 (이전 값들을 이용 좌하단, 우하단, 세로)
    public boolean possibility(int index) {
        for(int i = 0; i < index; i ++) {
            // 좌하단
            if(board[index] + index == board[i] + i) return false; 
            // 우하단
            int diff = index - i; 
            if(board[i] + diff == board[index]) return false; 
            // 세로 
            if(board[i] == board[index]) return false;
        }
        return true;
    }
}