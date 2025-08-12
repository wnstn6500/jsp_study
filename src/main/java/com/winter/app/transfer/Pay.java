package com.winter.app.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.winter.app.members.MemberVO;

import lombok.extern.slf4j.Slf4j;


@Component
@Aspect
@Slf4j
public class Pay {

	@Around("execution (* com.winter.app.transfer.Transfers.takeSubWay(..))")
	public Object cardCheck(ProceedingJoinPoint joinPoint)throws Throwable {
		System.out.println("탑승전 카드 체크");
		log.info("Args {}", joinPoint.getArgs());
		log.info("target{}", joinPoint.getTarget());
		log.info("kind : {}",joinPoint.getKind());
		MemberVO memberVO = new MemberVO();
		memberVO.setName("123");
		MemberVO [] members = new MemberVO[1];
		members[0] = memberVO;                            
 		Object obj = joinPoint.proceed();
		log.info("return : {}", obj);
		System.out.println("하차시 카드 체크");
		
		return obj;
	}
}
