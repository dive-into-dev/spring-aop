package dive.dev.aspect;

import java.util.NoSuchElementException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import dive.dev.model.Order;


@Aspect
@Component
public class CustomerOrderAdvice {
  
  //@Before("execution(* dive.dev.controller.CustomerOrderController.*(..))")
  public void beforCustomerOrder(JoinPoint jp) throws Exception {
    System.out.println("@Before "
        + jp.getSignature().getDeclaringTypeName()
        + "."
        + jp.getSignature().getName());
    Order order = (Order) jp.getArgs()[0];
    if (order.getItems() == null || order.getItems().size() == 0) {
      throw new Exception("No items found in the order");
    }
  }
  
  //@AfterReturning(value = "execution(* dive.dev.controller.CustomerOrderController.*(..))",
  //    returning = "ord")
  public void afterReturning(JoinPoint jp, Order order) {
    System.out.println("@AfterReturning "
        + jp.getSignature().getDeclaringTypeName()
        + "."
        + jp.getSignature().getName());
    System.out.println(order.getId());
  }
 
  //@AfterThrowing(value = "execution(* dive.dev.controller.CustomerOrderController.*(..))",
  //    throwing = "ex")
  public void afterThrowing(JoinPoint jp, NoSuchFieldError exc) {
    System.out.println("@AfterThrowing "
        + jp.getSignature().getDeclaringTypeName()
        + "."
        + jp.getSignature().getName());
    System.out.println(exc.getMessage());
  }
  
  //@After("execution(* dive.dev.controller.CustomerOrderController.*(..))")
  public void afterFinally(JoinPoint jp) {
    System.out.println("@After "
        + jp.getSignature().getDeclaringTypeName()
        + "."
        + jp.getSignature().getName());
  }
}
