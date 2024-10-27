package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallsuppliers;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;

import java.util.Collections;

import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

@Component
public class SmallSupplierMapper implements Mapper<
		SmallSupplier, SmallSupplierDto, SmallSupplierCreateRequest, SmallSupplierUpdateRequest> {
	@Override
	public SmallSupplier createEntity(SmallSupplierCreateRequest createRequest) {
		return SmallSupplier.builder()
				.name(createRequest.getName())
				.phoneNumber(createRequest.getPhoneNumber())
				.build();
	}

	@Override
	public void updateEntity(SmallSupplier smallSupplier, SmallSupplierUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getName(), smallSupplier::setName);
		setIfNotNull(updateRequest.getPhoneNumber(), smallSupplier::setPhoneNumber);
	}

	@Override
	public SmallSupplierDto toDto(SmallSupplier smallSupplier) {
		return SmallSupplierDto.builder()
				.id(smallSupplier.getId())
				.name(smallSupplier.getName())
				.phoneNumber(smallSupplier.getPhoneNumber())
				.guarantees(Collections.emptySet())
				.build();
	}
}
