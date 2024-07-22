class Solution {
    public int[] solution(int[] numbers) {
        // 원래의 인덱스와 값을 가진 stack
        Node [] stack = new Node [numbers.length];
        int top = -1; 
        // i = 원래 number 배열의 인덱스, value = numer[i]의 뒷큰수
        int [] NGE = new int [numbers.length]; 
        // 값 초기화
        for(int i = 0; i < numbers.length; i++){
            NGE[i] = -1;
        }
        
        for(int i = 0; i < numbers.length; i ++){
            Node now = new Node(i ,numbers[i]);
            if(top == -1){
                stack[++top] = now;
            }else {
                while(top > -1 && stack[top].v < now.v){
                    NGE[stack[top--].i] = now.v;
                }
                stack[++top] = now;
            }
        }
        return NGE;
    }
}

class Node {
    int i;   // index
    int v;   // 값
    
    public Node(int i, int v){
        this.i = i;
        this.v = v;
    }
}