package com.company;

public class LettFreqAnalysis {

    char[] ciphertexts;
    char[] plaintexts = new char[5];
    char[] keys = {};

    char L;
    int countJ = 0;
    int countC = 0;
    int countF = 0;
    int countZ = 0;

    public LettFreqAnalysis(char[] ciphertext) {
        this.ciphertexts = ciphertext;

        for(int i = 0; i < this.ciphertexts.length; i++) {
            if('J' == this.ciphertexts[i]) {
                ++countJ;
            }
            else if('C' == this.ciphertexts[i]) {
                ++countC;
            }
            else if('F' == this.ciphertexts[i]) {
                ++countF;
            }
            else if('Z' == this.ciphertexts[i]) {
                ++countZ;
            }
        }
            if (countJ > countC && countJ > countF && countJ > countZ) {

                System.out.println("Most frequent is J");
                this.L = 'J';
            }
            else if (countC > countJ && countC > countF && countC > countZ) {

                System.out.println("Most frequent is C");
                this.L = 'C';
            }
            else if (countF > countJ && countF > countC && countF > countZ) {

                System.out.println("Most frequent is F");
                this.L = 'F';

            }
            else if (countZ > countJ && countZ > countF && countZ > countC) {

                System.out.println("Most frequent is Z");
                this.L = 'Z';
            }

    }

    public char getMostFreq(){
        return L;
    }
}
