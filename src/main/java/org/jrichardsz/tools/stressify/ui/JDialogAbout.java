/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrichardsz.tools.stressify.ui;

import java.awt.Image;
import javax.swing.ImageIcon;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author jarvis
 */
public class JDialogAbout extends javax.swing.JDialog {

    /**
     * Creates new form JDialogAbout
     */
    public JDialogAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        configureIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAboutAppIcon = new javax.swing.JLabel();
        jLabelTittle = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jLabelDevelopedBy = new javax.swing.JLabel();
        jLabelAboutDeveloperIcon = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabelAboutAppIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAboutAppIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/utec/tools/stressify/ui/icon_100x100.png"))); // NOI18N
        jLabelAboutAppIcon.setAlignmentY(0.0F);

        jLabelTittle.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabelTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTittle.setText("Stressify");

        jLabelDescription.setText("<html>Stressify is a minimal application which help you to detect load behaviors in your http resources.<br><br>Stressify is not a replacement for jmeter or soapui , but it can help you if you need a quickly stress to determine how many concurrent users does it support.</html>");
        jLabelDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelDevelopedBy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDevelopedBy.setText("<html>Developed by <a href=\"https://github.com/jrichardsz\">JRichardsz</a></html>");

        jLabelAboutDeveloperIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAboutDeveloperIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/utec/tools/stressify/ui/me_31x31.png"))); // NOI18N
        jLabelAboutDeveloperIcon.setAlignmentY(0.0F);
        jLabelAboutDeveloperIcon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelAboutDeveloperIcon.setPreferredSize(new java.awt.Dimension(50, 50));

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("https://github.com/jrichardsz-software-architect-tools/stressify");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAboutDeveloperIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDevelopedBy)
                            .addComponent(jLabelAboutAppIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAboutAppIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDevelopedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAboutDeveloperIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogAbout dialog = new JDialogAbout(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void configureIcon(){
        int widthAboutAppIcon = 256;
        int heightAboutAppIcon = 256;

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/edu/utec/tools/stressify/ui/icon.png")).
                getImage().getScaledInstance(widthAboutAppIcon, heightAboutAppIcon, Image.SCALE_DEFAULT));
        jLabelAboutAppIcon.setIcon(imageIcon);

        int widthAboutDeveloperIcon = jLabelAboutDeveloperIcon.getSize().width;
        int heightAboutDeveloperIcon = jLabelAboutDeveloperIcon.getSize().height;

        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource("/edu/utec/tools/stressify/ui/me.png")).
                getImage().getScaledInstance(widthAboutDeveloperIcon, heightAboutDeveloperIcon, Image.SCALE_DEFAULT));
        jLabelAboutDeveloperIcon.setIcon(imageIcon2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAboutAppIcon;
    private javax.swing.JLabel jLabelAboutDeveloperIcon;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelDevelopedBy;
    private javax.swing.JLabel jLabelTittle;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
