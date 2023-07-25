package med.api.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.api.address.AddressDto;
import med.api.doctor.Area;

public record SignUpDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String register,
        @NotNull
        Area area,
        @NotNull
        @Valid
        AddressDto address
) {
}
