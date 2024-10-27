package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.dealers;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees.GuaranteeMapper;

import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DealerMapper implements Mapper<Dealer, DealerDto, DealerCreateRequest, DealerUpdateRequest> {

	private final GuaranteeMapper guaranteeMapper;

	public DealerMapper(GuaranteeMapper guaranteeMapper) {
		this.guaranteeMapper = guaranteeMapper;
	}

	@Override
	public Dealer createEntity(DealerCreateRequest createRequest) {
		return Dealer.builder()
				.name(createRequest.getName())
				.website(createRequest.getWebsite())
				.build();
	}

	@Override
	public void updateEntity(Dealer dealer, DealerUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getName(), dealer::setName);
		setIfNotNull(updateRequest.getWebsite(), dealer::setWebsite);
	}

	@Override
	public DealerDto toDto(Dealer dealer) {
		Set<GuaranteeDto> guaranteeDtoSet = dealer.getGuarantees()
				.stream()
				.map(guaranteeMapper::toDto)
				.collect(Collectors.toSet());

		return DealerDto.builder()
				.id(dealer.getId())
				.name(dealer.getName())
				.guarantees(guaranteeDtoSet)
				.website(dealer.getWebsite())
				.build();
	}
}
