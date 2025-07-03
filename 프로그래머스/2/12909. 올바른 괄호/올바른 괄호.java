import java.util.*;

class Solution {
    boolean solution(String s) {
        char [] stack = new char[s.length()];
        int iter = -1;
        
        for(int i = 0 ; i < s.length(); i++){
            char now = s.charAt(i);
            
            switch(now) {
                case '(': {
                    stack[++iter] = '(';
                    break;
                }
                case ')': {
                    if(iter == -1) return false;
                    stack[iter--] = '\0';
                    break;
                }
            }
        }
        return iter == -1 ? true : false;
    }
}