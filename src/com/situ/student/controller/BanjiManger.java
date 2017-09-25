package com.situ.student.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.student.pojo.Banji;
import com.situ.student.service.IBanjiService;
import com.situ.student.vo.FindBanjiByName;
import com.situ.student.vo.PageBean;

@Controller
@RequestMapping(value="/banji")
public class BanjiManger {
	@Resource(name="banjiService")
	private IBanjiService banjiService;
	
	@RequestMapping(value="/findAllBanji")
	public String findAllBanji(Model model) {
		List<Banji> banji_list = banjiService.findAllBanji();
		model.addAttribute("banji_list",banji_list);
		return "banji_list";
	}
	
	@RequestMapping(value="/pageBean")
	public String pageBean(String pageIndexStr,String pageSizeStr,Model model){
		int pageIndex = 1;
		if(pageIndexStr != null && !pageIndexStr.equals("")){
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;
		if(pageIndexStr != null && !pageIndexStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Banji> pageBean = banjiService.pageBean(pageIndex,pageSize);
		model.addAttribute("pageBean",pageBean);
		return "banji_list";
		
	}
	
	@RequestMapping("/deleteBanji")
	public String deleteBanji(int id) {
		banjiService.deleteById(id);
		return "redirect:/banji/findBanjiCondition.action";
		
	}
	
	@RequestMapping(value="/getAddPage")
	public String getAddPage() {
		return "banji_add";
	}
	@RequestMapping(value="/add")
	public String add(Model model,String banji) {
		banjiService.add(banji);
		return "redirect:/banji/findBanjiCondition.action";
		
	}
	
	@RequestMapping("/toUpdateBanji")
	public String toUpdateBanji(int id,Model model) {
		Banji banji = banjiService.findById(id);
		model.addAttribute("banji", banji);
		return "banji_update";
	}
	
	@RequestMapping("/updateBanji")
	public String updateBanji(Banji banji) {
		banjiService.update(banji);
		return "redirect:/banji/findBanjiCondition.action";
		
	}
	
	@RequestMapping(value="findBanjiCondition")
	private String findBanjiCondition(HttpServletRequest req,Model model) {
		String name = req.getParameter("name");
		System.out.println(name);
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		int pageIndex = 1;
		if(pageIndexStr != null && !pageIndexStr.equals("")){
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;
		if(pageSizeStr != null && !pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		FindBanjiByName findBanjiByName = new FindBanjiByName(name,pageIndex,pageSize);
		PageBean<Banji> pageBean = banjiService.findBanjiByName(findBanjiByName);
		model.addAttribute("pageBean", pageBean);
		return "banji_list";
		
	}
}
