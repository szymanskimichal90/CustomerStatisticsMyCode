package pl.sda.tddtraining;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class Customer {
    private final String name;
    private final String lastName;
    private final Integer age;
    private final Integer salary;
    private final Integer id;
    @Setter(value = AccessLevel.PRIVATE)
    private static int count = 1;

    public Customer(String name, String lastName, int age, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.id = count++;
    }

    public Customer(String name, String lastName, int age, String salary) {
        this(name, lastName, age, Integer.valueOf(salary));
    }

    public String getCustomerNameWithLastName() {
        String tempName = getName();
        if (tempName == null) {
            tempName = "";
        }
        String tempLastName = getLastName() == null ? "" : getLastName();
        return tempName.trim() + " " + tempLastName.trim();
    }

    public String getCustomerNameWithLastNameWithStringUtils() {
        return StringUtils.defaultIfBlank(getName(), "").trim()
                +(StringUtils.isBlank(getName())?"":" ")
                +StringUtils.defaultIfBlank(getLastName(), "").trim();
    }



}
