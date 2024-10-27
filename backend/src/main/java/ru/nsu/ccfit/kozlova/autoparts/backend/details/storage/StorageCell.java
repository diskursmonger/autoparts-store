package ru.nsu.ccfit.kozlova.autoparts.backend.details.storage;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.Detail;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "storage_cells")
@Getter @Setter
@NoArgsConstructor
@SuperBuilder
public class StorageCell extends AbstractEntity<Long> {

	@OneToMany(mappedBy = "cell", fetch = FetchType.EAGER)
	private final Set<Detail> details = new HashSet<>();

}
