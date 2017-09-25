package com.situ.student.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.student.dao.TeachDao;
import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Course;
import com.situ.student.pojo.Student;
import com.situ.student.pojo.Teach;
import com.situ.student.service.ITeachService;
import com.situ.student.vo.PageBean;
@Service("teachService")
public class TeachServiceImpl implements ITeachService{

	@Resource(name="teachDao")
	private TeachDao teachDao;
	

	@Override
	public List<Student> findAll() {
		return teachDao.findAll();
	}

/*	@Override
	public PageBean<Teach> pageBean(List<Banji> list, int pageIndex, int pageSize) {
		PageBean<Teach> pageBean = new PageBean<Teach>();
		// 当前页
				// private Integer pageIndex;
				pageBean.setPageIndex(pageIndex);
				// 当前页显示的条数
				// private Integer pageSize;
				pageBean.setPageSize(pageSize);
				// 总条数
				// private Integer totalCount;
				int totalCount = teachDao.totalCount();
				pageBean.setTotalCount(totalCount);
				// 总页数
				// private Integer totalPage;
				int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
				pageBean.setTotalPage(totalPage);
				// 当前页要显示的数据
				// private List<Student> list;
				int index = (pageIndex - 1) * pageSize;
		Set<Integer> set = new HashSet<Integer>();
		for (Banji banji : list) {
			Integer banjiId = banji.getId();
			set.add(banjiId);
		}
		String banjiName = null;
		String courseName = "";
		String courseName1 = "";
		List<Teach> listNew = new ArrayList<Teach>();
		for (Integer banjiId : set) {
			for (Banji banji : list) {
				if(banji.getId() == banjiId){
					banjiName = banji.getName();
				}
			}
			for (Banji banji : list) {
				for (Course course : banji.getCourseList()) {
					if(banji.getId() == banjiId){
						courseName = null;
						 courseName =courseName + "  , " + course.getName();
					}
				}
			}
			Teach teach = new Teach(banjiId, banjiName, courseName);
			listNew.add(teach);
			pageBean.setList(listNew);
		}
		return pageBean;
	}*/

	@Override
	public void addCourse(int banjiId, int addCourse) {
		teachDao.addCourse(banjiId,addCourse);
	}

	@Override
	public List<Teach> pageBean(List<Banji> list) {
		Set<Integer> set = new HashSet<Integer>();
		for (Banji banji : list) {
			Integer banjiId = banji.getId();
			set.add(banjiId);
		}
		String banjiName = null;
		String courseName = "";
		List<Teach> listNew = new ArrayList<Teach>();
		for (Integer banjiId : set) {
			for (Banji banji : list) {
				if(banji.getId() == banjiId){
					banjiName = banji.getName();
				}
			}
			for (Banji banji : list) {
				
				for (Course course : banji.getCourseList()) {
				
					if(banji.getId() == banjiId){
						 courseName =courseName + "  , " + course.getName();
					}
				}
			}
			Teach teach = new Teach(banjiId, banjiName, courseName);
			listNew.add(teach);
			courseName = "";
		}
		return listNew;
	}

	@Override
	public List<Banji> teach() {
		return teachDao.teach();
	}

	@Override
	public void delCourse(int parseInt, int parseInt2) {
		teachDao.delCourse(parseInt,parseInt2);
	}


}
