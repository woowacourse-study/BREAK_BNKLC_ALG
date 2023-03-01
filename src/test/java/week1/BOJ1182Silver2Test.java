package week1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static week1.BOJ1182Silver2.game;

public class BOJ1182Silver2Test extends OutputTestStream {
    @Test
    void setTestCase(){
        testCase = "5 0\n-7 -3 -2 5 8";
        result = "1";
    }

    @AfterEach
    void mainTest() {
        game(new Scanner(testCase));
        assertThat(output()).contains(result);
    }
}
