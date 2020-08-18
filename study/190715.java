import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num;
        int check_count = Integer.parseInt(br.readLine().trim());
        StringTokenizer num_all = null;


        num = new int[check_count];


        num_all = new StringTokenizer(br.readLine());

        for(int i=0;i<check_count;i++)
            num[i] = Integer.parseInt(num_all.nextToken());


        int max = num[0];
        int min = num[0];

        for(int i=0;i<check_count;i++){
            max = (max > num[i]) ? max : num[i];
            min = (min < num[i]) ? min : num[i];
        }

        bw.write(min + " " + max + "\n");
        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num[] = new int[10];
        int temp = 0;

        for(int i=0;i<10;i++)
            num[i] = Integer.parseInt(br.readLine().trim())%42;

        for(int i=0;i<9;i++){
            for(int j=i+1;j<10;j++)
                if(num[i] == num[j]){
                    temp++;
                    break;
                }
        }


        bw.write((10-temp) + "\n");
        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------------