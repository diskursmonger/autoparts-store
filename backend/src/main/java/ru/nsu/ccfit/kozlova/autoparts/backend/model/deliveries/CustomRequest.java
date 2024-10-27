package ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomRequest {

	private LocalDate clearanceDate;

	private Double taxPercent;

}
