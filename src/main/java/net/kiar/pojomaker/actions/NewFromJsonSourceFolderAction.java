package net.kiar.pojomaker.actions;

import net.kiar.pojomaker.ui.JsonToPojoWizard;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.actions.NodeAction;

@ActionID(
        category = "File",
        id = "net.kiar.pojomaker.NewFromJsonSourceFolderAction"
)
@ActionRegistration(
        displayName = "#CTL_NewFromJsonSourceFolderAction", lazy = true
)
//@ActionReference(path="Projects/package/Actions", position = 20)
@ActionReference(path = "Loaders/folder/any/Actions", position = 205)
public final class NewFromJsonSourceFolderAction extends NodeAction {

    @Override
    protected void performAction(Node[] activatedNodes) {
        String packageName = null;
        FileObject primary = null;
        if (activatedNodes != null && activatedNodes.length > 0) {
            packageName = activatedNodes[0].getName();
            DataObject dataObject = activatedNodes[0].getLookup().lookup( DataObject.class);
            if (dataObject != null) {
                primary = dataObject.getPrimaryFile();
            }
        }
        JsonToPojoWizard.startWizard(null, packageName, primary);
    }

    @Override
    protected boolean enable(Node[] activatedNodes) {
//        return Selenium2Support.isSupportEnabled(UICommonUtils.getFileObjectsFromNodes(activatedNodes));
        return true;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(NewFromJsonSourceFolderAction.class, "CTL_NewFromJsonSourceFolderAction");
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    public static FileObject getFileObjectFromNode(Node node) {
        FileObject fo = node.getLookup().lookup(FileObject.class);
        if (fo == null) {
            Children children = node.getChildren();
            for (Node child : children.getNodes()) {
                fo = child.getLookup().lookup(FileObject.class);
                if (fo != null) {
                    return child.getDisplayName().equals("<default package>") ? fo : fo;
                }
            }
        }
        return fo;
    }
}
