import java.util.*;
public class Main {
    static int ans = 0;
    static String inputs;
    static ArrayList<String> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputs = sc.next();
        
        list = new ArrayList<>();
        for(int i = 0; i < inputs.length()-1; i++){
            if(inputs.substring(i,i+2).equals("((") || inputs.substring(i,i+2).equals("))")) list.add(inputs.substring(i,i+2));
        }
        combination(0,0,"((");
        System.out.println(ans);
    }

    public static void combination( int start, int cnt, String s) {
        if(s.equals("))") && cnt == 1){
            ans++;
            return;
        }


        if(s.equals("((") && cnt == 1){
            combination(start, 0, "))");
            return;
        }

        for(int i = start ; i < list.size(); i++){
            if(list.get(i).equals(s)) combination(i+1, cnt+1, s);
        }
    }
}