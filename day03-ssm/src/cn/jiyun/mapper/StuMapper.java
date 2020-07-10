package cn.jiyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import cn.jiyun.pojo.Clazz;
import cn.jiyun.pojo.Stu;

public interface StuMapper {

	List<Stu> findAll();

	List<Clazz> findClazz();

	int addStu(Stu s);

	int updateStu(Stu s);

	int delStu(@Param("ids")Integer[] ids);

}
