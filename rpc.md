---
title: simple-rpc-framework
---
# simple-rpc-framework
## 项目简介
### 项目地址
https://github.com/kanggama857/simple-rpc-framework
>RPC（Remote Procedure Call Protocol）远程过程调用协议。一个通俗的描述是：客户端在不知道调用细节的情况下，调用存在于远程计算机上的某个对象，就像调用本地应用程序中的对象一样。

> RPC 协议只规定了 Client 与 Server 之间的点对点调用流程，包括 stub、通信协议、RPC 消息解析等部分，在实际应用中，还需要考虑服务的高可用、负载均衡等问题，所以这里的 RPC 框架指的是能够完成 RPC 调用的解决方案，除了点对点的 RPC 协议的具体实现外，还可以包括服务的发现与注销、提供服务的多台 Server 的负载均衡、服务的高可用等更多的功能。

因为在项目中会不时用到RPC框架，出于对底层原理的好奇，有了这个项目

simple-rpc-framework是一个开源的项目，**任何企业和个人可以免费学习使用**
- 实现了**代理层、路由层、注册中心层、序列化层、协议层、容错层**。
- 采用 Zookeeper 作为服务注册和发现中心，实现了**服务注册、服务心跳检测、服务上下线通知机制**。
- 提供了轮询、加权轮询、随机选择、一致性 Hash 等算法进行**负载均衡**。
- 使用**责任链设计模式**过滤请求，在执行请求处理前进行分组转发、日志记录等操作。
- 在容错层中引入**超时重传与服务限流**机制，实现服务稳定性治理，确保服务的高可用性。
- 通过压力测试，在 100/1000/10000 的并发场景下，RPC调用的响应速度与结果均保持不变，确认框架**高可用**。
## 项目架构图
### 技术架构图

![rpc-process.png](https://kanggama857.github.io/img/rpc-process.png)
## 项目用到的技术

- Java 1.8
- Maven
- netty
- zookeeper
- junit
- guava
- Lombok
- protostuff
- hessian
- kryo
## 项目模块说明
```
├── rpc-consumer
│   ├── rpc-consumer-demo          -> 未接入spring：consumer测试类
│   └── rpc-consumer-spring        -> 接入spring：consumer本地服务接口
├── rpc-core                       -> rpc核心实现逻辑模块
├── rpc-interface                  -> 远程服务接口
├── rpc-provider
│   ├── rpc-provider-demo          -> 未接入spring：provider测试类
│   ├── rpc-provider-goods         -> 接入spring：provider远程服务
│   ├── rpc-provider-pay           -> 接入spring：provider远程服务
│   └── rpc-provider-user          -> 接入spring：provider远程服务
├── rpc-spring-starter             -> spring-starter接入类
└── simple-rpc                     -> 简易rpc
```
## 如何使用本项目

- 进入rpc-provider模块下，分别运行rpc-provider-goods、rpc-provider-pay、rpc-provider-user三个服务启动类
- 进入rpc-consumer/rpc-consumer-spring模块下，运行服务启动类
- Consumer默认端口为8081，在浏览器中输入 http://localhost:8081/api-test/do-test 进行远程服务调用基本测试