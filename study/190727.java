import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        //https://www.acmicpc.net/problem/1712
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int count = Integer.parseInt(br.readLine().trim());


        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xMovie = 0;
            int yMovie = 0;
            int countMovie = 0;
            int dstMovie = 0;

            while(true){
                dstMovie++;

                x += dstMovie;
                countMovie++;

                if(x >= y)
                    break;

                y -= dstMovie;
                countMovie++;

                if(x >= y)
                    break;

            }
            bw.write(countMovie + "\n");
        }

        bw.flush();
        bw.close();
    }

}

