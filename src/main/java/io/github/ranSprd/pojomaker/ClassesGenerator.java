package io.github.ranSprd.pojomaker;

import com.sun.codemodel.CodeWriter;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import io.github.ranSprd.pojomaker.extensions.ReducedSchemaAnnotator;
import java.io.IOException;
import java.io.OutputStream;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.NoopAnnotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.openide.filesystems.FileObject;

/**
 *
 * @author ran
 */
public class ClassesGenerator {

    private String jsonSource;
    private String packageName;
    private String mainJavaClassName;

    private FileObject baseFolder;
    
    private final ClassesGeneratorConfig config = new ClassesGeneratorConfig();

    public String getJsonSource() {
        return jsonSource;
    }

    public void setJsonSource(String jsonSource, SourceType sourceType) {
        this.jsonSource = jsonSource;
        this.config.setSourceType(sourceType);
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMainJavaClassName() {
        return mainJavaClassName;
    }

    public void setMainJavaClassName(String mainJavaClassName) {
        this.mainJavaClassName = mainJavaClassName;
    }

    public FileObject getBaseFolder() {
        return baseFolder;
    }

    public void setBaseFolder(FileObject baseFolder) {
        this.baseFolder = baseFolder;
    }

    public ClassesGeneratorConfig getConfig() {
        return config;
    }

    public void build() throws IOException {

        JCodeModel jcodeModel = new JCodeModel();

        Annotator annotator = null;
        switch (config.getJsonCodeAnnotations()) {
            case ALL: annotator = new Jackson2Annotator(config);
                      break;
            case REDUCED : annotator = new ReducedSchemaAnnotator(new Jackson2Annotator(config), config);
                           break;
            case NOTHING:
                 default: annotator = new NoopAnnotator();
        }
        
        SchemaMapper mapper = new SchemaMapper(
                new RuleFactory(config,
                        annotator,
                        new SchemaStore()),
                new SchemaGenerator());

        JType result = mapper.generate(jcodeModel, mainJavaClassName, packageName, jsonSource);
        
        CodeWriter cw = new CodeWriter() {
            private OutputStream lastOpened = null;

            @Override
            public OutputStream openBinary(JPackage pkg, String fileName) throws IOException {
                close();
                lastOpened = baseFolder.createAndOpen(fileName);
//                throw new UnsupportedOperationException("Not supported yet."); 
//                return null;
                return lastOpened;
            }

            @Override
            public void close() throws IOException {
                if (lastOpened != null) {
                    try {
                        lastOpened.close();
                        lastOpened = null;
                    } catch (Exception e) {
                    }
                }
            }
        };
        jcodeModel.build(cw);
//        jcodeModel.build(outputJavaClassDirectory);
    }

}
