package com.ercargo.learn.concurrency.test;

/**
 * @author ercargo  on 2019/2/18
 * @DESCRIBE
 */
public class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        //两个对象的引用相同，直接返回是同一个对象
        if (this == o){
            return true;
        }
        //否则：
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    public static void main(String[] args) {
        Person p = new Person(1,"ky");
        Person p2 = new Person(1, "ky2");

        System.out.println(p.equals(p2));
    }
}
