import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        //https://www.acmicpc.net/problem/1712
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long standing_charge,  pro_cost, pro_pri; // 고정비용, 생산단가, 판매가격

        StringTokenizer input = new StringTokenizer(br.readLine().trim());
        standing_charge = Integer.parseInt(input.nextToken());
        pro_cost = Integer.parseInt(input.nextToken());
        pro_pri = Integer.parseInt(input.nextToken());

         if(pro_pri - pro_cost > 0)
            bw.write((standing_charge / (pro_pri - pro_cost) + 1) + "\n");
         else
             bw.write(-1 + "\n");


        bw.flush();
        bw.close();
        br.close();

    }
}

---------------------------------------------------------------------------------------------------