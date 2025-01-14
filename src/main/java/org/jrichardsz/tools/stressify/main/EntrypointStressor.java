package org.jrichardsz.tools.stressify.main;

import java.io.File;
import java.util.UUID;
import javax.swing.JFrame;
import org.jrichardsz.common.http.DisableCertificateValidation;
import org.jrichardsz.tools.stressify.ui.MainView;

public class EntrypointStressor {
  public static void main(String[] args) throws Exception {
    
    //https://github.com/jrichardsz-software-architect-tools/stressify/issues/18
    //fix: set a temp value to avoid issue
    //when stress starts, a new value is generated and log is realoaded
    String uuid = UUID.randomUUID().toString();
    System.setProperty("logFilename", System.getProperty("java.io.tmpdir")+File.separator+uuid+".log");
    
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
          .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    if (System.getProperty("disable.https") != null
        && System.getProperty("disable.https").contentEquals("true")) {
      System.out.println("Https certificate validation will be disabled");
      DisableCertificateValidation certificateValidation = new DisableCertificateValidation();
      certificateValidation.start();
    }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        MainView mainView = new MainView();
        mainView.setVisible(true);
        mainView.setExtendedState(mainView.getExtendedState() | JFrame.MAXIMIZED_BOTH);
      }
    });
  }
}
