package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        int winningCount = 0;
        ArrayList<String> computerWord = new ArrayList();
        computerWord.add("c");
        computerWord.add("a");
        computerWord.add("t");
        String head = "";
        String body = "";
        String footer = "";
        String letter1 = "_";
        String letter2 = "_";
        String letter3 = "_";
        System.out.println("Welcome to the Hangman game!");
        while(count < 4){
            if(winningCount == 3){
                System.out.println("Yes! The secret word is cat. You have won!");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Do you want to play again? (yes or no)");
                String play = scanner1.next().toLowerCase(Locale.ROOT);
                if(play.equals("yes")){
                    winningCount = 0;
                    count = 0;
                    letter1 = "_";
                    letter2 = "_";
                    letter3 = "_";
                    head = "";
                    body = "";
                    footer = "";
                    continue;
                }else if(play.equals("no")){
                    System.out.println("Maybe next time! Have a Good Day.");
                    break;
                }else {
                    System.out.println("Please makes sure your answer is 'yes' or 'no'");
                    continue;
                }
            }
            System.out.println("+------+");
            System.out.println("|");
            System.out.print("      "+head);
            System.out.println();
            System.out.print("       "+body);
            System.out.println();
            System.out.println("|");
            System.out.print("       "+footer);
            System.out.println();
            System.out.println();
            System.out.println("|");
            System.out.println("======");
            System.out.println("Missed letters: " + count);
            System.out.println(letter1 + letter2  + letter3 );
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose a letter: ");
            String input = scanner.next();
            if(input.length() != 1){
                System.out.println("You have to enter only one letter, please try again");
                continue;
            }
            if(computerWord.contains(input)){
                if(computerWord.get(0).equals(input)){
                    letter1 = input;
                    winningCount++;
                    continue;
                }else if(computerWord.get(1).equals(input)){
                    letter2 = input;
                    winningCount++;
                    continue;
                }else if(computerWord.get(2).equals(input)){
                    letter3 = input;
                    winningCount++;
                    continue;
                }else if(input == "q"){
                    System.out.println("Have a good day!");
                    break;
                }

            }
            count++;
            System.out.println("You missed a chance. Missed chances : " + count + ". Try again!");
            if(count == 1){
                head = "()";
            }
            if(count == 2){
                body = "|";
            }
            if(count == 3){
                footer = "|";
            }
            if(count == 4){
                System.out.println("Game over!");
            }
        }

    }
}
