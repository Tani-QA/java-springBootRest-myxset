package main.model;


public class User {

    private String name;
    private String surname;
    private Integer age;

    public User() {

    }

    public User(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {

        if(age==null){
            this.age=123;
        } else {
            this.age = age;
        }

    }

    @Override
    public String toString() {
        return "Person1: {" +
                "name='"+ name+ '\'' +
                ", surname='"+ surname+ '\'' +
                ", age='"+ age+ '\'' +
                '}';

    }





}
