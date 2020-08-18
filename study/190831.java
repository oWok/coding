import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1541

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        int[][] class_time = new int[input_count][2];
        int count = 0;
        int end = -1;

        for(int i=0;i<input_count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<2;j++)
                class_time[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(class_time, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
                if(start[1]==end[1])
                    return Integer.compare(start[0], end[0]);

                return Integer.compare(start[1], end[1]);
            }
        });

        for(int i=0;i<input_count;i++){
            if(class_time[i][0] >= end){
                count++;
                end = class_time[i][1];
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

