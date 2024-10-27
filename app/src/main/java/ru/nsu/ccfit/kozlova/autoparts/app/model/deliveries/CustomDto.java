package ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomDto implements Cloneable {

	private Date clearanceDate;

	private Double taxPercent;

	@SneakyThrows
	public CustomDto clone() {
		CustomDto clone = (CustomDto) super.clone();
		clone.setClearanceDate(clearanceDate);
		clone.setTaxPercent(taxPercent);
		return clone;
	}

}
