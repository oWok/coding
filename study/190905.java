import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/11866

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> que = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int people_count = Integer.parseInt(st.nextToken());
        int pop_people = Integer.parseInt(st.nextToken());
        int count = 1;

        for(int i=people_count;i>0;i--)
            que.push(i);

        bw.write("<");

        while (true){
            if(que.size() == 1){
                bw.write(que.pop() + "");
                break;
            }

            if(count==pop_people){
                bw.write(que.pop() + ", ");
                count = 1;
            }
            else{
                que.addLast(que.pop());
                count++;
            }
        }
        bw.write(">\n");

        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------

