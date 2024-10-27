package ru.nsu.ccfit.kozlova.autoparts.backend.details.types;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "detail_types")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DetailType extends AbstractEntity<Long> {

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "detailType", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ShopDetailTypePrice shopDetailTypePrice;

}
