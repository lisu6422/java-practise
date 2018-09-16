SpringBoot的Web组件内部集成了hibernate-validator，不需要再导入其他的包。SpringBoot采用了hibernate-validator。

#### 使用验证

<https://docs.jboss.org/hibernate/stable/validator/api/>

#### 自定义验证
自定义验证需要我们提供两个文件内容，一个是注解、另外一个是对应注解继承ConstraintValidator的实现类。

1. 首先创建一个注解，注解内部需要对应验证注解的验证实现类（@Constraint注解，里面传入了一个validatedBy的字段，这个就是我们自定义注解的实现类的类型）；
2. 自定义验证实现类里面有两个方法，分别是初始化验证消息和执行验证。初始化验证消息方法内可以得到配置的注解内容，而验证方法则是你的验证业务逻辑。

<https://github.com/lisu6422/java-practise.git>