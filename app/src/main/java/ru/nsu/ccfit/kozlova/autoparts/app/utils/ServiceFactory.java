package ru.nsu.ccfit.kozlova.autoparts.app.utils;

import lombok.experimental.UtilityClass;
import ru.nsu.ccfit.kozlova.autoparts.app.AppProperties;
import ru.nsu.ccfit.kozlova.autoparts.app.services.deliveries.DeliveryService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.details.DetailService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.details.storage.StorageCellService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.details.types.DetailTypeService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.queries.QueryService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.sales.SaleService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.sales.customers.CustomerService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.sales.orders.OrderService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.SupplierService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.dealers.DealerService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.firms.FirmService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.guarantees.GuaranteeService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.shops.ShopService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.smallproductions.SmallProductionService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.smallsuppliers.SmallSupplierService;

@UtilityClass
public class ServiceFactory {

	public SupplierService getSupplierService() {
		return new SupplierService(AppProperties.getServerHostname());
	}

	public SmallSupplierService getSmallSupplierService() {
		return new SmallSupplierService(AppProperties.getServerHostname());
	}

	public SmallProductionService getSmallProductionService() {
		return new SmallProductionService(AppProperties.getServerHostname());
	}

	public ShopService getShopService() {
		return new ShopService(AppProperties.getServerHostname());
	}

	public GuaranteeService getGuaranteeService() {
		return new GuaranteeService(AppProperties.getServerHostname());
	}

	public FirmService getFirmService() {
		return new FirmService(AppProperties.getServerHostname());
	}

	public DealerService getDealerService() {
		return new DealerService(AppProperties.getServerHostname());
	}

	public SaleService getSaleService() {
		return new SaleService(AppProperties.getServerHostname());
	}

	public OrderService getOrderService() {
		return new OrderService(AppProperties.getServerHostname());
	}

	public CustomerService getCustomerService() {
		return new CustomerService(AppProperties.getServerHostname());
	}

	public QueryService getQueryService() {
		return new QueryService(AppProperties.getServerHostname());
	}

	public DetailService getDetailService() {
		return new DetailService(AppProperties.getServerHostname());
	}

	public DetailTypeService getDetailTypeService() {
		return new DetailTypeService(AppProperties.getServerHostname());
	}

	public StorageCellService getStorageCellService() {
		return new StorageCellService(AppProperties.getServerHostname());
	}

	public DeliveryService getDeliveryService() {
		return new DeliveryService(AppProperties.getServerHostname());
	}

}
