import java.util.*;

class Solution {
    
    static class Music {
        int i;
        int v;
        
        public Music (int i, int v) {
            this.i = i;
            this.v = v;
        }
    }
    
    static class Genre {
        int pq;
        int v;
        
        public Genre(int pq, int v){
            this.pq = pq;
            this.v = v;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int N = genres.length;
        PriorityQueue<Music> [] aqs = new PriorityQueue [100];
        HashMap<String, Genre> map = new HashMap<>();
        
        int cnt = 1;
        for(int i = 0; i < N; i++){
            if(map.get(genres[i]) == null) {
                map.put(genres[i], new Genre(cnt, plays[i]));
                aqs[cnt] = new PriorityQueue<>((o1,o2) -> {
                    if(o2.v == o1.v) return o1.i - o2.i;
                    return o2.v - o1.v;
                });
                aqs[cnt].add(new Music(i, plays[i]));
                cnt++;
            }else {
                Genre now = map.get(genres[i]);
                aqs[now.pq].add(new Music(i, plays[i]));
                now.v += plays[i];
            }
        }
        
        PriorityQueue <Genre> pq = new PriorityQueue<>((o1,o2) -> o2.v - o1.v);
        for(String temp : map.keySet()){
            pq.add(map.get(temp));
        }
        
        while(!pq.isEmpty()){
            Genre now = pq.poll();
            for(int i = 0; i < 2; i++){
                if(aqs[now.pq].size() == 0) break;
                Music cur = aqs[now.pq].poll();
                list.add(cur.i);
            }
        }
        
        int [] ans = new int [list.size()];
        
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}