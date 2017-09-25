package com.situ.student.dao;

import org.apache.ibatis.annotations.Param;

import com.situ.student.pojo.Admit;

public interface AdmitDao {

	Admit findByNameAndPassword(@Param(value="name")String name, @Param(value="password")String password);

}
