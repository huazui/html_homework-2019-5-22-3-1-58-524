package com.tw.apistackbase;

public class Puke {
    private char pattern;
    private Integer number;
    public Puke(String puke){
        char a= puke.charAt(0);
        if(a=='T') {
            number = 10;
        }
        else if(a=='J'){
            number = 11;
        }
        else if(a=='Q'){
            number = 12;
        }
        else if(a=='A') {
            number = 1;
        }
        else if(a == 'K') {
            number = 13;
        }
        else number = a-'0';
        pattern = puke.charAt(1);
    }

    public char getPattern() {
        return pattern;
    }

    public Integer getNumber() {
        return number;
    }
}

