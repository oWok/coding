import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

    static int count;
    static char[][] star;

    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2447
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        count = Integer.parseInt(br.readLine().trim());
        star = new char[count][count];


        for(char[] change : star)
            Arrays.fill(change, ' ');

        for(int i=0;i<count;i++){
            for(int j=0;j<count;j++)
                bw.write(star_map(count, i, j));

            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }

    public static char star_map(int count, int x, int y) throws IOException{

        if((x/count) % 3 ==1 && (y/count) % 3 == 1){
            return ' ';
        }
        else{
            if(count/3 == 0){
                return '*';
            }
            else
                return star_map(count/3, x, y);
        }
    }
}

---------------------------------------------------------------------------------------------------