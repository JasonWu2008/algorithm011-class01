public class NO208Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); //true
        System.out.println(trie.search("app")); //false
        System.out.println(trie.startsWith("app")); //true
        trie.insert("app");
        System.out.println(trie.search("app")); //true
    }


    static class Trie {
        Trie[] next = new Trie[26];
        boolean isEnd = false;

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie current = this;
            for (char charC : word.toCharArray()) {
                if (current.next[charC - 'a'] == null) {
                    current.next[charC - 'a'] = new Trie();
                }
                current = current.next[charC - 'a'];
            }
            current.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie trie = this;
            for (char charC : word.toCharArray()) {
                if (trie.next[charC - 'a'] == null) {
                    return false;
                }
                trie = trie.next[charC - 'a'];
            }
            return trie.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie current = this;
            for (char charC : prefix.toCharArray()) {
                if (current.next[charC - 'a'] == null) {
                    return false;
                }
                current = current.next[charC - 'a'];
            }
            return true;
        }
    }
}
