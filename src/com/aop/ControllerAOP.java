package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.apache.log4j.Logger;

import com.domain.ResultBean;
import com.utils.ForegoneException;
import com.utils.Log4jFactory;

public class ControllerAOP {
	private static final Logger logger = Log4jFactory.getLogger(ControllerAOP.class);

	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();
		ResultBean<?> result;
		try {
			result = (ResultBean<?>) pjp.proceed();
			logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
		} catch (Throwable e) {
			result = handlerException(pjp, e);
		}
		return result;
	}

	private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
		ResultBean<String> result = new ResultBean<String>();
		// 已知异常
		if (e instanceof ForegoneException) {
			result.setMsg(e.getLocalizedMessage());
			result.setCode(((ForegoneException) e).getErrcode());
			result.setData("");
		} else {
			// 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
			logger.error(pjp.getSignature() + " error ", e);
			result.setMsg(e.toString());
			result.setCode(ResultBean.FAIL);
			result.setData("");
		}
		return result;
	}
}
