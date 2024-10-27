package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import lombok.SneakyThrows;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ChoiceItemSupplier;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.text.ParseException;
import java.time.Instant;
import java.util.*;
import java.util.List;
import java.util.function.UnaryOperator;

public class InputFormBuilder {

	public interface EntityFieldSetter<X> {
		void setField(X value);
	}

	private final List<TextField> textFields = new ArrayList<>();
	private final List<TextField> integerFields = new ArrayList<>();
	private final List<TextField> doubleFields = new ArrayList<>();
	private final List<TextField> dateTimeFields = new ArrayList<>();
	private final List<CheckBox> checkBoxes = new ArrayList<>();
	private final Map<ComboBox, ChoiceItem> choiceBoxes = new LinkedHashMap<>();

	private final Set<Object> nullableFields = new HashSet<>();

	private volatile GridPane grid;
	private final VBox root;

	public InputFormBuilder(VBox root) {
		this.root = root;
		clearFieldsGrid();
	}

	private void clearFieldsGrid() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);

		root.getChildren().clear();
		root.getChildren().add(grid);
	}

	public void addTextField(
			String name,
			String initFieldValue,
			EntityFieldSetter<String> fieldSetter
	) {
		addTextField(name, initFieldValue, fieldSetter, false);
	}

	public void addNullableTextField(
			String name,
			String initFieldValue,
			EntityFieldSetter<String> fieldSetter
	) {
		addTextField(name, initFieldValue, fieldSetter, true);
	}

	private void addTextField(
			String name,
			String initFieldValue,
			EntityFieldSetter<String> fieldSetter,
			boolean isNullable
	) {
		TextField textField = new TextField();
		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			fieldSetter.setField(newValue.trim());
		});

		initFieldValue = Objects.requireNonNullElse(initFieldValue, "");
		fieldSetter.setField(initFieldValue);
		textField.setText(initFieldValue);

		addField(name, textField, isNullable);
		textFields.add(textField);
	}

	public void addCheckBox(
			String name,
			Boolean initFieldValue,
			EntityFieldSetter<Boolean> fieldSetter
	) {
		CheckBox checkBox = new CheckBox();
		checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
			fieldSetter.setField(newValue);
		});

		initFieldValue = Objects.requireNonNullElse(initFieldValue, false);
		fieldSetter.setField(initFieldValue);
		checkBox.setSelected(initFieldValue);

		addField(name, checkBox, false);
		checkBoxes.add(checkBox);
	}

	public void addIntegerField(
			String name,
			Integer initFieldValue,
			EntityFieldSetter<Integer> fieldSetter
	) {
		addIntegerField(name, initFieldValue, fieldSetter, false);
	}

	public void addNullableIntegerField(
			String name,
			Integer initFieldValue,
			EntityFieldSetter<Integer> fieldSetter
	) {
		addIntegerField(name, initFieldValue, fieldSetter, true);
	}

	private void addIntegerField(
			String name,
			Integer initFieldValue,
			EntityFieldSetter<Integer> fieldSetter,
			boolean isNullable
	) {

		UnaryOperator<TextFormatter.Change> integerFilter = change -> {
			String newText = change.getControlNewText();
			if (newText.matches("0|([1-9][0-9]{0,8})?")) {
				return change;
			}
			return null;
		};

		TextField integerField = new TextField();
		integerField.setTextFormatter(
				new TextFormatter<>(
						new IntegerStringConverter(), initFieldValue, integerFilter
				)
		);

		integerField.textProperty().addListener((observable, oldValue, newValue) -> {
			fieldSetter.setField(newValue.isEmpty() ? null : Integer.valueOf(newValue));
		});

		addField(name, integerField, isNullable);
		integerFields.add(integerField);
	}

	public void addDoubleField(
			String name,
			Double initFieldValue,
			EntityFieldSetter<Double> fieldSetter
	) {
		addDoubleField(name, initFieldValue, fieldSetter, false);
	}

	public void addNullableDoubleField(
			String name,
			Double initFieldValue,
			EntityFieldSetter<Double> fieldSetter
	) {
		addDoubleField(name, initFieldValue, fieldSetter, true);
	}

	private void addDoubleField(
			String name,
			Double initFieldValue,
			EntityFieldSetter<Double> fieldSetter,
			boolean isNullable
	) {

		UnaryOperator<TextFormatter.Change> doubleFilter = change -> {
			String newText = change.getControlNewText();
			if (newText.matches("(([1-9][0-9]*)|0)?(\\\\.[0-9]*)?")) {
				return change;
			}
			return null;
		};

		TextField doubleField = new TextField();
		doubleField.setTextFormatter(
				new TextFormatter<>(
						new DoubleStringConverter(), initFieldValue, doubleFilter
				)
		);

		doubleField.textProperty().addListener((observable, oldValue, newValue) -> {
			fieldSetter.setField(newValue.isEmpty() ? null : Double.valueOf(newValue));
		});

		addField(name, doubleField, isNullable);
		doubleFields.add(doubleField);
	}

	public void addDateField(
			String name,
			Date initFieldValue,
			EntityFieldSetter<Date> fieldSetter
	) {
		addDateTimePicker(
				name,
				initFieldValue,
				fieldSetter,
				true,
				false
		);
	}

	public void addNullableDateField(
			String name,
			Date initFieldValue,
			EntityFieldSetter<Date> fieldSetter
	) {
		addDateTimePicker(
				name,
				initFieldValue,
				fieldSetter,
				true,
				true
		);
	}

	public void addDateTimeField(
			String name,
			Date initFieldValue,
			EntityFieldSetter<Date> fieldSetter
	) {
		addDateTimePicker(name, initFieldValue, fieldSetter, false, false);
	}

	public void addNullableDateTimeField(
			String name,
			Date initFieldValue,
			EntityFieldSetter<Date> fieldSetter
	) {
		addDateTimePicker(name, initFieldValue, fieldSetter, false, true);
	}

	private void addDateTimePicker(
			String name,
			Date initFieldValue,
			EntityFieldSetter<Date> fieldSetter,
			final boolean isDateOnly,
			boolean isNullable
	) {
		TextField dateTimeField = new TextField();
		Date currentDate = initFieldValue == null ? Date.from(Instant.now()) : initFieldValue;
		fieldSetter.setField(currentDate);

		String currentDateText = isDateOnly ?
				LocalDateFormatter.getFormattedDate(currentDate) :
				LocalDateFormatter.getFormattedDateTime(currentDate);
		dateTimeField.setText(currentDateText);

		dateTimeField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				try {
					String dateText = dateTimeField.getText().trim();
					dateTimeField.setText(dateText);
					Date date = isDateOnly ?
							LocalDateFormatter.parseDate(dateText)
							: LocalDateFormatter.parseDateTime(dateText);
					fieldSetter.setField(date);
				} catch (ParseException e) {
					dateTimeField.setText("");
					fieldSetter.setField(null);
				}
			}
		});

		addField(name, dateTimeField, isNullable);
		dateTimeFields.add(dateTimeField);
	}

	public <X> void addChoiceBox(
			String name,
			X initFieldValue,
			EntityFieldSetter<X> fieldSetter,
			ChoiceItemSupplier<X> itemSupplier
	) {
		addChoiceBox(name, initFieldValue, fieldSetter, itemSupplier, false);
	}

	public <X> void addNullableChoiceBox(
			String name,
			X initFieldValue,
			EntityFieldSetter<X> fieldSetter,
			ChoiceItemSupplier<X> itemSupplier
	) {
		addChoiceBox(name, initFieldValue, fieldSetter, itemSupplier, true);
	}

	@SneakyThrows
	private <X> void addChoiceBox(
			String name,
			X initFieldValue,
			EntityFieldSetter<X> fieldSetter,
			ChoiceItemSupplier<X> itemSupplier,
			boolean isNullable
	) {
		ChoiceItem<X> defaultItem = new ChoiceItem<>(null, "Не указано");
		var items = itemSupplier.getItems();
		items.add(defaultItem);

		ChoiceItem<X> selectedItem = items.stream()
				.filter(item -> item.getValue() != null &&
						item.getValue().equals(initFieldValue))
				.findAny()
				.orElse(defaultItem);

		ComboBox<ChoiceItem<X>> choiceBox = new ComboBox<>();
		choiceBox.setValue(selectedItem);
		choiceBox.getItems().addAll(items);
		choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			fieldSetter.setField(newValue.getValue());
		});

		choiceBoxes.put(choiceBox, defaultItem);
		addField(name, choiceBox, isNullable);
	}

	private void addField(String name, Control field, boolean isNullable) {
		field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		Label label = new Label(String.format("%s:", name));
		label.setTextAlignment(TextAlignment.CENTER);
		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		GridPane.setHalignment(field, HPos.CENTER);
		GridPane.setValignment(field, VPos.CENTER);
		GridPane.setHalignment(label, HPos.CENTER);
		GridPane.setValignment(label, VPos.CENTER);

		int rowsNumber = grid.getRowCount();
		grid.add(label, 0, rowsNumber, 2, 1);
		grid.add(field, 2, rowsNumber, 3, 1);

		if (isNullable) {
			nullableFields.add(field);
		}
	}

	public boolean validateFields() {
		for (var textField: textFields) {
			var text = textField.getText().trim();
			if (text.isEmpty() && !nullableFields.contains(textField)) {
				textField.setText("");
				textField.requestFocus();
				return false;
			}
		}

		for (var integerField: integerFields) {
			var value = integerField.getText();
			if ((value == null || value.isEmpty()) && !nullableFields.contains(integerField)) {
				integerField.requestFocus();
				return false;
			}
		}

		for (var doubleField: doubleFields) {
			var value = doubleField.getText();
			if ((value == null || value.isEmpty()) && !nullableFields.contains(doubleField)) {
				doubleField.requestFocus();
				return false;
			}
		}

		for (var dateTimeField: dateTimeFields) {
			var dateText = dateTimeField.getText().trim();
			if (dateText.isEmpty() && !nullableFields.contains(dateTimeField)) {
				dateTimeField.requestFocus();
				return false;
			}
		}

		for (var rawChoiceBox: choiceBoxes.keySet()) {
			ComboBox<ChoiceItem<?>> choiceBox = rawChoiceBox;
			ChoiceItem<?> choiceItem = choiceBox.valueProperty().getValue();
			if (choiceItem.getValue() == null && !nullableFields.contains(choiceBox)) {
				choiceBox.requestFocus();
				return false;
			}
		}

		return true;
	}

	public void clearFields() {
		for (var textField: textFields) {
			textField.setText("");
		}

		for (var integerField: integerFields) {
			integerField.setText("");
		}

		for (var doubleField: doubleFields) {
			doubleField.setText("");
		}

		for (var dateTimeField: dateTimeFields) {
			dateTimeField.setText("");
		}

		for (var rawChoiceBox: choiceBoxes.keySet()) {
			ComboBox<ChoiceItem<?>> choiceBox = rawChoiceBox;
			ChoiceItem<?> defaultItem = choiceBoxes.get(rawChoiceBox);
			choiceBox.setValue(defaultItem);
		}

		for (var checkBox: checkBoxes) {
			checkBox.setSelected(false);
		}
	}

	public void clearForm() {
		clearFieldsGrid();

		textFields.clear();
		integerFields.clear();
		doubleFields.clear();
		dateTimeFields.clear();
		checkBoxes.clear();
		choiceBoxes.clear();

		nullableFields.clear();
	}

}
