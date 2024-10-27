package ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;

import java.time.LocalDate;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DeliveryDto extends AbstractDto<Long> {

	private Double discountPercent;

	private LocalDate formationDate;

	private LocalDate deliveryDate;

	private SupplierDto supplier;

	private CustomDto custom;

	private Set<DetailDto> details;

	private Set<DeliveryDetailTypePriceDto> detailTypePrices;

}
