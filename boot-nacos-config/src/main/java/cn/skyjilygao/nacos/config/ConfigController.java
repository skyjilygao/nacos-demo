package cn.skyjilygao.nacos.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
@Controller
@RequestMapping("config")
public class ConfigController {


//    @Value("${useLocalCache:false}")
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;
    /*public void setUseLocalCache(boolean useLocalCache) {
        this.useLocalCache = useLocalCache;
    }*/

    @NacosValue(value = "${token:}", autoRefreshed = true)
    private String token;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }
    @RequestMapping(value = "/{dataId}/get/{key}", method = GET)
    @ResponseBody
    public String get2(@PathVariable String dataId, @PathVariable String key) {
        try {
            Field declaredField = this.getClass().getDeclaredField(key);
            Object o = declaredField.get(this);
            return o.toString();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "error. key="+key;
    }

}