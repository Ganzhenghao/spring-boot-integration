package com.example.springbootbeansearchstudy.config;

import com.ejlchina.json.JSONKit;
import com.ejlchina.searcher.BeanMeta;
import com.ejlchina.searcher.ParamFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2022/5/5 10:27
 */
@Configuration
public class BeanSearcherConfig {

    /**
     * 简化参数过滤器
     * 对于 op=mv / bt 的查询，可用 JSON 数组来传输多个值，
     * 例如：age=[20,30] 替代 age-0=20&age-1=30 对于 op=mv / bt 的查询，
     * 如何用 JSON 数组来传输多个值，
     * 例如：age=[20,30] 替代 age-0=20&age-1=30 on 26 Nov 2021
     * https://github.com/ejlchina/bean-searcher/issues/10
     *
     * @return {@link ParamFilter}
     */
    @Bean
    public ParamFilter myParamFilter() {
        return new ParamFilter() {

            final String OP_SUFFIX = "-op";

            @Override
            public <T> Map<String, Object> doFilter(BeanMeta<T> beanMeta, Map<String, Object> paraMap) {
                Map<String, Object> newParaMap = new HashMap<>();
                paraMap.forEach((key, value) -> {
                    if (key == null) {
                        return;
                    }
                    boolean isOpKey = key.endsWith(OP_SUFFIX);
                    String opKey = isOpKey ? key : key + OP_SUFFIX;
                    Object opVal = paraMap.get(opKey);
                    if (!"mv".equals(opVal) && !"bt".equals(opVal)) {
                        newParaMap.put(key, value);
                        return;
                    }
                    if (newParaMap.containsKey(key)) {
                        return;
                    }
                    String valKey = key;
                    Object valVal = value;
                    if (isOpKey) {
                        valKey = key.substring(0, key.length() - OP_SUFFIX.length());
                        valVal = paraMap.get(valKey);
                    }
                    if (likelyJsonArr(valVal)) {
                        try {
                            String vKey = valKey;
                            JSONKit.toArray((String) valVal).forEach(
                                    (index, data) -> newParaMap.put(vKey + "-" + index, data.toString())
                            );
                            newParaMap.put(opKey, opVal);
                            return;
                        } catch (Exception ignore) {}
                    }
                    newParaMap.put(key, value);
                });
                return newParaMap;
            }

            private boolean likelyJsonArr(Object value) {
                if (value instanceof String) {
                    String str = ((String) value).trim();
                    return str.startsWith("[") && str.endsWith("]");
                }
                return false;
            }

        };
    }
}
