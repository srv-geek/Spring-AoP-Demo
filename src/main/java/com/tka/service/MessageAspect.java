package com.tka.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MessageAspect {

//	@Before("execution (public void recharge())")
//	public void beforeMsg() {
//		System.out.println("Your recharge is going to expire soon.. plz recharge...");
//	}
//	
//	@After("execution (public void recharge())")
//	public void afterMsg() {
//		System.out.println("Recharge Done.. Enjoy Your Services...");
//	}

	@Around("execution (* com.tka.entity.MobileRecharge.*())")
	public void aroundMsg(ProceedingJoinPoint pj) {
		System.out.println("Your recharge is going to expire soon.. plz recharge...");
		try {
			pj.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Recharge Done.. Enjoy Your Services...");
	}
}
