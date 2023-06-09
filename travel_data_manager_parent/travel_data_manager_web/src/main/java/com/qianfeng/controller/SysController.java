package com.qianfeng.controller;

import com.qianfeng.domain.SysLog;
import com.qianfeng.service.ISysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("/sysLog")
@Aspect
@Component
public class SysController {

    @Pointcut(value = "execution(* com.qianfeng.controller.*.*(..))")  // 指定将来需要拦截的controller
    public void pt1(){
    }

    private Date visitTime = null;
    @Resource
    private HttpServletRequest request;

    @Resource
    private ISysLogService sysLogService;
    // 环绕通知
    @Around(value = "pt1()")
    public Object around(ProceedingJoinPoint pdj) throws Throwable {
        visitTime = new Date();
        //1. id
        SysLog sysLog = new SysLog();
        sysLog.setId(UUID.randomUUID().toString());
        //2. username
        SecurityContext securityContext = SecurityContextHolder.getContext();
        User user = (User) securityContext.getAuthentication().getPrincipal();
        String username = user.getUsername();
        sysLog.setUsername(username);
        //3. visitTime
        sysLog.setVisitTime(visitTime);
        //4. ip
        String ip = request.getRemoteAddr();
        sysLog.setIp(ip);
        //5. url
        //5.1 当前用户请求会访问哪个类
        Object target = pdj.getTarget();
        //5.2 获取class对象
        Class targetClass = target.getClass();
        // 5.3 判断类上是否存在@RequestMapping注解
        String url = "";
        String method = null;
        Object[] args = null;
        if(targetClass.isAnnotationPresent(RequestMapping.class)){
            //存在注解
            RequestMapping requestMappingClass = (RequestMapping) targetClass.getAnnotation(RequestMapping.class);
            url += requestMappingClass.value()[0]; // 获取类上的一级映射地址
            String executionMethodName = pdj.getSignature().getName();
            //获取方法执行的参数
            args = pdj.getArgs();
            Class[] params = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                params[i] = args[i].getClass();
            }
            Method excutionMethod = targetClass.getMethod(executionMethodName, params);
            method = targetClass.getName() + "." + excutionMethod.getName();
            //表示判断方法上是否存在@RequestMapping注解
            if(excutionMethod.isAnnotationPresent(RequestMapping.class)){
                RequestMapping requestMappingMethod = excutionMethod.getAnnotation(RequestMapping.class);
                //获取方法上的二级映射地址
                url += requestMappingMethod.value()[0];
            }
        }
        sysLog.setUrl(url);
        //6. method
        sysLog.setMethod(method);
        //7. executionTime
        Long executionTime = new Date().getTime() - visitTime.getTime();
        sysLog.setExecutionTime(executionTime);
        //执行
        Object result = pdj.proceed(args);
        //将sysLog写入数据库
        sysLogService.addSysLog(sysLog);
        //调用sysLogService
        System.out.println(sysLog);
        return result;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mav.addObject("sysLogs", sysLogs);
        mav.setViewName("syslog-list");
        return mav;
    }
}
