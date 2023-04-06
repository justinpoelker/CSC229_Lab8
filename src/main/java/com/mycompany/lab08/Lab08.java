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

    //Create main method
    public static void main(String[] args) {
        //Grab user input
        Scanner sc = new Scanner(System.in);
        //Grab value from user
        System.out.print("Enter n ");
        int n = sc.nextInt();
        
        //Create list with user value
        SinglyLinkedList<Integer> primes = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> primesWithThree = new SinglyLinkedList<>();
        for (int i = 2; i <= n; i++) {
            //Determine prime numbers
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
        //Output
        System.out.println("Prime numbers from 0 to " + n + ": " + primes);
        System.out.println("Prime numbers with digit '3': " + primesWithThree);
        System.out.println("Sum of prime numbers with digit '3': " + sum);
    }

    //Check if the number is = to prime
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
    //Make sure the number has 3 to move to the 2nd list
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
