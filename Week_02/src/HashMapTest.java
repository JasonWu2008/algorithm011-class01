import java.util.HashMap;

public class HashMapTest {
    //测试"树化"过程
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000000000; i++) {
            if(i>0&&i%50000==0){
                System.out.println("i=" + i);
            }
            map.put("acd:" + i, i);
        }
    }
}
