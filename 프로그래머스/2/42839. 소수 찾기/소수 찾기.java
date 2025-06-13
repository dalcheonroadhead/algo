import java.util.*;

class Solution {
    static boolean [] isVisited;
    static HashSet<Integer> set = new HashSet<>();
    static int answer = 0;
    public int solution(String numbers) {
        isVisited = new boolean[numbers.length()];
        permutation(numbers, 0, 0);
        return answer;
    }
    
    public void permutation (String numbers, int now, int depth) {
        
        if(prime_judgement(now)) {
            if(!set.contains(now)) {
                set.add(now);
                System.out.println(now);
                answer++;
            }
        }
        
        if(depth == numbers.length()) {
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                permutation(numbers, now*10 + (numbers.charAt(i) - 48), depth+1);
                isVisited[i] = false;
            }
        }
    }
    
    public boolean prime_judgement (int num) {
        if(num == 0 || num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}