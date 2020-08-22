public class NO5LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new NO5LongestPalindrome().longestPalindrome("cbbd"));
        System.out.println(new NO5LongestPalindrome().longestPalindrome("babad"));
    }

    //dp[i][j]:dp[i]==dp[j] && dp[i+1]==dp[j-1]
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }
        int startIndex = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < charArray.length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //分两种情况：gap<=2, gap>2
                    //其中gap>2状态方程为内层(dp[i][j]=dp[i+1][j-1])的状态
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];//此处即为"状态转移"，必须满足"无后效性"，即这个dp必须已经经过计算！
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
