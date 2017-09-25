package com.situ.student.service.impl;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.situ.student.dao.AdmitDao;
import com.situ.student.dao.BanjiDao;
import com.situ.student.pojo.Admit;
import com.situ.student.service.IAdmitService;

public class AdmitServiceImpl implements IAdmitService{

	@Resource(name="admitDao")
	private AdmitDao admitDao;

	@Override
	public Admit findByNameAndPassword(String name, String password) {
		 ClassPathXmlApplicationContext applicationContext =
		           new ClassPathXmlApplicationContext("applicationContext.xml");
		    // 从容器中获取bean
		   AdmitDao  admitDao = (AdmitDao) applicationContext.getBean("admitDao");
		return admitDao.findByNameAndPassword(name,password);
	}
}
