package com.futuretech180.document;

import java.util.ArrayList;

public class KeywordElementSearch {
    public static void main(String[] args) {
        KeywordElementSearch ks = new KeywordElementSearch();
        ArrayList<SingleReview> context = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        keys.add("3");
//        keys.add("0");
        char value = 'a';
        for (int i = 0; i < 5; i++) {
            context.add(new SingleReview("a" + i,"b" + i,"c" + i,"d" + i,i,"e" + i));
        }
        System.out.println(ks.multiSearch(context,keys));

    }

    public ArrayList<SingleReview> multiSearch(ArrayList<SingleReview> list,ArrayList<String> stringArrayList)
    {
        ArrayList<SingleReview> result = new ArrayList<>();
        for(SingleReview s: list)
        {
            boolean flag = true;
            for (String temp: stringArrayList)
            {
                if(!s.keyWordSearch(temp))
                    flag = false;
            }
            if(flag)
                result.add(s);
        }
        return result;
    }
}
