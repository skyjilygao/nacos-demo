package cn.skyjilygao.nacos.config;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class NacosConfigApplicationTests {

    @Test
    public void registerConfig() {
        Properties properties = new Properties();
        try {
            properties.put(PropertyKeyConst.SERVER_ADDR, "127.0.0.1:8848");
            ConfigService configService = ConfigFactory.createConfigService(properties);
            String dataId, content;
            dataId = "example";
            content = "useLocalCache=false";
            configService.publishConfig(dataId, "DEFAULT_GROUP", content);
            dataId = "example1";
            content = "{\"bmid\":\"13613\",\"token\":\"asdfasdfasddddddddddddadfba\"}";
            configService.publishConfig(dataId, "DEFAULT_GROUP", content);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

}
