package com.github.kuros.api.finder.scanner;

import java.util.List;

@Deprecated
public interface Scanner {

    String SCANNAR_PATH = "api.finder.include.path";

    List<Class<?>> getControllers();


}
