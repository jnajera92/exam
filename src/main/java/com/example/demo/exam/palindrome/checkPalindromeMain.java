package com.example.demo.exam.palindrome;

import java.util.Scanner;

public class checkPalindromeMain {
    public static void  main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una palabra a validar: ");
        String word = sc.nextLine();

        Boolean response = isPalindrome(word);

        String is = response == true?" es palindrome":
                                     " no es palindrome";
        System.out.print("la palabra "+word+is);

    }

    private static Boolean isPalindrome(String word){
        char[] charts = word.toCharArray();
        Boolean response = true;
        for (int c = 0, b = charts.length-1; c<charts.length;c++,b--) {
            if(charts[c] != charts[b]){
                 response = false;
            }
        }
        return response;
    }
}
