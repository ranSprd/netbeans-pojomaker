package io.github.ranSprd.pojomaker;

import java.io.IOException;
import org.jsonschema2pojo.SourceType;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ran
 */
public class ClassGeneratorTest {
    
    @org.junit.jupiter.api.Test
    public void testSomeMethod() throws IOException {
        
        ClassesGenerator cg = new ClassesGenerator();
        cg.setJsonSource("{ 'foo' : 'bar'}", SourceType.JSON);
        
        assertNotNull(cg.getJsonSource());
    }
    
}
