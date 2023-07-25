package med.api.patient.dto;

import med.api.patient.Patient;

public record GetPatientDto(
        Long id,
        String name,
        String email,
        String phone,
        String documentId
) {

    public GetPatientDto(Patient patient){
        this(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getDocumentId()
        );
    }
}
