public class NO647CountSubstrings {
    public static void main(String[] args) {
        System.out.println(new NO647CountSubstrings().countSubstrings("aaa"));
//        System.out.println(new NO647CountSubstrings().countSubstrings("abcdd"));
//        System.out.println(new NO647CountSubstrings().countSubstrings("abcddd"));
//        System.out.println(new NO647CountSubstrings().countSubstrings("aaaaa"));
        System.out.println(new NO647CountSubstrings().countSubstrings("aaaaaa"));
    }

    //s.charAt(i) == s.charAt(j) && (i - j < 2 || grids[j + 1][i - 1])
    //(i - j < 2 || grids[j + 1][i - 1])；i - j < 2表示重合或相邻;grids[j + 1][i - 1]右与左
    int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] grids = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || grids[j + 1][i - 1])) {
                    grids[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
