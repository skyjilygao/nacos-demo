package cn.skyjilygao.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerDiscoveryApplicationTests {

	/**
	 * 创建实例
	 */
	@Test
	void creatInstance() {
		try {
			NamingService namingService = NamingFactory.createNamingService("127.0.0.1:8848");
			namingService.registerInstance("t1", "127.0.0.1", 8081);
			// 创建之后访问：http://localhost:8081/discovery/get?serviceName=t1 即可能看到实例数据
		} catch (NacosException e) {
			e.printStackTrace();
		}
	}

}
