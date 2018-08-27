import javax.swing.*;
import java.awt.event.*;

class DemoFrame implements ActionListener{

	JFrame frame,addframe,updateframe;
	JLabel welcome,roll,name,updatename,updateroll;
	JTextField name_text,roll_text,u_text_name,u_text_roll;
	JButton add,update,display,exit,Submit,updatesubmit;

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==add)
			addFrame();
		else if(e.getSource()==update)
			updateframe();
		else if (e.getSource()==exit)
			frame.dispose();
	}

	void updateframe(){
		updateframe = new JFrame("UPDATE");

		updatename = new JLabel("Name : ");
		updateroll = new JLabel("of Roll no.:");

		u_text_name = new JTextField();
		u_text_roll = new JTextField();

		updatesubmit = new JButton("Submit");

		updateframe.setVisible(true);
		updateframe.setSize(400,400);
		updateframe.setLayout(null);

		updatename.setBounds(100,70,80,20);
		u_text_name.setBounds(200,100,80,20);
		updateroll.setBounds(100,160,80,20);
		u_text_roll.setBounds(200,190,80,20);
		updatesubmit.setBounds(200,300,120,20);

		updateframe.add(updatename);
		updateframe.add(updateroll);
		updateframe.add(updatesubmit);
		updateframe.add(u_text_name);
		updateframe.add(u_text_roll);
	}

	 void addFrame(){
	 	addframe = new JFrame("ADD");

		welcome = new JLabel("Enter following details : ");
		roll = new JLabel("Roll no. :");
		name = new JLabel("Name : ");

		name_text = new JTextField();
		roll_text = new JTextField();

		Submit = new JButton("Submit");

		addframe.setSize(400,400);
		addframe.setVisible(true);
		addframe.setLayout(null);
		//addframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		welcome.setBounds(30,30,300,20);
		name.setBounds(30,60,80,20);
		name_text.setBounds(100,60,80,20);
		roll.setBounds(30,100,80,20);
		roll_text.setBounds(100,100,80,20);
		Submit.setBounds(30,150,160,20);

		addframe.add(welcome);
		addframe.add(name);
		addframe.add(roll);
		addframe.add(name_text);
		addframe.add(roll_text);
		addframe.add(Submit);
	}

	 void menuframe(){

		frame = new JFrame("Menu");
    frame.setSize(600,600);
    frame.setVisible(true);

    add =new JButton("Add");
    update = new JButton("update");
    display = new JButton("display");
    exit = new JButton("Exit");

    frame.setLayout(null);

    add.setBounds(30,30,160,30);
    update.setBounds(30,90,160,30);
    display.setBounds(30,150,160,30);
    exit.setBounds(30,210,160,30);

    frame.add(add);
    frame.add(update);
    frame.add(display);
    frame.add(exit);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add.addActionListener(this);
		update.addActionListener(this);
		exit.addActionListener(this);
	}

}

public class swingDemo{

	public static void main(String arg[]){
		new DemoFrame().menuframe();
	}
}
