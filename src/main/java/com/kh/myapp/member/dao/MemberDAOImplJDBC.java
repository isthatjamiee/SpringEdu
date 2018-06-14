package com.kh.myapp.member.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

@Repository
public class MemberDAOImplJDBC implements MemberDAO{
   
   private JdbcTemplate jdbcTemplate;
   
      @Autowired 
      public void setDataSource(DataSource dataSource) {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
      }
   
   @Override
   public void insert(MemberVO memberVO) {
      StringBuffer str = new StringBuffer();
      str.append("insert into member(id, passwd, name, birth, phone, gender) ");
      str.append("values(?, ?, ?, ?, ?, ?)");
      try {
      this.jdbcTemplate .update(str.toString(),
            memberVO.getId(), memberVO.getPasswd(), memberVO.getName(),
            memberVO.getBirth(), memberVO.getPhone(), memberVO.getGender());
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   @Override
   public MemberVO getMember(String id) {
      MemberVO memberVO = new MemberVO();
      StringBuffer str = new StringBuffer();
      str.append("select * from member where id = ?");
      
      System.out.println("getMember");
      
      //query는 List타입이라 queryForObject 사용
      //queryForObject의 쿼리 결과값이 0일 때 error 발생하므로 try-catch로 묶어줌.
      try {
         memberVO = (MemberVO)this.jdbcTemplate.queryForObject(str.toString(), new Object[] { id },
                           new BeanPropertyRowMapper<>(MemberVO.class));
      } catch (DataAccessException e) {
         e.printStackTrace();
      }
      
      System.out.println(memberVO.toString());
      
      return memberVO;
   }

   @Override
   public ArrayList<MemberVO> getMemberList() {
      ArrayList<MemberVO> alist =  new ArrayList<>();
      StringBuffer str = new StringBuffer();
      str.append("select * from member");
      
      alist = (ArrayList<MemberVO>)this.jdbcTemplate.query(str.toString()
            , new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
      
      return alist;
   }

   @Override
   public void update(MemberVO memberVO) {
      StringBuffer str = new StringBuffer();
      str.append("update member set passwd = ?, ")
         .append("name = ?, birth = ?, phone = ?, gender = ? ")
         .append("where id = ?");
            
      this.jdbcTemplate.update(str.toString()
            , memberVO.getPasswd(), memberVO.getId(), memberVO.getBirth()
            , memberVO.getPhone(), memberVO.getGender(), memberVO.getId());
      
   }

   @Override
   public void delete(String id) {
      this.jdbcTemplate.update("delete from member where id = ?", id);
   }
   
   @Override
 	public String findId(String name, String phone) {
 		String id = null;
 		StringBuffer str = new StringBuffer();
 		str.append("select id from member where name = ? and phone = ? ");
 		
 		id = this.jdbcTemplate.queryForObject(str.toString(), new Object[] {name, phone} , String.class);
 		return id;
 		
 	}

 	@Override
 	public String findPasswd(String id, String name, String phone) {
 		String passwd = null;
 		StringBuffer str = new StringBuffer();
 		str.append("select passwd from member where id = ? and name =? and phone = ?");
 		
 		passwd = this.jdbcTemplate.queryForObject(str.toString(), new Object[] {id, name, phone}, String.class);
 		return passwd;
 	}
 	/*queryForObject : 단일레코드나 단일 값을 불러올때
 	 * queryFor / queryForList : 다중레코드 다중값,.
 	 * 
 	 * */
	
}