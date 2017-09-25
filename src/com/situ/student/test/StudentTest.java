package com.situ.student.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.situ.student.dao.StudentDao;
import com.situ.student.dao.TeachDao;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Student;
import com.situ.student.vo.FindByCondition;

public class StudentTest {

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
	public void testFindAll(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		List<Student> list = mapper.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	
	@Test
	public void testFindById(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		Student student = mapper.findById(10);
		System.out.println(student);
	}
	
	
	@Test
	public void testDeleteById(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		mapper.deleteStudent(10);
		session.commit();
	}
	@Resource(name="studentDao")
	private StudentDao studentDao;
	@Test
	public void testcheckName(){
		 ClassPathXmlApplicationContext applicationContext =
		           new ClassPathXmlApplicationContext("applicationContext.xml");
		    // 从容器中获取bean
		 StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");

		int result = studentDao.checkName("李四");
		System.out.println(result+"dfffffffffffffffffff");
	}
	
	
	
	
	@Test
	public void testFindAll1(){
		 ClassPathXmlApplicationContext applicationContext =
		           new ClassPathXmlApplicationContext("applicationContext.xml");
		    // 从容器中获取bean
		 TeachDao teachDao =  (TeachDao) applicationContext.getBean("teachDao");

		List<Student> list = teachDao.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	
	
	
	@Test
	public void testAddStudents(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		Student student = new Student();
		student.setName("小兰");
		student.setAge(20);
		student.setGender("女");
		student.setAddress("青岛");
		student.setBirthday(new Date());
		Banji banji = new Banji();
		banji.setId(1);
		student.setBanji(banji);
		mapper.addStudents(student);
		session.commit();
	}

	
	@Test
	public void testTotalCount(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		int count = mapper.totalCount();
		System.out.println(count);
	}
	
	@Test
	public void testTotalCountByCondition(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		FindByCondition condition = new FindByCondition();
		condition.setName("陈");
		condition.setAge("");
		condition.setGender("");
		//condition.setAge("20");
		int count = mapper.totalCountByCondition(condition);
		System.out.println(count);
	}
	
	
	@Test
	public void testPageBeanList(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		List<Student> list = mapper.pageBeanList(0, 3);

		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testPageBean(){
		 ClassPathXmlApplicationContext applicationContext =
		           new ClassPathXmlApplicationContext("applicationContext.xml");
		    // 从容器中获取bean
		 TeachDao teachDao =  (TeachDao) applicationContext.getBean("teachDao");
		 List<Banji> list = teachDao.pageBeanList(0, 3);
		 for (Banji banji : list) {
			System.out.println(banji);
		}
	}
	
	
	@Test
	public void testFindCondition(){
		SqlSession session = factory.openSession();
		StudentDao mapper = session.getMapper(StudentDao.class);
		FindByCondition findByCondition = new FindByCondition();
		findByCondition.setName("陈");
		/*findByCondition.setAge("20");*/
		findByCondition.setPageIndex(1);
		findByCondition.setPageSize(3);
		Map<Object, Object> map = new HashMap<>();
		map.put("condition", findByCondition);
		map.put("index", 0);
		List<Student> list = mapper.findCondition(map);

		for (Student student : list) {
			System.out.println(student);
		}
	}
}
