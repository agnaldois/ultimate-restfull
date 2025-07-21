package br.ultimate_restfull.unitetests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.ultimate_restfull.data.dto.V2.PersonDTOV2;
import br.ultimate_restfull.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTOV2 mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTOV2> mockDTOList() {
        List<PersonDTOV2> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTOV2 mockDTO(Integer number) {
        PersonDTOV2 person = new PersonDTOV2();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}