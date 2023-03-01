package week1;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static week1.BOJ15686Gold4.chickenGame;

public class BOJ15686Gold4Test {
    @Test
    void test(){
        String testCase1 = "5 3\n" +
                "0 0 1 0 0\n" +
                "0 0 2 0 1\n" +
                "0 1 2 0 0\n" +
                "0 0 1 0 0\n" +
                "0 0 0 0 2";
        chickenGame(new Scanner(testCase1));
        String testCase2 = "5 2\n" +
                "0 2 0 1 0\n" +
                "1 0 1 0 0\n" +
                "0 0 0 0 0\n" +
                "2 0 0 1 1\n" +
                "2 2 0 1 2";
        String result2 = "10";
        chickenGame(new Scanner(testCase2));
        String testCase3 = "5 1\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0";
        String result3 = "11";
        chickenGame(new Scanner(testCase3));
        String testCase4 = "5 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1";
        chickenGame(new Scanner(testCase4));
        String result4 = "32";
    }

}
