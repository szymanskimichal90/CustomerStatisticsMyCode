package pl.sda.tddtraining;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CustomerStatistics {
    private Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250"),
            new Customer("Adam", "Twardowski", 33, "1100"),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333)
    };

    public List<Customer> getPeople() {

        return Arrays.asList(people);
    }

    //2. Napisz metodę, która przyjmie tablicę people i zwróci
    // listę Stringów <imię nazwisko> (elementem listy będzie np "Anna Nowak")
    public List<String> getPeopleNames() {
        List<String> result = new ArrayList<String>();
        for (Customer person : people) {
            result.add(person.getName().trim() + " " + person.getLastName().trim());
        }
        return result;
    }

    public List<String> getPeopleNamesWithStream() {
        return getPeople().stream()
                .map(customer -> customer.getName().trim() + " " + customer.getLastName().trim())
                .collect(Collectors.toList());
    }

    //    3. Napisz metodę, która zwróci mapę osób <id,osoba>
    public Map<Integer, Customer> returnListOfCustomersAsMap() {
        Map<Integer, Customer> result = new HashMap<>();
        for (Customer person : getPeople()) {
            result.put(person.getId(), person);
        }

        return result;
    }

    public Map<Integer, Customer> returnListOfCustomersAsMapWithStream() {
        return getPeople().stream().collect(toMap(c -> c.getId(), c -> c));
    }
    //    4. Napisz metodę, która zwróci mapę osób
// według zarobków <zarobki,osoby_z_zarobkami>

    public Map<Integer, List<Customer>> getCustomersMapBySalary() {
        Map<Integer, List<Customer>> result = Maps.newHashMap();
        for (Customer customer : getPeople()) {
            if (result.containsKey(customer.getSalary())) {
                result.get(customer.getSalary()).add(customer);
            } else {
                result.put(customer.getSalary(), Lists.newArrayList(customer));
            }
        }
        result.put(null, Lists.newArrayList());
        return result;
    }

    public Map<Integer, List<Customer>> getCustomersMapBySalaryWithStream() {
        return getPeople().stream().collect(groupingBy(c -> c.getSalary()));
    }

    //    5. Napisz metodę, która zwróci statystykę
// ile jest osób z danymi zarobkami <zarobki,liczba_osób>

    public Map<Integer, Integer> getNumberOfPersonWithTheSameSalary() {
        Map<Integer, Integer> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            checkIfSalaryExistAndPopulate(person, result);
        }
        return result;
    }

    public Map<Integer, Long> getNumberOfPersonWithTheSameSalaryWithStream() {
        return getPeople().stream().collect(groupingBy(c -> c.getSalary(), counting()));
    }

    //    6. Napisz metodę, która zwróci
// mapę map <imię,<zarobki,liczba_osób_z_takimi_zarobkami>>
    public Map<String, Map<Integer, Integer>> getMapOfMapsWithSalary() {
        Map<String, Map<Integer, Integer>> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            if (result.containsKey(person.getName())) {
                Map<Integer, Integer> innerMap = result.get(person.getName());
                checkIfSalaryExistAndPopulate(person, innerMap);

            } else {
                HashMap<Integer, Integer> innerMap = Maps.newHashMap();
                innerMap.put(person.getSalary(), 1);
                result.put(person.getName(), innerMap);
            }
        }
        return result;
    }

    public Map<String, Map<Integer, Long>> getMapOfMapsWithSalaryWithStream() {
        return getPeople().stream().collect(
                groupingBy(c -> c.getName(),
                        groupingBy(c -> c.getSalary(), counting())));
    }

    private void checkIfSalaryExistAndPopulate(Customer person, Map<Integer, Integer> innerMap) {
        if (innerMap.containsKey(person.getSalary())) {
            Integer counter = innerMap.get(person.getSalary()) + 1;
            innerMap.put(person.getSalary(), counter);
        } else {
            innerMap.put(person.getSalary(), 1);
        }
    }


}
