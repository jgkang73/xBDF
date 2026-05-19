package egovframework.example.hcm.service;

import java.util.List;
import java.util.Map;

/**
 * Types comments
 * 작성일자: 2026. 5. 15.
 * 목    적: 코드유형 데이터 조회 및 건수 조회
 *           코드유형 데이터 저장(신규, 수정, 삭제) 
 * 설    명: 컨트롤러에서 선언된 메소드를 구현체에 전달하기 위한 인터페이스
 */
public interface EduNexaService {

	/**
	 * Methods comments
	 * 작성일자: 2026. 5. 15.
	 * 목    적: 코드유형 데이터 조회
	 * 매개변수: Map<String, Object> dsSearch
	 * 리    턴: List<Map<String, Object>>
	 */
	public List<Map<String, Object>> selectComCodeTypeList(Map<String, Object> dsSearch) throws Exception;
		
	/**
	 * Methods comments
	 * 작성일자: 2026. 5. 15.
	 * 목    적: 코드유형 데이터 건수 조회
	 * 매개변수: Map<String, Object> dsSearch
	 * 리    턴: List<Map<String, Object>>
	 */
	public List<Map<String, Object>> selectComCodeTypeCount(Map<String, Object> dsSearch) throws Exception;
}
