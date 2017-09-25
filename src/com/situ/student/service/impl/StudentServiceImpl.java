package com.situ.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.student.dao.StudentDao;
import com.situ.student.exception.NameException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.vo.FindByCondition;
import com.situ.student.vo.PageBean;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

	@Resource(name="studentDao")
	private StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}

	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	@Override
	public void addStudents(Student student) throws NameException{
		int result = studentDao.checkName(student.getName());
		if(result>0){
			throw new NameException("用户名已存在");
		}else {
			studentDao.addStudents(student);
		}
		 
	}

	@Override
	public int checkName(String name) {
		return studentDao.checkName(name);
	}

	@Override
	public PageBean<Student> getPageBean(int pageIndex, int pageSize) {
		PageBean<Student> pageBean = new PageBean<Student>();
		// 当前页
		// private Integer pageIndex;
		pageBean.setPageIndex(pageIndex);
		// 当前页显示的条数
		// private Integer pageSize;
		pageBean.setPageSize(pageSize);
		// 总条数
		// private Integer totalCount;
		int totalCount = studentDao.totalCount();
		pageBean.setTotalCount(totalCount);
		// 总页数
		// private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		// 当前页要显示的数据
		// private List<Student> list;
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = studentDao.pageBeanList(index, pageSize);
		pageBean.setList(list);

		return pageBean;
		
	}

	@Override
	public PageBean<Student> findCondition(FindByCondition condition) {
		PageBean<Student> pageBean = new PageBean<Student>();
		// 当前页
		// private Integer pageIndex;
		pageBean.setPageIndex(condition.getPageIndex());
		// 当前页显示的条数
		// private Integer pageSize;
		pageBean.setPageSize(condition.getPageSize());
		// 总条数
		// private Integer totalCount;
		int totalCount = studentDao.totalCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		// 总页数
		// private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / condition.getPageSize());
		pageBean.setTotalPage(totalPage);
		// 当前页要显示的数据
		// private List<Student> list;
		int index = (condition.getPageIndex() - 1) * condition.getPageSize();
		Map<Object, Object> map = new HashMap<Object,Object>();
		map.put("condition", condition);
		map.put("index", index);
		List<Student> list = studentDao.findCondition(map);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void deleteAll(int[] ids) {
		for (int id : ids) {
			studentDao.deleteStudent(id);
		}
	}

}
