/*
 * Τμήμα ΗΛΕ 43
 * @author ΒΑΣΙΛΗΣ ΤΣΑΠΑΡΙΚΟΣ - 114307
 * @author ΑΙΚΑΤΕΡΙΝΗ ΚΟΛΕΒΕΝΤΗ - 126971
 * @author ΑΡΙΣΤΕΙΔΗΣ ΦΑΣΟΥΛΑΣ - 100318
 */
package View;

import controller.*;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.*;
import remote.JsonManager;

/**
 *
 * @author Bill
 */
public class MainGui extends javax.swing.JFrame {

    /**
     * Creates new form MainGui
     */
    private CountryDataset currentGDPDataset = new CountryDataset();
    private CountryDataset currentOilDataset = new CountryDataset();
    private Country currentCountry = new Country();
    
    public MainGui() {
        initComponents();
        //Read contents of CSV file and update DB if necessary
        initializeData();
        //Renderer for the binding of Country Selector 
        countrySelector.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(
                   JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    if(value instanceof Country){
                       Country ct = (Country) value;
                       return super.getListCellRendererComponent(list, ct.getName(), index, isSelected, cellHasFocus);
                   }
               return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
            }
        });
        
        saveButton.setEnabled(false);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        EconometricaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("EconometricaPU").createEntityManager();
        countryQuery = java.beans.Beans.isDesignTime() ? null : EconometricaPUEntityManager.createQuery("SELECT c FROM Country c");
        countryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : countryQuery.getResultList();
        currentGdpQuery = java.beans.Beans.isDesignTime() ? null : EconometricaPUEntityManager.createQuery("SELECT c FROM CurrentGdp c");
        currentGdpList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : currentGdpQuery.getResultList();
        currentOilDataQuery = java.beans.Beans.isDesignTime() ? null : EconometricaPUEntityManager.createQuery("SELECT c FROM CurrentOilData c");
        currentOilDataList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : currentOilDataQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        countrySelector = new javax.swing.JComboBox<>();
        jButtonFetch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelOilDatasetName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelOilStart = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelOilEnd = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOil = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelGDPDatasetName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelGDPStart = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelGDPEnd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGDP = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        savedInDBCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, countryList, countrySelector);
        bindingGroup.addBinding(jComboBoxBinding);

        countrySelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                countrySelectorItemStateChanged(evt);
            }
        });
        countrySelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countrySelectorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 1, 6, 0);
        jPanel1.add(countrySelector, gridBagConstraints);

        jButtonFetch.setText("Fetch Data");
        jButtonFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFetchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        jPanel1.add(jButtonFetch, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Select Country :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("OIL DATA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Dataset Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(jLabel4, gridBagConstraints);

        labelOilDatasetName.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(labelOilDatasetName, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Available Timespan : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 5, 0);
        jPanel3.add(jLabel8, gridBagConstraints);

        jLabel11.setText("Start Date :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 4, 0);
        jPanel3.add(jLabel11, gridBagConstraints);

        labelOilStart.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jPanel3.add(labelOilStart, gridBagConstraints);

        jLabel13.setText("End Date :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(jLabel13, gridBagConstraints);

        labelOilEnd.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(labelOilEnd, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 150));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, currentOilDataList, jTableOil);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataYear}"));
        columnBinding.setColumnName("Data Year");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${value}"));
        columnBinding.setColumnName("Value");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTableOil);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("GDP DATA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Dataset Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        labelGDPDatasetName.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(labelGDPDatasetName, gridBagConstraints);

        jLabel9.setText("Start Date :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 4, 0);
        jPanel4.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Available Timespan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 5, 0);
        jPanel4.add(jLabel10, gridBagConstraints);

        labelGDPStart.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jPanel4.add(labelGDPStart, gridBagConstraints);

        jLabel16.setText("End Date :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(jLabel16, gridBagConstraints);

        labelGDPEnd.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(labelGDPEnd, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 150));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, currentGdpList, jTableGDP);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataYear}"));
        columnBinding.setColumnName("Data Year");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${value}"));
        columnBinding.setColumnName("Value");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTableGDP);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel2.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(saveButton, gridBagConstraints);

        jButton3.setText("Plot");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton3, gridBagConstraints);

        deleteButton.setText("DELETE ALL");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(deleteButton, gridBagConstraints);

        savedInDBCheckBox.setText("Already Saved to Database");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 24);
        getContentPane().add(savedInDBCheckBox, gridBagConstraints);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void countrySelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countrySelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countrySelectorActionPerformed

    private void countrySelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_countrySelectorItemStateChanged
        if(evt.getSource()== countrySelector){
            
            currentCountry = (Country) countrySelector.getSelectedItem();
            
            
        }
    }//GEN-LAST:event_countrySelectorItemStateChanged

    private void jButtonFetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFetchActionPerformed
        if(evt.getSource() == jButtonFetch){
            ControllerCountryDataset controllerCountryDataset  = new ControllerCountryDataset();
                      
            //Checking if data exists in the database
            if(!controllerCountryDataset.isInTheDatabase(currentCountry)){//in case they don't exist
                
                //Make the Api calls
                JsonManager jm = new JsonManager();
                
                //Uncheck box to indicate that data exists in the DB
                savedInDBCheckBox.setSelected(false);
                                
                //Get the GDP data
                currentGDPDataset = jm.fetchGDP(currentCountry);
                
                //Update Labels 
                refreshGDPLabels();
                
                //Update jTable in UI
                refreshGDPTable();
                
                //Get the Oil Data
                currentOilDataset = jm.fetchOil(currentCountry);
                
                //Update Labels 
                refreshOilLabels();
                
                //Update jTable in UI
                refreshOilTable();

                //Enable SAVE button
                saveButton.setEnabled(true);
                
                
            } else {
                
                                
                List<CountryDataset> r = controllerCountryDataset.selectByCountryName(currentCountry);
                List<CurrentGdp> listCurrentGdp = new ArrayList<CurrentGdp>();
                List<CurrentOilData> listCurrentOil = new ArrayList<CurrentOilData>();
                ControllerCurrentGDP controllerCurrentGDP = new ControllerCurrentGDP();
                ControllerCurrentOilData controllerOil = new ControllerCurrentOilData();
                
                //Check box to indicate that data exists in the DB
                savedInDBCheckBox.setSelected(true);

                //Disable SAVE button
                saveButton.setEnabled(false);
                
                //Copy the contents of the Database to the live tables.
                for(CountryDataset cd : r){
                    if(cd.getDescription().contains("GDP")){
                        
                        currentGDPDataset.setCountryCode(cd.getCountryCode());
                        currentGDPDataset.setCountryDataList(cd.getCountryDataList());
                        currentGDPDataset.setDescription(cd.getDescription());
                        currentGDPDataset.setStartYear(cd.getStartYear());
                        currentGDPDataset.setEndYear(cd.getEndYear());
                        currentGDPDataset.setName(cd.getName());
                        
                        for(CountryData countryData : cd.getCountryDataList()){
                            CurrentGdp cGdp = new CurrentGdp();
                            cGdp.setDataYear(countryData.getDataYear());
                            cGdp.setValue(countryData.getValue());
                            listCurrentGdp.add(cGdp);
                        }
                        
                        controllerCurrentGDP.addCurrentGdp(listCurrentGdp);
                        refreshGDPLabels();
                        refreshGDPTable();
                    
                    } else if (cd.getDescription().contains("Oil")){
                        
                        
                        currentOilDataset.setCountryCode(cd.getCountryCode());
                        currentOilDataset.setCountryDataList(cd.getCountryDataList());
                        currentOilDataset.setDescription(cd.getDescription());
                        currentOilDataset.setStartYear(cd.getStartYear());
                        currentOilDataset.setEndYear(cd.getEndYear());
                        currentOilDataset.setName(cd.getName());
                        
                        for(CountryData countryData : cd.getCountryDataList()){
                            CurrentOilData cOil = new CurrentOilData();
                            cOil.setDataYear(countryData.getDataYear());
                            cOil.setValue(countryData.getValue());
                            listCurrentOil.add(cOil);
                        }
                        
                        controllerOil.addCurrentOil(listCurrentOil);
                        refreshOilLabels();
                        refreshOilTable();

                    }
                }
                
                //If there was only one dataset in the DB 
                if(r.size()==1){
                    if(r.get(0).getDescription().contains("GDP")){
                        controllerOil.deleteData();
                        currentOilDataset = new CountryDataset();
                        refreshOilLabels();
                        refreshOilTable();
                    }
                    if(r.get(0).getDescription().contains("Oil")){
                        controllerCurrentGDP.deleteData();
                        currentGDPDataset = new CountryDataset();
                        refreshGDPLabels();
                        refreshGDPTable();
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonFetchActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(evt.getSource() == saveButton){
            ControllerCountryDataset controllerCountryDataset = new ControllerCountryDataset();
            
            if(currentGDPDataset.getCountryCode()!= null){
                controllerCountryDataset.addCountryDataset(currentGDPDataset);
            }
            if(currentOilDataset.getCountryCode()!= null){
                controllerCountryDataset.addCountryDataset(currentOilDataset);
            }
            
            
            //Disable SAVE Button
            saveButton.setEnabled(false);
            //Check box to indicate that data exists in the DB
            savedInDBCheckBox.setSelected(true);

        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(evt.getSource() == deleteButton ){
            //Display a confirmation Dialog
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all Data", "Delete", JOptionPane.YES_NO_OPTION);
            
            //If answer was yes
            if(option == 0){
                ControllerCountryData controllerCountryData = new ControllerCountryData();
                ControllerCountryDataset controllerCountryDataset = new ControllerCountryDataset();
                
                //Delete all Data
                controllerCountryData.deleteData();
                controllerCountryDataset.deleteData();
                
                //Update UI elements
                saveButton.setEnabled(true);
                savedInDBCheckBox.setSelected(false);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    public void refreshGDPLabels(){
        if(currentGDPDataset.getName() == null){//if no valid data were found inform the User
            labelGDPDatasetName.setText("No Data Were Found");
            labelGDPStart.setText(" ");
            labelGDPEnd.setText(" ");
                    
            } else {
            //Update Label Text to fit data
            labelGDPDatasetName.setText(currentGDPDataset.getName());
            labelGDPStart.setText(currentGDPDataset.getStartYear() + "-12-31");
            labelGDPEnd.setText(currentGDPDataset.getEndYear() + "-12-31");
        }
    }
    
    public void refreshOilLabels(){
        if(currentOilDataset.getName() == null){//if no valid data were found inform the User
            labelOilDatasetName.setText("No Data Were Found");
            labelOilStart.setText(" ");
            labelOilEnd.setText(" ");
        } else {
            labelOilDatasetName.setText(currentOilDataset.getName());
            labelOilStart.setText(currentOilDataset.getStartYear() + "-12-31");
            labelOilEnd.setText(currentOilDataset.getEndYear() + "-12-31");

        }
    }
    
    public void refreshOilTable(){
        currentOilDataQuery = java.beans.Beans.isDesignTime() ? null : EconometricaPUEntityManager.createQuery("SELECT c FROM CurrentOilData c ORDER BY c.dataYear DESC");
        currentOilDataList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : currentOilDataQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, currentOilDataList, jTableOil);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding3 = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataYear}"));
        columnBinding3.setColumnName("Data Year");
        columnBinding3.setColumnClass(String.class);
        columnBinding3 = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${value}"));
        columnBinding3.setColumnName("Value");
        columnBinding3.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }
    
    public void refreshGDPTable(){
        currentGdpQuery = java.beans.Beans.isDesignTime() ? null : EconometricaPUEntityManager.createQuery("SELECT c FROM CurrentGdp c ORDER BY c.dataYear DESC" );
        currentGdpList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : currentGdpQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, currentGdpList, jTableGDP);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataYear}"));
        columnBinding.setColumnName("Data Year");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${value}"));
        columnBinding.setColumnName("Value");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager EconometricaPUEntityManager;
    private java.util.List<model.Country> countryList;
    private javax.persistence.Query countryQuery;
    private javax.swing.JComboBox<String> countrySelector;
    private java.util.List<model.CurrentGdp> currentGdpList;
    private javax.persistence.Query currentGdpQuery;
    private java.util.List<model.CurrentOilData> currentOilDataList;
    private javax.persistence.Query currentOilDataQuery;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonFetch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGDP;
    private javax.swing.JTable jTableOil;
    private javax.swing.JLabel labelGDPDatasetName;
    private javax.swing.JLabel labelGDPEnd;
    private javax.swing.JLabel labelGDPStart;
    private javax.swing.JLabel labelOilDatasetName;
    private javax.swing.JLabel labelOilEnd;
    private javax.swing.JLabel labelOilStart;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox savedInDBCheckBox;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


public void initializeData(){
        List<List<String>> records = new ArrayList<>();
        List<Country> countryList = new ArrayList<>();
        ControllerCountry controllerCountry = new ControllerCountry();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/resources/iso-countries.csv")); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        }
        catch (Exception e){
            System.out.println(e);        
        }
        
        for (List<String> e :records){
            
            if (e.get(2).length() == 3){
                Country country = new Country(e.get(2),e.get(0));
                countryList.add(country);
                if(!controllerCountry.isInTheDatabase(country)){
                    controllerCountry.addCountry(country);
                }
                
            }
            
        }
        
    }
        
}