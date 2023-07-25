package med.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.patient.Patient;
import med.api.patient.PatientRepository;
import med.api.patient.dto.GetPatientDto;
import med.api.patient.dto.SignUpDto;
import med.api.patient.dto.UpdateDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping
    public Page<GetPatientDto> getPatient(@PageableDefault(sort = {"name"}) Pageable page){
        return repository.findAll(page).map(GetPatientDto::new);
    }

    @PostMapping
    @Transactional
    public SignUpDto signUp(@RequestBody @Valid SignUpDto signUpDto){
        repository.save(new Patient(signUpDto));
        return signUpDto;
    }

    @PutMapping
    @Transactional
    public String update(@RequestBody @Valid UpdateDataDto updateDataDto){
        var patient = repository.getReferenceById(updateDataDto.id());
        patient.updateInformation(updateDataDto);
        return "register updated!";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
