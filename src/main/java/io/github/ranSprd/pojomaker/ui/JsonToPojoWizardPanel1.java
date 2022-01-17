package io.github.ranSprd.pojomaker.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;

public class JsonToPojoWizardPanel1 implements WizardDescriptor.ValidatingPanel<WizardDescriptor> {
//public class JsonToPojoWizardPanel1 implements WizardDescriptor.Panel<WizardDescriptor> {

    private static final Logger logger = Logger.getLogger(JsonToPojoWizardPanel1.class.getName());

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private JsonToPojoVisualPanel1 component;
    private boolean isValid = false;

    private List<ChangeListener> changeListeners = new ArrayList<>();
    
    private final JsonToPojoWizardData data;

    public JsonToPojoWizardPanel1(JsonToPojoWizardData data) {
        this.data = data;
    }
    

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public JsonToPojoVisualPanel1 getComponent() {
        if (component == null) {
            component = new JsonToPojoVisualPanel1();
            if (component.hasJsonContent()) {
                isValid = true;
            }
            component.addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    isValid = e.getDocument().getLength() > 0;
                    fireChangeEvent();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    isValid = e.getDocument().getLength() > 0;
                    fireChangeEvent();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    isValid = e.getDocument().getLength() > 0;
                    fireChangeEvent();
                }
            });
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
        return isValid;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void validate() throws WizardValidationException {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree( getComponent().getJsonContent());
            isValid = true;
        } catch (Exception e) {
            isValid = false;
            throw new WizardValidationException(component, e.getMessage(), e.getLocalizedMessage());
        }

    }

    private void fireChangeEvent() {
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener l : changeListeners) {
            l.stateChanged(event);
        }
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        if (listener != null) {
            changeListeners.add(listener);
        }
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        if (listener != null) {
            changeListeners.remove(listener);
        }
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
//        component.setJsonContent( data.getJsonSource());
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        data.setJsonSource(component.getJsonContent());
    }

}
