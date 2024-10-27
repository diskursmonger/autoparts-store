package ru.nsu.ccfit.kozlova.autoparts.app.model.details;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;

import java.time.LocalDate;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RefundDto extends Entity {

	private Date customerRefundDate;

	private Date supplierRefundDate;

	@SneakyThrows
	public RefundDto clone() {
		RefundDto clone = (RefundDto) super.clone();
		clone.setId(getId());
		clone.setCustomerRefundDate(customerRefundDate);
		clone.setSupplierRefundDate(supplierRefundDate);
		return clone;
	}

}
