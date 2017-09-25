package com.situ.student.service;

import com.situ.student.pojo.Admit;

public interface IAdmitService {

	Admit findByNameAndPassword(String name, String password);

}
