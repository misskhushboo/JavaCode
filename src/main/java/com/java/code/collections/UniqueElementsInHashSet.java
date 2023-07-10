package com.java.code.collections;

import java.util.HashSet;
import java.util.Objects;

class Employee{
    String name;
    int age;
    Employee(String name, int age){
        this.name=name;
        this.age=age;
    };
    public String getName(){return name;}
    public int getAge(){return age;}

    //If Hashcode differs then equals will not be called since its guranteed to return false - this is a contract that must be followed.
    //Since for Rahul hashcode is same, in this case, equals will be called which will say both the same objects.

    //If two objects are equal according to the equals(Object) method,
    // then calling the hashCode method on each of the two objects must produce the same integer result. This is a contract that must be followed.
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    //Equals will only be called if the hashcode of 2 employee objects are same. Just to verify the contents of objects.
    public boolean equals(Object obj) {
        Employee emp=(Employee) obj;
       System.out.println("Emp name="+emp.getName()+" current name="+name);
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return emp.getName().equals(name);
    }
}
public class UniqueElementsInHashSet {
    public static void main(String[] args){
        new UniqueElementsInHashSet().problemStatementOne();
    }

    private void problemStatementOne() {

        HashSet<Employee> hashset=new HashSet<>();
        hashset.add(new Employee("Rahul",10));
        hashset.add(new Employee("Pankaj",30));
        hashset.add(new Employee("Krishav",10));
        hashset.add(new Employee("Bhan",25));
        hashset.add(new Employee("Mayor",40));
        hashset.add(new Employee("Rahul",50));
        hashset.forEach(employee-> System.out.println(employee.getName()));
    }
}
