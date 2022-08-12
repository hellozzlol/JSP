package co.sohyeon.web;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.sohyeon.notice.serviceImpl.NoticeServiceImpl;
import co.sohyeon.notice.vo.NoticeVO;

public class JacksonTest {
	
	//@Test
	public void toJson() throws JsonProcessingException {
		NoticeServiceImpl service =new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeSelectList();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String result=objectMapper.writeValueAsString(list);
		System.out.println(result);
	}
	
	@Test
	public void toObject() throws JsonMappingException, JsonProcessingException {
		String str = "{\"noticeId\":14,\"noticeWriter\":\"권민우\",\"noticeTitle\":\"우영우변호사\",\"noticeSubject\":null,\"noticeDate\":1658070000000,\"noticeHit\":0,\"noticeAttech\":null,\"noticeAttechDir\":null}";
		ObjectMapper objectMapper = new ObjectMapper();
		NoticeVO vo =objectMapper.readValue(str, NoticeVO.class);
		System.out.println(vo.getNoticeTitle());

	}


}
