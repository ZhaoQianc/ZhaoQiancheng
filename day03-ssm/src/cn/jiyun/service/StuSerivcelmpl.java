package cn.jiyun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiyun.mapper.StuMapper;
import cn.jiyun.pojo.Clazz;
import cn.jiyun.pojo.Stu;

@Service
public class StuSerivcelmpl implements StuSerivce {
		@Autowired
		private StuMapper sm;

		public List<Stu> findAll() {
			// TODO Auto-generated method stub
			List<Stu> list=sm.findAll();
			return list;
		}

		public List<Clazz> findClazz() {
			// TODO Auto-generated method stub
			List<Clazz> clist=sm.findClazz();
			return clist;
		}

		public int addStu(Stu s) {
			// TODO Auto-generated method stub
			int i=sm.addStu(s);
			return i;
		}

		public int updateStu(Stu s) {
			// TODO Auto-generated method stub
			int i=sm.updateStu(s);
			return i;
		}

		public int delStu(Integer[] ids) {
			// TODO Auto-generated method stub
			int i=sm.delStu(ids);
			return i;
		}
		
		
}
