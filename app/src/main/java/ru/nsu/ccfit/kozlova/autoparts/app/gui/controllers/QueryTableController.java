package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers;


import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.AlertDialogFactory;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ContextMenuAction;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ContextWindowBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.SuccessAction;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.EntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryListResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.eight.EightQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.eight.EightQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.eleven.one.ElevenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.eleven.one.ElevenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.eleven.two.ElevenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.eleven.two.ElevenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.fifteen.one.FifteenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.fifteen.one.FifteenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.fifteen.two.FifteenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.fifteen.two.FifteenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.five.one.FiveOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.five.one.FiveOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.five.two.FiveTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.five.two.FiveTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.four.one.FourOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.four.one.FourOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.four.three.FourThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.four.three.FourThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.four.two.FourTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.four.two.FourTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.fourteen.FourteenQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.fourteen.FourteenQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.one.NineOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.one.NineOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.three.NineThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.three.NineThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.two.NineTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.two.NineTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.one.OneOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.one.OneOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.three.OneThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.three.OneThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.two.OneTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.two.OneTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.four.SevenFourQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.four.SevenFourQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.one.SevenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.one.SevenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.three.SevenThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.three.SevenThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.two.SevenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.two.SevenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.six.SixQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.six.SixQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.sixteen.one.SixteenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.sixteen.one.SixteenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.sixteen.three.SixteenThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.sixteen.three.SixteenThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.sixteen.two.SixteenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.sixteen.two.SixteenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.ten.one.TenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.ten.one.TenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.ten.two.TenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.ten.two.TenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.thirteen.ThirteenQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.thirteen.ThirteenQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.one.ThreeOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.one.ThreeOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.three.ThreeThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.three.ThreeThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.two.ThreeTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.two.ThreeTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.twelve.one.TwelveOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.twelve.one.TwelveOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.twelve.two.TwelveTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.twelve.two.TwelveTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.two.TwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.two.TwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageInfo;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageSort;
import ru.nsu.ccfit.kozlova.autoparts.app.services.queries.QueryService;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class QueryTableController {

    private RequestExecutor requestExecutor;
    private Consumer<String> statusBarMessageAcceptor;

    public void setRequestExecutor(RequestExecutor requestExecutor) {
        this.requestExecutor = requestExecutor;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    static class ListViewItem {
        String queryDescription;
        Runnable onSelectAction;

        @Override
        public String toString() {
            return queryDescription;
        }
    }

    @FXML
    private VBox rootVBox;

    @FXML
    private ListView<ListViewItem> queryListView;

    @FXML
    private VBox queryListVBox;

    @FXML
    private VBox queryParamsVBox;

    @FXML
    private VBox queryParamsFieldsVBox;

    @FXML
    private VBox queryTableVBox;

    @FXML
    private HBox queryListBox;

    @FXML
    private Label totalSizeLabel;

    @FXML
    private Button queryListBoxButton;

    private final Label emptyTablePlaceholder = new Label();

    private final Label promptTablePlaceholder = new Label(
            "Для отображения данных, нажмите \"Выполнить запрос\""
    );

    private volatile Supplier<ServiceResponse<? extends List<? extends QueryResult>>> queryResultListSupplier;

    private volatile TableView<? extends QueryResult> queryTable;

    private final QueryService queryService = ServiceFactory.getQueryService();

    private InputFormBuilder inputFormBuilder;

    public void init(
            RequestExecutor requestExecutor,
            Consumer<String> statusBarMessageAcceptor
    ) {
        this.requestExecutor = requestExecutor;
        this.statusBarMessageAcceptor = statusBarMessageAcceptor;
        inputFormBuilder = new InputFormBuilder(queryParamsFieldsVBox);
        setupQueryListBox();
        populateQueryListView();
    }

    private void setupQueryListBox() {
        queryListBox.managedProperty().bind(queryListBox.visibleProperty());
        queryListBox.setVisible(true);
        queryListBox.setStyle(
                "-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: #3c3f4b;"
        );

        queryListBoxButton.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if (isFocused) {
                rootVBox.requestFocus();
            }
        });
    }

    private <T extends QueryResult> void createQueryResultTable(
            Map<String, String> entityPropertyNames
    ) {
        TableView<T> entityTable = new TableView<>();
        entityTable.setStyle("-fx-alignment: CENTER;");
        entityTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        entityTable.placeholderProperty().setValue(promptTablePlaceholder);
        ObservableList<T> entityObservableList = FXCollections.observableArrayList();

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

        Platform.runLater(() -> {
            queryTableVBox.getChildren().clear();
            queryTableVBox.getChildren().add(entityTable);

            queryTable = entityTable;
        });
    }

    private void addListViewItem(
            ObservableList<ListViewItem> listViewItems,
            String queryDescription,
            Runnable onSelectAction
    ) {
        listViewItems.add(new ListViewItem(queryDescription, onSelectAction));
    }

    private void populateQueryListView() {
        Platform.runLater(() -> {
            ObservableList<ListViewItem> items = FXCollections.observableArrayList();

            addListViewItem(
                items, "1.1 Показать перечень фирм, которые поставляют указанный тип детали",
                () -> {
                    var queryParams = new OneOneQueryParams();
                    createQueryResultTable(OneOneQueryResult.getPropertyNames());

                    inputFormBuilder.addIntegerField(
                            "№ типа детали",
                            toInteger(queryParams.getDetailTypeId()),
                            id -> queryParams.setDetailTypeId(toLong(id))
                    );

                    queryResultListSupplier = () -> queryService
                            .oneOne(queryParams)
                            .map(QueryListResult::getElements);
                }
            );

            addListViewItem(
                    items, "1.2 Показать общее число поставщиков, которые поставляют указанный тип детали",
                    () -> {
                        var queryParams = new OneTwoQueryParams();
                        createQueryResultTable(OneTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ типа детали",
                                toInteger(queryParams.getDetailTypeId()),
                                id -> queryParams.setDetailTypeId(toLong(id))
                        );

                        queryResultListSupplier = () -> queryService
                                .oneTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "1.3 Показать фирмы, поставившие указанный тип деталей, в количестве не менее заданного",
                    () -> {
                        var queryParams = new OneThreeQueryParams();
                        createQueryResultTable(OneThreeQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ типа детали",
                                toInteger(queryParams.getDetailTypeId()),
                                id -> queryParams.setDetailTypeId(toLong(id))
                        );

                        inputFormBuilder.addDateField(
                                "Мин. дата доставки",
                                queryParams.getMinDeliveryDate(),
                                queryParams::setMinDeliveryDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата доставки",
                                queryParams.getMaxDeliveryDate(),
                                queryParams::setMaxDeliveryDate
                        );

                        inputFormBuilder.addIntegerField(
                                "Количество деталей",
                                queryParams.getDetailsAmount(),
                                queryParams::setDetailsAmount
                        );

                        queryResultListSupplier = () -> queryService
                                    .oneThree(queryParams)
                                    .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "2 Показать сведения об указанном типе детали",
                    () -> {
                        var queryParams = new TwoQueryParams();
                        createQueryResultTable(TwoQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ типа детали",
                                toInteger(queryParams.getDetailTypeId()),
                                id -> queryParams.setDetailTypeId(toLong(id))
                        );

                        queryResultListSupplier = () -> queryService
                                .two(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "3.1 Показать перечень покупателей, которые купили указанный тип детали в заданный период",
                    () -> {
                        var queryParams = new ThreeOneQueryParams();
                        createQueryResultTable(ThreeOneQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ типа детали",
                                toInteger(queryParams.getDetailTypeId()),
                                id -> queryParams.setDetailTypeId(toLong(id))
                        );

                        inputFormBuilder.addDateField(
                                "Мин. дата покупки",
                                queryParams.getMinSaleDate(),
                                queryParams::setMinSaleDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата покупки",
                                queryParams.getMaxSaleDate(),
                                queryParams::setMaxSaleDate
                        );

                        queryResultListSupplier = () -> queryService
                                .threeOne(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "3.2 Показать число покупателей, которые купили указанный тип детали в заданный период",
                    () -> {
                        var queryParams = new ThreeTwoQueryParams();
                        createQueryResultTable(ThreeTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ типа детали",
                                toInteger(queryParams.getDetailTypeId()),
                                id -> queryParams.setDetailTypeId(toLong(id))
                        );

                        inputFormBuilder.addDateField(
                                "Мин. дата покупки",
                                queryParams.getMinSaleDate(),
                                queryParams::setMinSaleDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата покупки",
                                queryParams.getMaxSaleDate(),
                                queryParams::setMaxSaleDate
                        );

                        queryResultListSupplier = () -> queryService
                                .threeTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "3.3 Показать перечень покупателей, которые купили указанный тип детали, не менее заданного количества",
                    () -> {
                        var queryParams = new ThreeThreeQueryParams();
                        createQueryResultTable(ThreeThreeQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ типа детали",
                                toInteger(queryParams.getDetailTypeId()),
                                id -> queryParams.setDetailTypeId(toLong(id))
                        );

                        inputFormBuilder.addIntegerField(
                                "Число деталей",
                                queryParams.getDetailsAmount(),
                                queryParams::setDetailsAmount
                        );

                        queryResultListSupplier = () -> queryService
                                .threeThree(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "4.1 Показать перечень ячеек склада",
                    () -> {
                        var queryParams = new FourOneQueryParams();
                        createQueryResultTable(FourOneQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .fourOne(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "4.2 Показать общий объем склада",
                    () -> {
                        var queryParams = new FourTwoQueryParams();
                        createQueryResultTable(FourTwoQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .fourTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "4.3 Показать номер ячейки склада для каждой детали",
                    () -> {
                        var queryParams = new FourThreeQueryParams();
                        createQueryResultTable(FourThreeQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .fourThree(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "5.1 Показать самые продаваемые детали",
                    () -> {
                        var queryParams = new FiveOneQueryParams();
                        createQueryResultTable(FiveOneQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "Число \nотображаемых строк",
                                queryParams.getRowsAmount(),
                                queryParams::setRowsAmount
                        );

                        queryResultListSupplier = () -> queryService
                                .fiveOne(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "5.2 Показать самых дешевых поставщиков по самым продаваемым деталям",
                    () -> {
                        var queryParams = new FiveTwoQueryParams();
                        createQueryResultTable(FiveTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "Число \nотображаемых строк",
                                queryParams.getRowsAmount(),
                                queryParams::setRowsAmount
                        );

                        queryResultListSupplier = () -> queryService
                                .fiveTwo(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "6 Показать среднее число продаж на месяц по любому виду деталей",
                    () -> {
                        var queryParams = new SixQueryParams();
                        createQueryResultTable(SixQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .six(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "7.1 Показать долю проданного товара конкретного поставщика (в процентах)",
                    () -> {
                        var queryParams = new SevenOneQueryParams();
                        createQueryResultTable(SevenOneQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ поставщика",
                                toInteger(queryParams.getSupplierId()),
                                id -> queryParams.setSupplierId(toLong(id))
                        );

                        queryResultListSupplier = () -> queryService
                                .sevenOne(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "7.2 Показать долю проданного товара конкретного поставщика (в деньгах)",
                    () -> {
                        var queryParams = new SevenTwoQueryParams();
                        createQueryResultTable(SevenTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ поставщика",
                                toInteger(queryParams.getSupplierId()),
                                id -> queryParams.setSupplierId(toLong(id))
                        );

                        queryResultListSupplier = () -> queryService
                                .sevenTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "7.3 Показать долю проданного товара конкретного поставщика (в единицах)",
                    () -> {
                        var queryParams = new SevenThreeQueryParams();
                        createQueryResultTable(SevenThreeQueryResult.getPropertyNames());

                        inputFormBuilder.addIntegerField(
                                "№ поставщика",
                                toInteger(queryParams.getSupplierId()),
                                id -> queryParams.setSupplierId(toLong(id))
                        );

                        queryResultListSupplier = () -> queryService
                                .sevenThree(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "7.4 Показать прибыль магазина за указанный период",
                    () -> {
                        var queryParams = new SevenFourQueryParams();
                        createQueryResultTable(SevenFourQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата покупок",
                                queryParams.getMinSaleDate(),
                                queryParams::setMinSaleDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата покупок",
                                queryParams.getMaxSaleDate(),
                                queryParams::setMaxSaleDate
                        );

                        queryResultListSupplier = () -> queryService
                                .sevenFour(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "8 Показать накладные расходы в процентах от всей прибыли",
                    () -> {
                        var queryParams = new EightQueryParams();
                        createQueryResultTable(EightQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .eight(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "9.1 Показать перечень непроданного товара на складе за определенный период",
                    () -> {
                        var queryParams = new NineOneQueryParams();
                        createQueryResultTable(NineOneQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата поставок",
                                queryParams.getMinDeliveryDate(),
                                queryParams::setMinDeliveryDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата поставок",
                                queryParams.getMaxDeliveryDate(),
                                queryParams::setMaxDeliveryDate
                        );

                        queryResultListSupplier = () -> queryService
                                .nineOne(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "9.2 Показать общее количество непроданного товара на складе за определенный период",
                    () -> {
                        var queryParams = new NineTwoQueryParams();
                        createQueryResultTable(NineTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата поставок",
                                queryParams.getMinDeliveryDate(),
                                queryParams::setMinDeliveryDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата поставок",
                                queryParams.getMaxDeliveryDate(),
                                queryParams::setMaxDeliveryDate
                        );

                        queryResultListSupplier = () -> queryService
                                .nineTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "9.3 Показать объем непроданого товара на складе за определенный период от общего товара (в процентах)",
                    () -> {
                        var queryParams = new NineThreeQueryParams();
                        createQueryResultTable(NineThreeQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата поставок",
                                queryParams.getMinDeliveryDate(),
                                queryParams::setMinDeliveryDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата поставок",
                                queryParams.getMaxDeliveryDate(),
                                queryParams::setMaxDeliveryDate
                        );

                        queryResultListSupplier = () -> queryService
                                .nineThree(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "10.1 Показать перечень бракованного товара, пришедшего за указанный период",
                    () -> {
                        var queryParams = new TenOneQueryParams();
                        createQueryResultTable(TenOneQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата поставок",
                                queryParams.getMinDeliveryDate(),
                                queryParams::setMinDeliveryDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата поставок",
                                queryParams.getMaxDeliveryDate(),
                                queryParams::setMaxDeliveryDate
                        );

                        queryResultListSupplier = () -> queryService
                                .tenOne(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "10.2 Показать общее количество бракованного товара, пришедшего за указанный период",
                    () -> {
                        var queryParams = new TenTwoQueryParams();
                        createQueryResultTable(TenTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата поставок",
                                queryParams.getMinDeliveryDate(),
                                queryParams::setMinDeliveryDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата поставок",
                                queryParams.getMaxDeliveryDate(),
                                queryParams::setMaxDeliveryDate
                        );

                        queryResultListSupplier = () -> queryService
                                .tenTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "11.1 Показать перечень, общее количество и стоимость товара за конкретный день",
                    () -> {
                        var queryParams = new ElevenOneQueryParams();
                        createQueryResultTable(ElevenOneQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Дата",
                                queryParams.getDate(),
                                queryParams::setDate
                        );

                        queryResultListSupplier = () -> queryService
                                .elevenOne(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "11.2 Показать количество товара, проданного за конкретный день",
                    () -> {
                        var queryParams = new ElevenTwoQueryParams();
                        createQueryResultTable(ElevenTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Дата",
                                queryParams.getDate(),
                                queryParams::setDate
                        );

                        queryResultListSupplier = () -> queryService
                                .elevenTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "12.1 Показать оборот магазина за определенный период",
                    () -> {
                        var queryParams = new TwelveOneQueryParams();
                        createQueryResultTable(TwelveOneQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата покупок",
                                queryParams.getMinSaleDate(),
                                queryParams::setMinSaleDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата покупок",
                                queryParams.getMaxSaleDate(),
                                queryParams::setMaxSaleDate
                        );

                        queryResultListSupplier = () -> queryService
                                .twelveOne(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "12.2 Показать сумму денег, которую вернули покупателем за брак за определенный период",
                    () -> {
                        var queryParams = new TwelveTwoQueryParams();
                        createQueryResultTable(TwelveTwoQueryResult.getPropertyNames());

                        inputFormBuilder.addDateField(
                                "Мин. дата возврата",
                                queryParams.getMinCustomerRefDate(),
                                queryParams::setMinCustomerRefDate
                        );

                        inputFormBuilder.addDateField(
                                "Макс. дата возврата",
                                queryParams.getMaxCustomerRefDate(),
                                queryParams::setMaxCustomerRefDate
                        );

                        queryResultListSupplier = () -> queryService
                                .twelveTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "13 Показать инвентаризационную ведомость: тип детали, название, число деталей типа на складе, цена в магазине",
                    () -> {
                        var queryParams = new ThirteenQueryParams();
                        createQueryResultTable(ThirteenQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .thirteen(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "14 Показать скорость обращения денег, вложенных в товар",
                    () -> {
                        var queryParams = new FourteenQueryParams();
                        createQueryResultTable(FourteenQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .fourteen(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "15.1 Показать количество пустых ячеек на складе",
                    () -> {
                        var queryParams = new FifteenOneQueryParams();
                        createQueryResultTable(FifteenOneQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .fifteenOne(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "15.2 Показать количество свободных мест на складе",
                    () -> {
                        var queryParams = new FifteenTwoQueryParams();
                        createQueryResultTable(FifteenTwoQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .fifteenTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "16.1 Показать перечень заявок на ожидаемый товар",
                    () -> {
                        var queryParams = new SixteenOneQueryParams();
                        createQueryResultTable(SixteenOneQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .sixteenOne(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            addListViewItem(
                    items, "16.2 Показать общее количество заявок на ожидаемый товар",
                    () -> {
                        var queryParams = new SixteenTwoQueryParams();
                        createQueryResultTable(SixteenTwoQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .sixteenTwo(queryParams)
                                .map(List::of);
                    }
            );

            addListViewItem(
                    items, "16.3 Показать, на какую сумму даны заявки на ожидаемый товар",
                    () -> {
                        var queryParams = new SixteenThreeQueryParams();
                        createQueryResultTable(SixteenThreeQueryResult.getPropertyNames());

                        queryResultListSupplier = () -> queryService
                                .sixteenThree(queryParams)
                                .map(QueryListResult::getElements);
                    }
            );

            queryListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                Platform.runLater(() -> {
                    disableComponent();
                    inputFormBuilder.clearForm();
                    newValue.onSelectAction.run();
                    enableComponent();
                });
            });

            queryListView.setItems(items);
            queryListView.getSelectionModel().select(0);
            queryListView.getFocusModel().focus(0);
            queryListView.scrollTo(0);

            queryListView.setMinHeight(225);
            queryListView.setPrefHeight(225);
        });
    }

    @FXML
    public void queryListBoxButtonAction() {
        queryListBox.setVisible(!queryListBox.isVisible());
        queryListBoxButton.setText(queryListBox.isVisible() ?
                "Закрыть список запросов" : "Открыть список запросов"
        );
    }

    @FXML
    void clearQueryParams() {
        inputFormBuilder.clearFields();
    }

    @FXML
    public void performQuery() {
        boolean fieldsAreValid = inputFormBuilder.validateFields();
        if (!fieldsAreValid) {
            return;
        }

        disableComponent();
        requestExecutor
                .makeRequest(queryResultListSupplier::get)
                .setOnSuccessAction(resultList -> {
                    resultList.forEach(QueryResult::calculateProperties);
                    Platform.runLater(() -> {
                        totalSizeLabel.setText(String.format(
                                "Число записей: %d", resultList.size()
                        ));

                        ((TableView) queryTable).setItems(FXCollections.observableList(resultList));
                        statusBarMessageAcceptor.accept("Запрос выполнен успешно");
                        queryTable.setPlaceholder(emptyTablePlaceholder);
                    });
                })
                .setOnFailureAction(errorMessage -> Platform.runLater(() -> {
                    AlertDialogFactory.showErrorAlertDialog(
                            "Не удалось выполнить запрос!",
                            errorMessage
                    );
                    queryTable.setPlaceholder(promptTablePlaceholder);
                }))
                .setFinalAction(() -> Platform.runLater(this::enableComponent))
                .submit();
    }

    private void disableComponent() {
        rootVBox.setDisable(true);
    }

    private void enableComponent() {
        rootVBox.setDisable(false);
    }

    private Long toLong(Integer i) {
        return Optional.ofNullable(i).map(Integer::longValue).orElse(null);
    }

    private Integer toInteger(Long l) {
        return Optional.ofNullable(l).map(Long::intValue).orElse(null);
    }

}
