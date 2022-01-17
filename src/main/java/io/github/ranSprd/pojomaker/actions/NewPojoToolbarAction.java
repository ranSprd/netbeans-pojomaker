package io.github.ranSprd.pojomaker.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

//@ActionID(
//        category = "File",
//        id = "io.github.ranSprd.pojomaker.NewPojoToolbarAction"
//)
//@ActionRegistration(
//        iconBase = "json-icon.png",
//        displayName = "#CTL_NewPojo"
//)
//@ActionReference(path = "Toolbars/File", position = 150)
//@Messages("CTL_NewPojo=New from JSON")
public final class NewPojoToolbarAction implements ActionListener {

    private final Project context;

    public NewPojoToolbarAction(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // TODO use context
    }
}
