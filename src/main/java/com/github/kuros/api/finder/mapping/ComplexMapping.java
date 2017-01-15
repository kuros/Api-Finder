package com.github.kuros.api.finder.mapping;

import com.github.kuros.api.finder.config.BasicType;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComplexMapping {

    public static Map<String, Object> getAttributeWithType(final Class<?> parameterType) {

        return getAttributeTypes(parameterType);
    }

    private static Map<String, Object> getAttributeTypes(final Class<?> parameterType) {
        final Map<String, Object> requestBody = new HashMap<String, Object>();
        try {
            final BeanInfo beanInfo = Introspector.getBeanInfo(parameterType, Object.class);
            final PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : props) {
                final Set<Class<?>>traversedClass = new HashSet<Class<?>>();
                Object valueType = getAtValueLevel(traversedClass, pd);

                if (valueType != null) {
                    requestBody.put(pd.getName(), valueType);
                }

            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        return requestBody;
    }

    private static Object getAtValueLevel(final Set<Class<?>> traversedClass, final PropertyDescriptor pd) {
        Object valueType = null;

        final Method setter = pd.getWriteMethod();

        if (setter != null) {

            final BasicType type = BasicType.getType(pd.getPropertyType());
            if (type != null) {
                valueType = type.name();
            } else if (List.class.isAssignableFrom(pd.getPropertyType())) {

//                        pd.getPropertyType().
//
//                        List<Object> list = new ArrayList<Object>();
//                        list.add()
//
//                        requestBody.put()
                System.out.println(pd.getPropertyType());
            }


            else {
                if (!traversedClass.contains(pd.getPropertyType())) {
                    traversedClass.add(pd.getPropertyType());
                    valueType = getAtValueLevel(traversedClass, pd);
                }
            }

        }
        return valueType;
    }
}