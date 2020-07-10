package cn.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiyun.pojo.Clazz;
import cn.jiyun.pojo.Stu;
import cn.jiyun.service.StuSerivce;

@Controller
@RequestMapping("stu")
public class stuController {
		@Autowired
		private StuSerivce ss;
		@RequestMapping("findall")
		public String findALL(){
			return "show2";
		}
	@RequestMapping("toshow")
	@ResponseBody
	public List<Stu> toshow(){
		List<Stu> slist=ss.findAll();
		System.out.println(slist);
		return slist;
	}
	@RequestMapping("toadd")
	public String toadd(){
		return "add";
	}
	@ResponseBody
	@RequestMapping("findClazz")
	public List<Clazz> findClazz(){
		List<Clazz> clist=ss.findClazz();
		return  clist;
	}
	@ResponseBody
	@RequestMapping("addStu")
	public int addStu(@RequestBody Stu s){
		int i= ss.addStu(s);
		return i;
	}
	@ResponseBody
	@RequestMapping("updateStu")
	public int updateStu(@RequestBody Stu s){
		int i=ss.updateStu(s);
		return i;
	}
	@ResponseBody
	@RequestMapping("delStu")
	public int delStu(@RequestBody Integer [] ids){
		int i=ss.delStu(ids);
		return i;
	}
}
