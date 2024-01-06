package com.zzh.admin.code.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerDemo {

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);

        configuration.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "/admin-code-generate/src/main/resources/template"));

        Map<String, Object> data = new HashMap<>(4);
        data.put("packageName", "com.zzh.admin.code.entity");
        data.put("basePrefix", "Test");
        data.put("fieldList", Arrays.asList(new Field("Long", "id"), new Field("String", "name")));
        Template template = configuration.getTemplate("do.ftl");

        File controllerFile = new File(System.getProperty("user.dir") + "/admin-code-generate/src/main/java/com/zzh/admin/code/entity/TestDO.java");
        File parentFile = controllerFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        controllerFile.createNewFile();
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(controllerFile.toPath())))) {
            template.process(data, writer);
            writer.flush();
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
