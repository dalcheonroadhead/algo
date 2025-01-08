import java.io.*;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int n0, n1, n2, n3,n4;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        while(true) {
            n0 = Integer.parseInt(br.readLine());
            if(n0 == 0) break;
            n1 = makingN1(n0);
            n2 = makingN2(n1);
            n3 = makingN3(n2);
            n4 = makingN4(n3);
            ans.append(i).append(". ").append(n1%2 != 0? "odd" : "even").append(" ").append(n4).append("\n");
            i++;
        }
        System.out.println(ans);
    }

    public static int makingN1(int n0) {
        return n0*3;
    }
    public static int makingN2(int n1) {
        return n1%2 == 0? n1/2 : (n1+1)/2;
    }
    public static int makingN3(int n2) {
        return n2*3;
    }
    public static int makingN4(int n3) {
        return n3/9;
    }
}