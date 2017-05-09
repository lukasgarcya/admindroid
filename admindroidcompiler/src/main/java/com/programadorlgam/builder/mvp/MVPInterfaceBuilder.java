package com.programadorlgam.builder.mvp;

import com.programadorlgam.builder.Builder;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Created by lukasgarcya on 02/05/17.
 */

public class MVPInterfaceBuilder extends Builder {
    public MVPInterfaceBuilder(Element element, Filer filer) throws IOException {
        super(element, filer, "MVP.vm");
    }

    @Override
    protected String getFileName() {
        return new StringBuilder(getPackage()).append(".").append(getClassName()).append("MVP").toString();
    }
}
