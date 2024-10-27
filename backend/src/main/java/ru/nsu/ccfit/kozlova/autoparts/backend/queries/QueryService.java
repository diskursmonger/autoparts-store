package ru.nsu.ccfit.kozlova.autoparts.backend.queries;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.QueryListResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.eight.EightQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.eight.EightQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.eleven.one.ElevenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.eleven.one.ElevenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.eleven.two.ElevenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.eleven.two.ElevenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.fifteen.one.FifteenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.fifteen.one.FifteenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.fifteen.two.FifteenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.fifteen.two.FifteenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.five.one.FiveOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.five.one.FiveOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.five.two.FiveTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.five.two.FiveTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.four.one.FourOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.four.one.FourOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.four.three.FourThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.four.three.FourThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.four.two.FourTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.four.two.FourTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.fourteen.FourteenQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.fourteen.FourteenQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.one.NineOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.one.NineOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.three.NineThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.three.NineThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.two.NineTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.two.NineTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.one.OneOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.one.OneOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.three.OneThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.three.OneThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.two.OneTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.two.OneTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.four.SevenFourQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.four.SevenFourQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.one.SevenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.one.SevenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.three.SevenThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.three.SevenThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.two.SevenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.two.SevenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.six.SixQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.six.SixQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.sixteen.one.SixteenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.sixteen.one.SixteenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.sixteen.three.SixteenThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.sixteen.three.SixteenThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.sixteen.two.SixteenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.sixteen.two.SixteenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.ten.one.TenOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.ten.one.TenOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.ten.two.TenTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.ten.two.TenTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.thirteen.ThirteenQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.thirteen.ThirteenQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.one.ThreeOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.one.ThreeOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.three.ThreeThreeQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.three.ThreeThreeQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.two.ThreeTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.two.ThreeTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.twelve.one.TwelveOneQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.twelve.one.TwelveOneQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.twelve.two.TwelveTwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.twelve.two.TwelveTwoQueryResult;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.two.TwoQueryParams;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.two.TwoQueryResult;

