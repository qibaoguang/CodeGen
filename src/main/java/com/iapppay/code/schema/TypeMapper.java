package com.iapppay.code.schema;

import java.util.HashMap;
import java.util.Map;

public class TypeMapper {

    private static Map<Class<?>, String> mapper = new HashMap<Class<?>, String>();

    static {
        mapper.put(boolean.class, "tinyint(2)");
        mapper.put(int.class, "int(11)");
        mapper.put(float.class, "float");
        mapper.put(double.class, "double");
        mapper.put(char.class, "char(32)");
        mapper.put(long.class, "bigint(20)");
        mapper.put(short.class, "int(11)");
        mapper.put(byte.class, "tinyint(2)");
        mapper.put(Integer.class, "int(11)");
        mapper.put(String.class, "varchar(32)");
    }

    public static String getSqlType(Class<?> primitiveType) {
        String value = mapper.get(primitiveType);
        if (value == null) {
            throw new RuntimeException(String.format(
                    "Type[%s] has no sql type mapping !", primitiveType));
        }
        return value;
    }
}
