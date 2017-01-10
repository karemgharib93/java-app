import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CarStopPricing extends JFrame implements ActionListener{
	private JLabel l1,l2;
	private JRadioButton r1,r2;
	private JCheckBox c1,c2,c3;
	private JButton b1,b2;
	private JTextField t1,t2;
	private ButtonGroup group;

	public CarStopPricing()
	{
		super("Car Stop");
		setLayout(new FlowLayout());
		l1=new JLabel("Total Liters");
		l2=new JLabel("Total Charges");
		r1=new JRadioButton("95-1.95$ per liter");
		r2=new JRadioButton("98-1.80$ per liter");
		c1=new JCheckBox("Car Wash--8$");
		c2=new JCheckBox("Tires Fix--12$");
		c3=new JCheckBox("Light Repair--20$");
		b1=new JButton("Calculate");
		b2=new JButton("Cancel");
		t1=new JTextField(10);
		t2=new JTextField(10);

		group=new ButtonGroup();
		group.add(r1);
		group.add(r2);

		add(l1);
		add(t1);
		add(r1);
		add(r2);
		add(c1);
		add(c2);
		add(c3);
		add(l2);
		add(t2);
                t2.setEditable(false);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
		double n=0;
		n = Double.parseDouble(t1.getText());
		if(r1.isSelected())
			n*=1.95;
		else
			if(r2.isSelected())
				n*=1.80;

		if(c1.isSelected())
			n+=8;
		if(c2.isSelected())
			n+=12;
		if(c3.isSelected())
			n+=20;
		t2.setText(String.valueOf(n));
		}
		else if(e.getSource() == b2)
		{
			t1.setText("");
			group.clearSelection();
			c1.setSelected(false);
			c2.setSelected(false);
			c3.setSelected(false);
			t2.setText("");
		}
	}
}

public class CarStop{
	public static void main(String args[])
	{
		CarStopPricing p=new CarStopPricing();
		p.setSize(250,400);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setVisible(true);
	}
}

