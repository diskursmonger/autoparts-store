package ru.nsu.ccfit.kozlova.autoparts.backend.model.details;

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
public class RefundRequest {

	private LocalDate customerRefundDate;

	private LocalDate supplierRefundDate;

}
