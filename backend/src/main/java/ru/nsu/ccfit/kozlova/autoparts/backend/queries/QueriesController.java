package ru.nsu.ccfit.kozlova.autoparts.backend.queries;

import org.springframework.web.bind.annotation.*;
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

@RestController
@RequestMapping("/queries")
public class QueriesController {

	private final QueryService queryService;

	public QueriesController(QueryService queryService) {
		this.queryService = queryService;
	}

	@PostMapping("/one/one")
	public QueryListResult<OneOneQueryResult> oneOne(@RequestBody OneOneQueryParams queryParams) {
		return queryService.oneOne(queryParams);
	}

	@PostMapping("/one/two")
	public OneTwoQueryResult oneTwo(@RequestBody OneTwoQueryParams queryParams) {
		return queryService.oneTwo(queryParams);
	}

	@PostMapping("/one/three")
	public QueryListResult<OneThreeQueryResult> oneThree(@RequestBody OneThreeQueryParams queryParams) {
		return queryService.oneThree(queryParams);
	}

	@PostMapping("/two")
	public QueryListResult<TwoQueryResult> two(@RequestBody TwoQueryParams queryParams) {
		return queryService.two(queryParams);
	}

	@PostMapping("/three/one")
	public QueryListResult<ThreeOneQueryResult> threeOne(@RequestBody ThreeOneQueryParams queryParams) {
		return queryService.threeOne(queryParams);
	}

	@PostMapping("/three/two")
	public ThreeTwoQueryResult threeTwo(@RequestBody ThreeTwoQueryParams queryParams) {
		return queryService.threeTwo(queryParams);
	}

	@PostMapping("/three/three")
	public  QueryListResult<ThreeThreeQueryResult> threeThree(@RequestBody ThreeThreeQueryParams queryParams) {
		return queryService.threeThree(queryParams);
	}

	@PostMapping("/four/one")
	public QueryListResult<FourOneQueryResult> fourOne(@RequestBody FourOneQueryParams queryParams) {
		return queryService.fourOne(queryParams);
	}

	@PostMapping("/four/two")
	public FourTwoQueryResult fourTwo(@RequestBody FourTwoQueryParams queryParams) {
		return queryService.fourTwo(queryParams);
	}

	@PostMapping("/four/three")
	public QueryListResult<FourThreeQueryResult> fourThree(@RequestBody FourThreeQueryParams queryParams) {
		return queryService.fourThree(queryParams);
	}

	@PostMapping("/five/one")
	public QueryListResult<FiveOneQueryResult> fiveOne(@RequestBody FiveOneQueryParams queryParams) {
		return queryService.fiveOne(queryParams);
	}

	@PostMapping("/five/two")
	public QueryListResult<FiveTwoQueryResult> fiveTwo(@RequestBody FiveTwoQueryParams queryParams) {
		return queryService.fiveTwo(queryParams);
	}

	@PostMapping("/six")
	public QueryListResult<SixQueryResult> six(@RequestBody SixQueryParams queryParams) {
		return queryService.six(queryParams);
	}

	@PostMapping("/seven/one")
	public SevenOneQueryResult sevenOne(@RequestBody SevenOneQueryParams queryParams) {
		return queryService.sevenOne(queryParams);
	}

	@PostMapping("/seven/two")
	public SevenTwoQueryResult sevenTwo(@RequestBody SevenTwoQueryParams queryParams) {
		return queryService.sevenTwo(queryParams);
	}

	@PostMapping("/seven/three")
	public SevenThreeQueryResult sevenThree(@RequestBody SevenThreeQueryParams queryParams) {
		return queryService.sevenThree(queryParams);
	}

	@PostMapping("/seven/four")
	public SevenFourQueryResult sevenFour(@RequestBody SevenFourQueryParams queryParams) {
		return queryService.sevenFour(queryParams);
	}

	@PostMapping("/eight")
	public EightQueryResult eight(@RequestBody EightQueryParams queryParams) {
		return queryService.eight(queryParams);
	}

	@PostMapping("/nine/one")
	public QueryListResult<NineOneQueryResult> nineOne(@RequestBody NineOneQueryParams queryParams) {
		return queryService.nineOne(queryParams);
	}

	@PostMapping("/nine/two")
	public NineTwoQueryResult nineTwo(@RequestBody NineTwoQueryParams queryParams) {
		return queryService.nineTwo(queryParams);
	}

	@PostMapping("/nine/three")
	public NineThreeQueryResult nineThree(@RequestBody NineThreeQueryParams queryParams) {
		return queryService.nineThree(queryParams);
	}

	@PostMapping("/ten/one")
	public QueryListResult<TenOneQueryResult> tenOne(@RequestBody TenOneQueryParams queryParams) {
		return queryService.tenOne(queryParams);
	}

	@PostMapping("/ten/two")
	public TenTwoQueryResult tenTwo(@RequestBody TenTwoQueryParams queryParams) {
		return queryService.tenTwo(queryParams);
	}

	@PostMapping("/eleven/one")
	public QueryListResult<ElevenOneQueryResult> elevenOne(@RequestBody ElevenOneQueryParams queryParams) {
		return queryService.elevenOne(queryParams);
	}

	@PostMapping("/eleven/two")
	public ElevenTwoQueryResult elevenTwo(@RequestBody ElevenTwoQueryParams queryParams) {
		return queryService.elevenTwo(queryParams);
	}

	@PostMapping("/twelve/one")
	public TwelveOneQueryResult twelveOne(@RequestBody TwelveOneQueryParams queryParams) {
		return queryService.twelveOne(queryParams);
	}

	@PostMapping("/twelve/two")
	public TwelveTwoQueryResult twelveTwo(@RequestBody TwelveTwoQueryParams queryParams) {
		return queryService.twelveTwo(queryParams);
	}

	@PostMapping("/thirteen")
	public QueryListResult<ThirteenQueryResult> thirteen(@RequestBody ThirteenQueryParams queryParams) {
		return queryService.thirteen(queryParams);
	}

	@PostMapping("/fourteen")
	public QueryListResult<FourteenQueryResult> fourteen(@RequestBody FourteenQueryParams queryParams) {
		return queryService.fourteen(queryParams);
	}

	@PostMapping("/fifteen/one")
	public FifteenOneQueryResult fifteenOne(@RequestBody FifteenOneQueryParams queryParams) {
		return queryService.fifteenOne(queryParams);
	}

	@PostMapping("/fifteen/two")
	public FifteenTwoQueryResult fifteenTwo(@RequestBody FifteenTwoQueryParams queryParams) {
		return queryService.fifteenTwo(queryParams);
	}

	@PostMapping("/sixteen/one")
	public QueryListResult<SixteenOneQueryResult> sixteenOne(@RequestBody SixteenOneQueryParams queryParams) {
		return queryService.sixteenOne(queryParams);
	}

	@PostMapping("/sixteen/two")
	public SixteenTwoQueryResult sixteenTwo(@RequestBody SixteenTwoQueryParams queryParams) {
		return queryService.sixteenTwo(queryParams);
	}

	@PostMapping("/sixteen/three")
	public QueryListResult<SixteenThreeQueryResult> sixteenThree(@RequestBody SixteenThreeQueryParams queryParams) {
		return queryService.sixteenThree(queryParams);
	}
}
