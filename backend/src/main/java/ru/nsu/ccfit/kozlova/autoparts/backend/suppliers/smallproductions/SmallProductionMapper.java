package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallproductions;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;

import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

import java.util.Collections;

@Component
public class SmallProductionMapper implements Mapper<
		SmallProduction, SmallProductionDto, SmallProductionCreateRequest, SmallProductionUpdateRequest> {
	@Override
	public SmallProduction createEntity(SmallProductionCreateRequest createRequest) {
		return SmallProduction.builder()
				.name(createRequest.getName())
				.website(createRequest.getWebsite())
				.build();
	}

	@Override
	public void updateEntity(SmallProduction smallProduction, SmallProductionUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getName(), smallProduction::setName);
		setIfNotNull(updateRequest.getWebsite(), smallProduction::setWebsite);
	}

	@Override
	public SmallProductionDto toDto(SmallProduction smallProduction) {
		return SmallProductionDto.builder()
				.id(smallProduction.getId())
				.name(smallProduction.getName())
				.guarantees(Collections.emptySet())
				.website(smallProduction.getWebsite())
				.build();
	}
}
