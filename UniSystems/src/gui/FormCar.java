/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import car.*;
import loaning.*;
import javax.swing.DefaultListModel;
import people.Administrator;

/**
 *
 * @author Craig
 */
public class FormCar extends javax.swing.JFrame {

    private Administrator admin;
    private DefaultListModel serviceListModel;
    private DefaultListModel loanListModel;

    /**
     * Creates new form FormCar
     */
    public FormCar() {
        initComponents();

        this.getContentPane().setBackground(new Color (238,238,238));
        this.btnUpdate.setVisible(false);


    }

    public FormCar(Administrator admin){
        initComponents();

        this.getContentPane().setBackground(new Color (238,238,238));
        this.btnUpdate.setVisible(false);
        this.scrlLoanHistory.setVisible(false);
        this.lblLoanHistory.setVisible(false);
        this.scrlServiceHistory.setVisible(false);
        this.lblServiceHistory.setVisible(false);
        this.lblStatus.setVisible(false);
        this.lblStatusTitle.setVisible(false);
        this.setSize(this.getSize().width,
                jSeparator2.getLocation().y + jSeparator2.getSize().height 
                        + btnCreate.getSize().height);
        this.admin = admin;
    }

    /**
     * This constructor will auto-populate the fields given that the
     * List of cars contains a car with the regNo that you pass as a param.
     * @param regNo
     */
    public FormCar(String regNo) {

        initComponents();

        serviceListModel = new DefaultListModel();
        loanListModel = new DefaultListModel();


        //cars.loadFromDisk();
        //loans.loadFromDisk();
        this.getContentPane().setBackground(new Color (238,238,238));
        this.btnCreate.setVisible(false);
        Car car = admin.getCarByReg(regNo);
        if (car != null) {
            this.txtRegNo.setText(regNo);
            this.cboClassification.setSelectedItem(car.getClassification());
            this.txtMileage.setText(Integer.toString(car.getMilage()));
            this.cboFuelType.setSelectedItem(car.getFuelType());
            this.cboTransmission.setSelectedItem(car.getTransmission());
            this.txtDoors.setText(Integer.toString(car.getDoors()));
            this.txtSeats.setText(Integer.toString(car.getSeats()));
            this.txtLocation.setText(car.getLocation());
            this.lblStatus.setText(car.getStatus().name());
            populateServiceHistoryList(car);
            populateLoanHistory(car);
        }


    }
    /**
     * populate car service history list
     * @param reg car registration number
     */
    private void populateServiceHistoryList(Car objCar) {
        serviceListModel.clear();

        for (int i=0; i < objCar.getServiceRecord().size(); i++){
            String listElement = objCar.getServiceRecord().get(i).getMechanic() + " - ";
            listElement += objCar.getServiceRecord().get(i).getSummary() + " - ";
            listElement += data.UtilityFunctions.formatDate(
            objCar.getServiceRecord().get(i).getDateOfService()) + " ";
            serviceListModel.addElement(listElement);
        }

        this.lstServiceHistory.setModel(serviceListModel);

    }

    private void populateLoanHistory(Car objCar){
        loanListModel.clear();
        String listElement = "";
        
        for (DayLoan dayLoan : admin.getDayLoansForRef(objCar.getRegNo())) {
            listElement = dayLoan.getLoaner().getForename().toString()+" "
                        + dayLoan.getLoaner().getSurname()+" - ";
            listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
            loanListModel.addElement(listElement);
        }
        
        for (LongLoan longLoan : admin.getLongLoansForRef(objCar.getRegNo())) {
            listElement = longLoan.getLoaner().getForename().toString()+" "
                        + longLoan.getLoaner().getSurname()+" - ";
            listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate())+" - "+
                           data.UtilityFunctions.formatDate(longLoan.getEndDate());
            loanListModel.addElement(listElement);
        }

        this.lstLoanHistory.setModel(loanListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        lblRegTitle = new javax.swing.JLabel();
        lblTransmissionTitle = new javax.swing.JLabel();
        lblMileageTitle = new javax.swing.JLabel();
        lblFuelTitle = new javax.swing.JLabel();
        lblClassTitle = new javax.swing.JLabel();
        lblLocationTitle = new javax.swing.JLabel();
        lblSeatsTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblStatusTitle = new javax.swing.JLabel();
        scrlLoanHistory = new javax.swing.JScrollPane();
        lstLoanHistory = new javax.swing.JList<>();
        lblLoanHistory = new javax.swing.JLabel();
        scrlServiceHistory = new javax.swing.JScrollPane();
        lstServiceHistory = new javax.swing.JList<>();
        lblServiceHistory = new javax.swing.JLabel();
        txtRegNo = new javax.swing.JTextField();
        txtMileage = new javax.swing.JTextField();
        txtDoors = new javax.swing.JTextField();
        txtSeats = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cboTransmission = new javax.swing.JComboBox<>();
        cboFuelType = new javax.swing.JComboBox<>();
        lblDoorsTitle = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        cboClassification = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(450, 300));

