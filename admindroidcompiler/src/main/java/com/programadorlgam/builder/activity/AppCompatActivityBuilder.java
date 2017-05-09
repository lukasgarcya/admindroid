package com.programadorlgam.builder.activity;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Created by lukasgarcya on 01/05/17.
 */

public class AppCompatActivityBuilder extends ActivityBuilder {


    public AppCompatActivityBuilder(Element element, Filer filer) throws IOException {
        super(element, filer);
    }

    @Override
    public void setActionBar() {
        put("toolbar", true);
    }

    @Override
    public void setTitle() {
        put("title", getTitle());
    }
}
