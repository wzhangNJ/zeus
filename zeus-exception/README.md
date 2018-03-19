------
## 异常处理：

#### Java异常的分类和类结构图

Java标准裤内建了一些通用的异常，这些类以Throwable为顶层父类。

Throwable又派生出Error类和Exception类。

错误：Error类以及他的子类的实例，代表了JVM本身的错误。错误不能被程序员通过代码处理，Error很少出现。因此，程序员应该关注Exception为父类的分支下的各种异常类。

异常：Exception以及他的子类，代表程序运行时发送的各种不期望发生的事件。可以被Java异常处理机制使用，是异常处理的核心。
![image](../img/1519785904.jpg)

## 项目中如何优雅的处理异常
#### 自定义基础异常类BaseException
##### 项目中开发者自定义异常需要继承此基础异常类
##### 通过ExceptionHandler由框架统一处理异常