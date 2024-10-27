package ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;

import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StorageCellDto extends AbstractDto<Long> {

	private Set<DetailDto> details;

}
