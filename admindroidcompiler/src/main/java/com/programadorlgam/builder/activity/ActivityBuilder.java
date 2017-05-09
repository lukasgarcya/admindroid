package com.programadorlgam.builder.activity;

import com.programadorlgam.builder.Builder;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Created by lukasgarcya on 01/05/17.
 */

public abstract class ActivityBuilder extends Builder {

    public ActivityBuilder(Element element, Filer filer) throws IOException {
        super(element, filer, "Activity.vm");
        setLayout();
    }

    private void setLayout() {
        put("import_layout", "com.programadorlgam.admindroidresource.R");
        put("layout", "R.layout.activity_single_line_list");
    }

    protected String getTitle() {
        return getClassName();
    }

    @Override
    protected String getFileName() {
        return new StringBuilder(getPackage()).append(".").append(getClassName()).append("Activity").toString();
    }

    public abstract void setActionBar();

    public abstract void setTitle();

}
