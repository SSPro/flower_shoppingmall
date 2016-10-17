package com.spring.Hit.mail;

import java.util.Map;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
/*
 * google ������ ����ϴ� ��� ���ȼ����� ���� �ۿ��� �������� �����ϵ��� ����ؾ��Ѵ�.
 * ������ġ
 * => https://www.google.com/settings/security/lesssecureapps
 */
@Repository
public class SendMail {
	@Autowired 
	private JavaMailSender mailSender;
	
	public int sendMail(Model model){
		Map<String,Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		try {
			MimeMessage message = mailSender.createMimeMessage();
			String category = req.getParameter("category");	//����
			String title = req.getParameter("title");	//����
			if(category!=null)
				category = "["+category+"] ";
			String subject = category + title;
			String content = req.getParameter("content");//�۳���
			String receiver = req.getParameter("receiver");//�޴»��
			message.setSubject(subject);
            message.setText(content);	//�� ����
            
            message.setRecipients(RecipientType.TO, InternetAddress.parse(receiver));
            mailSender.send(message);
            
            System.out.println("���� ������ ����");
            
		} catch(Exception e){
			System.out.println(e);
			return 0;	//���� ������ ����
		}
		return 1;	//���� ������ ����
	}
}
