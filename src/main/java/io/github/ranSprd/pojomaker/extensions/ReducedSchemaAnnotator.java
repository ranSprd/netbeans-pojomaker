/*
 * Copyright 2022 raik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ranSprd.pojomaker.extensions;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JEnumConstant;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.GenerationConfig;

import javax.lang.model.SourceVersion;


/**
 * only add annotations to fields if their name is not equal to the json attribute, e.g.
 * the attribute name contains a '_'
 * @author raik
 */
public class ReducedSchemaAnnotator implements Annotator {

    private final Annotator wrapped;
    private final GenerationConfig config;

    public ReducedSchemaAnnotator(Annotator wrapped, GenerationConfig generationConfig) {
        this.wrapped = wrapped;
        this.config = generationConfig;
    }

    @Override
    public void typeInfo(JDefinedClass jdc, JsonNode jn) {
        wrapped.typeInfo(jdc, jn);
    }

    @Override
    public void propertyOrder(JDefinedClass jdc, JsonNode jn) {
//        wrapped.propertyOrder(jdc, jn);
    }

    @Override
    public void propertyInclusion(JDefinedClass jdc, JsonNode jn) {
//        wrapped.propertyInclusion(jdc, jn);
    }

    @Override
    public void propertyField(JFieldVar jfv, JDefinedClass jdc, String string, JsonNode jn) {
        if (string != null) {
            if (isInvalidName(string) || string.contains("_") || string.contains("$")) {
                // Variable names should not start with underscore _ or 
                // dollar sign $ characters, even though both are allowed.
                // general, some special characters found so we use a another variable name
                wrapped.propertyField(jfv, jdc, string, jn);
            }
        }
    }
    
    public boolean isInvalidName(String name) {
        return !SourceVersion.isIdentifier(name);
                            //&& !SourceVersion.isKeyword(name);
    }

    @Override
    public void propertyGetter(JMethod getter, JDefinedClass clazz, String propertyName) {
//        if (propertyName != null && propertyName.contains("_")) {
//            wrapped.propertyGetter(getter, clazz, propertyName);
//        }
    }

    @Override
    public void propertySetter(JMethod setter, JDefinedClass clazz, String propertyName) {
//        if (propertyName != null && propertyName.contains("_")) {
//            wrapped.propertySetter(setter, clazz, propertyName);
//        }
    }

    @Override
    public void anyGetter(JMethod getter, JDefinedClass clazz) {
        wrapped.anyGetter(getter, clazz);
    }

    @Override
    public void anySetter(JMethod setter, JDefinedClass clazz) {
        wrapped.anySetter(setter, clazz);
    }

    @Override
    public void enumCreatorMethod(JDefinedClass _enum, JMethod creatorMethod) {
        wrapped.enumCreatorMethod(_enum, creatorMethod);
    }

    @Override
    public void enumValueMethod(JDefinedClass _enum, JMethod valueMethod) {
        wrapped.enumValueMethod(_enum, valueMethod);
    }

    @Override
    public void enumConstant(JDefinedClass _enum, JEnumConstant constant, String value) {
        wrapped.enumConstant(_enum, constant, value);
    }

    @Override
    public boolean isAdditionalPropertiesSupported() {
        return wrapped.isAdditionalPropertiesSupported();
    }

    @Override
    public void dateTimeField(JFieldVar jfv, JDefinedClass jdc, JsonNode jn) {
        wrapped.dateTimeField(jfv, jdc, jn);
    }

    @Override
    public void dateField(JFieldVar jfv, JDefinedClass jdc, JsonNode jn) {
        wrapped.dateField(jfv, jdc, jn);
    }

    @Override
    public void timeField(JFieldVar jfv, JDefinedClass jdc, JsonNode jn) {
        wrapped.timeField(jfv, jdc, jn);
    }

    @Override
    public void additionalPropertiesField(JFieldVar field, JDefinedClass clazz, String propertyName) {
        wrapped.additionalPropertiesField(field, clazz, propertyName);
    }

    @Override
    public boolean isPolymorphicDeserializationSupported(JsonNode jn) {
        return wrapped.isPolymorphicDeserializationSupported(jn);
    }

}
