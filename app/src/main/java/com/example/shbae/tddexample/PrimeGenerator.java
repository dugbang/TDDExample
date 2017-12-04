package com.example.shbae.tddexample;

/**
 * Created by shbae on 2017-11-23.
 */
class PrimeGenerator {

    private static int candidate;
    private static int[] primes;
    private static int[] multiples;
    private static int ord;
    private static int square;
    private static boolean possiblyPrime;
    private static int n;
    private static int ordmax = 30;

    public static int[] generatorPrimes(int numberOfPrimes) {
        primes = new int[numberOfPrimes + 1];
        int primeIndex;
        multiples = new int[ordmax + 1];
        candidate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;
        while (primeIndex < numberOfPrimes) {
            findNextPrime();
            primeIndex++;
            primes[primeIndex] = candidate;
        }
        return primes;
    }

    private static void findNextPrime() {
        do {
            candidate = candidate + 2;
            if (candidate == square) {
                ord = ord + 1;
                square = primes[ord] * primes[ord];
                multiples[ord - 1] = candidate;
            }
            n = 2;
            possiblyPrime = true;
            while (n < ord && possiblyPrime) {
                while (multiples[n] < candidate)
                    multiples[n] = multiples[n] + primes[n] + primes[n];
                if (multiples[n] == candidate)
                    possiblyPrime = false;
                n = n + 1;
            }
        } while (!possiblyPrime);
    }

}
