import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String quizResult = br.readLine();
            int score = 0;
            int stack = 0;
            
            for (int i = 0; i < quizResult.length(); i++) {
                if (quizResult.charAt(i) == 'X') {
                    stack = 0;
                    continue;
                }

                stack++;
                score += stack;
            }

            sb.append(score).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
