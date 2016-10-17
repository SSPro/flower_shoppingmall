package com.spring.Hit.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.spring.Hit.dto.MemberDto;
import com.spring.Hit.dto.ProductDto;

@Repository
public class MemberIDaoImpl implements MemberIDao{
	@Inject
	private SqlSession session;
	
	@Override
	public List<ProductDto> mainDao() {
		// TODO Auto-generated method stub
		return null;
	}
/*
 * 	�ۼ��� : ������
 * 	������ : 2016.10.3
 */	
	@Override
	public void memberJoinDao(Model model) {
		// TODO Auto-generated method stub
		Map<String,Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		Date birthday = Date.valueOf(req.getParameter("birthday"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		MemberDto dto = new MemberDto(id, password, name, birthday, email, phone, null, gender, 0, new Timestamp(System.currentTimeMillis()/1000), 0, 0, null);
		session.insert("memberJoinDao", dto);
	}

	@Override
	public String memberId(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		String id = req.getParameter("id");
		
		return session.selectOne("memberId",id);
	}	
/*
 * 	�ۼ��� : ������
 * 	������ : 2016.10.3
 */	
	@Override
	public MemberDto viewMemberDao(String id) {
		// TODO Auto-generated method stub
		return (MemberDto) session.selectOne("viewMemberDao", id);
	}
	@Override
	public String updateMemberDao(Model model, HttpSession sess) {
		// TODO Auto-generated method stub
		Map<String,Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		String id = (String)sess.getAttribute("id");
		String passwords = (String)sess.getAttribute("password");	//������ ��й�ȣ
		String password1 = req.getParameter("password1");			//���� ��й�ȣ
		String types = req.getParameter("types");				//������ Į��
		String value = req.getParameter("value");				//������ ��
		if(passwords.equals(password1)){
			MemberDto dto = new MemberDto();
			value = types+" = '"+ value+"'";
		    dto.setId(id);
			dto.setName(value);
			session.update("updateMemberDao", dto);
			return "redirect:myPage";
		}else{
			return "redirect:myPage";
		}
	}
	//ȸ�� ����
	@Override
	public String deleteMemberDao(Model model, HttpSession sess) {
		// TODO Auto-generated method stub
		Map<String,Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		String id = (String)sess.getAttribute("id");
	    String password = req.getParameter("password");
	    MemberDto dto = new MemberDto();
	    dto.setId(id);
	    dto.setPassword(password);
	    
		int result = session.delete("deleteMemberDao", dto);
		
		if(result==1){
			sess.removeAttribute("id");
			return "redirect:main";
		}else{
			return "redirect:myPage";
		}
		
	}
	
	@Override
	public int checkDao(MemberDto dto) {
		// TODO Auto-generated method stub
		return session.selectList("checkDao", dto).size();
	}
/*
 * 	�ۼ��� : ������
 * 	������ : 2016.10.3
 */
   @Override
   public String loginDao(Model model, HttpSession sess) {
      // TODO Auto-generated method stub
	   
	   Map<String,Object> map = model.asMap();
	   HttpServletRequest req = (HttpServletRequest)map.get("req");
	   String id = req.getParameter("id");
	   String password = req.getParameter("password");
	   MemberDto dto = new MemberDto(id, password, null, null, null, null, null, null, 0, new Timestamp(System.currentTimeMillis()/1000), 0, 0, null);
	   dto = session.selectOne("loginDao", dto);
	   // dao�κ��� id,pwd�� �Ѱܼ� �����ͺ��̽����� �α��ε� ��������� �ƴ����� �Ǻ�
	   if (dto!=null&&dto.getId().equals(id)) {
			// �α��� �� ����� �̱� ������ ������ �����Ѵ�.
		   sess.setAttribute("id", id);
		   sess.setAttribute("password", password);
		   sess.setAttribute("name", dto.getName());
		   sess.setAttribute("logininfo", true);
		   System.out.println("Login ����!");
		   return "redirect:main";
	   } else {
			// �߸��� �����̶�� �並 �����ֵ��� ���� ������ ����.
		   System.out.println("�߸��� ����");
		   return "redirect:loginForm";
	   }
      
   }
   
}
