package Bresenham;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class Vista {

    private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="210,10"
    private JPanel jContentPane = null;
    private JPanel jPanel = null;
    private JPanel jPanel1 = null;
    private JPanel jPanel2 = null;
    private JPanel jPanel3 = null;
    private JPanel jPanel4 = null;
    private JPanel jPanel5 = null;
    private JPanel jPanel6 = null;
    private JPanel jPanel7 = null;
    private JPanel jPanel8 = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JTextField jTextField = null;
    private JTextField jTextField1 = null;
    private JLabel jLabel2 = null;
    private JLabel jLabel3 = null;
    private JTextField jTextField2 = null;
    private JTextField jTextField3 = null;
    private JButton jButton = null;
    private JButton jButton1 = null;
    private JButton jButton2 = null;
    private JLabel jLabel5 = null;
    private JCheckBox jCheckBox = null;
    private Bresenham bres;
    private Bresenham2 bres2;
    private JLabel jLabel4 = null;
    private JLabel jLabel6 = null;
    private JButton jButton3 = null;
    private JTextField jTextField4 = null;
    private JTextField jTextField5 = null;
    private final String MensajeError = "";
    private final String MensajeError6 = "[ERROR]Solo valores Arriba de 10";

    /**
     * This method initializes jFrame
     *
     * @return javax.swing.JFrame
     */
    JFrame getJFrame() {
        if (jFrame == null) {
            jFrame = new JFrame();
            jFrame.setSize(new Dimension(842, 649));
            jFrame.setTitle(".:: Ley de Bresenham ::.");
            jFrame.setContentPane(getJContentPane());
            jFrame.setVisible(true);
            jFrame.setLocationRelativeTo(null);
            jFrame.setResizable(false);

            bres = new Bresenham(jPanel2.getSize());
            bres2 = new Bresenham2();
            jPanel2.add(bres);
        }
        return jFrame;
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJPanel(), null);
            jContentPane.add(getJPanel1(), null);
        }
        return jContentPane;
    }

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            jPanel = new JPanel();
            jPanel.setLayout(null);
            jPanel.setBounds(new Rectangle(1, 1, 289, 528));
            jPanel.add(getJPanel6(), null);
            jPanel.add(getJPanel7(), null);
            //jPanel.add(getJPanel8(), null);
        }
        return jPanel;
    }

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            jPanel1 = new JPanel();
            jPanel1.setLayout(null);
            jPanel1.setBounds(new Rectangle(289, 1, 537, 610));
            jPanel1.add(getJPanel2(), null);
            jPanel1.add(getJPanel3(), null);
        }
        return jPanel1;
    }

    /**
     * This method initializes jPanel2
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel2() {
        if (jPanel2 == null) {
            jPanel2 = new JPanel();
            jPanel2.setLayout(new GridBagLayout());
            jPanel2.setBounds(new Rectangle(-1, 134, 538, 475));
            jPanel2.setBackground(Color.WHITE);
        }
        return jPanel2;
    }

    /**
     * This method initializes jPanel3
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel3() {
        if (jPanel3 == null) {
            jPanel3 = new JPanel();
            jPanel3.setLayout(null);
            jPanel3.setBounds(new Rectangle(1, 0, 543, 135));
            jPanel3.add(getJPanel4(), null);
            jPanel3.add(getJPanel5(), null);
        }
        return jPanel3;
    }

    /**
     * This method initializes jPanel4
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel4() {
        if (jPanel4 == null) {
            jPanel4 = new JPanel();
            jPanel4.setLayout(null);
            jPanel4.setBounds(new Rectangle(0, 30, 305, 77));
            jPanel4.add(getJButton(), null);
            jPanel4.add(getJButton1(), null);
            jPanel4.setBorder(new TitledBorder("Dibujar:"));
        }
        return jPanel4;
    }

    /**
     * This method initializes jPanel5
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel5() {
        if (jPanel5 == null) {
            jLabel5 = new JLabel();
            jLabel5.setBounds(new Rectangle(9, 19, 86, 21));
            jLabel5.setText("Color Linea :");
            jPanel5 = new JPanel();
            jPanel5.setLayout(null);
            jPanel5.setBounds(new Rectangle(307, 29, 230, 77));
            jPanel5.add(getJButton2(), null);
            jPanel5.add(jLabel5, null);
            jPanel5.setBorder(new TitledBorder("Propiedades:"));
            jPanel5.add(getJCheckBox(), null);
        }
        return jPanel5;
    }

    /**
     * This method initializes jPanel6
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel6() {
        if (jPanel6 == null) {
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(15, 62, 122, 25));
            jLabel1.setText("Punto Final    X,Y :");
            jLabel = new JLabel();
            jLabel.setText("Punto Inicial  X,Y :");
            jLabel.setBounds(new Rectangle(15, 15, 121, 24));
            jPanel6 = new JPanel();
            jPanel6.setLayout(null);
            jPanel6.setBorder(new TitledBorder("Linea:"));
            jPanel6.setBounds(new Rectangle(14, 16, 266, 105));
            jPanel6.setToolTipText("Linea");
            jPanel6.add(jLabel, null);
            jPanel6.add(jLabel1, null);
            jPanel6.add(getJTextField(), null);
            jPanel6.add(getJTextField1(), null);
        }
        return jPanel6;
    }

    /**
     * This method initializes jPanel7
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel7() {
        if (jPanel7 == null) {
            jLabel3 = new JLabel();
            jLabel3.setBounds(new Rectangle(15, 62, 124, 25));
            jLabel3.setText("Radio :");
            jLabel2 = new JLabel();
            jLabel2.setText("Punto Inicial X,Y :");
            jLabel2.setBounds(new Rectangle(15, 18, 122, 28));
            jPanel7 = new JPanel();
            jPanel7.setLayout(null);
            jPanel7.setBorder(new TitledBorder("Circulo:"));
            jPanel7.setBounds(new Rectangle(15, 136, 266, 106));
            jPanel7.add(jLabel2, null);
            jPanel7.add(jLabel3, null);
            jPanel7.add(getJTextField2(), null);
            jPanel7.add(getJTextField3(), null);
        }
        return jPanel7;
    }

    /**
     * This method initializes jPanel8
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel8() {
        if (jPanel8 == null) {
            jLabel6 = new JLabel();
            jLabel6.setBounds(new Rectangle(16, 105, 121, 25));
            jLabel6.setText(" Columnas :");
            jLabel4 = new JLabel();
            jLabel4.setBounds(new Rectangle(15, 45, 121, 25));
            jLabel4.setText(" Filas :");
            jPanel8 = new JPanel();
            jPanel8.setLayout(null);
            jPanel8.setBounds(new Rectangle(16, 256, 264, 225));
            jPanel8.setBorder(new TitledBorder("Panel:"));
            jPanel8.add(jLabel4, null);
            jPanel8.add(jLabel6, null);
            jPanel8.add(getJButton3(), null);
            jPanel8.add(getJTextField4(), null);
            jPanel8.add(getJTextField5(), null);
        }
        return jPanel8;
    }

    /**
     * This method initializes jTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField() {
        if (jTextField == null) {
            jTextField = new JTextField();
            jTextField.setBounds(new Rectangle(150, 13, 104, 31));
            jTextField.setText("[60.4,100.5]");
        }
        return jTextField;
    }

    /**
     * This method initializes jTextField1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField1() {
        if (jTextField1 == null) {
            jTextField1 = new JTextField();
            jTextField1.setBounds(new Rectangle(149, 59, 105, 29));
            jTextField1.setText("[360.1,301.8]");
        }
        return jTextField1;
    }

    /**
     * This method initializes jTextField2
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField2() {
        if (jTextField2 == null) {
            jTextField2 = new JTextField();
            jTextField2.setBounds(new Rectangle(150, 18, 104, 29));
            jTextField2.setText("[280.1,180.5]");
        }
        return jTextField2;
    }

    /**
     * This method initializes jTextField3
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField3() {
        if (jTextField3 == null) {
            jTextField3 = new JTextField();
            jTextField3.setBounds(new Rectangle(150, 62, 104, 29));
            jTextField3.setText("[100,100]");
        }
        return jTextField3;
    }

    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setBounds(new Rectangle(29, 17, 121, 43));
            jButton.setText("Linea");

            jButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    bres.linea2D(jTextField.getText(), jTextField1.getText()); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton;
    }

    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setBounds(new Rectangle(164, 17, 121, 43));
            jButton1.setText("Circulo");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    bres.circulo2D(jTextField2.getText(), jTextField3.getText()); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton1;
    }

    /**
     * This method initializes jButton2
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton2() {
        if (jButton2 == null) {
            jButton2 = new JButton();
            jButton2.setBounds(new Rectangle(115, 16, 106, 35));
            jButton2.setText("Color");
            jButton2.setEnabled(false);
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jButton2.setBackground(bres.Escoger_Color(e)); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton2;
    }

    /**
     * This method initializes jCheckBox
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox() {
        if (jCheckBox == null) {
            jCheckBox = new JCheckBox();
            jCheckBox.setBounds(new Rectangle(7, 46, 106, 26));
            jCheckBox.setText("Habilitar Color");

            jCheckBox.addItemListener(new java.awt.event.ItemListener() {
                @Override
                public void itemStateChanged(java.awt.event.ItemEvent e) {
                    if (jCheckBox.isSelected()) {
                        jButton2.setEnabled(true);
                    } else {
                        jButton2.setEnabled(false);
                    }
                }
            });
        }
        return jCheckBox;
    }

    /**
     * This method initializes jButton3
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton3() {
        if (jButton3 == null) {
            jButton3 = new JButton();
            jButton3.setBounds(new Rectangle(64, 164, 152, 39));
            jButton3.setText("Crear Panel");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    int filas = Integer.parseInt(jTextField4.getText());
                    int columnas = Integer.parseInt(jTextField5.getText());
                    Graphics2D Graphics2D = null;
                    Graphics2D g2 = Graphics2D;
                    if (filas < 10 || columnas < 10) {
                        JOptionPane.showMessageDialog(jFrame, MensajeError + "\n " + MensajeError6);
                    } else {
                        bres.cuadricula(g2, filas, columnas); // TODO Auto-generated Event stub actionPerformed()
                    }
                }
            });
        }
        return jButton3;
    }

    /**
     * This method initializes jTextField4
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField4() {
        if (jTextField4 == null) {
            jTextField4 = new JTextField();
            jTextField4.setBounds(new Rectangle(150, 45, 104, 29));
        }
        return jTextField4;
    }

    /**
     * This method initializes jTextField5
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField5() {
        if (jTextField5 == null) {
            jTextField5 = new JTextField();
            jTextField5.setBounds(new Rectangle(150, 105, 104, 29));
        }
        return jTextField5;
    }
}
