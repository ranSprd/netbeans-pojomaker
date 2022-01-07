package net.kiar.pojomaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;

// An example action demonstrating how the wizard could be called from within
// your code. You can move the code below wherever you need, or register an action:
@ActionID(category="Pojo", id="net.kiar.pojomaker.JsonToPojoWizardAction")
@ActionRegistration(displayName="New Pojo")
@ActionReferences({
  @ActionReference(path="Menu/File", position=250)
})
public final class JsonToPojoWizardAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JsonToPojoWizard.startWizard();
    }

}
