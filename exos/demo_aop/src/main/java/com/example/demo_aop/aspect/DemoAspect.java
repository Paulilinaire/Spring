package com.example.demo_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {

    // @Before("execution(* com.example.demo_aop.service.*.*(..) )") //selectionne la totalité des méthode des classes du package service avec 0 argument avec n'importe quel argument // il est possible juste de selectionner type d'argument en mettant dans la dernière paranthèse le type
//    @Before("execution(* com.example.demo_aop.service.*.*(..))") // je spécifie qu'avant l'execution de la méthode "method" dans DemoService, cette action se passe
//    public void addActionBefore(){
//        System.out.println("Action executed before by Aspect");
//    }
//
//    @After("execution(* com.example.demo_aop.service.*.*(..))")
//    public void addActionAfter(){
//        System.out.println("Action executed after by Aspect");
//    }
//
//    @AfterReturning("execution(* com.example.demo_aop.service.*.*(..))")
//    public void addActionAfterReturning(){
//        System.out.println("Action executed after returning value by Aspect");
//    }
//
//    @AfterThrowing("execution(* com.example.demo_aop.service.*.*(..))")
//    public void addActionAfterThrowing(){ // s'execute qu'avec la void method dans demoService parce qu'elle lève une exception (throw an exception)
//        System.out.println("Action executed after throwing exception by Aspect");
//    }

    @Around("execution(* com.example.demo_aop.service.*.*(..))") // = pointcut
    public void addActionAround(ProceedingJoinPoint joinPoint){
        try {
            //Avant
            System.out.println("Start Around");
            //Execute
            //Récupérer les arguments
            Object[] args = joinPoint.getArgs();
            //Utiliser les arguments de la méthode
            joinPoint.proceed();
        } catch (Exception ex){
            //Aprés
            System.out.println("End Around");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("Action executed after throwing exception by Aspect");

    }

    //créer notre pointcut pour notre custom annotation
    @Pointcut("@annotation(com.example.demo_aop.annotation.CustomAnnotation)")
    public void customAnnotationPointCut(){

    }

    @Before("customAnnotationPointCut()")
    public void methodAspectWithAnnotation(){
        System.out.println("Aspect run before with custom annotation");
    }

}
