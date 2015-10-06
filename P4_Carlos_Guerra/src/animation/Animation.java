package animation;

import java.awt.*;

public class Animation
{
    /**
     * This is the method that I implemented, the AnimationWindow.java and the DrawingArea.java were implemented by the 
     * Intstructor(Joe Zachary).
     * 
     * This is the method that you need to rewrite to create a custom animation. This method is called repeatedly as the
     * animation proceeds. It needs to draw to g how the animation should look after t milliseconds have passed.
     * 
     * @param g Graphics object on which to draw
     * @param t Number of milliseconds that have passed since animation started
     */
    // runs the animation
    public static void paintFrame (Graphics g, int t, int height, int width)
    {
        g.setFont(new Font("Ariel", Font.PLAIN, 20));
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 1000);
        
        if (t > 1 && t < 500)
        {
            drawStars(g, 100, 100-t);
            starShip(g, 390, -200 + t);
            g.setColor(Color.red);
            g.drawString("Starship Yolo and its maiden voyage", 300, 400);
        }
        else if (t >= 500 && t < 900)
        {
            drawStars(g, 100, 100-(t-500));
            starShip(g, 390, 300);
            g.setColor(Color.red);
            g.drawString("Hold onto your butts. SCOTTIE WARP SPEED!", 400, 200);
        }
        else if (t >= 900 && t < 1300)
        {
            if (t % 2 == 0)
            {
                g.setColor(Color.blue);
                g.fillRect(0, 0, 1000, 1000);
                starShip(g, 390, 300);
            }
            else if (t % 3 == 0)
            {
                g.setColor(Color.red);
                g.fillRect(0, 0, 1000, 1000);
                starShip(g, 390, 300);
            }
            else
            {
                g.setColor(Color.green);
                g.fillRect(0, 0, 1000, 1000);
                starShip(g, 390, 300);
            }
        }
        else if (t >= 1300 && t < 2200)
        {
            drawStars(g, 100, 100-(t-1300));
            starShip(g, 390, 300);
            g.setColor(Color.red);
            g.drawString("Captain, we were fazed out of warp!", 50, 500);
        }
        else if (t >= 2200 && t < 3000)
        {
            drawStars(g, 100, 100-(t-2200));
            starShip(g, 390, 300);
            g.setColor(Color.red);
            g.drawString("How? The dealer said that couldn't happen", 550, 500);
        }
        else if (t >= 3000 && t < 4000)
        {
            drawStars(g, 100, 100-(t-3000));
            starShip(g, 390, 300);
            g.setColor(Color.red);
            g.drawString("I don't know sir, maybe it's a local source.", 50, 500);
        }
        else if (t >= 4000 && t < 4600)
        {
            drawStars(g, 100, 100-(t-4000));
            starShip(g, 390, 300);
            g.setColor(Color.red);
            g.drawString("Local source? Do you mean...", 550, 500);
        }
        else if (t >= 4600 && t < 4900)
        {
            drawStars(g, 100, 100-(t-4600));
            UFO(g, 390, -200 + (t - 4600));
            starShip(g, 390 - (t - 4600), 300 + (t - 4600));
        }
        else if (t >= 4900 && t < 5500)
        {
            drawStars(g, 100, 100-(t-4900));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.green);
            g.drawString("I am Carl, fear me humans", 410, 90);
        }
        else if (t >= 5500 && t < 7600)
        {
            drawStars(g, 100, 100-(t-5500));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.red);
            g.drawString("But why?", 325, 610);
        }
        else if (t >= 7600 && t < 8600)
        {
            drawStars(g, 100, 100-(t-7600));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.green);
            g.drawString("Well...", 410, 90);
        }
        else if (t >= 8600 && t < 9600)
        {
            drawStars(g, 100, 100-(t-8600));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.green);
            g.drawString("Because, reasons", 410, 90);
        }
        else if (t >= 9600 && t < 10000)
        {
            drawStars(g, 100, 100-(t-9600));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.red);
            g.drawString("Are you at least going to shoot?", 325, 610);
        }
        else if (t >= 10000 && t < 11000)
        {
            drawStars(g, 100, 100-(t-10000));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.green);
            g.drawString("Well....", 410, 90);
        }
        else if (t >= 11000 && t < 12000)
        {
            drawStars(g, 100, 100-(t-11000));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.green);
            g.drawString("No, I don't have guns", 410, 90);
        }
        else if (t >= 12000 && t < 13000)
        {
            drawStars(g, 100, 100-(t-12000));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.red);
            g.drawString("Can I go then, cause I have guns and you don't.", 325, 610);
        }
        else if (t >= 13000 && t < 14000)
        {
            drawStars(g, 100, 100-(t-13000));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.green);
            g.drawString("Fine, do you have any chimichangas?", 410, 90);
        }
        else if (t >= 14000 && t < 15000)
        {
            drawStars(g, 100, 100-(t-14000));
            UFO(g, 390, 100);
            starShip(g, 90, 600);
            g.setColor(Color.red);
            g.drawString("None for you. HAHAHAHAHAH!", 325, 610);
        }
        else if (t >= 15000 && t < 16000)
        {
            drawStars(g, 100, 100-(t-15000));
            starShip(g, 390 - (t - 15000), 300 + (t - 15000));

        }
        else
        {
            if (t % 2 == 0)
            {
                g.setColor(Color.blue);
                g.fillRect(0, 0, 1000, 1000);
                starShip(g, 390, 300);
            }
            else if (t % 3 == 0)
            {
                g.setColor(Color.red);
                g.fillRect(0, 0, 1000, 1000);
                starShip(g, 390, 300);
            }
            else
            {
                g.setColor(Color.green);
                g.fillRect(0, 0, 1000, 1000);
                starShip(g, 390, 300);
            }
        }
    }

    /**
     * Creates the Star Ship YOLO
     * 
     * @param g
     * @param x
     * @param y
     */
    static void starShip (Graphics g, int x, int y)
    {
        g.setColor(Color.blue);
        g.fillRect(x + 75, y - 24, 50, 100);
        g.setColor(Color.gray);
        g.fillRect(x + 150, y - 100, 50, 150);
        g.fillRect(x, y - 100, 50, 150);
        g.fillRect(x + 75, y - 20, 50, 100);
        g.setColor(Color.red);
        g.fillOval(x, y, 200, 200);
        g.setColor(Color.gray);
        g.fillOval(x + 5, y + 5, 190, 190);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x + 90, y + 90, 20, 20);
        g.setColor(Color.BLACK);
        g.drawString("USS YOLO", x + 40, y + 80);
        g.fillOval(x + 100, y + 99, 2, 2);
    }

    /**
     * Creates the UFO
     * 
     * @param g
     * @param x
     * @param y
     */
    static void UFO (Graphics g, int x, int y)
    {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 300, 300);
        g.setColor(Color.orange);
        g.fillOval(x + 5, y + 5, 290, 290);
        g.setColor(Color.GRAY);
        g.fillOval(x + 135, y + 140, 30, 30);
        g.drawString("4/20 Blazers", x + 100, y + 100);
    }

    static void drawStars (Graphics g, int x, int y)
    {
        g.setColor(Color.white);
        g.fillOval(x + 300, y + 200, 4, 4);
        g.fillOval(x + 125, y + 600, 3, 3);
        g.fillOval(x + 400, y + 500, 3, 3);
        g.fillOval(x + 457, y + 123, 3, 3);
        g.fillOval(x + 157, y + 372, 3, 3);
        g.fillOval(x + 342, y + 23, 3, 3);
        g.fillOval(x + 745, y + 167, 3, 3);
        g.fillOval(x + 651, y + 321, 3, 3);
        g.fillOval(x + 849, y + 95, 3, 3);
        g.fillOval(x + 25, y + 842, 3, 3);
        g.fillOval(x + 512, y + 518, 3, 3);
        g.fillOval(x + 281, y + 518, 3, 3);
        g.fillOval(x + 810, y + 894, 3, 3);
        g.fillOval(x + 71, y + 320, 3, 3);
        g.fillOval(x + 56, y + 205, 3, 3);
        g.fillOval(x + 25, y + 150, 3, 3);
        g.fillOval(x + 552, y + 210, 3, 3);
        g.fillOval(x + 523, y + 562, 3, 3);
        
        g.fillOval(x + 340, y + 200, 4, 4);
        g.fillOval(x + 235, y + 600, 3, 3);
        g.fillOval(x + 23, y + 500, 3, 3);
        g.fillOval(x + 17, y + 123, 3, 3);
        g.fillOval(x + 907, y + 372, 3, 3);
        g.fillOval(x + 2, y + 23, 3, 3);
        g.fillOval(x + 45, y + 167, 3, 3);
        g.fillOval(x + 51, y + 321, 3, 3);
        g.fillOval(x + 89, y + 95, 3, 3);
        g.fillOval(x + 245, y + 842, 3, 3);
        g.fillOval(x + 51, y + 518, 3, 3);
        g.fillOval(x + 21, y + 518, 3, 3);
        g.fillOval(x + 84, y + 894, 3, 3);
        g.fillOval(x + 712, y + 320, 3, 3);
        g.fillOval(x + 562, y + 205, 3, 3);
        g.fillOval(x + 256, y + 150, 3, 3);
        g.fillOval(x + 55, y + 210, 3, 3);
        g.fillOval(x + 563, y + 562, 3, 3);
        
        g.fillOval(x + 340, y + 1200, 4, 4);
        g.fillOval(x + 235, y + 1000, 3, 3);
        g.fillOval(x + 23, y + 1500, 3, 3);
        g.fillOval(x + 17, y + 1123, 3, 3);
        g.fillOval(x + 907, y + 1372, 3, 3);
        g.fillOval(x + 2, y + 1523, 3, 3);
        g.fillOval(x + 45, y + 1167, 3, 3);
        g.fillOval(x + 51, y + 1321, 3, 3);
        g.fillOval(x + 89, y + 1095, 3, 3);
        g.fillOval(x + 245, y + 1042, 3, 3);
        g.fillOval(x + 51, y + 1018, 3, 3);
        g.fillOval(x + 21, y + 1618, 3, 3);
        g.fillOval(x + 84, y + 1894, 3, 3);
        g.fillOval(x + 712, y + 1320, 3, 3);
        g.fillOval(x + 562, y + 1205, 3, 3);
        g.fillOval(x + 256, y + 1150, 3, 3);
        g.fillOval(x + 55, y + 1210, 3, 3);
        g.fillOval(x + 563, y + 1562, 3, 3);
        g.fillOval(x + 300, y + 1200, 4, 4);
        g.fillOval(x + 125, y + 1100, 3, 3);
        g.fillOval(x + 400, y + 5000, 3, 3);
        g.fillOval(x + 457, y + 1230, 3, 3);
        g.fillOval(x + 157, y + 3720, 3, 3);
        g.fillOval(x + 342, y + 230, 3, 3);
        g.fillOval(x + 745, y + 1607, 3, 3);
        g.fillOval(x + 651, y + 3210, 3, 3);
        g.fillOval(x + 849, y + 950, 3, 3);
        g.fillOval(x + 25, y + 8420, 3, 3);
        g.fillOval(x + 512, y + 5180, 3, 3);
        g.fillOval(x + 281, y + 5180, 3, 3);
        g.fillOval(x + 810, y + 8940, 3, 3);
        g.fillOval(x + 71, y + 3200, 3, 3);
        g.fillOval(x + 56, y + 2050, 3, 3);
        g.fillOval(x + 25, y + 1500, 3, 3);
        g.fillOval(x + 552, y + 2100, 3, 3);
        g.fillOval(x + 523, y + 5602, 3, 3);
    }
}