package med.api.doctor.dto;

import med.api.doctor.Area;
import med.api.doctor.Doctor;

public record GetDoctorDto(
        Long id,
        String name,
        String email,
        String phone,
        String register,
        Area area
) {
    public GetDoctorDto(Doctor doctor){
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getRegister(),
                doctor.getArea());
    }
}
