package week1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static week1.Gold.game;

public class GoldTest extends OutputTestStream {
    @Test
    void setTestCase(){
        testCase = "4 5\n" +
                "50 45 37 32 30\n" +
                "35 50 40 20 25\n" +
                "30 30 25 17 28\n" +
                "27 24 22 15 10";
        result = "3";
    }

    @AfterEach
    void mainTest() throws IOException {
        game(new InputStreamReader(new ByteArrayInputStream(testCase.getBytes())));
        assertThat(output()).contains(result);
    }
}
