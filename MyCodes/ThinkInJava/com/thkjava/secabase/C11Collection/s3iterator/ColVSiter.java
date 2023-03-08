package com.thkjava.secabase.C11Collection.s3iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ColVSiter {
    public static void display(Iterator<Snow> it){
        // 使用迭代器作为参数
        while(it.hasNext()){
           Snow s = it.next();
           System.out.print(s+", ");
        }
        System.out.println();
    }

    public static void display(Collection<Snow> snows){
        // 使用Collection接口作为参数
        for(Snow s: snows){
            System.out.print(s+", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Snow> snowArr = new ArrayList<>(Arrays.asList(
            new Heavy(), new Powder(), new Snow(), new Crusty()
        ));
        Set<Snow> snowSet = new HashSet<Snow>(snowArr);
        Map<String, Snow> snowMap = new HashMap<>();
        for(int i=0; i<snowArr.size(); i++){
            snowMap.put("Key("+i+")", snowArr.get(i));
        }
        // display them directly
        display(snowArr);
        display(snowSet);
        System.out.println(snowMap);
        System.out.println(snowMap.keySet());
        display(snowMap.values());
        // use iterator
        display(snowArr.iterator());
        display(snowSet.iterator());
        display(snowMap.values().iterator());
    }
}
/*
Heavy 0, Powder 1, Snow 2, Crusty 3, 
Snow 2, Heavy 0, Powder 1, Crusty 3, 
{Key(0)=Heavy 0, Key(2)=Snow 2, Key(1)=Powder 1, Key(3)=Crusty 3}
[Key(0), Key(2), Key(1), Key(3)]
Heavy 0, Snow 2, Powder 1, Crusty 3, 
Heavy 0, Powder 1, Snow 2, Crusty 3, 
Snow 2, Heavy 0, Powder 1, Crusty 3,
Heavy 0, Snow 2, Powder 1, Crusty 3,
 */