import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/9020
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        boolean[] sosu = new boolean[5082];
        Arrays.fill(sosu, true);
        sosu[0] = false;
        sosu[1] = false;

        for(int i=2;i<5082;i++){
            if(sosu[i]){
                for(int j=i*i;j<5082;j+=i){
                    sosu[j] = false;
                }
            }
        }


        for(int i=0;i<input_count;i++){
            int num = Integer.parseInt(br.readLine().trim());
            int num_under = num/2;
            int num_over = num/2;

            while(true){
                if(sosu[num_under] && sosu[num_over])
                    break;

                num_over++;
                num_under--;
            }
            bw.write(String.format("%d %d\n", num_under, num_over));
        }

        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

