# ssh_test
1、整合ssh
2、添加shiro权限控制
3、添加登录拦截器

#遇到的问题及解决办法
1、
#question
ssh整合shiro时 Controller层使用Shiro注解@RequiresPermissions后使用@Autowired为Service注入值为空
#answer
结合网上的答案为相应的service接口添加set方法并在set方法上添加@Autowired注解后解决问题

2、
#question
使用拦截器时自定义的拦截器失效
#answer
此处涉及到拦截器的拦截规则（以登录拦截为例）：在未登录情况下除了访问struts中配置的（例如<param name="excludeMethods">index</param>）方法外自动会跳转到login.jsp页面而不执行拦截器的doIntercept方法。若已登录则在访问（接上例）除index之外的方法都会被此拦截器拦截从而执行doIntercept方法。