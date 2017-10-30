package com.swallow;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface ILinster {
     abstract <T extends Weather> T generatePhone(Class<T> clazz) throws Exception;
}
