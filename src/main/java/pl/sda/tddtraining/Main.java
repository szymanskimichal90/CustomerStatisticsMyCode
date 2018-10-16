package pl.sda.tddtraining;

import java.util.Map;

public class Main {


    public static void main(String[] args) {
        CustomerStatistics customerStatistics = new CustomerStatistics();
        for (Customer person : customerStatistics.getPeople()) {
            System.out.println(person.getId());

        }
    }
}