package com.github.kuros.api.finder.scanner;

import com.google.common.collect.Lists;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Deprecated
//@Component
public class ScannerImpl implements Scanner {

    @Autowired
    private ApplicationContext context;

    private List<Class<?>> scannedClasses;

    @PostConstruct
    public void scanClasses(){
        scannedClasses = scanClassesAnnotatedWithController(getInclusionPaths());
    }

    public List<Class<?>> getControllers() {
        return scannedClasses;
    }

    private List<Class<?>> scanClassesAnnotatedWithController(final List<String> inclusionPaths) {
        final List<Class<?>> classes = Lists.newArrayList();
        for (String inclusionPath : inclusionPaths) {
            final Reflections reflections = getReflections(inclusionPath);
            final Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Controller.class);
            classes.addAll(typesAnnotatedWith);
        }
        return classes;
    }

    Reflections getReflections(final String inclusionPath) {
        return new Reflections(inclusionPath);
    }

    private List<String> getInclusionPaths() {
//        final List<String> bean = new ArrayList<>();
//        try {
//            final List<String> contextBean = (List<String>) context.getBean(SCANNAR_PATH);
//            if (contextBean != null) {
//                bean.addAll(contextBean);
//            }
//        } catch (final Exception e) {
//            // skip
//        }
//        return bean;
        return null;
    }
}
