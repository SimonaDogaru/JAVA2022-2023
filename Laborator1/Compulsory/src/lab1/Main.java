package lab1;

import java.util.Scanner;

public class Main {
    static int compute(int n) {
        n = n * 3;
        n = n + 0B10101;
        n = n + 0xFF;
        n = n * 6;
        return n;
    }

    static int manyToOne(int n) {
        int sum = 0;
        while (n > 9) {
            sum = 0;
            while (n > 0) {
                sum = sum + n % 10;
                n = n / 10;
            }
            n = sum;
        }
        return sum;
    }

    static void compulsory() {
        //ex1
        System.out.println("Hello World!");
        //ex2
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //ex3
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        //ex4
        n = compute(n);
        System.out.println(n);
        //ex5
        int result = manyToOne(n);
        System.out.println(result);
        //ex6
        System.out.println("Willy-nilly, this semestere I will learn " + languages[result]);
    }


    public static void main(String args[]) {
      compulsory();
    }
}
