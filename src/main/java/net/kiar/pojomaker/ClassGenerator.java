package net.kiar.pojomaker;

import com.sun.codemodel.CodeWriter;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import java.io.IOException;
import java.io.OutputStream;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
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
public class ClassGenerator {
    
    private String jsonSource;
    private String packageName;
    private String mainJavaClassName;
    
    private FileObject baseFolder; 
    
    public String getJsonSource() {
        return jsonSource;
    }

    public void setJsonSource(String jsonSource) {
        this.jsonSource = jsonSource;
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
    

    public void build() throws IOException {
        
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return false;
            }

            @Override
            public boolean isIncludeAdditionalProperties() {
                return false;
            }

            @Override
            public boolean isIncludeToString() {
                return false;
            }

            @Override
            public boolean isIncludeHashcodeAndEquals() {
                return false;
            }

            @Override
            public boolean isUsePrimitives() {
                return true;
            }

            @Override
            public boolean isIncludeGeneratedAnnotation() {
                return false;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        SchemaMapper mapper = new SchemaMapper(
                new RuleFactory(config, 
                        new NoopAnnotator(),
//                                 new Jackson2Annotator(config), 
                                 new SchemaStore()), 
                                 new SchemaGenerator());
        
        JType result = mapper.generate(jcodeModel, mainJavaClassName, packageName, jsonSource);

        CodeWriter cw = new CodeWriter() {
            private OutputStream lastOpened =null;
            @Override
            public OutputStream openBinary(JPackage pkg, String fileName) throws IOException {
                close();
                lastOpened = baseFolder.createAndOpen(fileName);
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
