package week1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static week1.BOJ1182Silver2.game;

public class BOJ1182Silver2Test {
    @ParameterizedTest
    @ValueSource(strings = {
            "5 0\n-7 -3 -2 5 8"//1
    })
    void test(String testCase) {
        game(new Scanner(testCase));
    }
}
