package com.imooc.restful.controller;

import com.imooc.restful.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/restful")
public class RestfulController {
    @GetMapping("/request")
//    @ResponseBody
    public String doGetRequest() {
        return "{\"message\": \"getting...\"}";
    }

    @PostMapping("/request")
//    @ResponseBody
    public String doPostRequest(){
        return "{\"message\": \"inserting...\"}";
    }

    @PutMapping("/request")
//    @ResponseBody
    public String doPutRequest(){
        return "{\"message\": \"updating...\"}";
    }
    @DeleteMapping("/request")
//    @ResponseBody
    public String doDeleteRequest(){
        return "{\"message\": \"deleting...\"}";
    }

    @GetMapping("/person")
    public Person findByPersonId(Integer id){
        Person person = new Person();
        if(id == 1){
            person.setName("person1");
            person.setAge(20);
        }
        else if(id == 2){
            person.setName("person2");
            person.setAge(22);
        }
        return person;
    }
    @GetMapping("/persons")
    public List<Person> findPersons(){
        List list = new ArrayList();
        Person person1 = new Person();
        person1.setName("person1");
        person1.setAge(20);
        person1.setBirthday(new Date());
        Person person2 = new Person();
        person2.setName("person2");
        person2.setAge(22);
        person2.setBirthday(new Date());
        list.add(person1);
        list.add(person2);
        return list;
    }
}
