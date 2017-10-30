package com.swallow.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class ProductGenerator<T> implements IGenerator<T> {

    private Map<String, T> map = new HashMap<>();

    @Override
    public T generateIPhone(Class<T> clazz) throws Exception {
        T t;
        if (map.containsKey(clazz.getName())) {
            t = map.get(clazz.getName());
        } else {
            t = (T) Class.forName(clazz.getName()).newInstance();
            map.put(clazz.getName(), t);
        }
        return t;
    }
}
