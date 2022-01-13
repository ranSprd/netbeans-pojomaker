package net.kiar.pojomaker;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.SourceType;

/**
 *
 * @author ran
 */
public class ClassesGeneratorConfig extends DefaultGenerationConfig {

    private boolean generateBuilder = false;
    private boolean includeAdditionalProperties;
    private boolean includeToString;
    private boolean includeHashcodeAndEquals;
    private boolean usePrimitives;
    private boolean includeGeneratedAnnotation;
    
    private String classNamePrefix = "";
    private String classNameSuffix = "DTO";
    

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

    @Override
    public SourceType getSourceType() {
        return SourceType.JSON;
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

    public void setIncludeGeneratedAnnotation(boolean includeGeneratedAnnotation) {
        this.includeGeneratedAnnotation = includeGeneratedAnnotation;
    }

    @Override
    public boolean isIncludeSetters() {
        return super.isIncludeSetters(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean isIncludeGetters() {
        return super.isIncludeGetters(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean isIncludeConstructors() {
        return super.isIncludeConstructors(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
