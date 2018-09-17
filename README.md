SpringBoot的Web组件内部集成了hibernate-validator，不需要再导入其他的包。SpringBoot采用了hibernate-validator。

### 使用验证

<https://docs.jboss.org/hibernate/stable/validator/api/>

### 级联校验
```java
class Car {
  @NotNull
  private String manufacturer;
  @Valid
  private Driver driver;

  // getter setter
}
```
在校验Car的时候，也同时会校验Driver中的属性。

### 自定义验证
自定义验证需要我们提供两个文件内容，一个是注解、另外一个是对应注解继承ConstraintValidator的实现类。

1. 首先创建一个注解，注解内部需要对应验证注解的验证实现类（@Constraint注解，里面传入了一个validatedBy的字段，这个就是我们自定义注解的实现类的类型）；
2. 自定义验证实现类里面有两个方法，分别是初始化验证消息和执行验证。初始化验证消息方法内可以得到配置的注解内容，而验证方法则是你的验证业务逻辑。

### 分组校验
用来实现部分校验的功能。
* 例如我们在DriverEntity的fields上添加了较多约束，但是在有些场景中我们只需要验证car的部分属性。
* 对一个参数需要多种验证方式时，也可通过分配不同的组达到目的。

> @Validated & @Valid
> 1. 分组
 > @Validated：提供了一个分组功能，可以在入参验证时，根据不同的分组采用不同的验证机;@Validated没有添加groups属性时，默认验证没有分组的验证属性；
 > @Valid：标准JSR-303规范，还没有吸收分组的功能。
> 2. 注解地方
> @Validated：可以用在类型、方法和方法参数上。但是不能用在成员属性（字段）上;
> @Valid：可以用在方法、构造函数、方法参数和成员属性（字段）上;