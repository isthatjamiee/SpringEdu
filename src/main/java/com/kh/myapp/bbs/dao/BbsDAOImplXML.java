package com.kh.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;

@Repository
public class BbsDAOImplXML implements BbsDAO {

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public void write(BbsDTO bbsdto) {
		sqlsession.insert("insert", bbsdto);
	}

	@Override
	public BbsDTO view(String bNum) {
		return sqlsession.selectOne("view", bNum);
	}

	@Override
	public void updateHit(int bHit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(BbsDTO bbsdto) {
		sqlsession.update("update", bbsdto);

	}

	@Override
	public void delete(int bNum) {
		sqlsession.delete("delete", bNum);

	}

	@Override
	public BbsDTO replyView(int bNum) {
		return sqlsession.selectOne("replyView", bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) {
  sqlsession.insert("reply", bbsdto);
	}

	@Override
	public List<BbsDTO> list(PageCriteria pageCriteria) {
		return sqlsession.selectList("list");
	}

	@Override
	public int totalRec() {
		return sqlsession.selectOne("totalRec");
	}

	@Override
	public List<BbsDTO> list(FindCriteria findCriteria) {
		return sqlsession.selectList("listFindCri", findCriteria);
	}

	@Override
	public int searchTotalRec(FindCriteria findCriteria) {
		return sqlsession.selectOne("searchTotalRec", findCriteria);
	}


}
