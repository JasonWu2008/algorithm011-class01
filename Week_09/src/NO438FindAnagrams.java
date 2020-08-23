import java.util.ArrayList;
import java.util.List;

public class NO438FindAnagrams {
    public static void main(String[] args) {
        List<Integer> results = new NO438FindAnagrams().findAnagrams("cbaebabacd", "abc");
        for (Integer result : results) {
            System.out.println(result);
        }
    }

    List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            pArray[p.charAt(i) - 'a']++;
        }

        ArrayList<Integer> results = new ArrayList<>();
        int i = 0;
        int j = p.length();
        while (j < s.length()) {
            if (isSame(pArray, sArray)) {
                results.add(i);
            }
            sArray[s.charAt(i) - 'a']--;
            i++;
            sArray[s.charAt(j) - 'a']++;
            j++;
        }
        if (isSame(pArray, sArray)) {
            results.add(i);
        }
        return results;
    }

    private boolean isSame(int[] pArray, int[] sArray) {
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i] != sArray[i]) {
                return false;
            }
        }
        return true;
    }
}
