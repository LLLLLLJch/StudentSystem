package com.situ.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.situ.student.pojo.Banji;
import com.situ.student.vo.FindBanjiByName;

public interface BanjiDao {

	List<Banji> findAll();

	int totalCount();

	List<Banji> pageBeanList(@Param(value="pageIndex")int paegIndex, @Param(value="pageSize")int pageSize);

	void deleteById(int id);

	Banji findById(int id);

	void update(Banji banji);

	List<Banji> findBanjiByNamePageBeanList(Map<Object, Object> map);

	int findBanjiByNameTotalCount(FindBanjiByName findBanjiByName);

	void add(String banji);
}
