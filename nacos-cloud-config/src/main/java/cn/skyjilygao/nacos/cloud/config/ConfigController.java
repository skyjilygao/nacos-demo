package cn.skyjilygao.nacos.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RefreshScope
@Controller
@RequestMapping("config")
public class ConfigController {

//    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    @Value(value = "${useLocalCache:false}")
    private boolean useLocalCache;

//    @NacosValue(value = "${token:}", autoRefreshed = true)
    @Value(value = "${token:}")
    private String token;

    @RefreshScope
    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }
    @RequestMapping(value = "/get/{key}", method = GET)
    @ResponseBody
    public String get2(@PathVariable String key) {
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