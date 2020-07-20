package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoshu.dao.GradeMapper;
import com.xiaoshu.entity.Grade;

@Service
public class GradeService {
	@Autowired
	private GradeMapper gradeMapper;

	public List<Grade> findAllGrade() {
		// TODO Auto-generated method stub
		List<Grade> list = gradeMapper.selectAll();
		return list;
	}

}
