package io.github.ranSprd.pojomaker.ui;

import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

public class JsonToPojoWizardPanel2 implements WizardDescriptor.Panel<WizardDescriptor> {

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private JsonToPojoVisualPanel2 component;
    
    private final JsonToPojoWizardData data;

    public JsonToPojoWizardPanel2(JsonToPojoWizardData data) {
        this.data = data;
    }

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public JsonToPojoVisualPanel2 getComponent() {
        if (component == null) {
            component = new JsonToPojoVisualPanel2();
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        component.set( data.getMainJavaClassName(), data.getPackageName());
        component.readFromConfig(data.getConfig());
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        data.setPackageName( component.getPackageName());
        data.setMainJavaClassName(component.getMainJavaClassName());
        component.writeToConfig(data.getConfig());
    }

}
