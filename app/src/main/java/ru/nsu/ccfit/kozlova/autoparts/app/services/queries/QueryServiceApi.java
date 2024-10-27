package ru.nsu.ccfit.kozlova.autoparts.app.services.queries;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
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

public interface QueryServiceApi {

	@POST("queries/one/one")
	Call<QueryListResult<OneOneQueryResult>> oneOne(@Body OneOneQueryParams params);

	@POST("queries/one/two")
	Call<OneTwoQueryResult> oneTwo(@Body OneTwoQueryParams params);

	@POST("queries/one/three")
	Call<QueryListResult<OneThreeQueryResult>> oneThree(@Body OneThreeQueryParams params);

	@POST("queries/two")
	Call<QueryListResult<TwoQueryResult>> two(@Body TwoQueryParams params);

	@POST("queries/three/one")
	Call<QueryListResult<ThreeOneQueryResult>> threeOne(@Body ThreeOneQueryParams params);

	@POST("queries/three/two")
	Call<ThreeTwoQueryResult> threeTwo(@Body ThreeTwoQueryParams params);

	@POST("queries/three/three")
	Call<QueryListResult<ThreeThreeQueryResult>> threeThree(@Body ThreeThreeQueryParams params);

	@POST("queries/four/one")
	Call<QueryListResult<FourOneQueryResult>> fourOne(@Body FourOneQueryParams params);

	@POST("queries/four/two")
	Call<FourTwoQueryResult> fourTwo(@Body FourTwoQueryParams params);

	@POST("queries/four/three")
	Call<QueryListResult<FourThreeQueryResult>> fourThree(@Body FourThreeQueryParams params);

	@POST("queries/five/one")
	Call<QueryListResult<FiveOneQueryResult>> fiveOne(@Body FiveOneQueryParams params);

	@POST("queries/five/two")
	Call<QueryListResult<FiveTwoQueryResult>> fiveTwo(@Body FiveTwoQueryParams params);

	@POST("queries/six")
	Call<QueryListResult<SixQueryResult>> six(@Body SixQueryParams params);

	@POST("queries/seven/one")
	Call<SevenOneQueryResult> sevenOne(@Body SevenOneQueryParams params);

	@POST("queries/seven/two")
	Call<SevenTwoQueryResult> sevenTwo(@Body SevenTwoQueryParams params);

	@POST("queries/seven/three")
	Call<SevenThreeQueryResult> sevenThree(@Body SevenThreeQueryParams params);

	@POST("queries/seven/four")
	Call<SevenFourQueryResult> sevenFour(@Body SevenFourQueryParams params);

	@POST("queries/eight")
	Call<EightQueryResult> eight(@Body EightQueryParams params);

	@POST("queries/nine/one")
	Call<QueryListResult<NineOneQueryResult>> nineOne(@Body NineOneQueryParams params);

	@POST("queries/nine/two")
	Call<NineTwoQueryResult> nineTwo(@Body NineTwoQueryParams params);

	@POST("queries/nine/three")
	Call<NineThreeQueryResult> nineThree(@Body NineThreeQueryParams params);

	@POST("queries/ten/one")
	Call<QueryListResult<TenOneQueryResult>> tenOne(@Body TenOneQueryParams params);

	@POST("queries/ten/two")
	Call<TenTwoQueryResult> tenTwo(@Body TenTwoQueryParams params);

	@POST("queries/eleven/one")
	Call<QueryListResult<ElevenOneQueryResult>> elevenOne(@Body ElevenOneQueryParams params);

	@POST("queries/eleven/two")
	Call<ElevenTwoQueryResult> elevenTwo(@Body ElevenTwoQueryParams params);

	@POST("queries/twelve/one")
	Call<TwelveOneQueryResult> twelveOne(@Body TwelveOneQueryParams params);

	@POST("queries/twelve/two")
	Call<TwelveTwoQueryResult> twelveTwo(@Body TwelveTwoQueryParams params);

	@POST("queries/thirteen")
	Call<QueryListResult<ThirteenQueryResult>> thirteen(@Body ThirteenQueryParams params);

	@POST("queries/fourteen")
	Call<QueryListResult<FourteenQueryResult>> fourteen(@Body FourteenQueryParams params);

	@POST("queries/fifteen/one")
	Call<FifteenOneQueryResult> fifteenOne(@Body FifteenOneQueryParams params);

	@POST("queries/fifteen/two")
	Call<FifteenTwoQueryResult> fifteenTwo(@Body FifteenTwoQueryParams params);

	@POST("queries/sixteen/one")
	Call<QueryListResult<SixteenOneQueryResult>> sixteenOne(@Body SixteenOneQueryParams params);

	@POST("queries/sixteen/two")
	Call<SixteenTwoQueryResult> sixteenTwo(@Body SixteenTwoQueryParams params);

	@POST("queries/sixteen/three")
	Call<QueryListResult<SixteenThreeQueryResult>> sixteenThree(@Body SixteenThreeQueryParams params);
}
