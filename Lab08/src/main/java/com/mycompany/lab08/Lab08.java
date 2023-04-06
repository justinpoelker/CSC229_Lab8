/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab08;
import java.util.Scanner;

/**
 *
 * @author jpzuc
 */
public class Lab08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        SinglyLinkedList<Integer> primes = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> primesWithThree = new SinglyLinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.addLast(i);
                if (hasDigitThree(i)) {
                    primesWithThree.addLast(i);
                }
            }
        }
        int sum = 0;
        for (int i : primesWithThree) {
            sum += i;
        }
        System.out.println("Prime numbers from 0 to " + n + ": " + primes);
        System.out.println("Prime numbers with digit '3': " + primesWithThree);
        System.out.println("Sum of prime numbers with digit '3': " + sum);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDigitThree(int n) {
        while (n > 0) {
            if (n % 10 == 3) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
