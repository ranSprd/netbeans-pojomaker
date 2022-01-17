package io.github.ranSprd.pojomaker.actions;

import io.github.ranSprd.pojomaker.ui.JsonToPojoWizard;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;

//@ActionID(
//        category = "File",
//        id = "io.github.ranSprd.pojomaker.NewFromJsonProjectAction"
//)
//@ActionRegistration(
//        displayName = "#CTL_NewFromJsonProjectAction", lazy = true
//)
//@ActionReference(path="Projects/org-netbeans-modules-maven/Actions", position=150)
public final class NewFromJsonProjectAction extends AbstractAction implements ContextAwareAction  {

//    private final Project context;
//
//    public NewFromJsonProjectAction(Project context) {
//        this.context = context;
//    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // TODO use context
    }

    @Override
    public Action createContextAwareInstance(Lookup lkp) {
        Project p = lkp.lookup(Project.class);
        if (p == null) {
            return this;
        }
        
        // check if project if a java project
        // and disable for all other project types
//        this.setEnabled(false);
        return new ContextActionExecutor();
    }
    
    
    
    private class ContextActionExecutor extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            JsonToPojoWizard.startWizard(null, null,null);
        }
        
    }
}
