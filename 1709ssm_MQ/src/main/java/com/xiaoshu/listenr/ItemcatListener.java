package com.xiaoshu.listenr;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiaoshu.entity.Student;
import com.xiaoshu.service.StuService;

@Component
public class ItemcatListener implements MessageListener {
	
	@Autowired
	private StuService ss;

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage textMessage = (TextMessage)message;
		try {
			String cid = textMessage.getText();
		for (int i = 0; i < 3; i++) {

			Student student = new Student();
			student.setSname("张三"+cid+i);
			student.setSex("男");
			student.setCid(Integer.parseInt(cid));
			
			ss.addStu(student);
		}
			
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
