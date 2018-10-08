/*package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieDao2 {
	@Autowired
	SqlSessionFactory factory;
	
	
	
	@Autowired
	SqlSessionTemplate template;
	
	
	public Map map(String param) {
		return template.selectOne("movie.getmovietime",param);
	}
	
	
}
*/