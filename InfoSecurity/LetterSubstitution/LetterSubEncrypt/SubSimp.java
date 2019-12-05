package com.company;

public class SubSimp {

        char[] ciphertext = new char[5];
        char[] plaintexts;

        public SubSimp(char[] plaintext) {
            this.plaintexts = plaintext;
            System.out.print("plaintext: ");
            System.out.println(this.plaintexts);
            for (int i = 0; i < this.plaintexts.length; i++) {
                if (this.plaintexts[i] == 'H') {
                   // System.out.println(i);
                    this.ciphertext[i] = 'J';
                } else if (this.plaintexts[i] == 'E') {
                   // System.out.println(i);
                    this.ciphertext[i] = 'C';
                } else if (this.plaintexts[i] == 'L') {
                  // System.out.println(i);
                    this.ciphertext[i] = 'F';
                } else if (this.plaintexts[i] == 'O') {
                   // System.out.println(i);
                    this.ciphertext[i] = 'Z';
                } else {

                }
            }

        }

        public char[] getCiphertext() {
            return ciphertext;
         }
}
