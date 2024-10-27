package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input;

import javafx.scene.Parent;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.AlertDialogFactory;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.FxmlLoaderFactory;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ChoiceItemSupplier;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.SuccessAction;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.StageFactory;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageInfo;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class AbstractEntityInputFormBuilder<E extends Entity, CR, UR>
                implements EntityInputFormBuilder<E, CR, UR> {

    private String entityName;

    private final RequestExecutor requestExecutor;

    private final Supplier<CR> emptyCreateRequestSupplier;
    private final Function<E, UR> entityToUpdateRequestMapper;

    private final Function<CR, ServiceResponse<E>> createAction;
    private final BiFunction<Long, UR, ServiceResponse<E>> updateAction;

    protected AbstractEntityInputFormBuilder(
            String entityName,
            CrudService<E, CR, UR> crudService,
            RequestExecutor requestExecutor,
            Supplier<CR> emptyCreateRequestSupplier,
            Function<E, UR> entityToUpdateRequestMapper
    ) {
        this(
                entityName,
                requestExecutor,
                emptyCreateRequestSupplier,
                entityToUpdateRequestMapper,
                crudService::create,
                crudService::update
        );
    }

    protected AbstractEntityInputFormBuilder(
            String entityName,
            RequestExecutor requestExecutor,
            Supplier<CR> emptyCreateRequestSupplier,
            Function<E, UR> entityToUpdateRequestMapper,
            Function<CR, ServiceResponse<E>> createAction,
            BiFunction<Long, UR, ServiceResponse<E>> updateAction
    ) {
        this.entityName = entityName;
        this.requestExecutor = requestExecutor;
        this.emptyCreateRequestSupplier = emptyCreateRequestSupplier;
        this.entityToUpdateRequestMapper = entityToUpdateRequestMapper;
        this.createAction = createAction;
        this.updateAction = updateAction;
    }

    @Override
    public Stage buildCreationFormWindow(SuccessAction onSuccessAction) {
        var createRequest = emptyCreateRequestSupplier.get();
        return buildCreateInputFormWindow(createRequest, onSuccessAction, false);
    }

    @Override
    public Stage buildContextCreationFormWindow(CR createRequest, SuccessAction onSuccessAction) {
        return buildCreateInputFormWindow(createRequest, onSuccessAction, true);
    }

    @Override
    public Stage buildEditFormWindow(E entity, SuccessAction onSuccessAction) {
        var updateRequest = entityToUpdateRequestMapper.apply(entity);
        return buildEditInputFormWindow(entity, updateRequest, onSuccessAction, false);
    }

    @Override
    public Stage buildContextEditFormWindow(E entity, SuccessAction onSuccessAction) {
        var updateRequest = entityToUpdateRequestMapper.apply(entity);
        return buildEditInputFormWindow(entity, updateRequest, onSuccessAction, true);
    }

    @SneakyThrows
    private Stage buildCreateInputFormWindow(
            CR createRequest,
            SuccessAction onSuccessAction,
            boolean isContextWindow
    ) {
        var fxmlLoader = FxmlLoaderFactory.createEntityInputFormLoader();
        Parent rootNode = fxmlLoader.load();
        EntityInputFormController<CR, E> controller = fxmlLoader.getController();

        controller.init(
                createRequest,
                createAction::apply,
                onSuccessAction,
                errorMessage -> AlertDialogFactory.showErrorAlertDialog(
                        "Произошла ошибка при добавлении новой сущности!",
                        errorMessage
                ),
                requestExecutor
        );

        fillCreateInputForm(createRequest, controller, isContextWindow);
        String windowTitle = getCreationFormWindowTitle();

        return StageFactory.createStage(rootNode, windowTitle);
    }

    @SneakyThrows
    private Stage buildEditInputFormWindow(
            E entity,
            UR updateRequest,
            SuccessAction onSuccessAction,
            boolean isContextWindow
    ) {
        var fxmlLoader = FxmlLoaderFactory.createEntityInputFormLoader();
        Parent rootNode = fxmlLoader.load();
        EntityInputFormController<UR, E> controller = fxmlLoader.getController();

        controller.init(
                updateRequest,
                ur -> updateAction.apply(entity.getId(), ur),
                onSuccessAction,
                errorMessage -> AlertDialogFactory.showErrorAlertDialog(
                        String.format("Произошла ошибка при изменении сущности %d!", entity.getId()),
                        errorMessage
                ),
                requestExecutor
        );

        fillEditInputForm(updateRequest, controller, isContextWindow);
        String windowTitle = getEditFormWindowTitle(entity);

        return StageFactory.createStage(rootNode, windowTitle);
    }

    protected <X extends Entity, Y> ChoiceItemSupplier<Y> makeChoiceItemSupplierFromEntities(
        CrudService<X, ?, ?> entityService,
        Function<X, ChoiceItem<Y>> entityToChoiceItemMapper,
        String errorMessage
    ) {

        return makeChoiceItemSupplierFromEntities(
                entityService::getAll,
                x -> true,
                entityToChoiceItemMapper,
                errorMessage
        );
    }

    protected <X extends Entity, Y> ChoiceItemSupplier<Y> makeChoiceItemSupplierFromEntities(
            CrudService<X, ?, ?> entityService,
            Predicate<X> entityFilterPredicate,
            Function<X, ChoiceItem<Y>> entityToChoiceItemMapper,
            String errorMessage
    ) {

        return makeChoiceItemSupplierFromEntities(
                entityService::getAll,
                entityFilterPredicate,
                entityToChoiceItemMapper,
                errorMessage
        );
    }

    protected <X extends Entity, Y> ChoiceItemSupplier<Y> makeChoiceItemSupplierFromEntities(
            Function<PageInfo, ServiceResponse<Page<X>>> entitySupplier,
            Function<X, ChoiceItem<Y>> entityToChoiceItemMapper,
            String errorMessage
    ) {
        return makeChoiceItemSupplierFromEntities(
                entitySupplier,
                x -> true,
                entityToChoiceItemMapper,
                errorMessage
        );
    }

    protected <X extends Entity, Y> ChoiceItemSupplier<Y> makeChoiceItemSupplierFromEntities(
        Function<PageInfo, ServiceResponse<Page<X>>> entitySupplier,
        Predicate<X> entityFilterPredicate,
        Function<X, ChoiceItem<Y>> entityToChoiceItemMapper,
        String errorMessage
    ) {
        return () -> {

            try {
                Page<X> page = entitySupplier.apply(PageInfo.getUnlimitedPageInfo()).getBody();
                Objects.requireNonNull(page, errorMessage);

                return page.getElementList().stream()
                        .filter(entityFilterPredicate)
                        .map(entityToChoiceItemMapper)
                        .collect(Collectors.toList());
            } catch (Exception e) {
                throw new RuntimeException(errorMessage, e);
            }

        };
    }

    protected Long toLong(Integer i) {
        return Optional.ofNullable(i).map(Integer::longValue).orElse(null);
    }

    protected Integer toInteger(Long l) {
        return Optional.ofNullable(l).map(Long::intValue).orElse(null);
    }

    private String getCreationFormWindowTitle() {
        return String.format("%s - создание", entityName);
    }

    private String getEditFormWindowTitle(E entity) {
        return String.format("%s №%d - редактирование", entityName, entity.getId());
    }

    public abstract void fillCreateInputForm(
            CR createRequest,
            EntityInputFormController<CR, E> controller,
            boolean isContextWindow
    );

    public abstract void fillEditInputForm(
            UR updateRequest,
            EntityInputFormController<UR, E> controller,
            boolean isContextWindow
    );

}
