import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1932

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        int[][] tri = new int[count+1][count+1];
        int sum = 0;

        for(int i=1;i<=count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=1;j<=i;j++)
                tri[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=count;i++){
            for(int j=1;j<=i;j++){
                if(j == 1){
                    tri[i][j] = tri[i-1][j] + tri[i][j];
                }
                else if(j == i){
                    tri[i][j] = tri[i-1][j-1] + tri[i][j];
                }
                else
                    tri[i][j] = Math.max(tri[i-1][j-1], tri[i-1][j]) + tri[i][j];

                if(sum < tri[i][j])
                    sum = tri[i][j];
            }
        }

        bw.write(sum + "\n");



        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------