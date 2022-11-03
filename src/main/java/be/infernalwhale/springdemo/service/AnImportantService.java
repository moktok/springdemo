package be.infernalwhale.springdemo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
// Singleton, Prototype
// Singleton >> Eager
// Prototype >> Lazy
// Request, Session << These are WEB scopes
public class AnImportantService {
    public AnImportantService() {
        System.out.println("Creating the important service...");
    }

    public String woops() {
        return "woops";
    }

    public String hello() {
        return "hello";
    }

    public String getBuzz() {
        return "Buzz";
    }

    public String getFizz() {
        return "Fizz";
    }
}
