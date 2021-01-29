# Nacos Demo

[nacos官方示例](https://nacos.io/zh-cn/docs/quick-start-spring-boot.html)

## boot-nacos-config 配置管理(spring boot 版)
- 自动刷新：@NacosValue + @NacosPropertySource 并且 autoRefreshed都需要配置为true
- pom里不能有`nacos-client`依赖，否则自动刷新不起作用

## nacos-cloud-config 配置管理(spring cloud 版)
- 自动刷新：@Value + @RefreshScope
- 配置spring cloud不起作用，无法使用bootstrap配置文件
  https://www.yisu.com/zixun/373436.html

## nacos-server-discovery 服务发现(spring boot 版)





