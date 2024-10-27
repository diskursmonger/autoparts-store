package ru.nsu.ccfit.kozlova.autoparts.backend.model.details;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RefundDto {

	private Long id;

	private LocalDate customerRefundDate;

	private LocalDate supplierRefundDate;

}
