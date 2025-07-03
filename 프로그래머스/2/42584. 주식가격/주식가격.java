import java.util.*;

class Solution {
    
    static class Stock {
        int index;
        int price;
        
        public Stock(int index, int price){
            this.index = index;
            this.price = price;
        }
        
        @Override
        public String toString(){
            return "(원래 위치: " + index + " 가격: " + price + ")";
        }
    }
    
    
    public int[] solution(int[] prices) {
        int [] answer = new int[prices.length];
        int iter = -1;
        Stock [] stack = new Stock [prices.length];
        
        for(int i = 0; i < prices.length-1; i++){
            // 당초 주식 넣기
            if(iter == -1) stack[++iter] = new Stock(i, prices[i]);
            else {
                while(iter >= 0 && stack[iter].price > prices[i]){
                    iter--;
                }
                stack[++iter] = new Stock(i, prices[i]);
            }
            // 하루가 흐름.
            for(int j = 0; j <= iter; j++){
                answer[stack[j].index]++;
            }
        }
        
        return answer;
    }
}