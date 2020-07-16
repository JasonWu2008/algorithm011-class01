public class NO860LemonadeChange {
    public static void main(String[] args) {
//        int[] bills = {5, 5, 10};//true
//        int[] bills = {5, 5, 5, 10, 20};//true
//        int[] bills={10,10};//false
        int[] bills = {5, 5, 10, 10, 20};//false
        boolean result = new NO860LemonadeChange().lemonadeChange(bills);
        System.out.println(result);
    }

    //贪心算法实现找零，找零时先看大额面值能否满足，如果可以大额够的话再拼小的
//    大额面值不够的话再看小额的是否满足
    private boolean lemonadeChange(int[] bills) {
        int availableCoinFive = 0;
        int availableCoinTen = 0;
        for (int bill : bills) {
            if (bill == 5) {
                availableCoinFive++;
                continue;
            }
            if (bill == 10) {
                if (availableCoinFive < 1) {
                    return false;
                }
                availableCoinTen++;
                availableCoinFive--;
            }
            if (bill == 20) {
                if (availableCoinTen < 1) {
                    if (availableCoinFive < 3) {
                        return false;
                    }
                    availableCoinFive = availableCoinFive - 3;
                } else {
                    if (availableCoinFive < 1) {
                        return false;
                    }
                    availableCoinTen--;
                    availableCoinFive--;
                }
            }
        }
        return true;
    }
}
