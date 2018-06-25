package com.kh.myapp.login.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplJDBC implements LoginDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * JDBCTemplate 객체가 root-context.xml 에 빈으로 등록되어서 아래를 주석처리함
	 * 
	 * @Autowired public void setdataSource(DataSource dataSource) {
	 * this.jdbcTemplate = new JdbcTemplate(dataSource); }
	 */
	
	@Override
	public MemberVO getMember(LoginVO loginVO) {
		
		MemberVO memVO;
    StringBuffer str = new StringBuffer();
    str.append("select * from member where id = ? and passwd = ?");
 
    memVO = (MemberVO)this.jdbcTemplate.queryForObject(str.toString(), 
      		 new Object[]{ loginVO.getId(),loginVO.getPasswd()},
           new BeanPropertyRowMapper<>(MemberVO.class));
    
    return memVO;
 }

	@Override
	public Map<String, Object> selectUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
