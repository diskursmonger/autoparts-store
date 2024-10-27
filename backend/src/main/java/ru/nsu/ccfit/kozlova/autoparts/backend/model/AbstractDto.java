package ru.nsu.ccfit.kozlova.autoparts.backend.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter @Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractDto<ID extends Serializable> implements Serializable {

    private ID id;

}
