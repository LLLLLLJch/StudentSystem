package com.situ.student.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.situ.student.dao.BanjiDao;
import com.situ.student.dao.StudentDao;
import com.situ.student.pojo.Banji;

public class BanjiTest {

private SqlSessionFactory factory;
	
	@Before
	public void before() {
		String resource = "mybatis.xml";
	       InputStream inputStream = null;
	       try {
	           inputStream = Resources.getResourceAsStream(resource);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       // 创建SqlSessionFactory
	       factory = new SqlSessionFactoryBuilder().build(inputStream);
	       
	}
	
	@Test
	public void testFindAll() {
		SqlSession session = factory.openSession();
		BanjiDao mapper = session.getMapper(BanjiDao.class);
		List<Banji> list = mapper.findAll();
		for (Banji banji : list) {
			System.out.println(banji);
		}
	}
	
	
	@Test
	public void testTotalCount() {
		SqlSession session = factory.openSession();
		BanjiDao mapper = session.getMapper(BanjiDao.class);
		int count = mapper.totalCount();
		System.out.println(count);
	}
	
	@Test
	public void testPageBeanList() {
		SqlSession session = factory.openSession();
		BanjiDao mapper = session.getMapper(BanjiDao.class);
		List<Banji> list = mapper.findAll();
		for (Banji banji : list) {
			System.out.println(banji);
		}
	}
}
