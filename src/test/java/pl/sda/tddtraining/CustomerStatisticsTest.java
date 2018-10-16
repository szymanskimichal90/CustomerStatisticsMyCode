package pl.sda.tddtraining;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerStatisticsTest {



    @Test
    void shouldIdIncreasedByOne() {
        CustomerStatistics customerStatistics = new CustomerStatistics();

        List<Customer> people = customerStatistics.getPeople();
        int counter = 1;
        for (Customer cust : people) {
            int idAsInt = cust.getId().intValue();
            Assertions.assertEquals(counter++, idAsInt);

        }
    }

    @Test
    void shouldReturnProperNames() {
        CustomerStatistics customerStatistics = new CustomerStatistics();

        List<String> peopleNames = customerStatistics.getPeopleNames();
        List<String> peopleNamesWithStream = customerStatistics.getPeopleNamesWithStream();

        assertEquals("Anna Nowak", peopleNames.get(0));
        assertEquals("Monika Kos", peopleNames.get(4));
        assertEquals("Marek Nowak", peopleNamesWithStream.get(2));

    }

    @Test
    void shouldPopulateCustomersMap() {
        CustomerStatistics customerStatistics = new CustomerStatistics();

        Map<Integer, Customer> customersMap = customerStatistics.returnListOfCustomersAsMap();
        Map<Integer, Customer> customersAsMapWithStream = customerStatistics.returnListOfCustomersAsMapWithStream();

        assertEquals("Marek Nowak", customersMap.get(3).getCustomerNameWithLastName());
        assertEquals("Monika Kos", customersAsMapWithStream.get(5).getCustomerNameWithLastName());

    }

//    @Test
//    void shouldPopulateCustomersMapBySalary() {
//        CustomerStatistics customerStatistics = new CustomerStatistics();
//
//        Map<Integer, List<Customer>> customersMapBySalary = customerStatistics.getCustomersMapBySalary();
//
//        assertEquals(2, customersMapBySalary.get(1200).size());
//
//    }
//
//    @Test
//    void shouldPopulateNumberOfPersonWithTheSameSalary() {
//        CustomerStatistics customerStatistics = new CustomerStatistics();
//
//        Map<Integer, Integer> numberOfPersonWithTheSameSalary = customerStatistics.getNumberOfPersonWithTheSameSalary();
//        Integer numberOfPersonWith1200Salary = numberOfPersonWithTheSameSalary.get(1200);
//        assertEquals((Integer) 2, numberOfPersonWith1200Salary);
//
//
//    }
}