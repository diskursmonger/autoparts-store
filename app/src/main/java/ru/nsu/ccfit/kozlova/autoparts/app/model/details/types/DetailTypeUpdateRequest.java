package ru.nsu.ccfit.kozlova.autoparts.app.model.details.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetailTypeUpdateRequest {

	private String name;

	private Double shopPrice;

}
