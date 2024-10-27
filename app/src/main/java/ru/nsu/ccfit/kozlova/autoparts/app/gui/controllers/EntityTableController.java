package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.AlertDialogFactory;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ContextMenuAction;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ContextWindowBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.SuccessAction;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.EntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageInfo;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageSort;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EntityTableController<T extends Entity, CR, UR> {

    public interface EntitySource<E extends Entity> {
        ServiceResponse<Page<E>> getEntities(PageInfo pageInfo) throws Exception;
    }

    public interface EntityRemover<E extends Entity> {
        ServiceResponse<Void> deleteEntity(Long id) throws Exception;
    }

    private EntitySource<T> entitySource;
    private EntityRemover<T> entityRemover;
    private RequestExecutor requestExecutor;
    private ContextWindowBuilder<T> infoWindowBuilder;
    private Supplier<CR> createRequestSupplier;
    private EntityInputFormBuilder<T, CR, UR> inputFormBuilder;
    private Consumer<String> statusBarMessageAcceptor;
    private boolean isContextWindow;

    public void setInfoWindowBuilder(ContextWindowBuilder<T> infoWindowBuilder) {
        this.infoWindowBuilder = infoWindowBuilder;
    }

    public void setRequestExecutor(RequestExecutor requestExecutor) {
        this.requestExecutor = requestExecutor;
    }

    public void setEntitySource(EntitySource<T> entitySource) {
        this.entitySource = entitySource;
    }

    public void setEntityRemover(EntityRemover<T> entityRemover) {
        this.entityRemover = entityRemover;
    }

    private void fillContextMenu() {
        contextMenu = new ContextMenu();

        MenuItem infoItem = new MenuItem("Подробнее");
        MenuItem changeItem = new MenuItem("Изменить");
        MenuItem deleteItem = new MenuItem("Удалить");

        infoItem.setOnAction(event -> {
            T entity = entityTable.getSelectionModel().getSelectedItem();
            if (entity != null) {
                openWindow(
                        () -> infoWindowBuilder.buildWindow(entity),
                        String.format("Не удалось открыть информацию о сущности №%d", entity.getId())
                );
            }
        });

        changeItem.setOnAction(event -> {
            T entity = entityTable.getSelectionModel().getSelectedItem();
            if (entity != null) {
                SuccessAction successAction = () -> refreshTableContents("Успешно изменено");
                Supplier<Stage> windowBuilder = () -> {
                    if (isContextWindow) {
                        return inputFormBuilder.buildContextEditFormWindow(entity, successAction);
                    }
                    return inputFormBuilder.buildEditFormWindow(entity, successAction);
                };
                openWindow(
                        windowBuilder,
                        String.format("Не удалось открыть форму изменения сущности №%d", entity.getId())
                );
            }
        });

        deleteItem.setOnAction(event -> {
            T entity = entityTable.getSelectionModel().getSelectedItem();
            if (entity != null) {
                deleteEntity(entity);
            }
        });

        if (infoWindowBuilder != null) {
            contextMenu.getItems().add(infoItem);
        }

        contextMenu.getItems().addAll(changeItem, deleteItem);
        entityTable.setContextMenu(contextMenu);
    }

    public MenuItem addContextMenuWindowAction(String actionName, ContextWindowBuilder<T> windowBuilder) {
        return addContextMenuAction(
                actionName,
                entity -> openWindow(
                        () -> windowBuilder.buildWindow(entity),
                        String.format("Не удалось выполнить действие \"%s\"", actionName)
                ),
                e -> true
        );
    }

    public MenuItem addContextMenuWindowAction(
            String actionName,
            ContextWindowBuilder<T> windowBuilder,
            Predicate<T> visibleWhen
    ) {
        return addContextMenuAction(
                actionName,
                entity -> openWindow(
                        () -> windowBuilder.buildWindow(entity),
                        String.format("Не удалось выполнить действие \"%s\"", actionName)
                ),
                visibleWhen
        );
    }

    public MenuItem addContextMenuAction(
            String actionName,
            ContextMenuAction<T> menuAction,
            Predicate<T> visibleWhen
    ) {
        MenuItem menuItem = new MenuItem(actionName);
        menuItem.setOnAction(event -> {
            T entity = entityTable.getSelectionModel().getSelectedItem();
            if (entity != null) {
                menuAction.run(entity);
            }
        });

        contextMenu.getItems().add(0, menuItem);
        contextMenu.focusedProperty().addListener((observable, oldValue, newValue) -> {
            T entity = entityTable.getSelectionModel().getSelectedItem();
            boolean isActionVisible = visibleWhen.test(entity);
            menuItem.setVisible(isActionVisible);
        });

        return menuItem;
    }

    private ContextMenu contextMenu;

    @FXML
    private VBox rootVBox;

    @FXML
    private Pagination pagination;

    @FXML
    private TableView<T> entityTable;

    @FXML
    private ComboBox<ChoiceItem<String>> sortChoiceBox;

    @FXML
    private VBox filteringVBox;

    @FXML
    private Label pageSizeLabel;

    @FXML
    private Label totalSizeLabel;

    @FXML
    private HBox searchBox;

    @FXML
    private VBox sortingBox;

    @FXML
    private Button searchButton;

    private final ObservableList<T> entityObservableList = FXCollections.observableArrayList();

    private PageInfo pageInfo;
    private PageSort pageSort;
    private final Label emptyTablePlaceholder = new Label();
    private final Label promptTablePlaceholder = new Label(
            "Для отображения данных, нажмите \"Обновить\""
    );

    @FXML
    public void openSearchBox() {
        searchBox.setVisible(!searchBox.isVisible());
        searchButton.setText(searchBox.isVisible() ?
                "Закрыть параметры сортировки" : "Открыть параметры сортировки"
        );
    }

    public void init(
            Map<String, String> entityPropertyNames,
            Map<String, String> entitySortPropertyNames,
            EntityInputFormBuilder<T, CR, UR> entityInputFormBuilder,
            Supplier<CR> createRequestSupplier,
            boolean isContextWindow,
            Consumer<String> statusBarMessageAcceptor
    ) {

        searchBox.managedProperty().bind(searchBox.visibleProperty());
        searchBox.setVisible(false);

        sortingBox.setStyle(
                "-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #3c3f4b;"
        );

        searchButton.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if (isFocused) {
                rootVBox.requestFocus();
            }
        });

        this.inputFormBuilder = entityInputFormBuilder;
        this.createRequestSupplier = createRequestSupplier;
        this.isContextWindow = isContextWindow;
        this.statusBarMessageAcceptor = statusBarMessageAcceptor;

        pageSort = new PageSort();
        pageInfo = new PageInfo(0L, 25L, pageSort);

        pagination.pageCountProperty().setValue(1);
        pagination.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {
            int newPageNumber = (int) newValue;
            pageInfo.setPageNumber((long) newPageNumber);
            refreshTableContents();
        });

        entityTable.placeholderProperty().setValue(emptyTablePlaceholder);

        List<ChoiceItem<String>> sortFieldList = entitySortPropertyNames
                .entrySet()
                .stream()
                .map(e -> new ChoiceItem<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        ChoiceItem<String> defaultSortField = new ChoiceItem<>("id", "№");
        sortFieldList.add(0, defaultSortField);
        sortChoiceBox.setValue(defaultSortField);
        sortChoiceBox.getItems().addAll(sortFieldList);
        pageSort.addField(defaultSortField.getValue());

        sortChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            pageSort.removeAllFields();
            pageSort.addField(newValue.getValue());
            refreshTableContents();
        });

        List<TableColumn<T, String>> columns = entityPropertyNames
                .entrySet()
                .stream()
                .map(e -> {
                    TableColumn<T, String> tableColumn = new TableColumn<>(e.getValue());
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(e.getKey()));
                    tableColumn.setSortable(false);
                    tableColumn.setEditable(false);
                    return tableColumn;
                }).collect(Collectors.toList());
        entityTable.getColumns().addAll(columns);
        entityTable.setItems(entityObservableList);

        fillContextMenu();

        Platform.runLater(this::refreshTableContents);
    }

    @FXML
    private void setAscendingSortOrder() {
        pageSort.setOrder(PageSort.Order.ASC);
        refreshTableContents();
    }

    @FXML
    private void setDescendingSortOrder() {
        pageSort.setOrder(PageSort.Order.DESC);
        refreshTableContents();
    }

    @FXML
    private void openCreateWindow() {
        SuccessAction successAction = () -> refreshTableContents("Успешно изменено");
        Supplier<Stage> windowBuilder = () -> {
            if (isContextWindow) {
                return inputFormBuilder.buildContextCreationFormWindow(
                        createRequestSupplier.get(), successAction
                );
            }
            return inputFormBuilder.buildCreationFormWindow(successAction);
        };
        openWindow(
                windowBuilder,
                "Не удалось открыть форму добавления"
        );
    }

    @FXML
    public void refreshTableContents() {
        refreshTableContents("Данные успешно загружены");
    }

    public void refreshTableContents(String successMessage) {
        disableComponent();
        requestExecutor
                .makeRequest(() -> entitySource.getEntities(pageInfo))
                .setOnSuccessAction(page -> {
                    var entities = page.getElementList();
                    entities.forEach(Entity::calculateProperties);

                    Platform.runLater(() -> {
                        pagination.pageCountProperty().setValue(
                                page.getTotalPages().equals(0L) ? 1 : page.getTotalPages()
                        );

                        pageSizeLabel.setText(String.format(
                                "На странице: %d", page.getNumberOfElements()
                        ));

                        totalSizeLabel.setText(String.format(
                                "Всего: %d", page.getTotalElements()
                        ));

                        entityObservableList.clear();
                        entityObservableList.addAll(entities);
                        statusBarMessageAcceptor.accept(successMessage);
                        entityTable.setPlaceholder(emptyTablePlaceholder);
                    });
                })
                .setOnFailureAction(errorMessage -> Platform.runLater(() -> {
                        AlertDialogFactory.showErrorAlertDialog(
                                "Не удалось загрузить информацию",
                                errorMessage
                        );
                        entityTable.setPlaceholder(promptTablePlaceholder);
                }))
                .setFinalAction(() -> Platform.runLater(this::enableComponent))
                .submit();
    }

    private void openWindow(Supplier<Stage> windowBuilder, String errorDialogHeader) {
        try {
            if (windowBuilder != null) {
                Stage contextWindow = windowBuilder.get();
                contextWindow.show();
            }
        } catch (Exception e) {
            Platform.runLater(() ->
                    AlertDialogFactory.showErrorAlertDialog(
                            errorDialogHeader,
                            e.getLocalizedMessage()
                    )
            );
            e.printStackTrace();
        }
    }

    private void deleteEntity(T entity) {
        disableComponent();
        requestExecutor
                .makeRequest(() -> entityRemover.deleteEntity(entity.getId()))
                .setOnSuccessAction(responseBody -> Platform.runLater(
                        () -> refreshTableContents("Успешно удалено")
                ))
                .setOnFailureAction(errorMessage -> {
                    Platform.runLater(() -> {
                        enableComponent();
                        AlertDialogFactory.showErrorAlertDialog(
                                String.format("Не удалось удалить сущность № %d!", entity.getId()),
                                errorMessage
                        );
                    });
                })
                .submit();
    }

    private void disableComponent() {
        rootVBox.setDisable(true);
    }

    private void enableComponent() {
        rootVBox.setDisable(false);
    }

}
