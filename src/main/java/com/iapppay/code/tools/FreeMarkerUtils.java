package com.iapppay.code.tools;

import java.io.Writer;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerUtils {

    private static Configuration config = new Configuration(
            Configuration.VERSION_2_3_22);

    public static final String BASE_TEMPLATE_PATH = "com.iapppay.code.template";

    static {
        config.setLocale(Locale.CHINA);
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setClassLoaderForTemplateLoading(
                FreeMarkerUtils.class.getClassLoader(), BASE_TEMPLATE_PATH);
    }

    public static void processTemplate(String templateName, Object root,
            Writer out) throws Exception {
        Template template = config.getTemplate(templateName);
        template.process(root, out);
        out.flush();
    }
}
