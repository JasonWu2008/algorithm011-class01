public class NO91NumDecodings {
    public static void main(String[] args) {
        System.out.println(new NO91NumDecodings().numDecodings("12"));
        System.out.println(new NO91NumDecodings().numDecodings("226"));
    }

    int numDecodings(String s) {
        int length;
        char[] charArray;
        if (s == null || (length = s.length()) == 0 || (charArray = s.toCharArray())[0] == '0') {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[length - 1];
    }
}
