import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2217

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        int[] lope = new int[input_count];

        for(int i=0;i<input_count;i++)
            lope[i] = Integer.parseInt(br.readLine().trim());

        Arrays.sort(lope);

        int max = Integer.MIN_VALUE;

        for(int i=input_count-1;i>=0;i--){
            lope[i] *= input_count-i;
            if(max < lope[i])
                max = lope[i];
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();


    }

}

---------------------------------------------------------------------------------------------------