        lblTitle.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Car Details");
        lblTitle.setToolTipText("");

        lblRegTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblRegTitle.setText("Registration No:");

        lblTransmissionTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblTransmissionTitle.setText("Transmission:");

        lblMileageTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblMileageTitle.setText("Mileage:");

        lblFuelTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblFuelTitle.setText("Fuel Type:");

        lblClassTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblClassTitle.setText("Class:");

        lblLocationTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblLocationTitle.setText("Location:");

        lblSeatsTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblSeatsTitle.setText("Seats:");

        lblStatusTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblStatusTitle.setText("Status:");

        lstLoanHistory.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        scrlLoanHistory.setViewportView(lstLoanHistory);

        lblLoanHistory.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        lblLoanHistory.setText("Loan History");

        lstServiceHistory.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        scrlServiceHistory.setViewportView(lstServiceHistory);

        lblServiceHistory.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        lblServiceHistory.setText("Service History");

        txtRegNo.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtMileage.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtDoors.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtSeats.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblStatus.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        lblStatus.setText("PLACEHOLDER");

        cboTransmission.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboTransmission.setModel(new DefaultComboBoxModel(Transmission.values()));

        cboFuelType.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboFuelType.setModel(new DefaultComboBoxModel(FuelType.values()));

        lblDoorsTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblDoorsTitle.setText("Doors:");

        txtLocation.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        cboClassification.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboClassification.setModel(new DefaultComboBoxModel(Classification.values()));

        btnCancel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setAlignmentX(0.5F);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.setAlignmentX(0.5F);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setAlignmentX(0.5F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrlServiceHistory, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrlLoanHistory, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblServiceHistory)
                                    .addComponent(lblLoanHistory))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRegTitle)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(lblStatusTitle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblStatus)
                                        .addGap(199, 199, 199))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cboFuelType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboTransmission, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboClassification, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblMileageTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMileage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblLocationTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(lblSeatsTitle)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(lblDoorsTitle)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtDoors, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18))))
                            .addComponent(lblFuelTitle)
                            .addComponent(lblTransmissionTitle)
                            .addComponent(lblClassTitle))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegTitle)
                    .addComponent(txtRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMileageTitle)
                    .addComponent(txtMileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClassTitle)
                    .addComponent(cboClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocationTitle)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransmissionTitle)
                    .addComponent(cboTransmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoorsTitle)
                    .addComponent(txtDoors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuelTitle)
                    .addComponent(cboFuelType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeatsTitle)
                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(lblStatusTitle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(scrlLoanHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLoanHistory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblServiceHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlServiceHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        Car newCar = new Car(txtRegNo.getText(), (Transmission)cboTransmission.getSelectedItem()
            , (FuelType)cboFuelType.getSelectedItem(), txtLocation.getText(),
            (Classification)cboClassification.getSelectedItem(),
            Integer.parseInt(txtSeats.getText()),Integer.parseInt(txtDoors.getText()),
            Integer.parseInt(txtMileage.getText()) );
        admin.createCar(newCar);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        FormCarLookup frm = new FormCarLookup();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCar().setVisible(true);
            }
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboClassification;
    private javax.swing.JComboBox<String> cboFuelType;
    private javax.swing.JComboBox<String> cboTransmission;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblClassTitle;
    private javax.swing.JLabel lblDoorsTitle;
    private javax.swing.JLabel lblFuelTitle;
    private javax.swing.JLabel lblLoanHistory;
    private javax.swing.JLabel lblLocationTitle;
    private javax.swing.JLabel lblMileageTitle;
    private javax.swing.JLabel lblRegTitle;
    private javax.swing.JLabel lblSeatsTitle;
    private javax.swing.JLabel lblServiceHistory;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTransmissionTitle;
    private javax.swing.JList<String> lstLoanHistory;
    private javax.swing.JList<String> lstServiceHistory;
    private javax.swing.JScrollPane scrlLoanHistory;
    private javax.swing.JScrollPane scrlServiceHistory;
    private javax.swing.JTextField txtDoors;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtMileage;
    private javax.swing.JTextField txtRegNo;
    private javax.swing.JTextField txtSeats;
    // End of variables declaration//GEN-END:variables
}
