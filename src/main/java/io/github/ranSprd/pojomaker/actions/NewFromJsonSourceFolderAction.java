package io.github.ranSprd.pojomaker.actions;

import java.io.File;
import java.util.Optional;
import io.github.ranSprd.pojomaker.ui.JsonToPojoWizard;
import org.apache.commons.lang3.StringUtils;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.SourceGroup;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.actions.NodeAction;

@ActionID(
        category = "File",
        id = "io.github.ranSprd.pojomaker.NewFromJsonSourceFolderAction"
)
@ActionRegistration(
        displayName = "#CTL_NewFromJsonSourceFolderAction", lazy = true
)
//@ActionReference(path="Projects/package/Actions", position = 20)
@ActionReference(path = "Loaders/folder/any/Actions", position = 205)
public final class NewFromJsonSourceFolderAction extends NodeAction {

    // define own type, because the origin source of that constant 
    // is located in the java-j2seproject which is not accessable by 
    // 3rd party modules like us
    public static final String SOURCES_TYPE_JAVA = "java";
    
    @Override
    protected void performAction(Node[] activatedNodes) {
        String packageName = null;
        FileObject primary = null;
        if (activatedNodes != null && activatedNodes.length > 0) {
            packageName = activatedNodes[0].getName();
            DataObject dataObject = activatedNodes[0].getLookup().lookup( DataObject.class);
            if (dataObject != null) {
                primary = dataObject.getPrimaryFile();
                packageName = extractPackageName(primary).orElse(packageName);
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

    /**
     * get the package from given file/folder
     * @param folderObject
     * @return 
     */
    private Optional<String> extractPackageName(FileObject folderObject) {
        if (folderObject == null) {
            return Optional.empty();
        }
        ClassPath cPath = ClassPath.getClassPath(folderObject, ClassPath.SOURCE);
        if (cPath != null) {
            String relativePath = cPath.getResourceName(folderObject);
            if (StringUtils.isNotBlank(relativePath)) {
                return Optional.of( relativePath.replaceAll(File.separator, "."));
            }
        }
        return Optional.of( folderObject.getName().replaceAll(File.separator, "."));
    }

    /**
     * detect the source root of the project
     * @param folderObject
     * @return 
     */
    private Optional<SourceGroup> getSource(FileObject folderObject) {
        final Project project = FileOwnerQuery.getOwner(folderObject);     
        if (project != null) {
            SourceGroup[] sources = ProjectUtils.getSources(project).getSourceGroups(SOURCES_TYPE_JAVA);
            for(SourceGroup s : sources) {
                if (FileUtil.isParentOf(s.getRootFolder(), folderObject)) {
                    return Optional.of(s);
                }
            }
        }
        return Optional.empty();
    }
    
}
