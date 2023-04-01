package com.thkjava.secbmore.C13String.scanner;

import java.util.Scanner;

public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 23, 13, 24, 34, 24");
        scanner.useDelimiter("\\s*,\\s*");
        while(scanner.hasNext())
            System.out.println(scanner.nextInt());
        scanner.close();
    }
}
