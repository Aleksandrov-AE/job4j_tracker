package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddDuplicateMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenDuplicate = new Citizen("2f44a", "Alisher Pupkin");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(citizenDuplicate)).isFalse();
    }

    @Test
    void whenTestGetNull() {
        PassportOffice passportOffice = new PassportOffice();
        Citizen citizen = new Citizen("4005 999999", "Alex");
        passportOffice.add(citizen);
        passportOffice.get("4444");
        assertThat(passportOffice.get("4444")).isNull();
    }
}