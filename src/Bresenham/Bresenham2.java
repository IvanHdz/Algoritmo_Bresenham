package Bresenham;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bresenham2 extends JFrame {

    Bresenham2() {
        super("Bresenham");
        setSize(340, 230);
        add("Center", new Ventana());
    }
}

class Ventana extends JPanel {

    float rWidth = 10.0F, rHeight = 7.5F, pixelSize;
    int centerX, centerY, dGrid = 10, maxX, maxY;

    public void initgr() {
        Dimension d;
        d = getSize();
        maxX = d.width - 1;
        maxY = d.height - 1;
      //pixelSize = Math.max(rWidth/maxX, rHeight/maxY);
        //centerX = maxX/2; centerY = maxY/2;
    }

    public void putPixel(Graphics g, int x, int y) {
        int x1 = x * dGrid, y1 = y * dGrid, h = dGrid / 2;
        g.drawRect(x1 - h, y1 - h, dGrid, dGrid);
    }

    public void bresenhamL(Graphics g, int xP, int yP, int xQ, int yQ) {
        int x = xP, y = yP, D = 0, HX = xQ - xP, HY = yQ - yP,
                c, M, xInc = 1, yInc = 1;
        if (HX < 0) {
            xInc = -1;
            HX = -HX;
        }
        if (HY < 0) {
            yInc = -1;
            HY = -HY;
        }
        if (HY <= HX) {
            c = 2 * HX;
            M = 2 * HY;
            for (;;) {
                putPixel(g, x, y);
                if (x == xQ) {
                    break;
                }
                x += xInc;
                D += M;
                if (D > HX) {
                    y += yInc;
                    D -= c;
                }
            }
        } else {
            c = 2 * HY;
            M = 2 * HX;
            for (;;) {
                putPixel(g, x, y);
                if (y == yQ) {
                    break;
                }
                y += yInc;
                D += M;
                if (D > HY) {
                    x += xInc;
                    D -= c;
                }
            }
        }
    }

    public void bresenhamC(Graphics g, int xC, int yC, int r) {
        int x = 0, y = r, u = 1, v = 2 * r - 1, E = 0;
        while (x < y) {
            putPixel(g, xC + x, yC + y); // NNE
            putPixel(g, xC + y, yC - x); // ESE
            putPixel(g, xC - x, yC - y); // SSW
            putPixel(g, xC - y, yC + x); // WNW
            x++;
            E += u;
            u += 2;
            if (v < 2 * E) {
                y--;
                E -= v;
                v -= 2;
            }
            if (x > y) {
                break;
            }
            putPixel(g, xC + y, yC + x); // ENE
            putPixel(g, xC + x, yC - y); // SSE
            putPixel(g, xC - y, yC - x); // WSW
            putPixel(g, xC - x, yC + y); // NNW
        }
    }

    public void cuadricula(Graphics g) {
        for (int x = dGrid; x <= maxX; x += dGrid) {
            for (int y = dGrid; y <= maxY; y += dGrid) {
                g.drawLine(x, y, x, y);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        initgr();
        cuadricula(g);
        bresenhamL(g, 1, 1, 12, 9);
        bresenhamC(g, 23, 10, 8);
    }
}
