package ru.nsu.ccfit.kozlova.autoparts.backend.model.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetailUpdateRequest {

	private Long storageCellId;

	private Long deliveryId;

	private Long detailTypeId;

}
