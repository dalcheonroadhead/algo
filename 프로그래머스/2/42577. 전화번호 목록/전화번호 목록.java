import java.util.*; 

class Solution {
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Tri tri = new Tri();
        
        for(String phone_num : phone_book){
            tri.insert(phone_num);
        }
        
        for(String phone_num : phone_book) {
            if(tri.isPrefix(phone_num)) return false;
        }
        
        return answer;
    }
    
}

class Tri {
    Node root;
    
    public Tri () {
        this.root = new Node();
    }
    
    
    public void insert(String str) {
        Node node = this.root;
        
        for(int i = 0; i < str.length(); i++){
            char now = str.charAt(i);
            node.children.putIfAbsent(now, new Node());
            node = node.children.get(now);
        }
        node.isEnd = true;
    }
    
    public boolean isPrefix(String str) {
        Node node = this.root;
        
        for (int i = 0; i < str.length(); i++){
            char now = str.charAt(i);
            node = node.children.getOrDefault(now, null);
            if(node == null) return false;
        }
        if(node.children.size() >= 1) return true;
        return false;
    }
}

class Node {
    boolean isEnd;
    HashMap<Character, Node> children;
    
    public Node () {
        isEnd = false;
        children = new HashMap<>();
    }
}