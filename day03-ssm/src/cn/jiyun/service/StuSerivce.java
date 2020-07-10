package cn.jiyun.service;

import java.util.List;

import cn.jiyun.pojo.Clazz;
import cn.jiyun.pojo.Stu;

public interface StuSerivce {

	List<Stu> findAll();

	List<Clazz> findClazz();

	int addStu(Stu s);

	int updateStu(Stu s);

	int delStu(Integer[] ids);


}
