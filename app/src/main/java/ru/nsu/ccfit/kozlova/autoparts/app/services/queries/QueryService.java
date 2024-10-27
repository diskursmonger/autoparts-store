package ru.nsu.ccfit.kozlova.autoparts.app.services.queries;

import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryListResult;
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
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;

public class QueryService extends AbstractService {

	private final QueryServiceApi queryServiceApi;

	public QueryService(String baseUrl) {
		super(QueryServiceApi.class, baseUrl);
		queryServiceApi = (QueryServiceApi) getServiceApi();
	}

	public ServiceResponse<QueryListResult<OneOneQueryResult>> oneOne(OneOneQueryParams params) {
		return getServerResponse(queryServiceApi.oneOne(params));
	}

	public ServiceResponse<OneTwoQueryResult> oneTwo(OneTwoQueryParams params) {
		return getServerResponse(queryServiceApi.oneTwo(params));
	}

	public ServiceResponse<QueryListResult<OneThreeQueryResult>> oneThree(OneThreeQueryParams params) {
		return getServerResponse(queryServiceApi.oneThree(params));
	}

	public ServiceResponse<QueryListResult<TwoQueryResult>> two(TwoQueryParams params) {
		return getServerResponse(queryServiceApi.two(params));
	}

	public ServiceResponse<QueryListResult<ThreeOneQueryResult>> threeOne(ThreeOneQueryParams params) {
		return getServerResponse(queryServiceApi.threeOne(params));
	}

	public ServiceResponse<ThreeTwoQueryResult> threeTwo(ThreeTwoQueryParams params) {
		return getServerResponse(queryServiceApi.threeTwo(params));
	}

	public ServiceResponse<QueryListResult<ThreeThreeQueryResult>> threeThree(ThreeThreeQueryParams params) {
		return getServerResponse(queryServiceApi.threeThree(params));
	}

	public ServiceResponse<QueryListResult<FourOneQueryResult>> fourOne(FourOneQueryParams params) {
		return getServerResponse(queryServiceApi.fourOne(params));
	}
	public ServiceResponse<FourTwoQueryResult> fourTwo(FourTwoQueryParams params) {
		return getServerResponse(queryServiceApi.fourTwo(params));
	}
	public ServiceResponse<QueryListResult<FourThreeQueryResult>> fourThree(FourThreeQueryParams params) {
		return getServerResponse(queryServiceApi.fourThree(params));
	}

	public ServiceResponse<QueryListResult<FiveOneQueryResult>> fiveOne(FiveOneQueryParams params) {
		return getServerResponse(queryServiceApi.fiveOne(params));
	}

	public ServiceResponse<QueryListResult<FiveTwoQueryResult>> fiveTwo(FiveTwoQueryParams params) {
		return getServerResponse(queryServiceApi.fiveTwo(params));
	}

	public ServiceResponse<QueryListResult<SixQueryResult>> six(SixQueryParams params) {
		return getServerResponse(queryServiceApi.six(params));
	}

	public ServiceResponse<SevenOneQueryResult> sevenOne(SevenOneQueryParams params) {
		return getServerResponse(queryServiceApi.sevenOne(params));
	}

	public ServiceResponse<SevenTwoQueryResult> sevenTwo(SevenTwoQueryParams params) {
		return getServerResponse(queryServiceApi.sevenTwo(params));
	}

	public ServiceResponse<SevenThreeQueryResult> sevenThree(SevenThreeQueryParams params) {
		return getServerResponse(queryServiceApi.sevenThree(params));
	}

	public ServiceResponse<SevenFourQueryResult> sevenFour(SevenFourQueryParams params) {
		return getServerResponse(queryServiceApi.sevenFour(params));
	}

	public ServiceResponse<EightQueryResult> eight(EightQueryParams params) {
		return getServerResponse(queryServiceApi.eight(params));
	}

	public ServiceResponse<QueryListResult<NineOneQueryResult>> nineOne(NineOneQueryParams params) {
		return getServerResponse(queryServiceApi.nineOne(params));
	}

	public ServiceResponse<NineTwoQueryResult> nineTwo(NineTwoQueryParams params) {
		return getServerResponse(queryServiceApi.nineTwo(params));
	}

	public ServiceResponse<NineThreeQueryResult> nineThree(NineThreeQueryParams params) {
		return getServerResponse(queryServiceApi.nineThree(params));
	}

	public ServiceResponse<QueryListResult<TenOneQueryResult>> tenOne(TenOneQueryParams params) {
		return getServerResponse(queryServiceApi.tenOne(params));
	}

	public ServiceResponse<TenTwoQueryResult> tenTwo(TenTwoQueryParams params) {
		return getServerResponse(queryServiceApi.tenTwo(params));
	}

	public ServiceResponse<QueryListResult<ElevenOneQueryResult>> elevenOne(ElevenOneQueryParams params) {
		return getServerResponse(queryServiceApi.elevenOne(params));
	}

	public ServiceResponse<ElevenTwoQueryResult> elevenTwo(ElevenTwoQueryParams params) {
		return getServerResponse(queryServiceApi.elevenTwo(params));
	}

	public ServiceResponse<TwelveOneQueryResult> twelveOne(TwelveOneQueryParams params) {
		return getServerResponse(queryServiceApi.twelveOne(params));
	}

	public ServiceResponse<TwelveTwoQueryResult> twelveTwo(TwelveTwoQueryParams params) {
		return getServerResponse(queryServiceApi.twelveTwo(params));
	}

	public ServiceResponse<QueryListResult<ThirteenQueryResult>> thirteen(ThirteenQueryParams params) {
		return getServerResponse(queryServiceApi.thirteen(params));
	}

	public ServiceResponse<QueryListResult<FourteenQueryResult>> fourteen(FourteenQueryParams params) {
		return getServerResponse(queryServiceApi.fourteen(params));
	}

	public ServiceResponse<FifteenOneQueryResult> fifteenOne(FifteenOneQueryParams params) {
		return getServerResponse(queryServiceApi.fifteenOne(params));
	}

	public ServiceResponse<FifteenTwoQueryResult> fifteenTwo(FifteenTwoQueryParams params) {
		return getServerResponse(queryServiceApi.fifteenTwo(params));
	}

	public ServiceResponse<QueryListResult<SixteenOneQueryResult>> sixteenOne(SixteenOneQueryParams params) {
		return getServerResponse(queryServiceApi.sixteenOne(params));
	}

	public ServiceResponse<SixteenTwoQueryResult> sixteenTwo(SixteenTwoQueryParams params) {
		return getServerResponse(queryServiceApi.sixteenTwo(params));
	}

	public ServiceResponse<QueryListResult<SixteenThreeQueryResult>> sixteenThree(SixteenThreeQueryParams params) {
		return getServerResponse(queryServiceApi.sixteenThree(params));
	}
}
