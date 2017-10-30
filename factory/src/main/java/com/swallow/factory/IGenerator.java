package com.swallow.factory;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IGenerator<T> {

    T generateIPhone(Class<T> clazz) throws Exception;

}
