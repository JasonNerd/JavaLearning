package com.thkjava.secabase.C11Collection.s2features;

public class Snow {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}
