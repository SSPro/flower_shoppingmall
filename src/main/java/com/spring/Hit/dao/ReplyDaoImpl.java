package com.spring.Hit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.spring.Hit.dto.Criteria;
import com.spring.Hit.dto.ReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Inject
	private SqlSession session;

	private static String namespace = "com.spring.Hit.dao.ReplyDao";

	// ��� ����Ʈ
	@Override
	public List<ReplyDto> list(Integer item_no) throws Exception {

		return session.selectList(namespace + ".list", item_no);
	}

	// ��� ����
	@Override
	public void create(ReplyDto rdt) throws Exception {
		session.insert(namespace + ".create", rdt);
	}

	// ���� ����
	@Override
	public void repcreate(ReplyDto rdt) throws Exception {
		session.insert(namespace + ".repcreate", rdt);
	}

	// ���� ������Ʈ
	@Override
	public void repupdate(ReplyDto rdt) throws Exception {
		session.update(namespace + ".repupdate", rdt);
	}

	// ��� ����
	@Override
	public void update(ReplyDto rdt) throws Exception {
		session.update(namespace + ".update", rdt);
	}

	// ��� ����
	@Override
	public void delete(Integer reply_no) throws Exception {

		session.delete(namespace + ".delete", reply_no);
	}

	// ��� ����Ʈ & ����¡ó��
	@Override
	public List<ReplyDto> listPage(Integer item_no, Criteria cri) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("item_no", item_no);
		paramMap.put("cri", cri);

		return session.selectList(namespace + ".listPage", paramMap);
	}

	// ��ǰ��ȣ(item_no) ��
	@Override
	public int count(Integer item_no) throws Exception {

		return session.selectOne(namespace + ".count", item_no);
	}

	// ��ǰ��ȣ ����
	@Override
	public int getItemNo(Integer reply_no) throws Exception {
		return session.selectOne(namespace + ".getItemNo", reply_no);
	}

	// ����
	@Override
	public int replyCountDao() {
		return session.selectOne("replyCountDao");
	}

	@Override
	public List<ReplyDto> replyAllList(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest) map.get("req");
		int strNum = 1;
		if (req.getParameter("strNum") != null) {
			strNum = Integer.parseInt(req.getParameter("strNum"));
		}
		return session.selectList("replyList", strNum);
	}

	@Override
	public List<ReplyDto> replyDtail(int reply_group) {
		return session.selectList("replyDtail", reply_group);
	}

}
