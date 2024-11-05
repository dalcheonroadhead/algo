import java.io.*;
import java.util.*;

class Solution {
    private final String DELIM  = ":";
    private final String PREV   = "prev";
    private final String NEXT   = "next";
    
    static private int now;
    static private int end;
    static private int open_s;
    static private int open_e;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        now = convert2Sec(pos);
        end = convert2Sec(video_len);
        open_s = convert2Sec(op_start);
        open_e = convert2Sec(op_end);
        
        for(String order : commands){
            skip();
            if(order.equals(PREV)) prev();
            else next();
            skip();
        }
        
        return convert2String(now);
        
    }
    
    
    public int convert2Sec (String mmss) {
        StringTokenizer st = new StringTokenizer(mmss, DELIM);
        return Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
    }
    
    public String convert2String (int time) {
        StringBuilder sb = new StringBuilder();
        int mm = time/60;
        int ss = time%60;
        
        if(mm < 10) sb.append("0");
        sb.append(mm).append(":");
        if(ss < 10) sb.append("0");
        sb.append(ss);
        
        return sb.toString();
    }
    
    public void skip() {
        if(now < open_s || now > open_e) return;
        else now = open_e;
    }
    
    public void next() {
        now += 10;
        if(now > end) now = end;
    }
    
    public void prev() {
        now -= 10;
        if(now < 0) now = 0;
    }
}