package com.assessment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Assessment2 {
    String firstName; //
    String city;  //empty or not empty
    String lastName;

    public Assessment2(String firstName, String lastName ){
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public static void main(String[] args){
        new Assessment2().process();
    }

    public void process(){
        Assessment2 inst1=new Assessment2("Khushboo","Kaur");
        Assessment2 inst2=new Assessment2("Rajeev","Lucknow","Gupta");
        Assessment2 inst3=new Assessment2("Archana","Singh");
        Assessment2 inst4=new Assessment2("Arnold","Mac");

        List<Assessment2> list= List.of(inst1,inst2,inst3,inst4);

        //Optional<Wipro> opt= Optional.of(inst1);

        //System.out.println(Optional.ofNullable(inst2.getCity()).isEmpty());
        //List<Wipro> changedList=list.stream().filter(w-> w.getCity()!=null).collect(Collectors.toList());
        List<Assessment2> changedList1=list.stream().filter(w-> (Optional.ofNullable(w.getCity()).isEmpty())).collect(Collectors.toList());

        System.out.println(changedList1.size());
        changedList1.forEach(System.out::println);

    }

}
/*
*
* */