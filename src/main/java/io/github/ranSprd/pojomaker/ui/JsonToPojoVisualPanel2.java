package io.github.ranSprd.pojomaker.ui;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import io.github.ranSprd.pojomaker.ClassesGeneratorConfig;
import org.apache.commons.lang3.StringUtils;

public final class JsonToPojoVisualPanel2 extends JPanel {
    
    /**
     * Creates new form JsonToPojoVisualPanel2
     */
    public JsonToPojoVisualPanel2() {
        initComponents();
        mainClassNameField.getDocument().addDocumentListener( new RelevantClassNameDataListener());
        classNameSuffixField.getDocument().addDocumentListener( new RelevantClassNameDataListener());
        classNamePrefixField.getDocument().addDocumentListener( new RelevantClassNameDataListener());
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
        return classNamePrefixField.getText() +mainClassNameField.getText() +classNameSuffixField.getText();
    }

    @Override
    public String getName() {
        return "Naming and Settings";
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
        useSetters.setSelected(config.isIncludeSetters());
        useBuilders.setEnabled( config.isIncludeSetters());
        useBuilders.setSelected(config.isGenerateBuilders());
        useGetters.setSelected(config.isIncludeGetters());
        useOptional.setEnabled(config.isIncludeGetters());
        useOptional.setSelected( config.isUseOptionalForGetters());
        addConstructor.setSelected(config.isIncludeConstructors());
        
        classNameSuffixField.setText( config.getClassNameSuffix());
        
        switch (config.getJsonCodeAnnotations()) {
            case ALL: fullAnnotationsRadioButton.setSelected(true);
                      break;
            case REDUCED : reducedAnnotationsRadioButton.setSelected(true);
                           break;
            case NOTHING:
                 default: noAnnotationsRadioButton.setSelected(true);
        }
        
        updateClassNamePreview();
    }
    
