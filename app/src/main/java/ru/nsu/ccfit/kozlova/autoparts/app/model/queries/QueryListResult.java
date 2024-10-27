package ru.nsu.ccfit.kozlova.autoparts.app.model.queries;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class QueryListResult<T> {
	private List<T> elements;
}
