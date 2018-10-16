package pl.sda.tddtraining;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Junit5Basic {

    private static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void firstTest() {
        int a = 1;
        int b = 2;
        assert 3 == calculator.add(1, 2);
    }

    @Test
    void firstJunitTest() {
        int a = 1;
        int b = 2;
        Assertions.assertEquals(3, calculator.add(a, b));
    }

    @Test
    void assertions() {
        List<String> legacyPeople = new ArrayList();
        legacyPeople.add("Adam Nowak");
        legacyPeople.add("Jan Kowalski");
        List<String> people = Lists.newArrayList("Adam Nowak", "Jan Kowalski");
        Assertions.assertNotNull(people);
        Assertions.assertSame(people, people); //  == do porównania
        Assertions.assertNotSame(legacyPeople, people);
        Assertions.assertLinesMatch(legacyPeople, people);
        Assertions.assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }
}
