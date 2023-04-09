package com.xfactor.openlibrary.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;
@RestController
public class Hello 
{

    @GetMapping("/hello")
    public String hello() 
    {
        return "Hello World from Spring Controller!!";
    }
    @GetMapping("/login")
    public String welcome(@RequestParam String userName, @RequestParam String password)
    {
        if(password.equals("123"))
        {
            return "Hello, "+userName;
        }
        else
        {
            return "Invalid Password";
        }
    }
    @GetMapping("/welcomePage/{name}")
        public String Page(@PathVariable String name, @RequestParam String usrName, @RequestParam int password)
        {
            Map<String, Integer> accountList = new HashMap<String, Integer>();
            accountList.put("Ayush_Singh", 340);
            accountList.put("Pratik_Saha", 900);
            accountList.put("Rishav_Dutta", 250);
            //if(accountList.containsKey(usrName))
            if(accountList.keySet().contains(usrName))
            {
                if(password==(accountList.get(usrName)))
                {
                    return "Welcome " + name;
                }
                else
                {
                    return "Invalid Password";
                }
            }
            else
            {
                return "Account does not exist";
            }
        }
    @GetMapping("/hashMap/{name}/{age}")
    public HashMap<String, String> mapping(@PathVariable String name, @PathVariable String age)
    {
        HashMap<String, String> userData = new HashMap<String, String>();
        userData.put("name", name);
        userData.put("age", age);
        return userData;
    }
}


