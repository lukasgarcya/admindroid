package com.programadorlgam;

import com.programadorlgam.builder.activity.ActivityBuilder;
import com.programadorlgam.builder.activity.AppCompatActivityBuilder;
import com.programadorlgam.builder.adapter.FirebaseRecyclerAdapterBuilder;
import com.programadorlgam.builder.mvp.MVPInterfaceBuilder;
import com.programadorlgam.builder.presenter.PresenterBuilder;
import com.programadorlgam.builder.viewholder.ViewHolderBuilder;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("com.programadorlgam.Admin")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class AdminParcelProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Admin.class)) {
            try {
                ActivityBuilder activityBuilder = new AppCompatActivityBuilder(element, processingEnv.getFiler());
                activityBuilder.setActionBar();
                activityBuilder.setTitle();
                activityBuilder.build();
                new FirebaseRecyclerAdapterBuilder(element, processingEnv.getFiler()).build();
                new ViewHolderBuilder(element, processingEnv.getFiler()).build();
                new MVPInterfaceBuilder(element, processingEnv.getFiler()).build();
                Firebase firebase = element.getAnnotation(Firebase.class);
                if (firebase == null) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Firebase Annotation not found!");
                }
                PresenterBuilder presenterBuilder = new PresenterBuilder(element, processingEnv.getFiler());
                presenterBuilder.setPath(firebase.path());
                presenterBuilder.build();
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
        return false;
    }
}
