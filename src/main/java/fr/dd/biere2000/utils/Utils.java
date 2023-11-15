package fr.dd.biere2000.utils;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

    public static ArrayList<Long> giveMeFifteenIdArticle(int poolSize){
        ArrayList<Long> result = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i< 15; i++){
            result.add(r.nextLong(poolSize));
        }
        return result;
    }
}
