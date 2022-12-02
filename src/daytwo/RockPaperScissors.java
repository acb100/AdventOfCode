package daytwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissors {
    File file = new File("src/daytwo/input.txt");
    Scanner fileReader = new Scanner(file);



    private int score = 0;

    public RockPaperScissors() throws FileNotFoundException {
    }

    public void part1() {
        while (fileReader.hasNextLine()) {
            String currentLine = fileReader.nextLine();
            String[] arr = currentLine.split((" "));

            switch (arr[1]) {
                case "X" -> score += 1;
                case "Y" -> score += 2;
                case "Z" -> score += 3;
            }

            if ((arr[0].equals("A") && arr[1].equals("Y")) ||
                    (arr[0].equals("B") && (arr[1].equals("Z")) ||
                            arr[0].equals("C") && arr[1].equals("X"))) {
                score += 6;
            } else if ((arr[0].equals("A") && arr[1].equals("X")) ||
                    (arr[0].equals("B") && arr[1].equals("Y")) ||
                    (arr[0].equals("C") && arr[1].equals("Z"))) {
                score += 3;
            }
        }
        System.out.println(score);
    }

   public void part2() {
        while (fileReader.hasNextLine()) {
            String currentLine = fileReader.nextLine();
            String[] arr = currentLine.split((" "));
            switch (arr[1]) {
                case "X": //Lose
                    if (arr[0].equals("A")) {
                        score += 3; //Scissors
                    } else if (arr[0].equals("B")) {
                        score += 1; //Rock
                    } else if (arr[0].equals("C")) {
                        score += 2; //Paper
                    }
                    break;
                case "Y": //Draw
                    score += 3;
                    if (arr[0].equals("A")) {
                        score += 1;
                    } else if (arr[0].equals("B")) {
                        score += 2;
                    } else if (arr[0].equals("C")) {
                        score += 3;
                    }
                    break;
                case "Z": //Win
                    score += 6;
                    if (arr[0].equals("A")) {
                        score += 2; //Paper
                    } else if (arr[0].equals("B")) {
                        score += 3; //Scissors
                    } else if (arr[0].equals("C")) {
                        score += 1; //Rock
                    }
                    break;
            }
        }
       System.out.println(score);
    }

    private void run() {
        part2();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new RockPaperScissors().run();
    }
}
