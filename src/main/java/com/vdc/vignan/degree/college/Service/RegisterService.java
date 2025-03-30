package com.vdc.vignan.degree.college.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vdc.vignan.degree.college.Entity.Register;
import com.vdc.vignan.degree.college.Repository.RegisterRepository;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public Register saveRegister(Register register) {
        return registerRepository.save(register);
    }

    public Register getRegisterById(int id) {
        return registerRepository.findById(id).orElse(null);
    }

    public List<Register> getAllRegister() {
        return registerRepository.findAll();
    }
}
