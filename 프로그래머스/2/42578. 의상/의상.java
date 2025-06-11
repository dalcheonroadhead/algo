import java.util.*;

class Solution {
    static ArrayList<String> [] lists;
    static int answer = 0;
    
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String [] now : clothes) {
            ArrayList<String> cur = map.getOrDefault(now[1],null);
            if(cur == null) {
                map.put(now[1], new ArrayList<>());
                map.get(now[1]).add(now[0]);
            }
            else cur.add(now[0]);
        }
        
        
        lists = new ArrayList [map.size()];
        
        int i = 0;
        for(ArrayList<String> now : map.values()){
            now.add("");
            lists[i++] = now;
            System.out.println(now);
        }
        combination( 0);
        return answer - 1;
    }
    
    public void combination (int depth) {
        
        if(depth == lists.length){
            answer += 1;
            return;
        }
        
        for(int i = 0; i < lists[depth].size(); i++){
            combination(depth+1);
        }
        
    }
}