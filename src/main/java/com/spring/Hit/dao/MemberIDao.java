package com.spring.Hit.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.Hit.dto.MemberDto;
import com.spring.Hit.dto.ProductDto;

public interface MemberIDao {
	

	//���������� & ������ ��ǰ ����Ʈ
	public List<ProductDto> mainDao();
/*
 * 	�ۼ��� : ������
 * 	������ : 2016.10.3
 */	
	//ȸ�� ����
	public void memberJoinDao(Model model);
	//ID �ߺ� Ȯ��
	public String memberId(Model model);

/*
 * 	�ۼ��� : ������
 * 	������ : 2016.10.3
 */		
	//ȸ�� ���� ����
	public MemberDto viewMemberDao(String id);
	//ȸ�� ���� ����
	public void updateDao(MemberDto dto);
	//ȸ�� ���� ����
	public void deleteDao(String id);
	//�α��� ���� üũ
	public int checkDao(MemberDto dto);
/*
 * 	�ۼ��� : ������
 * 	������ : 2016.10.3
 */	
	// �α���
	public String loginDao(Model model, HttpSession sess);

	
}
