package med.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String number;
    private String extra;
    private String zip;
    private String city;
    private String state;

    public Address(AddressDto addressDto){
        this.street = addressDto.street();
        this.number = addressDto.number();
        this.extra = addressDto.extra();
        this.zip = addressDto.zip();
        this.city = addressDto.city();
        this.state = addressDto.state();
    }

    public void updateAddress(AddressDto address) {
        Optional.ofNullable(address.street()).ifPresent(this::setStreet);
        Optional.ofNullable(address.number()).ifPresent(this::setNumber);
        Optional.ofNullable(address.extra()).ifPresent(this::setExtra);
        Optional.ofNullable(address.zip()).ifPresent(this::setZip);
        Optional.ofNullable(address.city()).ifPresent(this::setCity);
        Optional.ofNullable(address.state()).ifPresent(this::setState);
    }
}
