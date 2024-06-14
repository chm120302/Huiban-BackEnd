package com.example.huibanbackend.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public abstract class BaseVoEntityTest<T> {
    protected abstract T getT();

    private void testGetAndSet() throws IllegalAccessException, InstantiationException, IntrospectionException,
            InvocationTargetException {
        T t = getT();
        Class modelClass = t.getClass();
        Object obj = modelClass.newInstance();
        Field[] fields = modelClass.getDeclaredFields();
        for (Field f : fields) {
            boolean isStatic = Modifier.isStatic(f.getModifiers());
            // 过滤字段
            if (f.getName().equals("isSerialVersionUID") || f.getName().equals("serialVersionUID") || isStatic || f.getGenericType().toString().equals("boolean")
                    || f.isSynthetic()) {
                continue;
            }
            PropertyDescriptor pd = new PropertyDescriptor(f.getName(), modelClass);
            Method get = pd.getReadMethod();
            Method set = pd.getWriteMethod();
            set.invoke(obj, get.invoke(obj));
        }
    }

    @Test
    public void getAndSetTest() throws InvocationTargetException, IntrospectionException,
            InstantiationException, IllegalAccessException {
        this.testGetAndSet();
    }

}
