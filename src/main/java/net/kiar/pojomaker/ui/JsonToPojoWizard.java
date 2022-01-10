package net.kiar.pojomaker.ui;

import java.awt.Component;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import net.kiar.pojomaker.ClassGenerator;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;

/**
 *
 * @author ran
 */
public class JsonToPojoWizard {

    public static void startWizard(String mainClassName, String packageName) {
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<>();
        panels.add(new JsonToPojoWizardPanel1());
        panels.add(new JsonToPojoWizardPanel2());
        String[] steps = new String[panels.size()];
        for (int i = 0; i < panels.size(); i++) {
            Component c = panels.get(i).getComponent();
            // Default step name to component name of panel.
            steps[i] = c.getName();
            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
            }
        }
        WizardDescriptor wiz = new WizardDescriptor(new WizardDescriptor.ArrayIterator<>(panels));
        // {0} will be replaced by WizardDesriptor.Panel.getComponent().getName()
        wiz.setTitleFormat(new MessageFormat("{0}"));
        wiz.setTitle("Pojo Class Creator");
        wiz.putProperty(Constants.CLASS_NAME, mainClassName);
        wiz.putProperty(Constants.PACKAGE_NAME, packageName);
        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
            // do something
            try {
                ClassGenerator cg = new ClassGenerator();
                cg.build((String) wiz.getProperty(Constants.JSON_SOURCE), 
                        packageName, 
                        mainClassName);
            } catch (Exception e) {
            }
        }
        
    }
}
