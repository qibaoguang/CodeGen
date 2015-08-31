package com.iapppay.code.tools;

import java.io.File;
import java.io.PrintWriter;

import com.iapppay.code.schema.Filter;
import com.iapppay.code.schema.SqlBean;
import com.iapppay.code.schema.XmlBean;

public class CodeGenerator {

    public static final String SQL_TEMPLATE = "sql.ftl";
    public static final String XML_TEMPLATE = "xml.ftl";

    public static final Filter NO_OPERATE_FILTER = new Filter() {
        @Override
        public boolean isAccept(Class<?> clazz) {
            return true;
        }
    };

    /**
     * JavaBean生成SQL
     * 
     * @param clazz
     *            对应的JavaBean
     * @param outPath
     *            SQL输出路径
     * @throws Exception
     */
    public static void bean2sql(Class<?> clazz, String outPath)
            throws Exception {
        bean2sql(clazz, outPath, NO_OPERATE_FILTER);
    }

    /**
     * JavaBean生成Mybatis配置
     * 
     * @param clazz
     *            对应的JavaBean
     * @param outPath
     *            XML输出路径
     * @throws Exception
     */
    public static void bean2xml(Class<?> clazz, String outPath)
            throws Exception {
        bean2xml(clazz, outPath, NO_OPERATE_FILTER);
    }

    /**
     * JavaBean生成SQL
     * 
     * @param clazz
     *            对应的JavaBean
     * @param outPath
     *            SQL输出路径
     * @param filter
     *            过滤器
     * @throws Exception
     */
    public static void bean2sql(Class<?> clazz, String outPath, Filter filter)
            throws Exception {
        SqlBean sql = BeanUtils.describeSql(clazz, filter);
        String fileName = outPath + File.separator + sql.getTableName()
                + ".sql";
        PrintWriter writer = new PrintWriter(fileName);
        FreeMarkerUtils.processTemplate(SQL_TEMPLATE, sql, writer);
        writer.close();
        System.out.println(String.format(
                "Generate sql for clazz[%s] success ! SQL file:[%s]", clazz,
                fileName));
    }

    /**
     * JavaBean生成Mybatis配置
     * 
     * @param clazz
     *            对应的JavaBean
     * @param outPath
     *            XML输出路径
     * @param filter
     *            过滤器
     * @throws Exception
     */
    public static void bean2xml(Class<?> clazz, String outPath, Filter filter)
            throws Exception {
        XmlBean xml = BeanUtils.describeXml(clazz, filter);
        String fileName = outPath + File.separator + xml.getTableName()
                + ".xml";
        PrintWriter writer = new PrintWriter(fileName);
        FreeMarkerUtils.processTemplate(XML_TEMPLATE, xml, writer);
        writer.close();
        System.out.println(String.format(
                "Generate mybatis.xml for clazz[%s] success ! Xml file:[%s]",
                clazz, fileName));
    }

}
