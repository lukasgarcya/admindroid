package com.programadorlgam.builder;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Properties;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;

/**
 * Created by lukasgarcya on 01/05/17.
 */

public abstract class Builder {
    protected Element element;
    private Writer writer;
    private Properties properties;
    private Template template;
    private VelocityContext velocityContext;
    private Class model;

    public Builder(Element element, Filer filer, String template) throws IOException {
        this.element = element;
        JavaFileObject javaFileObject = filer.createSourceFile(getFileName());
        this.writer = javaFileObject.openWriter();
        URL url = this.getClass().getClassLoader().getResource("velocity.properties");
        properties = new Properties();
        properties.load(url.openStream());
        this.template = new VelocityEngine(properties).getTemplate(template);
        velocityContext = new VelocityContext();
        setPackage();
        setClass();
    }

    private void setClass() {
        put("class", getClassName());
    }

    private void setPackage() {
        put("package", element.getEnclosingElement());
    }

    protected String getPackage() {
        return element.getEnclosingElement().toString();
    }

    protected abstract String getFileName();

    protected void put(String key, Object value) {
        velocityContext.put(key, value);
    }

    protected String getClassName() {
        return element.getSimpleName().toString();
    }

    public void build() throws IOException {
        template.merge(velocityContext, writer);
        writer.close();
    }
}
