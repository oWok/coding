import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1149

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim()) + 1;

        int[][] DP = new int[input_count][3];
        int[][] cost = new int[input_count][3];

        for(int i=1;i<input_count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<3;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<input_count;i++){
            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + cost[i][0];
            DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + cost[i][1];
            DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + cost[i][2];
        }

        bw.write(Math.min(Math.min(DP[input_count-1][0], DP[input_count-1][1]), DP[input_count-1][2]) + "\n");
        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------