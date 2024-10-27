package ru.nsu.ccfit.kozlova.autoparts.backend.model.details;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetailDto extends AbstractDto<Long> {

	private Long storageCellId;

	private Long deliveryId;

	private DetailTypeDto detailType;

	private RefundDto refund;

}
