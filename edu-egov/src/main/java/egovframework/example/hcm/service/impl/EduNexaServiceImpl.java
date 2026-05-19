package egovframework.example.hcm.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import egovframework.example.hcm.service.EduNexaService;

/**
 * Types comments
 * 작성일자: 2026. 5. 15.
 * 목    적: 코드유형 데이터 조회 및 건수 조회
 *           코드유형 데이터 저장(신규, 수정, 삭제)
 * 설    명: 서비스에서 전달된 정보를 대상으로 비즈니스 로직(SQL 매퍼에 데이터 전달 및 결과 리턴)을 구현하는 클래스
 * @Service import : org.springframework.stereotype.Service;
 */
@Service
public class EduNexaServiceImpl implements EduNexaService {
	
	//EduNexaMapper에 대한 의존성 주입
	@Resource(name = "eduNexaMapper")
	private EduNexaMapper eduNexaMapper;
	
	/**
	 * Overriding methods comments
	 * 작성일자: 2026. 5. 15.
	 * 목    적: 코드유형을 조회하는 메소드
	 * 매개변수: List<Map<String, Object>> dsSearch
	 * 리    턴: List<Map<String, Object>> 
	 */
	@Override
	public List<Map<String, Object>> selectComCodeTypeList(Map<String, Object> dsSearch) throws Exception {		
		//메소드 저장 후 오류 발생시 좌측 메뉴 "Create Method ..." 클릭하면 EduNexaMapper 파일에 인터페이스 메소드가 자동으로 생성됨
		return eduNexaMapper.selectComCodeTypeList(dsSearch);
	}
	
	/**
	 * Overriding methods comments
	 * 작성일자: 2026. 5. 15.
	 * 목    적: 코드유형 조회된 건수를 조회하는 메소드
	 * 매개변수: List<Map<String, Object>> dsSearch
	 * 리    턴: List<Map<String, Object>> 
	 */
	@Override
	public List<Map<String, Object>> selectComCodeTypeCount(Map<String, Object> dsSearch) throws Exception {		
		//메소드 저장 후 오류 발생시 좌측 메뉴 "Create Method ..." 클릭하면 EduNexaMapper 파일에 인터페이스 메소드가 자동으로 생성됨
		return eduNexaMapper.selectComCodeTypeCount(dsSearch);
	}
}
