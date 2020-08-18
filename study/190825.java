import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1463

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_num = Integer.parseInt(br.readLine().trim());

        int dp[] = new int[input_num + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= input_num; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        bw.write(dp[input_num] + "\n");
        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/10844

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        long[][] dp = new long[101][11];

        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=input_count;i++){
            dp[i][0] = dp[i-1][1];
            for(int j=1;j<=9;j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long sum = 0;

        for(int i=0;i<10;i++){
            sum+=dp[input_count][i];
        }

        bw.write(sum%1000000000 + "\n");
        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

