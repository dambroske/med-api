package med.api.patient;

import jakarta.persistence.*;
import lombok.*;
import med.api.address.Address;
import med.api.patient.dto.SignUpDto;
import med.api.patient.dto.UpdateDataDto;

import java.util.Optional;

@Table(name = "patient")
@Entity(name = "Patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String documentId;

    @Embedded
    private Address address;

    public Patient(SignUpDto signUpDto){
        this.name = signUpDto.name();
        this.email = signUpDto.email();
        this.phone = signUpDto.phone();
        this.documentId = signUpDto.documentId();
        this.address = new Address(signUpDto.address());
    }

    public void updateInformation(UpdateDataDto updateDataDto){
        Optional.ofNullable(updateDataDto.name()).ifPresent(this::setName);
        Optional.ofNullable(updateDataDto.email()).ifPresent(this::setEmail);
        Optional.ofNullable(updateDataDto.phone()).ifPresent(this::setPhone);
        Optional.ofNullable(updateDataDto.address()).ifPresent(this.address::updateAddress);
    }
}
