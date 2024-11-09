import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), "+,-" , true);

        int acc = 0;
        boolean isMinus = false;
        while (st.hasMoreTokens()){
            String now = st.nextToken();
            if(!now.equals("+") && !now.equals("-")){
                if(isMinus) acc -= Math.abs(Integer.parseInt(now));
                else acc += Integer.parseInt(now);
            }
            if(now.equals("-")) isMinus = true;
        }

        System.out.println(acc);
    }
}