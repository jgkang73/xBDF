package egovframework.example.hcm.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * Types comments
 * 작성일자: 2026. 5. 15.
 * 목    적: 코드유형 데이터 조회 및 건수 조회
 *           코드유형 데이터 저장(신규, 수정, 삭제)
 * 설    명: DB SQL(조회, 신규, 수정, 삭제, 처리 등)과 Java 객체를 연결하는 인터페이스 클래스
 * @Mapper : 해당 인터페이스를 SQL Mapper(DB 처리 객체)로 등록하는 어노테이션
 */
@Mapper
public interface EduNexaMapper {

	/**
	 * Methods comments
	 * 작성일자: 2026. 5. 15.
	 * 목    적: 코드유형의 데이터를 조회
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
