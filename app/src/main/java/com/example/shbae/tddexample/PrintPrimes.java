package com.example.shbae.tddexample;//package function;

// 리펙토링 진행 (TDD는 아님)
public class PrintPrimes {

    private static final int numberOfPrimes = 1000;
    private static final int linesPerPage = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        int[] primes = primeGenerator.generatorPrimes(numberOfPrimes);
        NumberPrinter numberPrinter = new NumberPrinter(linesPerPage, columns);
        numberPrinter.print(primes, numberOfPrimes);
    }
}
