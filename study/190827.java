import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/11047

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int count = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int[] change_money = new int[count+1];

        int result = 0;

        for(int i=1;i<=count;i++)
            change_money[i] = Integer.parseInt(br.readLine().trim());

        for(int i=count;i>0;i--){
            result += money / change_money[i];
            money %= change_money[i];
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();


    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/11399

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] time = new int[count+1];

        for(int i=1;i<=count;i++)
            time[i] =Integer.parseInt(st.nextToken());

        Arrays.sort(time);

        int sum = 0;

        for(int i=1;i<=count;i++){
            time[i] += time[i-1];
            sum += time[i];
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

