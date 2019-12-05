package com.company;

public class Main {

    public static void main(String[] args) {
        char[] ciphertext = {'J', 'C', 'F', 'F', 'Z'}; //Hello
        char[] ciphertexts;
        char[] plaintext = {'H', 'E', 'L', 'L', 'O'};
        SubSimp encode = new SubSimp(plaintext);
        ciphertexts = encode.getCiphertext();
        System.out.print("ciphertext: ");
        System.out.println(ciphertexts);

        LettFreqAnalysis decode = new LettFreqAnalysis(ciphertext);
        System.out.println("Most frequent letter in english is E. therefore " + decode.getMostFreq() + " must be E");



    }

}
