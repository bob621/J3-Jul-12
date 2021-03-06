// -------- Begin: MyApplet.java ------------------
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class MyApplet extends JApplet implements ActionListener
{
    JTextField tfInput;
    JLabel lblInput;

    JButton goButton, resetButton;

    public void init()
    {
        setLayout(new FlowLayout());

        // Input text field for URL
        tfInput = new JTextField(20);

        lblInput = new JLabel("Input: ");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setSize(200, 50);

        inputPanel.add(lblInput);
        inputPanel.add(tfInput);

        // Add the Go and Cancel Buttons
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        submitPanel.setSize(200, 50);

        goButton = new JButton("Go");
        goButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        submitPanel.add(goButton);
        submitPanel.add(resetButton);

        add( inputPanel );
        add( submitPanel );
    }

    public void actionPerformed( ActionEvent e )
    {
        if (e.getSource() == goButton)
        {
            String strUrl = tfInput.getText();

            if (strUrl.startsWith("www"))
            {
                strUrl = "http://" + strUrl;
            }

            URL url = null;

            try
            {
                url = new URL(strUrl);

                getAppletContext().showDocument(url);
            }
            catch (MalformedURLException ex)
            {
                System.out.println("Bad URL: " + url);
            }
        }
        else if (e.getSource() == resetButton)
        {
            tfInput.setText("");
        }
    }
}
// -------- End: MyApplet.java ------------------