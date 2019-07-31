package com.spire.demo;

import com.spire.barcode.BarcodeScanner;

public class Scan {
    public static void main(String[] args) throws Exception {

        //Scan
        //Get code information by scanning the image
        String[] s = BarcodeScanner.scan("CODABAR.png");
        System.out.println(s[0]);

    }
}
