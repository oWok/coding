import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1847

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int input_count = Integer.parseInt(br.readLine().trim());
        Stack<Integer> stack = new Stack<Integer>();
        boolean check = true;


        for(int i=0, j=1;i<input_count;i++){

            int input_num = Integer.parseInt(br.readLine().trim());

            if(!check)
                continue;

            while (j<=input_num){
                stack.push(j++);
                sb.append("+\n");
            }

            if(stack.peek()==input_num){
                stack.pop();
                sb.append("-\n");
            }
            else{
                sb = new StringBuilder();
                sb.append("NO\n");
                check = false;
            }

        }

        bw.write(sb + "");
        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

