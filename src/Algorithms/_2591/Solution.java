package Algorithms._2591;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static void main() {
        System.out.println(distMoney(20, 3));
    }

    public static int distMoney(int money, int children) {
        int forbidden = 4;
        int availableFunds = money;
        int result = 0;

        if (money < children) return -1;
        if(money<children +7) return 0;
        if (money / children == 8) return children;

        //give 1 dollar for everyone
        availableFunds -= children;
        if (availableFunds < 7) return -1;
        Map<Integer, Integer> kids = new HashMap<>();
        for (int i = 0; i < children; i++) {
            kids.put(i, 1);
        }
        for (int i = 0; i < children; i++) {
            if(availableFunds>=7){
                kids.merge(i, 7, Integer::sum);
                availableFunds -=7;
            } else {
                if(kids.get(i) + availableFunds == forbidden){
                    if(i<children-1) {
                        kids.merge(i, 1, Integer::sum);
                        availableFunds--;
                    } else {
                        kids.merge(i-1, availableFunds, Integer::sum);
                    }
                }
            }
        }


        return (int) kids.values().stream().filter(v -> v == 8).count();
    }
}