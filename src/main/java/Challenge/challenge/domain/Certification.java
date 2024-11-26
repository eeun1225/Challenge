package Challenge.challenge.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Participation participation;

    private String file_path;

    private String file_type;

    private LocalDate upload_date;

    private String status;
}
