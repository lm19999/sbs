package com.systop.sbs.common.util;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * 说明：默认接口返回的均是json数据
 *
 * @Package: top.yeliusu.ehcache.demo.utils
 * @Description： webClient工具类
 * @Author: SongJunWei
 * @Date: 2020/5/9
 */
public class WebClientUtils {


    /***天气api前缀*/
    public final static String WEATHER_URL = "https://tianqiapi.com";

    /***短信api前缀*/
    public final static String MESSAGE_URL = "http://www.btom.cn:8080";

    /***构建webClient*/
    private static WebClient webClient = WebClient.builder().baseUrl(WEATHER_URL).build();

    /**
     * 通用post方法提交
     * <p>
     * 使用：parameter可传递对象、json；
     * map以及单独参数传递未测试，应该也可以
     *
     * @param url       接口路径（无前缀）
     * @param parameter 参数
     * @return 返回数据
     */
    public static <T> Map<String, Object> wcPost(String url, T parameter) {
        Mono<Map> mono = webClient
                //POST 请求
                .post()
                //接口地址
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                //参数
                .body(Mono.just(parameter), parameter.getClass())
                //获取响应体
                .retrieve()
                //响应数据类型转换
                .bodyToMono(Map.class)
                //6秒超时
                .timeout(Duration.ofSeconds(6));
        return mono.block();
    }

    /**
     * 通用get方式提交
     * 适用：？&形式的接口路径提交
     * <p>
     * 使用方法：
     * 1、普通的form表单形式：需要定义一个 multiValueMap，将参数以kv的方式传入此map,然后调用方法
     * 2、bean对象形式：将bean传入beanTransformationMap()，将返回的值作为参数，调用方法
     *
     * @param url    接口路径（无前缀）
     * @param params MultiValueMap类型参数
     * @return Map<String, Object>
     */
    public static Map<String, Object> wcGet(String url, MultiValueMap<String, String> params) {
        Mono<Map> mono = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(url)
                        .queryParams(params)
                        .build())
                //获取响应体
                .retrieve()
                //响应数据类型转换
                .bodyToMono(Map.class)
                //6秒超时
                .timeout(Duration.ofSeconds(6));
        Map<String, Object> block = mono.block();
        return block;
    }

    /**
     * get方式提交
     * 适用：/user/list/{1}/{2}形式的路径变量传递参数，参数list中的顺序必须和接口一致
     * <p>
     * 缺点：只有一个参数时也需要定义一个list,项目传递参数较少时，可新建一个单独的方法，用于单独的参数提交
     *
     * @param url    接口路径（无前缀）
     * @param params 参数集合
     * @return Map<String, Object>
     */
    public Map<String, Object> wcGetByUrl(String url, List<String> params) {
        StringBuilder newUrl = new StringBuilder(url);
        for (String param : params) {
            newUrl.append("/{").append(param).append("}");
        }
        System.out.println(newUrl);
        Mono<Map> mono = webClient
                .get()
                .uri(String.valueOf(newUrl))
                //获取响应体
                .retrieve()
                //响应数据类型转换
                .bodyToMono(Map.class)
                //6秒超时
                .timeout(Duration.ofSeconds(6));
        return mono.block();
    }

    /**
     * 使用get方式，以对象进行传参时使用
     * 作用：将对象转为 MultiValueMap
     * <p>
     * 使用方法：
     * 1.将bean对象传进该方法；2.调用wcGet(url,第1步的返回值)接口将1的返回值传入。
     *
     * @param beanParams 对象参数
     * @return MultiValueMap<String, String>
     */
    public static <T> MultiValueMap<String, String> beanTransformationMap(T beanParams) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        try {
            Field[] fields = beanParams.getClass().getDeclaredFields();
            for (Field field : fields) {
                //设置是否允许访问，不是修改原来的访问权限修饰词。
                field.setAccessible(true);
                if (!StringUtils.isEmpty(field.get(beanParams))) {
                    multiValueMap.add(field.getName(), field.get(beanParams).toString());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return multiValueMap;
    }

}
