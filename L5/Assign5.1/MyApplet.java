import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.Iterator;

public class MyApplet extends JApplet implements ItemListener
{
    JTextField tfPhoneNumber, tfDialing;
    JButton dialButton, cancelButton;
    JList list;

    public void init()
    {
        GridLayout gl = new GridLayout(4,1,5,5);
        setLayout(gl);

        //Display Panel
	JPanel displayPanel = new JPanel();
	GridLayout dpgl = new GridLayout(1,1,5,5);
	displayPanel.setLayout(dpgl);
	tfPhoneNumber = new JTextField(40);
	//	tfPhoneNumber.setEditable(false);
	displayPanel.add(tfPhoneNumber);
	displayPanel.setSize (200, 80);

        MyMouseAdapter ma = new MyMouseAdapter();

	//Button Panel
        JPanel butPanel = new JPanel();
        GridLayout butgl = new GridLayout(1,1,5,5);
        butPanel.setLayout(butgl);
	JButton dialButton = new JButton("Dial");
	JButton cancelButton = new JButton("Cancel/Erase");
	dialButton.setSize (40,20);
	cancelButton.setSize (40,20);
	dialButton.addMouseListener(ma);
	cancelButton.addMouseListener(ma);
	butPanel.add(dialButton);
	butPanel.add(cancelButton);
	butPanel.setSize (200, 80);


        // List Panel
	JPanel inputPanel = new JPanel();
        GridLayout ingl = new GridLayout(1,1,5,5);
	inputPanel.setLayout (ingl);
	inputPanel.setSize (100,100);

	List<PhoneNum> pnList = PhoneUtil.readPhoneList("phone.txt"); 
	Iterator <PhoneNum> it = pnList.iterator();
	int i = 0;
	String[] phoneNumbers = new String[5];

	while (it.hasNext()){ 
	    PhoneNum pn = it.next(); 
	    phoneNumbers[i] = pn.getPhoneNum();
	    i++;
	}
	
	list = new JList(phoneNumbers); 
        list.setSelectedIndex(0);
        list.addMouseListener(ma);
	//	String sel = list.getSelectedValue();
	tfPhoneNumber.setText("" + list.getSelectedValue());
	inputPanel.add(list); 

	//Dialing Panel
        JPanel dialingPanel = new JPanel();
	GridLayout dlgl = new GridLayout(1,1,5,5);
        dialingPanel.setLayout(dlgl);
        dialingPanel.setSize(200, 50);
	tfDialing = new JTextField(40);
	tfDialing.setEditable (false);
	dialingPanel.add(tfDialing);

        add( displayPanel );
	add( butPanel);
	add( inputPanel);
        add( dialingPanel );
    }

    public void itemStateChanged(ItemEvent e)
    {
	System.out.println ("Event");
        updateResult();
    }

    class MyMouseAdapter extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
	    if (e.getSource() == list){
		String result = "";
		result += " " + list.getSelectedValue();
		tfPhoneNumber.setText(result);
		//		System.out.println ("List");
	    } else {
		
		JButton b = (JButton) e.getSource();
		if (b.getLabel().equals("Dial")) 
		    { 
			tfDialing.setText("Dialing.." + tfPhoneNumber.getText());
			//			System.out.println ("Dial Button");
		    } 

		if (b.getLabel().equals("Cancel/Erase")) 
		    { 
			tfPhoneNumber.setText(""); 
			tfDialing.setText ("");
			//			System.out.println ("Cancel Button");

		    }
	    }
        }
    }

    private void updateResult()
    {
        String result = "";
        result += " " + list.getSelectedValue();
	System.out.println ("Resule:" + result);
        tfDialing.setText(result);
    }
}