package med.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.doctor.Doctor;
import med.api.doctor.DoctorRepository;
import med.api.doctor.dto.GetDoctorDto;
import med.api.doctor.dto.SignUpDto;
import med.api.doctor.dto.UpdateDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @GetMapping
    public Page<GetDoctorDto> getDoctor(@PageableDefault(sort = {"name"}) Pageable page){
        return repository.findAll(page).map(GetDoctorDto::new);
    }

    @PostMapping
    @Transactional
    public SignUpDto signUp(@RequestBody @Valid SignUpDto signUpDto){
        repository.save(new Doctor(signUpDto));
        return signUpDto;
    }

    @PutMapping
    @Transactional
    public String update(@RequestBody @Valid UpdateDataDto updateDataDto){
        var doctor = repository.getReferenceById(updateDataDto.id());
        doctor.updateInformation(updateDataDto);
        return "register updated!";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        if (repository.existsById(id)){
           repository.deleteById(id);
        }
    }
}
