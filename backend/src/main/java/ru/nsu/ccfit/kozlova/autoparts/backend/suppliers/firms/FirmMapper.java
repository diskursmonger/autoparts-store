package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.firms;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees.GuaranteeMapper;

import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FirmMapper implements Mapper<Firm, FirmDto, FirmCreateRequest, FirmUpdateRequest> {

	private final GuaranteeMapper guaranteeMapper;

	public FirmMapper(GuaranteeMapper guaranteeMapper) {
		this.guaranteeMapper = guaranteeMapper;
	}

	@Override
	public Firm createEntity(FirmCreateRequest createRequest) {
		return Firm.builder()
				.name(createRequest.getName())
				.website(createRequest.getWebsite())
				.build();
	}

	@Override
	public void updateEntity(Firm firm, FirmUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getName(), firm::setName);
		setIfNotNull(updateRequest.getWebsite(), firm::setWebsite);
	}

	@Override
	public FirmDto toDto(Firm firm) {
		Set<GuaranteeDto> guaranteeDtoSet = firm.getGuarantees()
				.stream()
				.map(guaranteeMapper::toDto)
				.collect(Collectors.toSet());

		return FirmDto.builder()
				.id(firm.getId())
				.name(firm.getName())
				.guarantees(guaranteeDtoSet)
				.website(firm.getWebsite())
				.build();
	}
}
