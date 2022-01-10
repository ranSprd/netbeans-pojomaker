package net.kiar.pojomaker.ui;

import net.kiar.pojomaker.ClassGenerator;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;

/**
 *
 * @author ran
 */
public class JsonToPojoWizardData {
    
    private ClassGenerator classGenerator;

    public JsonToPojoWizardData() {
        this( new ClassGenerator());
    }

    
    public JsonToPojoWizardData(ClassGenerator classGenerator) {
        this.classGenerator = classGenerator;
    }

    public ClassGenerator getClassGenerator() {
        return classGenerator;
    }

    public String getJsonSource() {
        return classGenerator.getJsonSource();
    }

    public void setJsonSource(String jsonSource) {
        classGenerator.setJsonSource(jsonSource);
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
