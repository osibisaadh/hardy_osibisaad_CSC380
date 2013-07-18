package util;

public class Person {
    private String name;
    private int age;
    public Person(String name, int e){
        this.name = name;
        age = e;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
