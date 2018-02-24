package com.datayang.controller;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datayang.pojo.Dome;
import com.datayang.service.DomeService;

@RestController
public class IndexController {
	@Resource
	private DomeService domeService;
	@RequestMapping("/")
    Dome home(ModelMap map) {
	     return domeService.findDomeById(1);  
    }
}
