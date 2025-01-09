import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            ans.append("Pairs for ").append(now).append(":");
            int range = now%2 == 0? now : now + 1;
            for (int j = 1; j < range/2; j++) {
                if(now-j == j) continue;
                ans.append(" ").append(j).append(" ").append(now-j).append(",");
            }
            if(ans.charAt(ans.length()-1) == ',') {
                ans.delete(ans.length()-1, ans.length());
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}