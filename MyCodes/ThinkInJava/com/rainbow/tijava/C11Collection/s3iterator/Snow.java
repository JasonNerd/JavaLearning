package com.rainbow.tijava.C11Collection.s3iterator;
public class Snow {
    protected static int st;
    private int sid;
    Snow(){sid = st++;}
    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+sid;
    }
}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}