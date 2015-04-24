/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hda.wldg;

import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author daan
 */
public class HdaThread implements Runnable {

    private javax.swing.JTextArea txtOut;
    JButton btDeploy;
    private String cmd[];

    public HdaThread(JTextArea txtOut, JButton btDeploy, String[] cmd) {
        this.txtOut = txtOut;
        this.btDeploy = btDeploy;
        this.cmd = cmd;
    }

    @Override
    public void run() {
        try {
            HdaProcessUtil.run(txtOut, cmd);
        } finally {
//            txtOut
            txtOut.selectAll();
            //txtOut.setCaretPosition(txtOut.getRows());
            txtOut.requestFocus();
            btDeploy.setEnabled(true);
        }
    }

}
