import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int T = Integer.parseInt(br.readLine());

        // when
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int strLen = str.length();

            sb.append("Case #").append(t).append(":\n");

            boolean foundMaxPalindrome = false;
            int builderLength = sb.length();
            for (int l = strLen; l > 1; l--) {
                for (int start = 0; start < strLen - l + 1; start++) {
                    if (isPalindrome(str, start, start + l - 1)) {
                        foundMaxPalindrome = true;

                        sb.insert(builderLength, " ");
                        for (int i = start; i < start + l; i++) {
                            sb.insert(builderLength, str.charAt(i));
                        }
                    }
                }
                if (foundMaxPalindrome) break;
            }

            if (foundMaxPalindrome) {
                sb.replace(sb.length() - 1, sb.length(), "");
                sb.append("\n");
            }
        }

        // then
        System.out.println(sb);
        br.close();
    }

    public static boolean isPalindrome(String str, int left, int right) {
        if (left > right) return false;

        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
