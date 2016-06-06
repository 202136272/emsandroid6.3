package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import java.io.Serializable;
/**
 * Created by Bonga on 2016/03/28.
 */


public class Person implements Serializable {
    private Long id;
    private String persalNumber;
    private String name;
    private String surname;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersalNumber() {
        return persalNumber;
    }

    public Person(Builder builder) {

        id = builder.id;
        name = builder.name;
        surname = builder.surname;
        persalNumber = builder.persalNumber;

    }

    public static class Builder {

        //Equivalent to setters
        private Long id;
        private String name;
        private String surname;
        private String persalNumber;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder persalNumber(String persalNumber) {
            this.persalNumber = persalNumber;
            return this;
        }

        public Builder copy(Person person){
            this.id = person.getId();
            this.name = person.getName();
            this.surname = person.getSurname();
            this.persalNumber = person.getPersalNumber();

            return this;
        }
        public Person build() {
            return new Person(this);
        }
    }
}