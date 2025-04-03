import java.io.*;
import java.util.*;

class Solution {
    
    int cnt;
    char [][] wareHouse;
    int  [][] dir;
    
    public int solution(String[] storage, String[] requests) {
        init(storage);
        
        for(int i = 0; i < requests.length; i++){
            if(requests[i].length() == 1) fork_lift(requests[i].charAt(0));
            if(requests[i].length() == 2) craine(requests[i].charAt(0));
        }
        
        return cnt;
    }
    
    private void init(String [] storage) {
        
        cnt = storage.length * storage[0].length();
        wareHouse = new char[storage.length + 2][storage[0].length() + 2];
        
        for(int i = 0; i < storage.length + 2; i ++) {
            Arrays.fill(wareHouse[i], '_');
        }
        
        dir = new int [][] {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i = 1; i <= storage.length; i++) {
            for(int j = 1; j <= storage[0].length(); j++) {
                wareHouse[i][j] = storage[i-1].charAt(j-1);
            }
        }
    }
    
    public void fork_lift(char order) {
        boolean [][] isVisited = new boolean [wareHouse.length][wareHouse[0].length];
        ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
        aq1.add(new Coordinate(0,0));
        isVisited[0][0] = true;
        
        while(!aq1.isEmpty()) {
            Coordinate now = aq1.poll();
            
            for(int i = 0; i < 4; i++){
                int nextR = now.row + dir[i][0];
                int nextC = now.col + dir[i][1];
                
                if(!OOB(nextR, nextC) && !isVisited[nextR][nextC]){
                    if(wareHouse[nextR][nextC] == order){
                        wareHouse[nextR][nextC] = '-';
                        cnt--;
                        isVisited[nextR][nextC] = true;
                    }
                    if(wareHouse[nextR][nextC] == '_'){
                        isVisited[nextR][nextC] = true;
                        aq1.add(new Coordinate(nextR, nextC));                   
                    }
                }
            }
        }
        for(int i = 1; i < wareHouse.length-1; i++){
            for(int j = 1; j < wareHouse[0].length-1; j++){
                if(wareHouse[i][j] == '-') wareHouse[i][j] = '_';
            }
        }
        
        return;
    }
    
    public void craine (char order) {
        for(int i = 1; i < wareHouse.length-1; i++){
            for(int j = 1; j < wareHouse[0].length-1; j++){
                if(wareHouse[i][j] == order){
                    cnt --;
                    wareHouse[i][j] = '_';
                }
            }
        }
    }
    
    public boolean OOB(int r, int c) {
        return r < 0 || c < 0 || r >= wareHouse.length || c >= wareHouse[0].length;
    }
}

class Coordinate {
    int row;
    int col;
    
    Coordinate (int row, int col) {
        this.row = row;
        this.col = col;
    }
}