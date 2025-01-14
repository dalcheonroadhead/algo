import java.io.*;
import java.util.*;


class Tri {
    Node root; 
    
    public Tri() {
        root = new Node();
    }
    
    public void insert(String str) {
        Node now = this.root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            now.children.putIfAbsent(c, new Node());
            now.lenMap.compute(str.length(), (k,ov) -> ov == null? 1 : ov + 1);
            now = now.children.get(c);
        }
    }
    
    public int find(String str) {
        int ans = 0;
        Node now = this.root;
        
        if(str.charAt(0) == '?') ans = now.lenMap.getOrDefault(str.length(), 0);
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c =='?') break;
            if(!now.children.containsKey(c)) return 0; // 이런 문자 가지고 있지 않음.
            now = now.children.get(c);
            ans = now.lenMap.getOrDefault(str.length(),0);
        }
        return ans;
    }
}

class Node {
    HashMap<Character, Node> children;
    HashMap<Integer, Integer> lenMap;
    
    public Node() {
        children = new HashMap<>();
        lenMap = new HashMap<>();
    }
}

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int [queries.length];
        Tri tri = new Tri();
        Tri irt = new Tri();
        
        for(int i = 0; i < words.length; i++){
            tri.insert(words[i]);
            irt.insert(reverse(words[i]));
        }
        
        for(int i = 0; i < queries.length; i++){
            String now = queries[i];
            if(now.charAt(0) != '?') {
                answer[i] = tri.find(now);
            }else{
                answer[i] = irt.find(reverse(now));
            }
        }
        
        return answer;
    }
    
    public String reverse (String str) {
        return new StringBuilder(str).reverse().toString();
    }
}