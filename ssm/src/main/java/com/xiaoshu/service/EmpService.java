package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.EmpMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Emp;
import com.xiaoshu.entity.EmpExample;
import com.xiaoshu.entity.EmpExample.Criteria;
import com.xiaoshu.entity.EmpVo;
import com.xiaoshu.entity.User;


@Service
public class EmpService {


	@Autowired
	UserMapper userMapper;
	@Autowired
	EmpMapper empMapper;

	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addUser(Emp t) throws Exception {
		empMapper.insert(t);
	};

	// 修改
	public void updateUser(Emp t) throws Exception {
		empMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteUser(Integer id) throws Exception {
		empMapper.deleteByPrimaryKey(id);
	};

	

	// 通过用户名判断是否存在，（新增时不能重名）
	public Emp existUserWithUserName(String userName) throws Exception {
		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andTbEmpNameEqualTo(userName);
		List<Emp> userList = empMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	


	
	public PageInfo<EmpVo> findUserPage(EmpVo empvO, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<EmpVo> userList = empMapper.findemp(empvO);
		PageInfo<EmpVo> pageInfo = new PageInfo<EmpVo>(userList);
		return pageInfo;
	}


}
