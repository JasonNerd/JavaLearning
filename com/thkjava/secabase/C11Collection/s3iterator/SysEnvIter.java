package com.thkjava.secabase.C11Collection.s3iterator;

import java.util.Map;

public class SysEnvIter {
    public static void main(String[] args) {
        for(Map.Entry entry: System.getenv().entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
