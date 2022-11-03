package be.infernalwhale.springdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/wonderful")
public class MyWonderfulController {
    // https://www.youtube.com:443/watch?v=CBfGIR0NqCE

    // 200, 404, 314, 204
    // 1xx >> information
    // 2xx >> all is well, here is your response
    // 3xx >> You don't need to be HERE, but somewhere else... (REDIRECT)
    // 4xx >> Error (You fucked up)
    // 5xx >> Error (We fucked up)
    // { "error": "Name of customer not complete" }
    @GetMapping("/hello")
    public ResponseEntity doStuff() {
        return ResponseEntity.ok("Hello World from the controller");
    }

    @PostMapping("/hello")
    public ResponseEntity helloPost() {
        return ResponseEntity.ok("Hello from the POST endpoint");
    }

    @GetMapping("/employee/{idee}")
    public ResponseEntity getEmployee(@PathVariable("idee") Long id) throws ValidationException {
        if (id < 10000 || id > 99999) throw new ValidationException("Your id was not within spec");

        return ResponseEntity.ok("Received var id with value: " + id);
    }

    @GetMapping("/employee")
    public ResponseEntity getEmployee(@RequestParam("empname") String name) {
        return ResponseEntity.ok("Received param with value: " + name);
    }

    @PostMapping("/employee")
    public ResponseEntity createEmployee(@RequestBody Employee employee) throws ValidationException {
        if (employee.getId() < 10000 || employee.getId() > 99999)
            throw new ValidationException("The id for this employyee is too big... No mas");
        return ResponseEntity.ok("Emp received: " + employee.toString());
    }

    @GetMapping("/testPoop")
    public ResponseEntity testing(@RequestBody Employee employee) {
        throw new NullPointerException("Poop");

//        return ResponseEntity.ok("Emp received: " + employee.toString());
    }
}
