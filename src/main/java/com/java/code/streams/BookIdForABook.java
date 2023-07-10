package com.java.code.streams;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Book{
    int bookId;
    String bookName;
    Book(int id, String name){
        this.bookId=id;
        this.bookName=name;
    }
}
public class BookIdForABook {
    public static void main(String[] args){
        BookIdForABook bookIdForABook=new BookIdForABook();
        bookIdForABook.problemStatementOne();
    }
    //Find the Book id from a map whose name is “java” using stream API java-8.

    private void problemStatementOne() {

        Map<String, String> books=new HashMap<>();
        books.put("123-A", "DS");
        books.put( "324-A", "c++");
        books.put("213-B", "Java");
        books.put("213-A", "Java");
        //EntrySet() returns Set<Map.Entry<K,V>>
        //Set set=map.entrySet();
        //Map.Entry is an interface
        //In predicate test method, Map.Entry instance will be passed on.
        Optional<Map.Entry<String, String>> opt=books.entrySet().stream().filter(k-> k.getValue().
                        equalsIgnoreCase("java")).findFirst();

        List<Map.Entry<String, String>> optList=books.entrySet().stream().filter(k-> k.getValue().
                equalsIgnoreCase("java")).collect(Collectors.toList());

        System.out.println("Output:"+opt.get().getKey());
        System.out.println("Output:"+optList.get(0).getKey());
    }
}
