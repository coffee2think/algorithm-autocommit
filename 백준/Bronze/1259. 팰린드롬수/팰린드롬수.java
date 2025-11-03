import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String n = br.readLine();
            if ("0".equals(n)) {
                break;
            }

            int left = 0;
            int right = n.length() - 1;
            boolean isPalindrome = true;

            while (left <= right) {
                if (n.charAt(left) != n.charAt(right)) {
                    isPalindrome = false;
                    break;
                }

                left++;
                right--;
            }

            sb.append(isPalindrome ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
