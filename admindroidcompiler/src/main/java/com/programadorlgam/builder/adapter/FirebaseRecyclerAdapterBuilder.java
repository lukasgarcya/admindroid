package com.programadorlgam.builder.adapter;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Created by lukasgarcya on 01/05/17.
 */

public class FirebaseRecyclerAdapterBuilder extends RecyclerAdapterBuilder {
    public FirebaseRecyclerAdapterBuilder(Element element, Filer filer) throws IOException {
        super(element, filer, "FirebaseRecyclerAdapter.vm");
    }

    @Override
    protected String getFileName() {
        return new StringBuilder(getPackage()).append(".").append(getClassName()).append("FirebaseRecyclerAdapter").toString();
    }
}
