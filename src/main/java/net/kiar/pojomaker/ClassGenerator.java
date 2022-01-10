package net.kiar.pojomaker;

import com.sun.codemodel.CodeWriter;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

/**
 *
 * @author ran
 */
public class ClassGenerator {

    public void build(String jsonSource, String packageName, String javaClassName) throws IOException {
        
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        SchemaMapper mapper = new SchemaMapper(
                new RuleFactory(config, 
                                 new Jackson2Annotator(config), 
                                 new SchemaStore()), 
                                 new SchemaGenerator());
        
        JType result = mapper.generate(jcodeModel, javaClassName, packageName, jsonSource);

        CodeWriter cw = new CodeWriter() {
            @Override
            public OutputStream openBinary(JPackage pkg, String fileName) throws IOException {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                return null;

            }

            @Override
            public void close() throws IOException {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
//        jcodeModel.build(cw);
//        jcodeModel.build(outputJavaClassDirectory);
    }

}
