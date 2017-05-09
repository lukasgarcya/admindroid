package com.programadorlgam.builder.adapter;

import com.programadorlgam.builder.Builder;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Created by lukasgarcya on 01/05/17.
 */

public abstract class RecyclerAdapterBuilder extends Builder {
    public RecyclerAdapterBuilder(Element element, Filer filer, String template) throws IOException {
        super(element, filer, template);
    }

//    @Override
//    public String getFileName() {
//        return new StringBuilder(getPackage()).append(".").append(getClassName()).append("Activity").toString();
//    }
}
