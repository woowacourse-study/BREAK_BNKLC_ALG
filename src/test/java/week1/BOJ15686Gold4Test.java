package week1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static week1.BOJ15686Gold4.game;

public class BOJ15686Gold4Test extends OutputTestStream {
    @Test
    void test1() {
        testCase = "5 3\n" +
                "0 0 1 0 0\n" +
                "0 0 2 0 1\n" +
                "0 1 2 0 0\n" +
                "0 0 1 0 0\n" +
                "0 0 0 0 2";
        result = "5";
    }
    @Test
    void test2(){
        testCase = "5 2\n" +
                "0 2 0 1 0\n" +
                "1 0 1 0 0\n" +
                "0 0 0 0 0\n" +
                "2 0 0 1 1\n" +
                "2 2 0 1 2";
        result = "10";
    }
    @Test
    void test3(){
        testCase = "5 1\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0\n" +
                "1 2 0 0 0";
        result = "11";
    }
    @Test
    void test4(){
        testCase="5 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1\n" +
                "1 2 0 2 1";
        result = "32";
    }
    @AfterEach
    void mainTest(){
        game(new Scanner(testCase));
        assertThat(output()).contains(result);
    }
}
