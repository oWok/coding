import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2579

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        int[] floor = new int[input_count+1];
        int[] sum = new int[input_count+1];

        for(int i=1;i<=input_count;i++)
            floor[i] = Integer.parseInt(br.readLine().trim());

        sum[1] = floor[1];

        if(input_count >= 2)
            sum[2] = sum[1] + floor[2];

        for(int i=3;i<=input_count;i++)
            sum[i] = Math.max(sum[i-2] + floor[i], sum[i-3] + floor[i-1] + floor[i]);

        bw.write(sum[input_count] + "\n");

        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------

