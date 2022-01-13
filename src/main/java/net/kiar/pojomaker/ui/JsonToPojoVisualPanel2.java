package net.kiar.pojomaker.ui;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.kiar.pojomaker.ClassesGeneratorConfig;
import org.apache.commons.lang3.StringUtils;

public final class JsonToPojoVisualPanel2 extends JPanel {
    
    /**
     * Creates new form JsonToPojoVisualPanel2
     */
    public JsonToPojoVisualPanel2() {
        initComponents();
        mainClassNameField.getDocument().addDocumentListener( new RelevantClassNameDataListener());
        classNameSuffixField.getDocument().addDocumentListener( new RelevantClassNameDataListener());
    }
    
    public void set(String mainClassName, String packageName) {
        if (StringUtils.isBlank(mainClassNameField.getText())) {
            mainClassNameField.setText(mainClassName);
        }
        if (StringUtils.isBlank(packageNameField.getText())) {
            packageNameField.setText(packageName);
        }
        updateClassNamePreview();
    }
    
    public String getPackageName() {
        return packageNameField.getText();
    }

    public String getMainJavaClassName() {
        return mainClassNameField.getText();
    }
    
    public String getBaseJavaClassName() {
        return mainClassNameField.getText() + classNameSuffixField.getText();
    }

    @Override
    public String getName() {
        return "Name and Package";
    }
    
    private void updateClassNamePreview() {
        classNamePreviewField.setText( getBaseJavaClassName() +".java");
    }
    
    public void readFromConfig(ClassesGeneratorConfig config) {
        additionalPropertiesCheckBox.setSelected(config.isIncludeAdditionalProperties());
        generatorCheckBox.setSelected(config.isIncludeGeneratedAnnotation());
        primitiveTypesCheckBox.setSelected( config.isUsePrimitives());
        hashCodeCheckBox.setSelected( config.isIncludeHashcodeAndEquals());
        toStringCheckBox.setSelected( config.isIncludeToString());
        useBuilders.setSelected(config.isGenerateBuilders());
        
        classNameSuffixField.setText( config.getClassNameSuffix());
        
        updateClassNamePreview();
    }
    
    public void writeToConfig(ClassesGeneratorConfig config) {
        config.setIncludeAdditionalProperties( additionalPropertiesCheckBox.isSelected());
        config.setIncludeGeneratedAnnotation(generatorCheckBox.isSelected());
        config.setUsePrimitives( primitiveTypesCheckBox.isSelected());
        config.setIncludeHashcodeAndEquals(hashCodeCheckBox.isSelected());
        config.setIncludeToString(toStringCheckBox.isSelected());
        config.setGenerateBuilder( useBuilders.isSelected());
        
        config.setClassNameSuffix( classNameSuffixField.getText());
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mainClassNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        classNameSuffixField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        classNamePreviewField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        packageNameField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        additionalPropertiesCheckBox = new javax.swing.JCheckBox();
        toStringCheckBox = new javax.swing.JCheckBox();
        hashCodeCheckBox = new javax.swing.JCheckBox();
        generatorCheckBox = new javax.swing.JCheckBox();
        primitiveTypesCheckBox = new javax.swing.JCheckBox();
        useBuilders = new javax.swing.JCheckBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jLabel2.text")); // NOI18N

        mainClassNameField.setText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.mainClassNameField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jLabel3.text")); // NOI18N

        classNameSuffixField.setText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.classNameSuffixField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jLabel4.text")); // NOI18N

        classNamePreviewField.setEditable(false);
        classNamePreviewField.setText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.classNamePreviewField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jLabel1.text")); // NOI18N

        packageNameField.setEditable(false);
        packageNameField.setText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.packageNameField.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(mainClassNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 19, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(classNameSuffixField))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(classNamePreviewField))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(packageNameField)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(packageNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainClassNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classNameSuffixField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(classNamePreviewField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(additionalPropertiesCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.additionalPropertiesCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(toStringCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.toStringCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(hashCodeCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.hashCodeCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(generatorCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.generatorCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(primitiveTypesCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.primitiveTypesCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(useBuilders, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useBuilders.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(additionalPropertiesCheckBox)
                    .addComponent(toStringCheckBox)
                    .addComponent(hashCodeCheckBox)
                    .addComponent(generatorCheckBox)
                    .addComponent(primitiveTypesCheckBox)
                    .addComponent(useBuilders))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(additionalPropertiesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toStringCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hashCodeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generatorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(primitiveTypesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useBuilders)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox additionalPropertiesCheckBox;
    private javax.swing.JTextField classNamePreviewField;
    private javax.swing.JTextField classNameSuffixField;
    private javax.swing.JCheckBox generatorCheckBox;
    private javax.swing.JCheckBox hashCodeCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mainClassNameField;
    private javax.swing.JTextField packageNameField;
    private javax.swing.JCheckBox primitiveTypesCheckBox;
    private javax.swing.JCheckBox toStringCheckBox;
    private javax.swing.JCheckBox useBuilders;
    // End of variables declaration//GEN-END:variables

    private class RelevantClassNameDataListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateClassNamePreview();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateClassNamePreview();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateClassNamePreview();
        }
        
    }

}
