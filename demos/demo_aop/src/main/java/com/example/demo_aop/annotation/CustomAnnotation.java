package com.example.demo_aop.annotation;

import org.aspectj.lang.annotation.Before;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // spécifie que l'annotation CustomAnnotation peut être utilisée uniquement sur des méthodes. En d'autres termes, elle est destinée à être appliquée aux déclarations de méthodes.
@Retention(RetentionPolicy.RUNTIME) // Cette ligne indique que l'annotation CustomAnnotation sera conservée au moment de l'exécution (runtime). Cela signifie que vous pourrez inspecter et traiter cette annotation à l'exécution à l'aide de la réflexion (reflection) en Java.
public @interface CustomAnnotation {



}
