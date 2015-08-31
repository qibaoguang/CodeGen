package com.iapppay.code.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.iapppay.code.schema.Filter;
import com.iapppay.code.schema.MetaBean;
import com.iapppay.code.schema.SqlBean;
import com.iapppay.code.schema.TypeMapper;
import com.iapppay.code.schema.XmlBean;

public class BeanUtils {

    private BeanUtils() {
    }

    public static SqlBean describeSql(Class<?> clazz, Filter filter) {
        SqlBean sql = new SqlBean();
        sql.setTableName(camel2underline(clazz.getSimpleName()));
        sql.setDesc("Table structure for `" + sql.getTableName() + "`");
        List<MetaBean> columns = new ArrayList<MetaBean>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (filter.isAccept(field.getType())) {
                MetaBean col = new MetaBean();
                col.setPrimitiveName(field.getName());
                col.setPrimitiveType(field.getType());
                col.setOutName(camel2underline(field.getName()));
                col.setOutType(TypeMapper.getSqlType(field.getType()));
                col.setComment("");
                columns.add(col);
            }
        }
        sql.setColumns(columns);
        return sql;
    }

    public static XmlBean describeXml(Class<?> clazz, Filter filter) {
        XmlBean xml = new XmlBean();
        xml.setClazz(clazz.getCanonicalName());
        xml.setClazzName(clazz.getSimpleName());
        xml.setNameSpace(normalizeNameSpace(clazz.getCanonicalName()));
        xml.setTableName(camel2underline(clazz.getSimpleName()));
        List<MetaBean> columns = new ArrayList<MetaBean>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (filter.isAccept(field.getType())) {
                MetaBean col = new MetaBean();
                col.setPrimitiveName(field.getName());
                col.setPrimitiveType(field.getType());
                col.setOutName(camel2underline(field.getName()));
                col.setOutType(TypeMapper.getSqlType(field.getType()));
                col.setComment("");
                columns.add(col);
            }
        }
        xml.setColumns(columns);
        return xml;
    }

    public static String normalizeNameSpace(String clazz) {
        if (clazz == null || clazz.isEmpty()) {
            return "";
        }
        return clazz.replace(".model.", ".dao.") + "Dao";
    }

    public static String camel2underline(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        StringBuilder ret = new StringBuilder(name.length());
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (i == 0) {
                if (Character.isUpperCase(ch)) {
                    ret.append(Character.toLowerCase(ch));
                } else {
                    ret.append(ch);
                }
                continue;
            }
            if (Character.isUpperCase(ch)) {
                ret.append("_");
                ret.append(Character.toLowerCase(ch));
            } else {
                ret.append(ch);
            }
        }
        return ret.toString();
    }

}
