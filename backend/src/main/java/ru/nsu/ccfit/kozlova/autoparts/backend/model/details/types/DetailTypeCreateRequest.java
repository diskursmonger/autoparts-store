package ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetailTypeCreateRequest {

	private String name;

	private Double shopPrice;

}