    public void writeToConfig(ClassesGeneratorConfig config) {
        config.setIncludeAdditionalProperties( additionalPropertiesCheckBox.isSelected());
        config.setIncludeGeneratedAnnotation(generatorCheckBox.isSelected());
        config.setUsePrimitives( primitiveTypesCheckBox.isSelected());
        config.setIncludeHashcodeAndEquals(hashCodeCheckBox.isSelected());
        config.setIncludeToString(toStringCheckBox.isSelected());
        config.setGenerateBuilder( useBuilders.isSelected());
        config.setIncludeSetters( useSetters.isSelected());
        config.setIncludeGetters( useGetters.isSelected());
        config.setUseOptionalForGetters(useOptional.isSelected());
        config.setIncludeConstructors( addConstructor.isSelected());
        
        config.setClassNameSuffix( classNameSuffixField.getText());
        
        if (fullAnnotationsRadioButton.isSelected()) {
            config.setJsonCodeAnnotations(ClassesGeneratorConfig.JsonCodeAnnotations.ALL);
        } else if (reducedAnnotationsRadioButton.isSelected()) {
            config.setJsonCodeAnnotations(ClassesGeneratorConfig.JsonCodeAnnotations.REDUCED);
        } else {
            config.setJsonCodeAnnotations(ClassesGeneratorConfig.JsonCodeAnnotations.NOTHING);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        annotationButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mainClassNameField = new javax.swing.JTextField();
        SuffixLabel = new javax.swing.JLabel();
        classNameSuffixField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        classNamePreviewField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        packageNameField = new javax.swing.JTextField();
        PrefixLabel = new javax.swing.JLabel();
        classNamePrefixField = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        additionalPropertiesCheckBox = new javax.swing.JCheckBox();
        generatorCheckBox = new javax.swing.JCheckBox();
        primitiveTypesCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        addConstructor = new javax.swing.JCheckBox();
        toStringCheckBox = new javax.swing.JCheckBox();
        hashCodeCheckBox = new javax.swing.JCheckBox();
        useSetters = new javax.swing.JCheckBox();
        useGetters = new javax.swing.JCheckBox();
        useBuilders = new javax.swing.JCheckBox();
        useOptional = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        noAnnotationsRadioButton = new javax.swing.JRadioButton();
        reducedAnnotationsRadioButton = new javax.swing.JRadioButton();
        fullAnnotationsRadioButton = new javax.swing.JRadioButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jLabel2.text")); // NOI18N

        mainClassNameField.setText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.mainClassNameField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SuffixLabel, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.SuffixLabel.text")); // NOI18N

        classNameSuffixField.setText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.classNameSuffixField.text")); // NOI18N
        classNameSuffixField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classNameSuffixFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jLabel4.text")); // NOI18N

        classNamePreviewField.setEditable(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jLabel1.text")); // NOI18N

        packageNameField.setEditable(false);
        packageNameField.setText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.packageNameField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(PrefixLabel, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.PrefixLabel.text")); // NOI18N
        PrefixLabel.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.PrefixLabel.toolTipText")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(classNamePreviewField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(223, 223, 223))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(packageNameField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PrefixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(classNamePrefixField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(classNameSuffixField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(SuffixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(mainClassNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(packageNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainClassNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrefixLabel)
                    .addComponent(SuffixLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classNamePrefixField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classNameSuffixField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(classNamePreviewField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(additionalPropertiesCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.additionalPropertiesCheckBox.text")); // NOI18N
        additionalPropertiesCheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.additionalPropertiesCheckBox.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(generatorCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.generatorCheckBox.text")); // NOI18N
        generatorCheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.generatorCheckBox.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(primitiveTypesCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.primitiveTypesCheckBox.text")); // NOI18N
        primitiveTypesCheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.primitiveTypesCheckBox.toolTipText")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(additionalPropertiesCheckBox)
                    .addComponent(generatorCheckBox)
                    .addComponent(primitiveTypesCheckBox))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(additionalPropertiesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generatorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(primitiveTypesCheckBox)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N
        jPanel2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel2.AccessibleContext.accessibleName")); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel3.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addConstructor, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.addConstructor.text")); // NOI18N
        addConstructor.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.addConstructor.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(toStringCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.toStringCheckBox.text")); // NOI18N
        toStringCheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.toStringCheckBox.toolTipText")); // NOI18N
        toStringCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toStringCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(hashCodeCheckBox, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.hashCodeCheckBox.text")); // NOI18N
        hashCodeCheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.hashCodeCheckBox.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(useSetters, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useSetters.text")); // NOI18N
        useSetters.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useSetters.toolTipText")); // NOI18N
        useSetters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useSettersActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(useGetters, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useGetters.text")); // NOI18N
        useGetters.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useGetters.toolTipText")); // NOI18N
        useGetters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useGettersActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(useBuilders, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useBuilders.text")); // NOI18N
        useBuilders.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useBuilders.toolTipText")); // NOI18N
        useBuilders.setEnabled(useSetters.isSelected());
        useBuilders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useBuildersActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(useOptional, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useOptional.text")); // NOI18N
        useOptional.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.useOptional.toolTipText")); // NOI18N
        useOptional.setEnabled(useGetters.isSelected());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toStringCheckBox)
                    .addComponent(addConstructor)
                    .addComponent(hashCodeCheckBox)
                    .addComponent(useSetters)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(useBuilders)
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(useOptional))
                            .addComponent(useGetters))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addConstructor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toStringCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hashCodeCheckBox)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useSetters)
                    .addComponent(useGetters))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useBuilders)
                    .addComponent(useOptional))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel4.border.title"))); // NOI18N

        annotationButtonGroup.add(noAnnotationsRadioButton);
        noAnnotationsRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(noAnnotationsRadioButton, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.noAnnotationsRadioButton.text")); // NOI18N

        annotationButtonGroup.add(reducedAnnotationsRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(reducedAnnotationsRadioButton, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.reducedAnnotationsRadioButton.text")); // NOI18N
        reducedAnnotationsRadioButton.setToolTipText(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.reducedAnnotationsRadioButton.toolTipText")); // NOI18N

        annotationButtonGroup.add(fullAnnotationsRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(fullAnnotationsRadioButton, org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.fullAnnotationsRadioButton.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fullAnnotationsRadioButton)
                    .addComponent(reducedAnnotationsRadioButton)
                    .addComponent(noAnnotationsRadioButton))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(noAnnotationsRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reducedAnnotationsRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullAnnotationsRadioButton)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(JsonToPojoVisualPanel2.class, "JsonToPojoVisualPanel2.jPanel4.TabConstraints.tabTitle"), jPanel4); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void toStringCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toStringCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toStringCheckBoxActionPerformed

    private void classNameSuffixFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classNameSuffixFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classNameSuffixFieldActionPerformed

    private void useBuildersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useBuildersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useBuildersActionPerformed

    private void useGettersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useGettersActionPerformed
        // TODO add your handling code here:
        useOptional.setEnabled( useGetters.isSelected());
    }//GEN-LAST:event_useGettersActionPerformed

    private void useSettersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useSettersActionPerformed
        // TODO add your handling code here:
        useBuilders.setEnabled( useSetters.isSelected());
    }//GEN-LAST:event_useSettersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PrefixLabel;
    private javax.swing.JLabel SuffixLabel;
    private javax.swing.JCheckBox addConstructor;
    private javax.swing.JCheckBox additionalPropertiesCheckBox;
    private javax.swing.ButtonGroup annotationButtonGroup;
    private javax.swing.JTextField classNamePrefixField;
    private javax.swing.JTextField classNamePreviewField;
    private javax.swing.JTextField classNameSuffixField;
    private javax.swing.JRadioButton fullAnnotationsRadioButton;
    private javax.swing.JCheckBox generatorCheckBox;
    private javax.swing.JCheckBox hashCodeCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mainClassNameField;
    private javax.swing.JRadioButton noAnnotationsRadioButton;
    private javax.swing.JTextField packageNameField;
    private javax.swing.JCheckBox primitiveTypesCheckBox;
    private javax.swing.JRadioButton reducedAnnotationsRadioButton;
    private javax.swing.JCheckBox toStringCheckBox;
    private javax.swing.JCheckBox useBuilders;
    private javax.swing.JCheckBox useGetters;
    private javax.swing.JCheckBox useOptional;
    private javax.swing.JCheckBox useSetters;
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
