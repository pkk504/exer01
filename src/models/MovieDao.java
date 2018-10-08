package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieDao {
	@Autowired
	SqlSessionFactory factory;
	
	
	
	@Autowired
	SqlSessionTemplate template;
	
	
	public List<Map> lione(String param) {
		return template.selectList("movie.getmovietimeone",param);
	}
	
	public List<Map> litwo(String param){
		return template.selectList("movie.getmovietimetwo",param);
	}
	
	public List<String> litwotitle(){
		return template.selectList("movie.getmovietimetwotitle");
	}
	
	public Integer litwono(Map param) {
		return template.selectOne("movie.getmovietimetwono",param);
	}
	
	public int litwoin(Map param) {
		return template.insert("getmovietimetwoinset",param);
	}
	
	public List<String> getmovieseat(int param) {
		return template.selectList("movie.getmovieseat",param);
	}
	
	
}
