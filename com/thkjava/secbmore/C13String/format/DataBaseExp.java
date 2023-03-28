package com.thkjava.secbmore.C13String.format;

public class DataBaseExp extends Exception{
    public DataBaseExp(int tID, int qID, String message){
        super(String.format("(Transaction %d, Query %d) %s", tID, qID, message));
    }
    public static void main(String[] args) {
        try{
            throw new DataBaseExp(2, 26, "Database server collapsed!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
