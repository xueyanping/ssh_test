# ssh_test
1、整合ssh
2、添加shiro权限控制
3、添加登录拦截器
4、增加文件上传功能
5、上传sql文件至github
6、多文件上传
7、文件下载


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

3、
#question
继问题1发现使用shiro的@RequiresPermissions在整合cxf时@Autowired和set方法两种注入方法同时失效
#answer
这是由于shiro的加载顺序实在bean之前就已经注入了的（此时还是不理解，待以后填坑），根本原因是使用的Shiro的@RequiresPermissions注解，因此建议以后将需要授权的方法写在xml配置文件中，这样@Autowired就完全正常注入了（该问题困扰两天后得出此解决方法，以后有更好的的方法再补充）

4、
#question
(1)文件上传时无法上传指定类型文件（如.rar,.pdf,.avi,.mp4）
(2)上传出错时抛出 no result and input错误
(3)不能上传大文件
#answer
(1)无法上传指定文件是由于在默认的拦截器栈中配置了<param name="fileUpload.allowedExtensions">，其中没有添加需要上传的文件后缀名（多个后缀名用逗号隔开如.pdf,.avi.rar）
(2)抛出该错误是由于上传文件出现错误并且没有在struts.xml中配置name为“input”的result标签
(3)默认上传的文件大小为2M，若要超出2M则需要在struts.xml中配置文件上传的总大小有两种配置方式
第一种是配置常量如：
<constant name="struts.multipart.maxSize" value="40000000"></constant>
第二种是在默认拦截器栈中配置
<param name="fileUpload.maximumSize">40000000</param>
5、
#question
文件下载抛出 cannot find inputName错误说明需要下载的文件的路径没有找到或书写错误
#answer
路径分两种第一种是要下载的文件存放在工程中的webContent下可以通过
ServletActionContext.getServletContext().getResourceAsStream(webappsDir+"\\upload\\"+filename)的方式获得
注：在struts中配置的如inputStream filename不需要在action中声明相应属性只需要提供相应的get方法即可
第二种要下载的文件不存在于项目中而在本地存储需要通过inputStream = new FileInputStream(new File(webappsDir+"\\upload\\"+filename))获取输入流
下载的过程：
1、先找到下载的方法**.action,通过方法返回的字符串与struts配置的result相匹配
2、执行获取输入流inputStream的方法getInputStream,最后获取下载的文件的文件名及后缀名
