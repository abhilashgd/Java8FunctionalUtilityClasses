package combinatorpattern;

import java.time.LocalDate;

public class Customer {

    public Customer(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }
}
