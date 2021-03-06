package store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void isNumber(Object e) throws RightAnswer {
        if(e instanceof Integer){
            throw new RightAnswer();
        }
    }

    public static void main(String[] args) throws IOException {
        CheckingAllCounts checkingAllCounts = new CheckingAllCounts();
        Scanner n = new Scanner(System.in);
        System.out.println("Welcome to the Hangman game. \n Please enter your name: ");
        String name = n.next();
        int count = checkingAllCounts.getCount();
        int winningCount = checkingAllCounts.getWinningCount();
        int score = checkingAllCounts.getScore();

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
                String correctWord = Arrays.toString(computerWord.stream().map(letter -> letter + "").collect(Collectors.toList()).toArray());
                System.out.println("Yes! The secret word is " + correctWord +". You have won!");
                System.out.println("Your final score is " + score + " out of 5");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Do you want to play again? (yes or no)");
                String play;
                try{

                    play = scanner1.next().toLowerCase(Locale.ROOT);
                 //   isNumber((Object)play);
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
                            throw new AcceptableRespond();
                    }
                }catch (AcceptableRespond e){
                    System.out.println(e.getMessage());
                    continue;
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
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
            //have letters in list and then map them
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose a letter: ");
            String input;
try{
    input = scanner.next().toLowerCase(Locale.ROOT);
//    Integer test = Integer.parseInt(input);
    isNumber((Object)input);
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
        }else if(input.equals("q")){
            System.out.println("Have a good day!");
            break;
        }

    }
}catch(RightAnswer e){
    System.out.println(e.getMessage());
}
catch(Exception e){

}
            count++;
            System.out.println("You missed a chance. Missed chances : " + count + ". Try again!");
            if(count == 1){
                score--;
                head = "()";
            }
            if(count == 2){
                body = "|";
                score--;
            }
            if(count == 3){
                footer = "|";
                score--;

            }
            if(count == 4){
                score--;
                System.out.println("Your final score is " + score + " out of 5");
                System.out.println("Game over!");
            }
        }
        File file = new File("C:\\Users\\kajay\\IdeaProjects\\Hangman\\gameResult.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter("C:\\Users\\kajay\\IdeaProjects\\Hangman\\gameResult.txt");
        fw.write("Name: " + name + "\nYour Score is: " + score + " out of 5");
        fw.close();
    }
}
