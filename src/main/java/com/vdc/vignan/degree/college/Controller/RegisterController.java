package com.vdc.vignan.degree.college.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vdc.vignan.degree.college.Entity.Register;
import com.vdc.vignan.degree.college.Service.RegisterService;

@RestController
@RequestMapping("/api/vignan/register")
@CrossOrigin
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<?> postRegister(@RequestBody Register register) {
        try {
            Register savedRegister = registerService.saveRegister(register);
            return ResponseEntity.ok(savedRegister);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving register: " + e.getMessage());
        }
    }
    
    @GetMapping // Endpoint to retrieve all students
    public List<Register> getAllRegister() {
        return registerService.getAllRegister();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRegisterById(@PathVariable int id) {
        Register register = registerService.getRegisterById(id);
        if (register == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(register);
    }
}
