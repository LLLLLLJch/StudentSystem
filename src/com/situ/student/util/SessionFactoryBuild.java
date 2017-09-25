package com.situ.student.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryBuild {

	public static  SqlSessionFactory getSqlSession() {
		SqlSessionFactory factory;
		String resource = "mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建SqlSessionFactory
		return new SqlSessionFactoryBuilder().build(inputStream);

	}
}
