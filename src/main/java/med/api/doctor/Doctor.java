package med.api.doctor;

import jakarta.persistence.*;
import lombok.*;
import med.api.address.Address;
import med.api.doctor.dto.SignUpDto;
import med.api.doctor.dto.UpdateDataDto;

import java.util.Optional;

@Table(name = "doctor")
@Entity(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String register;

    @Enumerated(EnumType.STRING)
    private Area area;

    @Embedded
    private Address address;

    public Doctor(SignUpDto signUpDto) {
        this.name = signUpDto.name();
        this.email = signUpDto.email();
        this.phone = signUpDto.phone();
        this.register = signUpDto.register();
        this.area = signUpDto.area();
        this.address = new Address(signUpDto.address());
    }

    public void updateInformation(UpdateDataDto updateDataDto){
        Optional.ofNullable(updateDataDto.name()).ifPresent(this::setName);
        Optional.ofNullable(updateDataDto.email()).ifPresent(this::setEmail);
        Optional.ofNullable(updateDataDto.phone()).ifPresent(this::setPhone);
        Optional.ofNullable(updateDataDto.address()).ifPresent(this.address::updateAddress);
    }

}
