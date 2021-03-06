// -------- Begin: MyApplet.java ------------------
import java.applet.*;
import java.awt.*;

public class MyApplet extends Applet
{
    public void paint(Graphics g)
    {
        g.setColor(Color.blue);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        g.drawString("Hello World!", 10, 20);

        g.setColor(Color.green);
        g.drawLine(30, 40, 300, 250);

        g.setColor(Color.red);
        g.drawRect(200, 60, 80, 80);

        g.setColor(Color.cyan);
        g.fillOval(300, 60, 80, 80);

        g.setColor(Color.blue);
        g.drawOval(300, 60, 80, 80);
    }
}
// -------- End: MyApplet.java ------------------