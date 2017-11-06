package com.statusinquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.ResultBean;

@Controller
public class StatusInquiryController {

	@Autowired
	private StatusInquiryService statusInquiryService;

	@RequestMapping(value = "/test")
	@ResponseBody
	public ResultBean<Boolean> test() throws Exception {
		return new ResultBean<Boolean>(statusInquiryService.test());
	}
}
