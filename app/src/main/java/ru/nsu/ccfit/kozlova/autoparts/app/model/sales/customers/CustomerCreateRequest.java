package ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomerCreateRequest {

	private String name;

}
