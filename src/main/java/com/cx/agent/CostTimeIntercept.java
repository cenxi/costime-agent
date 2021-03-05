package com.cx.agent;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author :fengxi
 * @date :Created in 2021/3/5 4:57 下午
 * @description：
 * @modified By:
 */
public class CostTimeIntercept {

    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            // 原有函数执行
            return callable.call();
        } finally {
            System.out.println(method.getName() + " 方法耗时：" + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
