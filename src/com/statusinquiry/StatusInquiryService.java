package com.statusinquiry;

import org.springframework.stereotype.Service;

import com.utils.ForegoneException;

@Service
public class StatusInquiryService {

	public Boolean test() throws ForegoneException, Exception {

		// throw new ForegoneException("test exception", -10000);
		// throw new Exception("test exception");
		return true;
	}

}
