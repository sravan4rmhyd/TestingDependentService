package com.sravan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleTestController {
	@RequestMapping("/sample.html")
	public @ResponseBody String getTestResponse(){
		return "welcome to test result";
	}
}
