package dive.dev.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerOrderAspect {
	
	@Before("execution(* dive.dev.controller.CustomerOrderController.*(..))")
	public void beforCustomerOrder(JoinPoint jp) {
		System.out.println("@Before");
	}
	
	@Around("execution(* dive.dev.controller.CustomerOrderController.*(..))")
	public Object aroundCustomerOrder(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("@Around Start");
		Object response = joinPoint.proceed();
		System.out.println("@Around End");
		System.out.println("===================================");
		return response;
	}
	
	@AfterReturning("execution(* dive.dev.controller.CustomerOrderController.*(..))")
	public void afterReturning() {
		System.out.println("@AfterReturning");
	}
	
	@AfterThrowing("execution(* dive.dev.controller.CustomerOrderController.*(..))")
	public void afterThrowing() {
		System.out.println("@AfterThrowing");
	}
	
	@After("execution(* dive.dev.controller.CustomerOrderController.*(..))")
	public void afterFinally() {
		System.out.println("@After");
	}

}
