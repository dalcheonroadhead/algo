import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();
        for(String phone_num : phone_book) {
            map.putIfAbsent(phone_num, true);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            if(phone_book[i].length() == 1) continue;
            for(int j = 1; j < phone_book[i].length(); j++){
                if(map.getOrDefault(phone_book[i].substring(0,j), false)){
                    return false;   
                }
            }
        }
        return true;
    }
}