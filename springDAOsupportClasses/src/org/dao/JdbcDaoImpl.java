package org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class JdbcDaoImpl {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate ;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * public Circle getCircle(int circleId) {
	 * 
	 * try {
	 * 
	 * 
	 * conn=dataSource.getConnection(); PreparedStatement
	 * ps=conn.prepareStatement("SELECT  * from  circle where id=  ?"); ps.setInt(1,
	 * circleId);
	 * 
	 * 
	 * 
	 * Circle circle=null; ResultSet rs=ps.executeQuery();
	 * 
	 * if(rs.next()) { circle= new Circle(circleId,rs.getString("name"));
	 * 
	 * } rs.close(); ps.close(); return circle; }catch(Exception e) { throw new
	 * RuntimeException(e); } finally { try { conn.close(); }catch(SQLException e)
	 * {} }
	 */
	

	 public List<Map<String, Object>> getCircleCount() {
		 String sql="SELECT count(*)  from circle";
	  
	  return jdbcTemplate.queryForList(sql);
	  
	  }
	 
public String getCircleName(int circleId) {
	String sql="SELECT name  from circle where id=?";
	
	return jdbcTemplate.queryForObject(sql,new Object[] {circleId},String.class);
	
}
public Circle getCircleforId(int circleId) {
	String sql="select * from circle where id=?";
	return jdbcTemplate.queryForObject(sql, new Object[] {circleId},new CircleMapper());
	
}
public List<Circle> getAllCircles(){
	String sql="select * from circle";
	return jdbcTemplate.query(sql,new CircleMapper());

}

/*
 * public void insertCircle(Circle circle) { String
 * sql="insert into circle (ID,NAME) values(?,?)"; jdbcTemplate.update(sql,new
 * Object[] {circle.getId(),circle.getName()}); }
 */

public void insertCircle(Circle circle) { 
	String sql="insert into circle (ID,NAME) values(:id,:name)";
	SqlParameterSource namedParameters=new MapSqlParameterSource("id",circle.getId()).
			addValue("name",circle.getName());
	namedParameterJdbcTemplate.update(sql, namedParameters);
}
public void createTriangleTable() {
	String sql="create able triangle(ID INTEGER,NAME VARCHAR(30))";
	jdbcTemplate.execute(sql);
}
private static final class CircleMapper implements RowMapper<Circle >{

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
			
		}			
			
	
}
}