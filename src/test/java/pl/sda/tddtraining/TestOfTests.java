package pl.sda.tddtraining;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class TestOfTests {

    @Test
    void treeSet() {
        Customer customer = new Customer("", "", 1, 1);
        TreeSet<Comparable> comparables = Sets.newTreeSet();
        comparables.add("");
    }
}
