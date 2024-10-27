package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
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
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ErrorAction;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.SuccessAction;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.function.UnaryOperator;

public class EntityInputFormController<I, O> {

    public interface SubmitAction<X, Y> {
        ServiceResponse<Y> submit(X inputEntity) throws Exception;
    }

    public interface EntityFieldSetter<X> {
        void setField(X value);
    }


    private SubmitAction<I, O> submitAction;
    private SuccessAction onSuccessAction;
    private ErrorAction onErrorAction;
    private RequestExecutor requestExecutor;

    private final List<TextField> textFields = new ArrayList<>();
    private final List<TextField> integerFields = new ArrayList<>();
    private final List<TextField> doubleFields = new ArrayList<>();
    private final List<TextField> dateTimeFields = new ArrayList<>();
    private final List<CheckBox> checkBoxes = new ArrayList<>();
    private final Map<ComboBox, ChoiceItem> choiceBoxes = new LinkedHashMap<>();

    private final Set<Object> nullableFields = new HashSet<>();

    @FXML
    private VBox contentBox;

    @FXML
    private GridPane grid;

    private I inputEntity;

    public void init(
            I entity,
            SubmitAction<I, O> submitAction,
            SuccessAction onSuccessAction,
            ErrorAction onErrorAction,
            RequestExecutor requestExecutor
    ) {
        this.inputEntity = entity;
        this.submitAction = submitAction;
        this.requestExecutor = requestExecutor;
        this.onSuccessAction = onSuccessAction;
        this.onErrorAction = onErrorAction;
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

    private boolean validateFields() {
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

    @FXML
    private void clearFields() {
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

    @FXML
    private void submit(ActionEvent event) {
        boolean fieldsAreValid = validateFields();
        if (!fieldsAreValid) {
            return;
        }

        disableComponent();
        requestExecutor
                .makeRequest(() -> submitAction.submit(inputEntity))
                .setOnSuccessAction(outputEntity -> {
                    Platform.runLater(() -> {
                        Node sourceNode = (Node) event.getSource();
                        Stage stage = (Stage) sourceNode.getScene().getWindow();
                        stage.close();
                    });
                    if (onSuccessAction != null) {
                        onSuccessAction.run();
                    }
                })
                .setOnFailureAction(errorMessage -> {
                    if (onErrorAction != null) {
                        onErrorAction.run(errorMessage);
                    }
                })
                .setFinalAction(this::enableComponent)
                .submit();
    }

    public void enableComponent() {
        contentBox.setDisable(false);
    }

    public void disableComponent() {
        contentBox.setDisable(true);
    }

}
