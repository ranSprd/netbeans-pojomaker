package net.kiar.pojomaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

//@ActionID(
//        category = "File",
//        id = "net.kiar.pojomaker.NewPojo"
//)
//@ActionRegistration(
//        iconBase = "json-icon.png",
//        displayName = "#CTL_NewPojo"
//)
//@ActionReference(path = "Toolbars/File", position = 150)
//@Messages("CTL_NewPojo=New from JSON")
public final class NewPojo implements ActionListener {

    private final Project context;

    public NewPojo(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // TODO use context
    }
}
