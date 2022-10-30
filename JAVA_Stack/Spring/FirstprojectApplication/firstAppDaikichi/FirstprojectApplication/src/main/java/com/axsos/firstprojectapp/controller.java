package com.axsos.firstprojectapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
@RequestMapping("/daikichi")
public class controller {

        @RequestMapping("")
        // 3. Method that maps to the request route above
        public String daikichi() { // 3
                return "Welcome!";
        }
        @RequestMapping("/today")
        // 3. Method that maps to the request route above
        public String daikichiToday() { // 3
                return "Today you will find luck in all your endeavors";
        }
        @RequestMapping("/tomorrow")
        // 3. Method that maps to the request route above
        public String daikichiTmw() { // 3
                return "Tomorrow, an opportunity will arise, be sure to be open to new ideas!";
        }
}

