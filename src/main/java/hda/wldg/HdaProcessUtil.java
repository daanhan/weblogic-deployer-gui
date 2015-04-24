/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hda.wldg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author daan
 */
public class HdaProcessUtil {
    
    public static void start(JTextArea txtOut,  final String... cmd){
        
        
    } 

    /**
     *
     * @param txtOut
     * @param cmd
     * @return
     */
    public static int run(JTextArea txtOut,  final String... cmd) {

        txtOut.append("-----------------start----------------\n");
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);

            pb.redirectErrorStream(true);

            Process process = pb.start();
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    process.getInputStream(), "GBK"));

            String s;
            while ((s = input.readLine()) != null) {
                //System.out.println(s);
                txtOut.append(s);
                txtOut.append("\n");
            }
            return process.waitFor();

        } catch (IOException e) {
            System.out.println("Error executing command.");
            txtOut.append(e.getLocalizedMessage());
            txtOut.append("\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(HdaProcessUtil.class.getName()).log(Level.SEVERE, null, ex);
            txtOut.append(ex.getLocalizedMessage());
            txtOut.append("\n");
        } finally {
            txtOut.append("-----------------end------------------\n\n");
        }

        return -1;
    }
}

;
class ProcessRunnable implements Runnable{
    
            public JTextArea getTxtOut() {
                return txtOut;
            }

            public void setTxtOut(JTextArea txtOut) {
                this.txtOut = txtOut;
            }

            public String[] getCmd() {
                return cmd;
            }

            public void setCmd(String[] cmd) {
                this.cmd = cmd;
            }

             JTextArea txtOut;
            String [] cmd;
            
            public void run() {
                
            }
}
