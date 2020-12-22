Spring Cache缓存技术的介绍
缓存用于提升系统的性能，特别适用于一些对资源需求比较高的操作。
本文介绍如何基于spring boot cache技术，使用caffeine作为具体的缓存实现，
对操作的结果进行缓存。

caffeine-cache 这个 module 主要引入了三个依赖：
spring-boot-starter-web
打包了web项目的常规依赖
spring-boot-starter-cache
打包了依赖功能的常规依赖
caffeine
具体的依赖实现
spring cache提供了一层抽象和使用接口，底层可以切换不同的cache实现，
caffeine就是其中之一，且性能表现较优。

spring cache还可以与redis集成，提供分布式缓存的能力。


spring cache常用注解为：@Cacheable、@CachePut、@CacheEvit
@Cacheable 的作用：适用于获取数据，如果缓存中有数据，不在调用注解方法；
@CachePut 的作用：适合于插入数据和更新数据。一定会调用真实方法，再将方法返回值保存到缓存；
@CacheEvict 的作用：适合于删除数据。

spring boot + spring cache 实现两级缓存（redis + caffeine）

<a href="https://gitee.com/uploads/images/2018/0131/093021_342bd812_1092395.png">aaa</a>