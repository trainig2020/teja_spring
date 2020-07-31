package org.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport{
	
	public List<Map<String, Object>> getCircleCount() {
		 String sql="SELECT count(*)  from circle";
	  
	  return this.getJdbcTemplate().queryForList(sql);
	  
	  }
	

}
