import java.util.*;

public class NO126FindLadders {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");

        List<String> words2 = new ArrayList<>();
        words2.add("hot");
        words2.add("dot");
        words2.add("dog");
        words2.add("lot");
        words2.add("log");
        System.out.println(new NO126FindLadders().findLadders("hit", "cog", words));
        System.out.println(new NO126FindLadders().findLadders("hit", "cog", words2));
    }

    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        Map<String, List<String>> map = new HashMap<>();

        bfs(dict, begin, end, map);
        List<String> temp = new ArrayList<>(Collections.singletonList(beginWord));
        return dfs(temp, beginWord, endWord, map);
    }

    int dfs(List<String> temp, String start, String end, Map<String, List<String>> map) {
        if (start.equals(end)) {
            return 1;
        }
        if (!map.containsKey(start)) {
            return 0;
        }
        int counter = 0;
        for (String word : map.get(start)) {
            temp.add(word);
            counter += dfs(temp, word, end, map);
            temp.remove(temp.size() - 1);
        }
        return counter;
    }

    void bfs(Set<String> dict, Set<String> begin, Set<String> end, Map<String, List<String>> map) {
        boolean reversed = false;
        boolean terminate = false;
        while (!begin.isEmpty()) {
            dict.removeAll(begin);
            dict.removeAll(end);
            if (begin.size() > end.size()) {
                reversed = !reversed;
                Set<String> temp = new HashSet<>(begin);
                begin = end;
                end = temp;
            }
            Set<String> set = new HashSet<>();
            for (String s : begin) {
                for (int i = 0; i < s.length(); i++) {
                    char[] ch = s.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (ch[i] == c) {
                            continue;
                        }
                        ch[i] = c;
                        String word = new String(ch);
                        if (end.contains(word)) {
                            if (!reversed) {
                                List<String> list = map.containsKey(s) ? map.get(s) : new ArrayList<>();
                                list.add(word);
                                map.put(s, list);
                            } else {
                                List<String> list = map.containsKey(word) ? map.get(word) : new ArrayList<>();
                                list.add(s);
                                map.put(word, list);
                            }
                            terminate = true;
                        }
                        if (dict.contains(word)) {
                            if (!reversed) {
                                List<String> list = map.containsKey(s) ? map.get(s) : new ArrayList<>();
                                list.add(word);
                                map.put(s, list);
                            } else {
                                List<String> list = map.containsKey(word) ? map.get(word) : new ArrayList<>();
                                list.add(s);
                                map.put(word, list);
                            }
                            set.add(word);
                        }
                    }
                }
            }
            begin = set;
            if (terminate) {
                return;
            }
        }
    }
}
