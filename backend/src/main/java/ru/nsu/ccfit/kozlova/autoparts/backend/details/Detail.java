package ru.nsu.ccfit.kozlova.autoparts.backend.details;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.deliveries.Delivery;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.storage.StorageCell;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Detail extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "detail_type_id")
    private DetailType detailType;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "cell_id")
    private StorageCell cell;

    @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Refund refund;

}
