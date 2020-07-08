import java.util.ArrayList;
import java.util.List;

public class NO22GenerateParenthesis {

    public static void main(String[] args) {
        List<String> results = new NO22GenerateParenthesis().generateParenthesis(3);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private List<String> generateParenthesis(int n) {
        //Set<String> resultSet = new HashSet<>();
        List<String> results = new ArrayList<>();
        dfs("", n, 0, 0, results);

        //results.addAll(resultSet);
        return results;
    }

    private void dfs(String current, int n, int left, int right, List<String> results) {
        if (current.length() == 2 * n && left == right) {
            results.add(current);
            return;
        }
        //剔除不合法的组合，右括号个数不应该大于左括号
        if (left < right) {
            return;
        }
        if (left < n) {
            //此处不应该使用current=current + "("，应该保证传入参数current不可变
            //同理也不一能使用left++，否则right<n内的left被修改了
            dfs(current + "(", n, left + 1, right, results);
        }
        if (right < n) {
            dfs(current + ")", n, left, right + 1, results);
        }
    }
}
