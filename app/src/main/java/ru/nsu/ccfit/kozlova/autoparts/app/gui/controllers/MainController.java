package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import lombok.SneakyThrows;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ContextWindowBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.EntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.deliveries.DeliveryInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details.DetailInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details.RefundInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details.storage.StorageCellInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details.types.DetailTypeInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.sales.SaleInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.sales.customers.CustomerInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.sales.orders.OrderInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.dealers.DealerInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.firms.FirmInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.guarantees.GuaranteeInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.shops.ShopInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.smallproductions.SmallProductionInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.smallsuppliers.SmallSupplierInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.CustomDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.RefundDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage.StorageCellDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.dealers.DealerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers.SmallSupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

import java.time.Instant;
import java.util.*;
import java.util.function.Supplier;

public class MainController {

    private RequestExecutor requestExecutor;

    @FXML
    private TabPane contentTabPane;

    @FXML
    private Label statusBarLabel;

    @FXML
    private Tab defaultTab;

    @SneakyThrows
    public void init(
            RequestExecutor requestExecutor
    ) {
        this.requestExecutor = requestExecutor;
        contentTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
    }

    private void setStatusBarMessage(String message) {
        Platform.runLater(() -> {
            String messageTime = LocalDateFormatter.getFormattedDateTime(Instant.now().toEpochMilli());
            String messageWithTime = String.format("%s: %s", messageTime, message);
            statusBarLabel.textProperty().setValue(messageWithTime);
        });
    }

    @SneakyThrows
    private <T extends Entity, CR, UR> EntityTableController<T, CR, UR> createEntityTable(
            String tableName,
            Map<String, String> entityPropertyNames,
            Map<String, String> entitySortPropertyNames,
            CrudService<T, CR, UR> entityService,
            EntityInputFormBuilder<T, CR, UR> inputFormBuilder,
            ContextWindowBuilder<T> infoWindowBuilder
    ) {
        FXMLLoader tableLoader = FxmlLoaderFactory.createEntityTableLoader();
        Node table = tableLoader.load();

        Tab tableTab = new Tab(tableName);
        tableTab.setContent(table);
        tableTab.setOnClosed(event -> {
            if (contentTabPane.getTabs().isEmpty()) {
                contentTabPane.getTabs().add(defaultTab);
            }
        });

        contentTabPane.getTabs().remove(defaultTab);
        contentTabPane.getTabs().add(tableTab);
        contentTabPane.getSelectionModel().select(tableTab);

        EntityTableController<T, CR, UR> controller = tableLoader.getController();
        controller.setInfoWindowBuilder(infoWindowBuilder);

        controller.setEntityRemover(entityService::delete);
        controller.setEntitySource(entityService::getAll);

        controller.setRequestExecutor(requestExecutor);

        controller.init(
                entityPropertyNames,
                entitySortPropertyNames,
                inputFormBuilder,
                null,
                false,
                this::setStatusBarMessage
        );

        return controller;
    }

    @SneakyThrows
    private <T extends Entity, CR, UR> Node createInfoWindowEntityTable(
            Map<String, String> entityPropertyNames,
            Map<String, String> entitySortPropertyNames,
            EntityTableController.EntitySource<T> entitySource,
            EntityTableController.EntityRemover<T> entityRemover,
            EntityInputFormBuilder<T, CR, UR> inputFormBuilder,
            Supplier<CR> createRequestSupplier
    ) {

        FXMLLoader tableLoader = FxmlLoaderFactory.createEntityTableLoader();
        Node table = tableLoader.load();

        EntityTableController<T, CR, UR> entityTableController = tableLoader.getController();
        entityTableController.setEntitySource(entitySource);
        entityTableController.setEntityRemover(entityRemover);
        entityTableController.setRequestExecutor(requestExecutor);
        entityTableController.init(
                entityPropertyNames,
                entitySortPropertyNames,
                inputFormBuilder,
                createRequestSupplier,
                true,
                this::setStatusBarMessage
        );

        return table;
    }

    @SneakyThrows
    private void createQueryTable() {
        FXMLLoader tableLoader = FxmlLoaderFactory.createQueryTableLoader();
        Node rootNode = tableLoader.load();
        QueryTableController queryTableController = tableLoader.getController();
        queryTableController.init(requestExecutor, this::setStatusBarMessage);

        Tab tableTab = new Tab("Запросы");
        tableTab.setContent(rootNode);
        tableTab.setOnClosed(event -> {
            if (contentTabPane.getTabs().isEmpty()) {
                contentTabPane.getTabs().add(defaultTab);
            }
        });

        contentTabPane.getTabs().remove(defaultTab);
        contentTabPane.getTabs().add(tableTab);
        contentTabPane.getSelectionModel().select(tableTab);
    }

    @FXML
    void openQueries(ActionEvent event) {
        createQueryTable();
    }

