package egovframework.example.hcm.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter.spring.core.data.NexacroResult;

import egovframework.example.hcm.service.EduNexaService;

/**
 * Types comments
 * 작성일자: 2026. 5. 15.
 * 목    적: 코드유형 데이터 조회 및 건수 조회
 *           코드유형 데이터 저장(신규, 수정, 삭제) 
 * 설    명: 클라이언트(넥사크로)에서 요청한 데이터(데이터셋, 매개변수)에 대하여
 *           자바에서 인식할 수 있는 형태의 데이터로 전환 및 서버에서 처리된 결과를 클라이언트(넥사크로)에 전달하는 클래스
 * @Controller     : 해당 클래스를 웹 요청(URL)을 처리하는 Controller 클래스로 등록하는 어노테이션
 * @RequestMapping : Spring Framework에서 URL 요청을 컨트롤러 메서드와 매핑하는 어노테이션          
 */
@Controller
@RequestMapping(value = "com/COM10000")
public class EduNexaController {

	/** 
	 * 목    적: 로그 출력 
	 * 설    명: 서버에서 로그를 출력하기 위한 변수
	 * 
	 * pom.xml에 Log4j2 라이브러리 추가
	 * log4j-api / log4j-core / log4j-slf4j2-impl
	 * 
	 * 로그설정 log4j2.xml 수정
	 */
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	//EduNexaService에 대한 의존성 주입
	@Resource
	private EduNexaService eduNexaService;

	/** 
	 * Methods comments
	 * 작성일자: 2026. 5. 15.
	 * 목    적: 코드유형 데이터 조회
	 * 매개변수: Map<String, Object> dsSearch
	 *           String userID
	 * 리    턴: NexacroResult
	 */
	@RequestMapping(value = "selectComCodeTypeList.do")
	public NexacroResult selectComCodeTypeList(@ParamDataSet(name = "inSearch") Map<String, Object> dsSearch
			                                  ,@ParamVariable(name = "userId") String userID) throws Exception {		
		
		//데이터 셋 로우타입
		//0(초기상태), 1(조회), 2(신규), 4(수정), 8(삭제)  
		int nRowType = (Integer) dsSearch.get("DataSetRowType");
		
		log.debug("####################################################");
		log.debug("DataSetRowType         → " + nRowType);
		log.debug("dsSearch(CODE_TYPE)    → " + dsSearch.get("CODE_TYPE"));
		log.debug("dsSearch(CODE_TYPE_NM) → " + dsSearch.get("CODE_TYPE_NM"));
		log.debug("userID                 → " + userID);
		log.debug("####################################################");
		
		
		//코드유형 데이터 건수 조회
		//리스트 맵 데이터를 맵 데이터로 추출 후 맵의 컬럼의 값을 추출
		List<Map<String, Object>> selectCodeTypeCount = eduNexaService.selectComCodeTypeCount(dsSearch);
		Map<String, Object> selCntMap = selectCodeTypeCount.get(0);
		BigDecimal rowCnt = (BigDecimal)selCntMap.get("ROW_CNT");
		log.debug("####################################################");
		log.debug("rowCnt                 → " + rowCnt);
		log.debug("####################################################");
		
		//코드유형 데이터 조회를 위한 메소드 호출 및 결과 리턴
		List<Map<String, Object>> selectCodeTypeList = eduNexaService.selectComCodeTypeList(dsSearch);		
		
		//selectCodeTypeList에 존재하는 데이터 확인
		for(int i=0; i<selectCodeTypeList.size(); i++) {
			if (i == 0) {
				log.debug("####################################################");
			}
			
			//List 데이터를 각각의 rowData로 추출
			Map<String, Object> rowData = selectCodeTypeList.get(i);
			
			//rowData의 값을 컬럼 단위로 추출 
			BigDecimal codeTypeId = (BigDecimal)rowData.get("CODE_TYPE_ID");
			String codeType = (String)rowData.get("CODE_TYPE");
			
			log.debug("[" + i + "] codeTypeId → " + codeTypeId);
			log.debug("[" + i + "] codeType   → " + codeType);
			
			if (i == selectCodeTypeList.size()-1) {
				log.debug("####################################################");
			}			
		}
		NexacroResult result = new NexacroResult();
		
		//자바객체로 처리된 결과를 넥사크로 데이터셋 형태로 전환
		result.addDataSet("outSelectList", selectCodeTypeList);
		result.addDataSet("outSelectCount", selectCodeTypeCount);
		return result;
	}
}
