package Bresenham;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Bresenham extends JPanel {

    Point2D Punto1;
    Point2D Punto2;

    int f = 20;
    int c = 20;
    int dGrid = 10;

    private Color color;
    private final Float grosor_linea = 3.0f;

    // para el dibujo de la cuadricula
    private int grilaX = 0;
    private int grilaY = 0;
    //variable de control
    private int Opcion = -1;
    //mensajes de error
    private String MensajeError = "";
    private final String MensajeError1 = "- No se puede dibujar -";
    private final String MensajeError2 = "[ERROR] No se pudo convertir";
    private final String MensajeError3 = "[ERROR]Parametros incorrectos";
    private final String MensajeError4 = "[ERROR]Formato incorrecto";
    private final String MensajeError5 = "[ERROR]Solo Parametros Iguales";

//constructor
    public Bresenham(Dimension d) {
        this.setPreferredSize(d);
        this.setSize(d);
        this.setVisible(true);
        this.repaint();
        this.color = new Color(0, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graficar(g);
    }

    //metodo encargado de graficar las figuras
    void Graficar(Graphics ap) {
        //Casting de Graphics a Graphics2D
        Graphics2D g2 = (Graphics2D) ap;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //dibuja la cuadricula
        grilla(g2, c, f);
        /* estable el color y tipode linea para el dibujo */
        //color de la linea
        g2.setColor(this.color);
        //grosor de la linea
        g2.setStroke(new BasicStroke(this.grosor_linea));
        //segun la Opcion, dibuja
        switch (Opcion) {
            case 0://Linea2D              
                g2.draw(new Line2D.Double(Punto1.getX(), Punto1.getY(), Punto2.getX(), Punto2.getY()));
                dibuja_coordenada(g2, Punto1.getX(), Punto1.getY(), "Inicio");
                dibuja_coordenada(g2, Punto2.getX(), Punto2.getY(), "Fin");
                //bresenhamL(g2,Punto1.getX(),Punto1.getY(),Punto2.getX(),Punto2.getY());
                break;
            case 2://Circulo2D
                g2.draw(new Ellipse2D.Double(Punto1.getX() - Punto2.getX() / 2, Punto1.getY() - Punto2.getX() / 2, Punto2.getX(), Punto2.getX()));
                g2.setStroke(new BasicStroke(0.5f));
                g2.setColor(new Color(0, 0, 0));
                g2.draw(new Line2D.Double(Punto1.getX() - Punto2.getX() / 2, Punto1.getX() - Punto2.getX() / 2, Punto1.getX(), Punto1.getY()));
                dibuja_coordenada(g2, Punto1.getX(), Punto1.getY(), "P1");
                //dibuja_coordenada(g2,Punto1.getX()+Punto2.getX(),Punto1.getY()+Punto2.getY(),"P2");                  
                break;
        }
        this.repaint();
    }

    /**
     * @param g2
     * @param c
     * @param f
     */
    public void grilla(Graphics2D g2, int c, int f) {
        g2.setColor(new Color(0, 0, 0));
        g2.setStroke(new BasicStroke(0.5f));
        g2.setFont(new Font("Arial", Font.PLAIN, 8));
        //lineas horizontales
        while (this.grilaX <= this.getSize().width) {
            this.grilaX = this.grilaX + f;
            g2.draw(new Line2D.Double(this.grilaX, 0, this.grilaX, this.getSize().height));
            g2.drawString("" + this.grilaX, this.grilaX + 2, 10);
        }
        //lineas verticales
        while (this.grilaY <= this.getSize().height) {
            this.grilaY = this.grilaY + c;
            g2.draw(new Line2D.Double(0, this.grilaY, this.getSize().width, this.grilaY));
            g2.drawString("" + this.grilaY, 2, this.grilaY - 2);
        }
        this.grilaY = 0;
        this.grilaX = 0;
    }

    public void cuadricula(Graphics ap, int filas, int columnas) {
        this.f = filas;
        this.c = columnas;
        Graphics2D g2 = (Graphics2D) ap;
        grilla(g2, c, f);
    }

    //dibuja las coordenas dadas  un punto P1,P2   
    public void dibuja_coordenada(Graphics2D g2, double x, double y, String t) {
        NumberFormat mf = NumberFormat.getInstance();
        mf.setMaximumFractionDigits(2);
        g2.setColor(Color.BLUE);
        g2.setFont(new Font("Georgia", Font.BOLD, 12));
        g2.drawString(t + " (" + mf.format(x) + "," + mf.format(y) + ")", (float) (x + 4), (float) (y - 10));

        g2.setStroke(new BasicStroke(4.5f));
        g2.draw(new Line2D.Double(x, y, x, y));
    }

    /* metodos para inicializar las coordenas necesarias para los dibujos */
    public void linea2D(String P1, String P2) {
        this.Punto1 = ObtenerPunto(P1);
        this.Punto2 = ObtenerPunto(P2);
        if ((Punto1 != null) && (Punto2 != null)) {
            this.Opcion = 0;
        } else {
            this.Opcion = -1;
            JOptionPane.showMessageDialog(this, this.MensajeError + "\n " + this.MensajeError1);
        }
    }

    public void circulo2D(String P1, String P2) {
        this.Punto1 = ObtenerPunto(P1);
        this.Punto2 = ObtenerPunto2(P2);
        if ((Punto1 != null) && (Punto2 != null)) {
            this.Opcion = 2;
        } else {
            this.Opcion = -1;
            JOptionPane.showMessageDialog(this, this.MensajeError + "\n " + this.MensajeError1);
        }
    }

    /* MUESTRA LA VENTA DE DIALOGO [ESCOGER COLOR]*/
    public Color Escoger_Color(java.awt.event.ActionEvent evt) {
        Color c = JColorChooser.showDialog(null, "Escoja un color", ((JButton) evt.getSource()).getBackground());
        this.color = c;
        if (c != null) {
            return color;
        } else {
            return new Color(-1118482);
        }
    }

    //dado un String de la forma [numero,numero] lo descompone en un objeto Point2D
    public Point2D ObtenerPunto(String s) {
        Point2D p = null;
        //El minimo que se acepta es [0,0]
        if (s.length() >= 5) {
            if ((s.substring(0, 1).equals("[")) && (s.substring(s.length() - 1, s.length()).equals("]"))) {
                //se quitan los corchetes
                String cadena = s.substring(1, s.length() - 1);
                //se separan en un Array 
                String[] numero = cadena.split(",");
                //si no existen 2 elementos en el array, el string  esta mal formado
                if ((numero.length > 2) || (numero.length < 2)) {
                    this.MensajeError = this.MensajeError3;
                } else {
                    //se convierte los String en valores numericos   
                    if ((EsUnNumero(numero[0])) && (EsUnNumero(numero[1]))) {
                        p = new Point2D.Float(Float.valueOf(numero[0]), Float.valueOf(numero[1]));
                    } else {
                        this.MensajeError = this.MensajeError2;
                    }
                }
            } else {
                this.MensajeError = this.MensajeError4;
            }
        }
        return p;
    }

    public Point2D ObtenerPunto2(String s) {
        Point2D p = null;
        //El minimo que se acepta es [0,0]
        if (s.length() >= 5) {
            if ((s.substring(0, 1).equals("[")) && (s.substring(s.length() - 1, s.length()).equals("]"))) {
                //se quitan los corchetes
                String cadena = s.substring(1, s.length() - 1);
                //se separan en un Array 
                String[] numero2 = cadena.split(",");

                //si no existen 2 elementos en el array, el string  esta mal formado
                if ((numero2.length > 2) || (numero2.length < 2)) {
                    this.MensajeError = this.MensajeError3;
                } else {
                    //se convierte los String en valores numericos   
                    if ((EsUnNumero(numero2[0])) && (EsUnNumero(numero2[1]))) {
                        if (numero2[0].equals(numero2[1])) {
                            p = new Point2D.Float(Float.valueOf(numero2[0]), Float.valueOf(numero2[1]));
                        } else {
                            this.MensajeError = this.MensajeError5;
                        }
                    } else {
                        this.MensajeError = this.MensajeError2;
                    }
                }
            } else {
                this.MensajeError = this.MensajeError4;
            }
        }
        return p;
    }

    //metodo que dado un string lo convierte en numero, devuelve TRUE si tiene exito
    private boolean EsUnNumero(String numero) {
        try {
            Float.parseFloat(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
