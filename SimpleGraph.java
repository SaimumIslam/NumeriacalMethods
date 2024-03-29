import java.awt.*;
import javax.swing.*;
public class SimpleGraph extends JFrame {
    private final int WIDTH = 330;
    private final int HEIGHT = 500;
    private Container drawable;
    private JPanel canvas;
    public SimpleGraph(double[] someData) {
        super("SimpleGraph");
        drawable = getContentPane();
        canvas = new GraphCanvas(someData);
        drawable.add(canvas);
        setSize(WIDTH, HEIGHT);
    }
    public class GraphCanvas extends JPanel {
        private double[] data;
        private int points;
        private double[] XData;
        private double[] YData;
        public GraphCanvas(double[] someData) {
            super();
            data = someData;
            points = data.length / 2;
            XData = new double[points];
            YData = new double[points];
            for(int i = 0; i < points; i++) {
                XData[i] = data[i * 2];
                YData[i] = data[i * 2 + 1];
            }
        }
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            this.setBackground(Color.BLUE);
            for(int i = 0; i < points - 1; i++) {
                int x0 = (int) (XData[i] * 15);
                int x1 = (int) (XData[i + 1] * 15);
                int y0 = (int) (YData[i] *15);
                int y1 = (int) (YData[i + 1] *15);
                g.setColor(Color.RED);
                g2.drawLine(x0, y0, x1, y1);
                if (i == 0)
                  g2.drawString(("" + x0 + ", " + y0), x0 - 20, y0 + 10);
                if (i == points - 2)
                  g2.drawString(("" + x1 + ", " + y1), x1, y1);
            }
        }
    }
}