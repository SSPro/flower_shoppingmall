package com.spring.Hit.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.spring.Hit.dto.Criteria;
import com.spring.Hit.dto.ReplyDto;

public interface ReplyDao {
	// ��� ��ü ����Ʈ ����
	public List<ReplyDto> list(Integer bno) throws Exception;

	// ��� �߰�
	public void create(ReplyDto rto) throws Exception;

	// ���� �߰�
	public void repcreate(ReplyDto rto) throws Exception;

	// ���� ������Ʈ
	public void repupdate(ReplyDto rto) throws Exception;

	// ��� ����
	public void update(ReplyDto rto) throws Exception;

	// ��� ����
	public void delete(Integer rno) throws Exception;

	// ��ۺ���+����¡ó��
	public List<ReplyDto> listPage(Integer bno, Criteria cri) throws Exception;

	// ��ǰ ���� ����
	public int count(Integer bno) throws Exception;

	// ��ǰ��ȣ ����
	public int getItemNo(Integer rno) throws Exception;

	// ����
	// ��� ����
	public int replyCountDao();

	// ��� ��ü ����Ʈ ����
	public List<ReplyDto> replyAllList(Model model);

	// ��ۿ� �޸� ���� ����Ʈ ����
	public List<ReplyDto> replyDtail(int reply_group);
}
