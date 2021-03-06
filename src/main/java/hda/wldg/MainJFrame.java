/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hda.wldg;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author daan
 */
public class MainJFrame extends javax.swing.JFrame {

    static Logger logger = LoggerFactory.getLogger(MainJFrame.class);

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wlTarget = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtWarFile = new javax.swing.JTextField();
        btWarFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOut = new javax.swing.JTextArea();
        btDeploy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weblogic Deployer Gui");
        setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        setResizable(false);

        wlTarget.setModel(new javax.swing.DefaultComboBoxModel(hda.wldg.ToolConfig.getDomainList()));

        jLabel1.setText("Target");

        txtWarFile.setEditable(false);
        txtWarFile.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        txtWarFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWarFileActionPerformed(evt);
            }
        });

        btWarFile.setText("Pick war");
        btWarFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWarFileActionPerformed(evt);
            }
        });

        txtOut.setEditable(false);
        txtOut.setColumns(20);
        txtOut.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        txtOut.setLineWrap(true);
        txtOut.setRows(5);
        txtOut.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtOut);

        btDeploy.setText("distribute");
        btDeploy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeployActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDeploy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtWarFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btWarFile))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wlTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wlTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWarFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btWarFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeploy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("WeblogicDeployTool - dahan@chinaums.com");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btWarFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWarFileActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser();
        
        String c = txtWarFile.getText();
        if (c.isEmpty()){
            c = "..";
        }
        fileChooser.setCurrentDirectory(new File(c));

        FileFilter warFileFilter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".war");
            }

            @Override
            public String getDescription() {
                return "*.war";
            }
        };

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
        fileChooser.setFileFilter(warFileFilter);

        int rVal = fileChooser.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            logger.info(fileChooser.getSelectedFile().toString());
            txtWarFile.setText(fileChooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_btWarFileActionPerformed

    private void btDeployActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeployActionPerformed
        // TODO add your handling code here:
        btDeploy.setEnabled(false);
        if (txtWarFile.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Choose war file", "", JOptionPane.WARNING_MESSAGE);
            btDeploy.setEnabled(true);
        } else {

            String app = wlTarget.getSelectedItem().toString();
            StringBuilder cmd = new StringBuilder();
            cmd.append("java -cp ")
                    .append(ToolConfig.getWeblogicJarLocation())
                    .append(" weblogic.Deployer -upload -adminurl ")
                    .append(ToolConfig.getAdminUrl(app))
                    .append(" -username ").append(ToolConfig.getUsername(app)).append(" -password ").append(ToolConfig.getPassword(app))
                    .append(" -name ").append(ToolConfig.getName(app)).append(" -targets ").append(ToolConfig.getTargets(app)).
                    append(" -remote -distribute -source ").append(txtWarFile.getText());

            //logger.debug("cmd:\n{}", cmd);
            HdaThread t = new HdaThread(txtOut, btDeploy, cmd.toString().split(" "));
            new Thread(t).start();
//        HdaProcessUtil.run(txtOut, cmd.toString().split(" "));

//        btDeploy.setEnabled(true);
        }
    }//GEN-LAST:event_btDeployActionPerformed

    private void txtWarFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWarFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWarFileActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeploy;
    private javax.swing.JButton btWarFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtOut;
    private javax.swing.JTextField txtWarFile;
    private javax.swing.JComboBox wlTarget;
    // End of variables declaration//GEN-END:variables
}
