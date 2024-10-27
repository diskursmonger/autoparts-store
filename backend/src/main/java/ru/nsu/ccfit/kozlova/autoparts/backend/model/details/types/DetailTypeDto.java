package ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetailTypeDto extends AbstractDto<Long> {

	private String name;

	private Double shopPrice;

}
