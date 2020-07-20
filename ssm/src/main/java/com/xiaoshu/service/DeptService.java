package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.DeptMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Dept;
import com.xiaoshu.entity.DeptExample;
import com.xiaoshu.entity.DeptExample.Criteria;
import com.xiaoshu.entity.User;

@Service
public class DeptService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	DeptMapper deptMapper;

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
	public void addUser(Dept t) throws Exception {
		deptMapper.insert(t);
	};

	// 修改
	public void updateUser(Dept t) throws Exception {
		deptMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteUser(Integer id) throws Exception {
		deptMapper.deleteByPrimaryKey(id);
	};

	

	// 通过用户名判断是否存在，（新增时不能重名）
	public Dept existUserWithUserName(String userName) throws Exception {
		DeptExample example = new DeptExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(userName);
		List<Dept> userList = deptMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	

	public PageInfo<Dept> findUserPage(Dept dept, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<Dept> userList = deptMapper.finddept(dept);
		PageInfo<Dept> pageInfo = new PageInfo<Dept>(userList);
		return pageInfo;
	}

	public List<Dept> findall() {
	  List<Dept> list=	deptMapper.findall();
		return list;
	}


}