    @FXML
    void openCustomers(ActionEvent event) {
        createEntityTable(
            "Клиенты",
                CustomerDto.getPropertyNames(),
                CustomerDto.getSortPropertyNames(),
                ServiceFactory.getCustomerService(),
                new CustomerInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openGuarantees(ActionEvent event) {
        createEntityTable(
                "Гарантии",
                GuaranteeDto.getPropertyNames(),
                GuaranteeDto.getSortPropertyNames(),
                ServiceFactory.getGuaranteeService(),
                new GuaranteeInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openDealers(ActionEvent event) {
        createEntityTable(
                "Дилеры",
                DealerDto.getPropertyNames(),
                DealerDto.getSortPropertyNames(),
                ServiceFactory.getDealerService(),
                new DealerInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openDeliveries(ActionEvent event) {
        createEntityTable(
                "Поставки",
                DeliveryDto.getPropertyNames(),
                DeliveryDto.getSortPropertyNames(),
                ServiceFactory.getDeliveryService(),
                new DeliveryInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openDetailTypes(ActionEvent event) {
        createEntityTable(
                "Типы деталей",
                DetailTypeDto.getPropertyNames(),
                DetailTypeDto.getSortPropertyNames(),
                ServiceFactory.getDetailTypeService(),
                new DetailTypeInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openDetails(ActionEvent event) {

        ContextWindowBuilder<DetailDto> refundInfoWindowBuilder = detail -> {
            FXMLLoader refundInfoWindowLoader = FxmlLoaderFactory.createEntityInfoLoader();
            Parent entityInfoRoot = null;
            try {
                entityInfoRoot = refundInfoWindowLoader.load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            EntityInfoController controller = refundInfoWindowLoader.getController();

            var refund = detail.getRefund();
            controller.addInfoLine(
                    "Дата возврата покупателем: " + LocalDateFormatter.getFormattedDate(refund.getCustomerRefundDate())
            );
            controller.addInfoLine(
                    "Дата возврата поставщику: " + Optional.ofNullable(refund.getSupplierRefundDate())
                                                        .map(LocalDateFormatter::getFormattedDate).orElse("-")
            );

            return EntityInfoWindowBuilder
                    .newInfoWindow("Деталь №" + refund.getId())
                    .addTab(entityInfoRoot, "Информация о возврате")
                    .build();
        };

        RefundInputFormBuilder refundInputFormBuilder = new RefundInputFormBuilder(requestExecutor);

        var controller = createEntityTable(
                "Детали",
                DetailDto.getPropertyNames(),
                DetailDto.getSortPropertyNames(),
                ServiceFactory.getDetailService(),
                new DetailInputFormBuilder(requestExecutor),
                null
        );

        controller.addContextMenuWindowAction(
                "Информация о возврате",
                refundInfoWindowBuilder,
                d -> d.getRefund() != null
        );

        controller.addContextMenuAction(
                "Возврат",
                d -> refundInputFormBuilder.buildEditFormWindow(
                        RefundDto.builder().id(d.getId()).build(),
                        controller::refreshTableContents
                ).show(),
                d -> d.getRefund() == null
        );

        controller.addContextMenuAction(
                "Изменить данные о возврате",
                d -> refundInputFormBuilder.buildContextEditFormWindow(
                        d.getRefund(), controller::refreshTableContents
                ).show(),
                d -> d.getRefund() != null
        );
    }

    @FXML
    void openFirms(ActionEvent event) {
        createEntityTable(
                "Фирмы",
                FirmDto.getPropertyNames(),
                FirmDto.getSortPropertyNames(),
                ServiceFactory.getFirmService(),
                new FirmInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openOrders(ActionEvent event) {
        createEntityTable(
                "Заказы",
                OrderDto.getPropertyNames(),
                OrderDto.getSortPropertyNames(),
                ServiceFactory.getOrderService(),
                new OrderInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openSmallProductions(ActionEvent event) {
        createEntityTable(
                "Малые производства",
                SmallProductionDto.getPropertyNames(),
                SmallProductionDto.getSortPropertyNames(),
                ServiceFactory.getSmallProductionService(),
                new SmallProductionInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openSmallSuppliers(ActionEvent event) {
        createEntityTable(
                "Мелкие поставщики",
                SmallSupplierDto.getPropertyNames(),
                SmallSupplierDto.getSortPropertyNames(),
                ServiceFactory.getSmallSupplierService(),
                new SmallSupplierInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openShops(ActionEvent event) {
        createEntityTable(
                "Магазины",
                ShopDto.getPropertyNames(),
                ShopDto.getSortPropertyNames(),
                ServiceFactory.getShopService(),
                new ShopInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openStorageCells(ActionEvent event) {
        createEntityTable(
                "Ячейки склада",
                StorageCellDto.getPropertyNames(),
                StorageCellDto.getSortPropertyNames(),
                ServiceFactory.getStorageCellService(),
                new StorageCellInputFormBuilder(requestExecutor),
                null
        );
    }

    @FXML
    void openSales(ActionEvent event) {
        createEntityTable(
                "Покупки",
                SaleDto.getPropertyNames(),
                SaleDto.getSortPropertyNames(),
                ServiceFactory.getSaleService(),
                new SaleInputFormBuilder(requestExecutor),
                null
        );
    }

}
