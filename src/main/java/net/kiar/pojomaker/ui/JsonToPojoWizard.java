package net.kiar.pojomaker.ui;

import java.awt.Component;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import net.kiar.pojomaker.ClassGenerator;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;

/**
 *
 * @author ran
 */
public class JsonToPojoWizard {

    public static void startWizard(String mainClassName, String packageName, FileObject folder) {
        
        if (folder == null) {
            DialogDisplayer.getDefault().notify(
                new NotifyDescriptor.Message("Can't locate working folder", NotifyDescriptor.ERROR_MESSAGE)
            );
//            JOptionPane.showMessageDialog(null, "Can't locate a working folder", "Internal error", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        
        JsonToPojoWizardData data = new JsonToPojoWizardData();
        data.setBaseFolder(folder);
        data.setMainJavaClassName(mainClassName);
        data.setPackageName(packageName);
        
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<>();
        panels.add(new JsonToPojoWizardPanel1(data));
        panels.add(new JsonToPojoWizardPanel2(data));
        
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
        
        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
            // do something
            try {
                ClassGenerator cg = data.getClassGenerator();
                cg.build();
            } catch (Exception e) {
                System.out.println("FEHLER "+e);
                e.printStackTrace();
            }
        }
        
    }
}
