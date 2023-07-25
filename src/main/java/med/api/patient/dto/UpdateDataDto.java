package med.api.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.api.address.AddressDto;

public record UpdateDataDto(
        @NotNull
        Long id,
        String name,
        String email,
        String phone,
        AddressDto address
) {
}
