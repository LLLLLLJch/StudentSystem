package com.situ.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.situ.student.dao.BanjiDao;
import com.situ.student.pojo.Banji;
import com.situ.student.service.IBanjiService;
import com.situ.student.vo.FindBanjiByName;
import com.situ.student.vo.PageBean;

@Service("banjiService")
public class BanjiServiceImpl implements IBanjiService{

	@Resource(name="banjiDao")
	private BanjiDao banjiDao;
	
	public List<Banji> findAllBanji() {
		 ClassPathXmlApplicationContext applicationContext =
		           new ClassPathXmlApplicationContext("applicationContext.xml");
		    // 从容器中获取bean
		   BanjiDao banjiDao = (BanjiDao) applicationContext.getBean("banjiDao");
		return banjiDao.findAll();
	}

	@Override
	public PageBean<Banji> pageBean(int pageIndex, int pageSize) {
		PageBean<Banji> pageBean = new PageBean<Banji>();
		// 当前页
		// private Integer pageIndex;
		pageBean.setPageIndex(pageIndex);
		// 当前页显示的条数
		// private Integer pageSize;
		pageBean.setPageSize(pageSize);
		// 总条数
		// private Integer totalCount;
		int totalCount = banjiDao.totalCount();
		pageBean.setTotalCount(totalCount);
		// 总页数
		// private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		// 当前页要显示的数据
		// private List<Student> list;
		int index = (pageIndex - 1) * pageSize;
		List<Banji> list = banjiDao.pageBeanList(index, pageSize);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void deleteById(int id) {
		banjiDao.deleteById(id);
	}

	@Override
	public Banji findById(int id) {
		return banjiDao.findById(id);
	}

	@Override
	public void update(Banji banji) {
		banjiDao.update(banji);
	}

	@Override
	public PageBean<Banji> findBanjiByName(FindBanjiByName findBanjiByName) {
		PageBean<Banji> pageBean = new PageBean<Banji>();
		// 当前页
		// private Integer pageIndex;
		pageBean.setPageIndex(findBanjiByName.getPageIndex());
		// 当前页显示的条数
		// private Integer pageSize;
		pageBean.setPageSize(findBanjiByName.getPageSize());
		// 总条数
		// private Integer totalCount;
		int totalCount = banjiDao.findBanjiByNameTotalCount(findBanjiByName);
		pageBean.setTotalCount(totalCount);
		// 总页数
		// private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / findBanjiByName.getPageSize());
		pageBean.setTotalPage(totalPage);
		// 当前页要显示的数据
		// private List<Student> list;
		int index = (findBanjiByName.getPageIndex() - 1) * findBanjiByName.getPageSize();
		Map<Object, Object> map = new HashMap<Object,Object>();
		map.put("findBanjiByName", findBanjiByName);
		map.put("index", index);
		List<Banji> list = banjiDao.findBanjiByNamePageBeanList(map);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void add(String banji) {
		banjiDao.add(banji);
	}

}