@Service
public class QueryService {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	public QueryService(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public QueryListResult<OneOneQueryResult> oneOne(OneOneQueryParams queryParams) {
		var sql = "select deliveries.supplier_id\n" +
				"from firms\n" +
				"         inner join suppliers on firms.id = suppliers.id\n" +
				"         inner join deliveries on suppliers.id = deliveries.supplier_id\n" +
				"         inner join details on deliveries.id = details.delivery_id\n" +
				"where deliveries.delivery_date is not null\n" +
				"  and details.detail_type_id = :detailTypeId\n" +
				"group by deliveries.supplier_id";
		return executeQuery(sql, queryParams, OneOneQueryResult.class);
	}

	public OneTwoQueryResult oneTwo(OneTwoQueryParams queryParams) {
		var sql = "select COUNT(supplier_id) as suppliers_amount\n" +
				"from (\n" +
				"         select deliveries.supplier_id\n" +
				"         from firms\n" +
				"                  inner join suppliers on firms.id = suppliers.id\n" +
				"                  inner join deliveries on suppliers.id = deliveries.supplier_id\n" +
				"                  inner join details on deliveries.id = details.delivery_id\n" +
				"         where deliveries.delivery_date is not null\n" +
				"           and details.detail_type_id = :detailTypeId\n" +
				"         group by deliveries.supplier_id\n" +
				"     )";
		return executeSingleObjectQuery(sql, queryParams, OneTwoQueryResult.class);
	}

	public QueryListResult<OneThreeQueryResult> oneThree(OneThreeQueryParams queryParams) {
		var sql = "select suppliers.id as supplier_id, \n" +
				"       details.detail_type_id as detail_type_id, \n" +
				"       deliveries.id as delivery_id, \n" +
				"       COUNT(details.id) as details_amount\n" +
				"from suppliers\n" +
				"         inner join firms on firms.id = suppliers.id\n" +
				"         inner join deliveries on deliveries.supplier_id = suppliers.id\n" +
				"         inner join details on details.delivery_id = deliveries.id\n" +
				"where details.detail_type_id = :detailTypeId\n" +
				"  and deliveries.delivery_date between :minDeliveryDate and :maxDeliveryDate\n" +
				"group by details.detail_type_id, suppliers.id, deliveries.id\n" +
				"having COUNT(details.id) > :detailsAmount";
		return executeQuery(sql, queryParams, OneThreeQueryResult.class);
	}

	public QueryListResult<TwoQueryResult> two(TwoQueryParams queryParams) {
		var sql = "select suppliers.id as supplier_id,\n" +
				"       AVG(deliveries_detail_types.supplier_price) as average_supplier_price,\n" +
				"       AVG(MONTHS_BETWEEN(deliveries.delivery_date, deliveries.formation_date)) as average_delivery\n" +
				"from suppliers\n" +
				"         inner join deliveries on deliveries.supplier_id = suppliers.id\n" +
				"         inner join deliveries_detail_types on deliveries_detail_types.delivery_id = deliveries.id\n" +
				"         inner join details on details.delivery_id = deliveries.id\n" +
				"where details.detail_type_id = :detailTypeId\n" +
				"group by suppliers.id, details.detail_type_id\n" +
				"order by suppliers.id";

		return executeQuery(sql, queryParams, TwoQueryResult.class);
	}

	public QueryListResult<ThreeOneQueryResult> threeOne(ThreeOneQueryParams queryParams) {
		var sql = "select distinct customers.id as customer_id,\n" +
				"                customers.name as customer_name,\n" +
				"                sold_details.sale_id as sale_id,\n" +
				"                details.id as detail_id,\n" +
				"                details.detail_type_id as detail_type_id,\n" +
				"                sales.sale_date as sale_date\n" +
				"from customers\n" +
				"         inner join sales on customers.id = sales.customer_id\n" +
				"         inner join sold_details on sales.id = sold_details.sale_id\n" +
				"         inner join details on sold_details.detail_id = details.id\n" +
				"where (\n" +
				"                  details.detail_type_id = :detailTypeId and\n" +
				"                  sales.sale_date between :minSaleDate and :maxSaleDate\n" +
				"          )\n" +
				"order by customer_id";

		return executeQuery(sql, queryParams, ThreeOneQueryResult.class);
	}

	public ThreeTwoQueryResult threeTwo(ThreeTwoQueryParams queryParams) {
		var sql = "select distinct COUNT(cid) as customers_amount\n" +
				"from (\n" +
				"         select distinct customers.id as cid,\n" +
				"                         customers.name,\n" +
				"                         sold_details.sale_id,\n" +
				"                         details.id,\n" +
				"                         details.detail_type_id,\n" +
				"                         sales.sale_date\n" +
				"         from customers\n" +
				"                  inner join sales on customers.id = sales.customer_id\n" +
				"                  inner join sold_details on sales.id = sold_details.sale_id\n" +
				"                  inner join details on sold_details.detail_id = details.id\n" +
				"         where (\n" +
				"                           details.detail_type_id = :detailTypeId and\n" +
				"                           sales.sale_date between :minSaleDate and :maxSaleDate\n" +
				"                   )\n" +
				"         order by customers.id\n" +
				"     )";
		return executeSingleObjectQuery(sql, queryParams, ThreeTwoQueryResult.class);
	}

	public QueryListResult<ThreeThreeQueryResult> threeThree(ThreeThreeQueryParams queryParams) {
		var sql = "select sales.customer_id as customer_id, COUNT(details.id) bought_det_amount\n" +
				"from sales\n" +
				"         inner join sold_details on sales.id = sold_details.sale_id\n" +
				"         inner join details on sold_details.detail_id = details.id\n" +
				"where detail_type_id = :detailTypeId\n" +
				"group by sales.customer_id\n" +
				"having COUNT(details.id) > :detailsAmount\n" +
				"order by sales.customer_id";
		return executeQuery(sql, queryParams, ThreeThreeQueryResult.class);
	}

	public QueryListResult<FourOneQueryResult> fourOne(FourOneQueryParams queryParams) {
		var sql = "select id as id\n" +
				"from storage_cells";
		return executeQuery(sql, queryParams, FourOneQueryResult.class);
	}

	public FourTwoQueryResult fourTwo(FourTwoQueryParams queryParams) {
		var sql = "select COUNT(*) as storage_capacity\n" +
				"from storage_cells";
		return executeSingleObjectQuery(sql, queryParams, FourTwoQueryResult.class);
	}

	public QueryListResult<FourThreeQueryResult> fourThree(FourThreeQueryParams queryParams) {
		var sql = "select cell_id as cell_id,\n" +
				"       id as id,\n" +
				"       detail_type_id as detail_type_id\n" +
				"from details\n" +
				"where cell_id is not null";
		return executeQuery(sql, queryParams, FourThreeQueryResult.class);
	}

	public QueryListResult<FiveOneQueryResult> fiveOne(FiveOneQueryParams queryParams) {
		var sql = "select detail_type_id,\n" +
				"       COUNT(detail_type_id) as sold_detail_type_amount\n" +
				"from (\n" +
				"         select details.detail_type_id\n" +
				"         from sold_details\n" +
				"                  inner join details on sold_details.detail_id = details.id)\n" +
				"group by detail_type_id\n" +
				"order by sold_detail_type_amount desc, detail_type_id\n" +
				"    fetch next :rowsAmount rows only";
		return  executeQuery(sql, queryParams, FiveOneQueryResult.class);
	}

	public QueryListResult<FiveTwoQueryResult> fiveTwo(FiveTwoQueryParams queryParams) {
		var sql = "select t.sup_id as supp_id,\n" +
				"       t.det_type_id as det_type_id,\n" +
				"       t.avg_price as avg_price,\n" +
				"       t.sold_det_t_amount as sold_det_t_amount\n" +
				"from (\n" +
				"         select suppliers.id    as sup_id,\n" +
				"                top_sold_details.detail_type_id     as det_type_id,\n" +
				"                AVG(deliveries_detail_types.supplier_price)    as avg_price,\n" +
				"                top_sold_details.sold_detail_type_amount   as sold_det_t_amount,\n" +
				"                row_number() over (partition by top_sold_details.detail_type_id order by sold_detail_type_amount) as seq\n" +
				"         from (\n" +
				"                  select detail_type_id,\n" +
				"                         COUNT(detail_type_id) as sold_detail_type_amount\n" +
				"                  from (\n" +
				"                           select details.detail_type_id\n" +
				"                           from sold_details\n" +
				"                                    inner join details on sold_details.detail_id = details.id)\n" +
				"                  group by detail_type_id\n" +
				"                  order by sold_detail_type_amount desc, detail_type_id\n" +
				"              ) top_sold_details\n" +
				"                  inner join deliveries_detail_types\n" +
				"                             on deliveries_detail_types.detail_type_id = top_sold_details.detail_type_id\n" +
				"                  inner join deliveries on deliveries.id = deliveries_detail_types.delivery_id\n" +
				"                  inner join suppliers on suppliers.id = deliveries.supplier_id\n" +
				"         group by suppliers.id, top_sold_details.detail_type_id, top_sold_details.sold_detail_type_amount\n" +
				"         order by top_sold_details.sold_detail_type_amount desc, avg_price\n" +
				"     ) t\n" +
				"where seq = 1\n" +
				"    fetch next :rowsAmount rows only";
		return executeQuery(sql, queryParams, FiveTwoQueryResult.class);
	}

	public QueryListResult<SixQueryResult> six(SixQueryParams queryParams) {
		var sql = "select t.det_type as det_type, AVG(t.sold_details_amount) as avg_amount\n" +
				"from (\n" +
				"         select details.detail_type_id   as det_type,\n" +
				"                EXTRACT(MONTH from sales.sale_date),\n" +
				"                EXTRACT(YEAR from sales.sale_date),\n" +
				"                COUNT(details.id) as sold_details_amount\n" +
				"         from sales\n" +
				"                  inner join sold_details on sales.id = sold_details.sale_id\n" +
				"                  inner join details on details.id = sold_details.detail_id\n" +
				"         group by details.detail_type_id, EXTRACT(MONTH from sales.sale_date), EXTRACT(YEAR from sales.sale_date)\n" +
				"         order by EXTRACT(YEAR from sales.sale_date), EXTRACT(MONTH from sales.sale_date)\n" +
				"     ) t\n" +
				"group by t.det_type\n" +
				"order by t.det_type";
		return executeQuery(sql, queryParams, SixQueryResult.class);
	}

	public SevenOneQueryResult sevenOne(SevenOneQueryParams queryParams) {
		var sql = "select (COUNT(details.id) / sold_details_amount.details_amount) * 100 as percent\n" +
				"from sold_details\n" +
				"         inner join details on sold_details.detail_id = details.id\n" +
				"         inner join deliveries on deliveries.id = details.delivery_id,\n" +
				"     (\n" +
				"         select COUNT(details.id) as details_amount\n" +
				"         from sold_details\n" +
				"                  inner join details on sold_details.detail_id = details.id\n" +
				"     ) sold_details_amount\n" +
				"where deliveries.supplier_id = :supplierId\n" +
				"group by sold_details_amount.details_amount";

		return executeSingleObjectQuery(sql, queryParams, SevenOneQueryResult.class);
	}

	public SevenTwoQueryResult sevenTwo(SevenTwoQueryParams queryParams) {
		var sql = "select SUM(details_shop_prices.shop_price) as share_of_goods_sold\n" +
				"from sold_details\n" +
				"         inner join details on details.id = sold_details.detail_id\n" +
				"         inner join deliveries on deliveries.id = details.delivery_id\n" +
				"         inner join details_shop_prices on details.detail_type_id = details_shop_prices.detail_type_id\n" +
				"where deliveries.supplier_id = :supplierId\n" +
				"order by details.detail_type_id";
		return executeSingleObjectQuery(sql, queryParams, SevenTwoQueryResult.class);
	}

	public SevenThreeQueryResult sevenThree(SevenThreeQueryParams queryParams) {
		var sql = "select (COUNT(details.id)) as share_of_goods_sold\n" +
				"from sold_details\n" +
				"         inner join details on sold_details.detail_id = details.id\n" +
				"         inner join deliveries on deliveries.id = details.delivery_id\n" +
				"where deliveries.supplier_id = :supplierId";
		return executeSingleObjectQuery(sql, queryParams, SevenThreeQueryResult.class);
	}

	public SevenFourQueryResult sevenFour(SevenFourQueryParams queryParams) {
		var sql = "select SUM(bought.shop_price) - total_expenses.total_expenses as income\n" +
				"from (\n" +
				"         select details_shop_prices.shop_price\n" +
				"         from sold_details\n" +
				"                  inner join details on sold_details.detail_id = details.id\n" +
				"                  left join refunds on details.id = refunds.detail_id\n" +
				"                  inner join details_shop_prices on details_shop_prices.detail_type_id = details.detail_type_id\n" +
				"                  inner join sales on sales.id = sold_details.sale_id\n" +
				"         where sales.sale_date between :minSaleDate and :maxSaleDate\n" +
				"           and (refunds.customer_refund_date is null\n" +
				"             or refunds.supplier_refund_date is not null)\n" +
				"     ) bought,\n" +
				"     (select SUM(expenses.total_amount + COALESCE(expenses.tax, 0)) as total_expenses\n" +
				"      from (\n" +
				"               select SUM(deliveries_detail_types.supplier_price)  as total_amount,\n" +
				"                      SUM((deliveries_detail_types.supplier_price / 100) * customs.tax_percent) as tax\n" +
				"               from deliveries_detail_types\n" +
				"                        inner join deliveries on deliveries.id = deliveries_detail_types.delivery_id\n" +
				"                        left join customs on customs.delivery_id = deliveries.id\n" +
				"               where deliveries.delivery_date between :minSaleDate and :maxSaleDate\n" +
				"           ) expenses\n" +
				"     ) total_expenses\n" +
				"group by total_expenses.total_expenses";
		return executeSingleObjectQuery(sql, queryParams, SevenFourQueryResult.class);
	}

	public EightQueryResult eight(EightQueryParams queryParams) {
		var sql = "select (SUM(deliveries_detail_types.supplier_price / 100 * COALESCE(customs.tax_percent, 0)) / tot_exp.income) * 100 as overheads_percent\n" +
				"from deliveries\n" +
				"         inner join customs on customs.delivery_id = deliveries.id\n" +
				"         inner join deliveries_detail_types on deliveries.id = deliveries_detail_types.delivery_id,\n" +
				"     (select SUM(bought.shop_price) - total_expenses.total_expenses as income\n" +
				"      from (\n" +
				"               select details_shop_prices.shop_price\n" +
				"               from sold_details\n" +
				"                        inner join details on sold_details.detail_id = details.id\n" +
				"                        left join refunds on details.id = refunds.detail_id\n" +
				"                        inner join details_shop_prices on details_shop_prices.detail_type_id = details.detail_type_id\n" +
				"                        inner join sales on sales.id = sold_details.sale_id\n" +
				"                   and (refunds.customer_refund_date is null\n" +
				"                       or refunds.supplier_refund_date is not null)\n" +
				"           ) bought,\n" +
				"           (select SUM(expenses.total_amount + COALESCE(expenses.tax, 0)) as total_expenses\n" +
				"            from (\n" +
				"                     select SUM(deliveries_detail_types.supplier_price)  as total_amount,\n" +
				"                            SUM((deliveries_detail_types.supplier_price / 100) * customs.tax_percent) as tax\n" +
				"                     from deliveries_detail_types\n" +
				"                              inner join deliveries on deliveries.id = deliveries_detail_types.delivery_id\n" +
				"                              left join customs on customs.delivery_id = deliveries.id\n" +
				"                 ) expenses\n" +
				"           ) total_expenses\n" +
				"      group by total_expenses.total_expenses\n" +
				"     ) tot_exp\n" +
				"group by tot_exp.income";
		return executeSingleObjectQuery(sql, queryParams, EightQueryResult.class);
	}

	public QueryListResult<NineOneQueryResult> nineOne(NineOneQueryParams queryParams) {
		var sql = "select details.id as id,\n" +
				"       details.detail_type_id as detail_type_id,\n" +
				"       deliveries.delivery_date as delivery_date,\n" +
				"       sales.sale_date as sale_date\n" +
				"from details\n" +
				"         left join sold_details on details.id = sold_details.detail_id\n" +
				"         left join sales on sales.id = sold_details.sale_id\n" +
				"         inner join deliveries on deliveries.id = details.delivery_id\n" +
				"where deliveries.delivery_date between :minDeliveryDate and :maxDeliveryDate\n" +
				"  and (sales.sale_date is null or sales.sale_date >= :maxDeliveryDate)";
		return executeQuery(sql, queryParams, NineOneQueryResult.class);
	}

	public NineTwoQueryResult nineTwo(NineTwoQueryParams queryParams) {
		var sql = "select COUNT(details.id) as details_amount\n" +
				"from details\n" +
				"         left join sold_details on details.id = sold_details.detail_id\n" +
				"         left join sales on sales.id = sold_details.sale_id\n" +
				"         inner join deliveries on deliveries.id = details.delivery_id\n" +
				"where deliveries.delivery_date between :minDeliveryDate and :maxDeliveryDate\n" +
				"  and (sales.sale_date is null or sales.sale_date >= :maxDeliveryDate)";
		return executeSingleObjectQuery(sql, queryParams, NineTwoQueryResult.class);
	}

	public NineThreeQueryResult nineThree(NineThreeQueryParams queryParams) {
		var sql = "select (COUNT(details.id) / all_details_in_curr_period.det_amount) * 100 as percent\n" +
				"from details\n" +
				"         left join sold_details on details.id = sold_details.detail_id\n" +
				"         left join sales on sales.id = sold_details.sale_id\n" +
				"         inner join deliveries on deliveries.id = details.delivery_id,\n" +
				"     (\n" +
				"         select COUNT(details.id) as det_amount\n" +
				"         from details\n" +
				"                  inner join deliveries on deliveries.id = details.delivery_id\n" +
				"         where deliveries.delivery_date between :minDeliveryDate and :maxDeliveryDate\n" +
				"     ) all_details_in_curr_period\n" +
				"where deliveries.delivery_date between :minDeliveryDate and :maxDeliveryDate\n" +
				"  and (sales.sale_date is null or sales.sale_date >= :maxDeliveryDate)\n" +
				"group by all_details_in_curr_period.det_amount";
		return executeSingleObjectQuery(sql, queryParams, NineThreeQueryResult.class);
	}

	public QueryListResult<TenOneQueryResult> tenOne(TenOneQueryParams queryParams) {
		var sql = "select details.detail_type_id as detail_type_id,\n" +
				"       COUNT(details.detail_type_id) as amount,\n" +
				"       deliveries.delivery_date as delivery_date,\n" +
				"       refunds.customer_refund_date as customer_refund_date,\n" +
				"       deliveries.supplier_id as supplier_id\n" +
				"from details\n" +
				"         inner join deliveries on details.delivery_id = deliveries.id\n" +
				"         inner join refunds on refunds.detail_id = details.id\n" +
				"where deliveries.delivery_date between :minDeliveryDate and :maxDeliveryDate\n" +
				"group by details.detail_type_id, deliveries.delivery_date, refunds.customer_refund_date,\n" +
				"         deliveries.supplier_id\n" +
				"order by details.detail_type_id";
		return executeQuery(sql, queryParams, TenOneQueryResult.class);
	}

	public TenTwoQueryResult tenTwo(TenTwoQueryParams queryParams) {
		var sql = "select COUNT(details.id) as details_amount\n" +
				"from details\n" +
				"         inner join deliveries on details.delivery_id = deliveries.id\n" +
				"         inner join refunds on refunds.detail_id = details.id\n" +
				"where deliveries.delivery_date between :minDeliveryDate and :maxDeliveryDate\n" +
				"order by details.detail_type_id";
		return executeSingleObjectQuery(sql, queryParams, TenTwoQueryResult.class);
	}

	public QueryListResult<ElevenOneQueryResult> elevenOne(ElevenOneQueryParams queryParams) {
		var sql = "select details.detail_type_id,\n" +
				"       COUNT(details.id) as details_amount,\n" +
				"       SUM(details_shop_prices.shop_price) as sum_shop_price\n" +
				"from sales\n" +
				"         inner join sold_details on sales.id = sold_details.detail_id\n" +
				"         inner join details on details.id = sold_details.detail_id\n" +
				"         inner join details_shop_prices on details_shop_prices.detail_type_id = details.detail_type_id\n" +
				"where sale_date = :date\n" +
				"group by sales.sale_date, details.detail_type_id\n" +
				"order by detail_type_id";
		return executeQuery(sql, queryParams, ElevenOneQueryResult.class);
	}

	public ElevenTwoQueryResult elevenTwo(ElevenTwoQueryParams queryParams) {
		var sql = "select COUNT(details.id) as details_amount\n" +
				"from sales\n" +
				"         inner join sold_details on sales.id = sold_details.detail_id\n" +
				"         inner join details on details.id = sold_details.detail_id\n" +
				"         inner join details_shop_prices on details_shop_prices.detail_type_id = details.detail_type_id\n" +
				"where sale_date = :date\n" +
				"order by details.detail_type_id";
		return executeSingleObjectQuery(sql, queryParams, ElevenTwoQueryResult.class);
	}

	public TwelveOneQueryResult twelveOne(TwelveOneQueryParams queryParams) {
		var sql = "select SUM(bought.shop_price) as turnover\n" +
				"from (\n" +
				"         select details_shop_prices.shop_price\n" +
				"         from sold_details\n" +
				"                  inner join details on sold_details.detail_id = details.id\n" +
				"                  left join refunds on details.id = refunds.detail_id\n" +
				"                  inner join details_shop_prices on details_shop_prices.detail_type_id = details.detail_type_id\n" +
				"                  inner join sales on sales.id = sold_details.sale_id\n" +
				"         where sales.sale_date between :minSaleDate and :maxSaleDate\n" +
				"           and (refunds.customer_refund_date is null\n" +
				"             or refunds.supplier_refund_date is not null)\n" +
				"     ) bought";
		return executeSingleObjectQuery(sql, queryParams, TwelveOneQueryResult.class);
	}

	public TwelveTwoQueryResult twelveTwo(TwelveTwoQueryParams queryParams) {
		var sql = "select SUM(refunds.shop_price) as refunds_shop_price\n" +
				"from (\n" +
				"         select details_shop_prices.shop_price\n" +
				"         from refunds\n" +
				"                  inner join details on details.id = refunds.detail_id\n" +
				"                  inner join details_shop_prices on details_shop_prices.detail_type_id = details.detail_type_id\n" +
				"         where refunds.customer_refund_date between :minCustomerRefDate and :maxCustomerRefDate\n" +
				"           and refunds.supplier_refund_date is null\n" +
				"     ) refunds";
		return executeSingleObjectQuery(sql, queryParams, TwelveTwoQueryResult.class);
	}

	public QueryListResult<ThirteenQueryResult> thirteen(ThirteenQueryParams queryParams) {
		var sql = "select details.detail_type_id,\n" +
				"       detail_types.name as name,\n" +
				"       COUNT(details.detail_type_id) as detail_types_amount,\n" +
				"       details_shop_prices.shop_price as shop_price\n" +
				"from details\n" +
				"         inner join detail_types on details.detail_type_id = detail_types.id\n" +
				"         inner join details_shop_prices on details_shop_prices.detail_type_id = detail_types.id\n" +
				"where details.cell_id is not null\n" +
				"group by details.detail_type_id, detail_types.name, details_shop_prices.shop_price\n" +
				"order by details.detail_type_id";
		return executeQuery(sql, queryParams, ThirteenQueryResult.class);
	}

	public QueryListResult<FourteenQueryResult> fourteen(FourteenQueryParams queryParams) {
		var sql = "select details.detail_type_id as det_type_id,\n" +
				"       SUM(details_shop_prices.shop_price) /\n" +
				"       (expenses.total_amount + COALESCE(expenses.tax, 0)) as circulation_speed\n" +
				"from sold_details\n" +
				"         inner join details on sold_details.detail_id = details.id\n" +
				"         inner join details_shop_prices on details.detail_type_id = details_shop_prices.detail_type_id\n" +
				"         inner join (select deliveries_detail_types.detail_type_id,\n" +
				"                            SUM(deliveries_detail_types.supplier_price)    as total_amount,\n" +
				"                            SUM((deliveries_detail_types.supplier_price / 100) * customs.tax_percent) as tax\n" +
				"                     from deliveries_detail_types\n" +
				"                              inner join deliveries on deliveries.id = deliveries_detail_types.delivery_id\n" +
				"                              left join customs on customs.delivery_id = deliveries.id\n" +
				"                     group by deliveries_detail_types.detail_type_id\n" +
				"                     order by deliveries_detail_types.detail_type_id) expenses\n" +
				"                    on expenses.detail_type_id = details.detail_type_id\n" +
				"group by details.detail_type_id, expenses.total_amount, expenses.tax\n" +
				"order by details.detail_type_id";
		return executeQuery(sql, queryParams, FourteenQueryResult.class);
	}

	public FifteenOneQueryResult fifteenOne(FifteenOneQueryParams queryParams) {
		var sql = "select COUNT(storage_cells.id) as storage_cells_amount\n" +
				"from storage_cells\n" +
				"         left join details on details.cell_id = storage_cells.id\n" +
				"where details.id is null";
		return executeSingleObjectQuery(sql, queryParams, FifteenOneQueryResult.class);
	}

	public FifteenTwoQueryResult fifteenTwo(FifteenTwoQueryParams queryParams) {
		var sql = "select MAX(storage_cells.id) * 5 - COUNT(details.id) as free_places\n" +
				"from storage_cells\n" +
				"         left join details on storage_cells.id = details.cell_id";
		return executeSingleObjectQuery(sql, queryParams, FifteenTwoQueryResult.class);
	}

	public QueryListResult<SixteenOneQueryResult> sixteenOne(SixteenOneQueryParams queryParams) {
		var sql = "select orders.id as order_id\n" +
				"from orders\n" +
				"         left join sales on orders.id = sales.order_id\n" +
				"where sales.id is null";
		return executeQuery(sql, queryParams, SixteenOneQueryResult.class);
	}

	public SixteenTwoQueryResult sixteenTwo(SixteenTwoQueryParams queryParams) {
		var sql = "select COUNT(orders.id) as orders_amount\n" +
				"from orders\n" +
				"         left join sales on orders.id = sales.order_id\n" +
				"where sales.id is null";
		return executeSingleObjectQuery(sql, queryParams, SixteenTwoQueryResult.class);
	}

	public QueryListResult<SixteenThreeQueryResult> sixteenThree(SixteenThreeQueryParams queryParams) {
		var sql = "select orders_detail_types.amount as amount,\n" +
				"       orders_detail_types.detail_type_id as det_type_id,\n" +
				"       orders_detail_types.order_id as order_id,\n" +
				"       SUM(details_shop_prices.shop_price * amount) as sum_shop_price\n" +
				"from orders\n" +
				"         inner join orders_detail_types on orders.id = orders_detail_types.order_id\n" +
				"         inner join details_shop_prices on details_shop_prices.detail_type_id = orders_detail_types.detail_type_id\n" +
				"         left join sales on orders.id = sales.order_id\n" +
				"where sales.id is null\n" +
				"group by orders_detail_types.order_id, orders_detail_types.detail_type_id, orders_detail_types.amount\n" +
				"order by orders_detail_types.order_id";
		return executeQuery(sql, queryParams, SixteenThreeQueryResult.class);
	}

	private <T> T executeSingleObjectQuery(String sql, Object queryParams, Class<T> objectClass) {
		var parameterSource = getParameterSource(queryParams);
		return jdbcTemplate.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<>(objectClass));
	}

	private <T> QueryListResult<T> executeQuery(String sql, Object queryParams, Class<T> elementClass) {
		var parameterSource = getParameterSource(queryParams);
		var elements = jdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(elementClass));
		return new QueryListResult<>(elements);
	}

	private SqlParameterSource getParameterSource(Object queryParams) {
		var parameterSource = new MapSqlParameterSource();
		ReflectionUtils.doWithFields(queryParams.getClass(), f -> {
			f.setAccessible(true);
			parameterSource.addValue(f.getName(), f.get(queryParams));
		});
		return parameterSource;
	}

}
