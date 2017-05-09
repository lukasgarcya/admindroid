package com.programadorlgam.builder.viewholder;

import com.programadorlgam.builder.Builder;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Created by lukasgarcya on 02/05/17.
 */

public class ViewHolderBuilder extends Builder {
    public ViewHolderBuilder(Element element, Filer filer) throws IOException {
        super(element, filer, "ViewHolder.vm");
    }

    @Override
    protected String getFileName() {
        return new StringBuilder(getPackage()).append(".").append(getClassName()).append("Holder").toString();
    }
}
