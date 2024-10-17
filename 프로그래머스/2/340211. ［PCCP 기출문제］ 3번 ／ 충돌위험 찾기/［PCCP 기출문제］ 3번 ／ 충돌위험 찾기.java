import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        // 0. initialize
        // (robotTraker = store the way robots move), (map = store point locations),
        // (longestDest = longest move among robot's move)
        ArrayDeque<Loc> [] robotTrackers = new ArrayDeque [routes.length];
        HashMap<Integer,Loc> dest = new HashMap<>();
        int longestDest = 0;
        for(int i = 0; i < points.length; i++){
            dest.put((i+1), new Loc(points[i][0], points[i][1]));
        }
        
        for(int i = 0; i < routes.length; i++){
            robotTrackers[i] = new ArrayDeque<Loc>();
            trackingLocation(dest, routes[i], robotTrackers[i]);
            longestDest = Math.max(longestDest, robotTrackers[i].size());
        }
        
        return countingCrush(robotTrackers, longestDest);

    }
    
    // store one robot's move from the start to the end
    public void  trackingLocation (HashMap<Integer, Loc> dest, int [] route, ArrayDeque<Loc> tracking) {    
        for(int i = 1; i<route.length; i++){
            Loc start = dest.get(route[i-1]);
             Loc next = dest.get(route[i]);

             int r = start.r;
             int c = start.c;

             if(tracking.isEmpty()){
                tracking.add(new Loc(r,c));
             }

             while(r != next.r){
                r = (r<next.r? r+1 : r-1);
                tracking.add(new Loc(r,c));
             }

             while(c != next.c){
                 c = (c<next.c? c+1 : c-1);
                 tracking.add(new Loc(r,c));
            }
        }  
    }
    
    public int countingCrush (ArrayDeque<Loc> [] robotTrackers, int longestDist) {
        int res = 0; 
        
        for(int i = 0; i < longestDist; i ++){
            // store crush cnt of each location 
            HashMap<Loc, Integer> map = new HashMap<>();
            int cnt = 0;
            for(int j = 0; j < robotTrackers.length; j++){
                if(robotTrackers[j].isEmpty()) continue;
                Loc now = robotTrackers[j].poll();
                map.compute(now, (key, oldvalue) -> (oldvalue == null? 1 : map.get(key)+1));
            }
            for(Integer v : map.values()){
                if(v >= 2) cnt++;
            }
            res += cnt;
        }
        return res;
    }
    
}

class Loc {
    int r;
    int c;

    public Loc(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public Loc(int r, int c, int nextPoint){
        this.r = r;
        this.c = c;
    }
    
    // to make Loc instance equal to another Loc instance which have same materials
    @Override
    public boolean equals (Object obj) {
        if(this == obj) return true; 
        if(obj == null || this.getClass() != obj.getClass()) return false; 
        Loc o = (Loc) obj;
        return (this.r == o.r && this.c == o.c);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(r,c);
    }
}