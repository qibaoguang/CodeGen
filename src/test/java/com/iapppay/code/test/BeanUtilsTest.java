package com.iapppay.code.test;

import org.junit.Test;

import com.iapppay.code.model.test.User;
import com.iapppay.code.schema.Filter;
import com.iapppay.code.tools.BeanUtils;
import com.iapppay.code.tools.CodeGenerator;

public class BeanUtilsTest {

    public static final Filter NO_OPERATE_FILTER = new Filter() {
        @Override
        public boolean isAccept(Class<?> clazz) {
            return true;
        }
    };

    @Test
    public void describeSql() throws Exception {
        System.out
                .println(BeanUtils.describeSql(User.class, NO_OPERATE_FILTER));
    }

    @Test
    public void describeXml() throws Exception {
        System.out
                .println(BeanUtils.describeXml(User.class, NO_OPERATE_FILTER));
    }

    @Test
    public void bean2sql() throws Exception {
        String outPath = "C:\\360Downloads\\SQL";
        CodeGenerator.bean2sql(User.class, outPath);
    }

    @Test
    public void bean2xml() throws Exception {
        String outPath = "C:\\360Downloads\\SQL";
        CodeGenerator.bean2xml(User.class, outPath);
    }
}
