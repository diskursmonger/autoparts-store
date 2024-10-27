package ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomDto {

	private Long id;

	private LocalDate clearanceDate;

	private Double taxPercent;

}
