package com.situ.student.service;

import java.util.List;

import com.situ.student.pojo.Banji;
import com.situ.student.vo.FindBanjiByName;
import com.situ.student.vo.PageBean;

public interface IBanjiService {

	List<Banji> findAllBanji();

	PageBean<Banji> pageBean(int pageIndex, int pageSize);

	void deleteById(int id);

	Banji findById(int id);

	void update(Banji banji);

	PageBean<Banji> findBanjiByName(FindBanjiByName findBanjiByName);

	void add(String banji);

}
