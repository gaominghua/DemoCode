package com.tjpu.Reflect.DI_Reflect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)//作用在属性上
@Inherited
@Documented
public @interface AutoWired {
}
