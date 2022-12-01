package DayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindMostCalories {
    Scanner fileReader = new Scanner(new File("src/DayOne/input.txt"));
    ArrayList<Integer> calories = new ArrayList<>();

    public FindMostCalories() throws FileNotFoundException {
    }

    public void readFile() {
        int sumOfAlf = 0;
        do {
            String in = fileReader.nextLine();
            if (in.equals("")){
                calories.add(sumOfAlf);
                sumOfAlf = 0;
            } else {
                sumOfAlf += Integer.parseInt(in);
            }
        } while (fileReader.hasNextLine());
    }


    public int findMostCalories() {
        int index;
        int compare = 0;
        for (int i = 0; i < calories.size(); i++) {
            index = calories.get(i);
            if (index > compare) {
                compare = index;
            }
        }
        return compare;
    }

    private void run() {
        readFile();
        findMostCalories();
        System.out.println(Collections.max(calories));
    }

    public static void main(String[] args) throws FileNotFoundException {
        new FindMostCalories().run();
    }
}
