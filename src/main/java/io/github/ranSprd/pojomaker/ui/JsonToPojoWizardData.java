package io.github.ranSprd.pojomaker.ui;

import io.github.ranSprd.pojomaker.ClassesGenerator;
import io.github.ranSprd.pojomaker.ClassesGeneratorConfig;
import org.jsonschema2pojo.SourceType;
import org.openide.filesystems.FileObject;

/**
 *
 * @author ran
 */
public class JsonToPojoWizardData {
    
    private ClassesGenerator classGenerator;

    public JsonToPojoWizardData() {
        this(new ClassesGenerator());
    }

    
    public JsonToPojoWizardData(ClassesGenerator classGenerator) {
        this.classGenerator = classGenerator;
    }

    public ClassesGenerator getClassGenerator() {
        return classGenerator;
    }

    public ClassesGeneratorConfig getConfig() {
        return classGenerator.getConfig();
    }
    
    public String getJsonSource() {
        return classGenerator.getJsonSource();
    }

    public void setJsonSource(String jsonSource, SourceType sourceType) {
        classGenerator.setJsonSource(jsonSource, sourceType);
    }

    public String getPackageName() {
        return classGenerator.getPackageName();
    }

    public void setPackageName(String packageName) {
        classGenerator.setPackageName(packageName);
    }

    public String getMainJavaClassName() {
        return classGenerator.getMainJavaClassName();
    }

    public void setMainJavaClassName(String mainJavaClassName) {
        classGenerator.setMainJavaClassName(mainJavaClassName);
    }

    public FileObject getBaseFolder() {
        return classGenerator.getBaseFolder();
    }

    public void setBaseFolder(FileObject baseFolder) {
        classGenerator.setBaseFolder(baseFolder);
    }
    
    
    
}
