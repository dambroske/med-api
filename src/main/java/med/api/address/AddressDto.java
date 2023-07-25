package med.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDto(
        @NotBlank
        String street,
        String number,
        String extra,
        @NotBlank
        String zip,
        @NotBlank
        String city,
        @NotBlank
        @Pattern(regexp = "[A-Z]{2}")
        String state
) {
}
