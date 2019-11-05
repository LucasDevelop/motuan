package com.futrue.frame.data.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 目标{}后端给[] null ""返回 null
 * 目标{}后端给 非空String 返回 真实对象
 * 目标[]后端给{} null "" 返回空数组
 * 目标[]后端给String返回 真实数组
 * 兼容 String 里面包含Object/Array 多层嵌套 不管多复杂杂乱的数据 都可以解析成bean 或 list
 */
public class CustomGson {

    /**
     * 生成注册自定义的对象处理器与集合处理器的Gson，方法
     *
     * @return
     */
    public static Gson newGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls().setDateFormat("yyyy-MM-dd").setPrettyPrinting();
        Class builder = (Class) gsonBuilder.getClass();
        Field f = null;
        try {
            //通过反射得到构造器
            f = builder.getDeclaredField("instanceCreators");
            f.setAccessible(true);
            final Map<Type, InstanceCreator<?>> val = (Map<Type, InstanceCreator<?>>) f.get(gsonBuilder);//得到此属性的值
            //注册String类型处理器
            // 这个不需要
//            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(String.class,GsonTools.stringTypeAdapter()));
            //注册int.class, Integer.class处理器
            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, GsonTools.longAdapter(0)));
            //注册short.class, Short.class处理器
            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(short.class, Short.class, GsonTools.longAdapter(1)));
            //注册long.class, Long.class处理器
            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, GsonTools.longAdapter(2)));
            //注册double.class, Double.class处理器
            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, GsonTools.longAdapter(3)));
            //注册float.class, Float.class处理器
            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, GsonTools.longAdapter(4)));
            //注册反射对象的处理器
            gsonBuilder.registerTypeAdapterFactory(new ReflectiveTypeAdapterFactory(new ConstructorConstructor(val), FieldNamingPolicy.IDENTITY, Excluder.DEFAULT));
            //注册集合的处理器
            gsonBuilder.registerTypeAdapterFactory(new CollectionTypeAdapterFactory(new ConstructorConstructor(val)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gsonBuilder.create();
    }
}
