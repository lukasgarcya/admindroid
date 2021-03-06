package com.programadorlgam.builder.presenter;

import com.programadorlgam.builder.Builder;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Created by lukasgarcya on 02/05/17.
 */

public class PresenterBuilder extends Builder {
    public PresenterBuilder(Element element, Filer filer) throws IOException {
        super(element, filer, "Presenter.vm");
        setItemLayout();
    }

    public void setPath(String path) {
        put("path", path);
    }

    protected void setItemLayout() {
        put("item_layout", "R.layout.item_single_line");
    }

    @Override
    protected String getFileName() {
        return new StringBuilder(getPackage()).append(".").append(getClassName()).append("Presenter").toString();
    }
}
