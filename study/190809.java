import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1002
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] jo = new int[2];
        int[] baeg = new int[2];
        int count_ryu = 0;
        int jo_to_ryu, baeg_to_ryu;
        int count = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            jo[0] = Integer.parseInt(st.nextToken());
            jo[1] = Integer.parseInt(st.nextToken());
            jo_to_ryu = Integer.parseInt(st.nextToken());

            baeg[0] = Integer.parseInt(st.nextToken());
            baeg[1] = Integer.parseInt(st.nextToken());
            baeg_to_ryu = Integer.parseInt(st.nextToken());
            int street = (int)(Math.pow(jo[0] - baeg[0], 2) + Math.pow(jo[1] - baeg[1], 2));
            int sum = (int)Math.pow(jo_to_ryu + baeg_to_ryu, 2);
            int dif = (int)Math.pow(jo_to_ryu - baeg_to_ryu, 2);

            if(street == 0){
                if(dif == 0)
                    bw.write("-1" + "\n");
                else
                    bw.write("0" + "\n");
            }
            else if(street == sum || street == dif)
                bw.write("1" + "\n");
            else if(street > dif && street < sum)
                bw.write("2" + "\n");
            else
                bw.write("0" + "\n");

            
        }

        bw.flush();
        bw.close();
    }



}

---------------------------------------------------------------------------------------------------

