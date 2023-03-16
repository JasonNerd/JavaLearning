package com.thkjava.secbmore.C12Exception;

public class MyException extends Exception{
    public MyException(){}
    public MyException(String msg){super(msg);}
    public static void main(String[] args) {
        try{
            TestMC.f();
        }catch(MyException e){
            e.printStackTrace(System.out);
        }
        try{
            TestMC.g();
        }catch(MyException e){
            e.printStackTrace(System.out);
        }
    }
}

class TestMC{
    public static void f() throws MyException{
        System.out.println("throw MyException from f()");
        throw new MyException();
    }
    public static void g() throws MyException{
        System.out.println("throw MyException from g()");
        throw new MyException("msg from g()");
    }
}