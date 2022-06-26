package io.github.ranSprd.pojomaker;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.SourceType;

/**
 *
 * @author ran
 */
public class ClassesGeneratorConfig extends DefaultGenerationConfig {

    private boolean generateBuilder = false;
    private boolean includeSetters = true;
    private boolean includeGetters = true;
    private boolean useOptionalForGetters = false;
    
    private boolean includeAdditionalProperties;
    private boolean includeToString;
    private boolean includeHashcodeAndEquals;
    private boolean usePrimitives;
    private boolean includeGeneratedAnnotation;
    
    private boolean includeConstructors;
    
    private String classNamePrefix = "";
    private String classNameSuffix = "DTO";
    
    private SourceType sourceType = SourceType.JSON;
    

    @Override
    public boolean isGenerateBuilders() {
        return generateBuilder;
    }

    @Override
    public boolean isIncludeAdditionalProperties() {
        return includeAdditionalProperties;
    }

    @Override
    public boolean isIncludeToString() {
        return includeToString;
    }

    @Override
    public boolean isIncludeHashcodeAndEquals() {
        return includeHashcodeAndEquals;
    }

    @Override
    public boolean isUsePrimitives() {
        return usePrimitives;
    }

    
    @Override
    public boolean isIncludeGeneratedAnnotation() {
        return includeGeneratedAnnotation;
    }

    public void setIncludeGeneratedAnnotation(boolean includeGeneratedAnnotation) {
        this.includeGeneratedAnnotation = includeGeneratedAnnotation;
    }

    @Override
    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }
    
    public void setGenerateBuilder(boolean generateBuilder) {
        this.generateBuilder = generateBuilder;
    }

    public void setIncludeAdditionalProperties(boolean includeAdditionalProperties) {
        this.includeAdditionalProperties = includeAdditionalProperties;
    }

    public void setIncludeToString(boolean includeToString) {
        this.includeToString = includeToString;
    }

    public void setIncludeHashcodeAndEquals(boolean includeHashcodeAndEquals) {
        this.includeHashcodeAndEquals = includeHashcodeAndEquals;
    }

    public void setUsePrimitives(boolean usePrimitives) {
        this.usePrimitives = usePrimitives;
    }

    @Override
    public boolean isIncludeSetters() {
        return includeSetters;
    }

    public void setIncludeSetters(boolean includeSetters) {
        this.includeSetters = includeSetters;
    }
    
    @Override
    public boolean isIncludeGetters() {
        return includeGetters;
    }

    public void setIncludeGetters(boolean includeGetters) {
        this.includeGetters = includeGetters;
    }

    @Override
    public boolean isIncludeConstructors() {
        return includeConstructors;
    }

    public void setIncludeConstructors(boolean includeConstructors) {
        this.includeConstructors = includeConstructors;
    }

    

    @Override
    public boolean isUseOptionalForGetters() {
        return useOptionalForGetters;
    }

    public void setUseOptionalForGetters(boolean useOptionalForGetters) {
        this.useOptionalForGetters = useOptionalForGetters;
    }

    @Override
    public String getClassNameSuffix() {
        return classNameSuffix;
    }

    public void setClassNameSuffix(String classNameSuffix) {
        this.classNameSuffix = classNameSuffix;
    }

    @Override
    public String getClassNamePrefix() {
        return classNamePrefix;
    }

    public void setClassNamePrefix(String classNamePrefix) {
        this.classNamePrefix = classNamePrefix;
    }
    
}
