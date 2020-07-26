//Restaurant management system
/********************************************************/
/*********************************************************/
//all imports
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.Region;

/********************************************************/
/*********************************************************/
//main class
public class rmsys{
	public static void main(String[] args){
	//new Login();
    new RMSystem();
	}
}

/********************************************************/
/*********************************************************/
//admin access to the system
class RMSystem extends JFrame implements ActionListener {
//assign variables to be used in the program and initialize

///buttons
public JButton ubtn=new JButton("USERS");
public JButton ibtn=new JButton("INVENTORY"); 
public JButton obtn=new JButton("Order");
public JButton ebtn=new JButton("Log Out");
public JButton adduserbtn=new JButton("add");
public JButton additem;
public JButton addoitem=new JButton("Add");
public JButton reset=new JButton("Reset");
public JButton print=new JButton("Bill");
public JButton newitem=new JButton("New");
public JButton edititem=new JButton("edit");
public JButton deleteitem=new JButton("delete");
public JButton savenewitem=new JButton("save");
public JButton saveedit=new JButton("Save");
public JButton savedelete=new JButton("Delete");
public JButton deleteuserbtn=new JButton("delete");
public JButton savedelubtn=new JButton("save");
public JButton savenewubtn=new JButton("save");
public JButton updateuserview= new JButton("update view");
public JButton updatitemview= new JButton("update view");
public JButton ViewItems= new JButton("view Items");
public JButton MakeAdmin= new JButton("make admin");
public JButton MakeAdminSave=new JButton("save admin");

//panels
public JPanel panel =new JPanel();
public JPanel workpanel =new JPanel();
public JPanel userpanel1 =new JPanel();
public JPanel inventorypanel1 =new JPanel();
public JPanel orderpanel1 =new JPanel();
public JPanel menupanel =new JPanel();
public JPanel titlepanel =new JPanel();
public JPanel listpanel =new JPanel();
public JPanel adduserpl =new JPanel();
    public JPanel makeadminpl =new JPanel();
public JPanel deluserpl  =new JPanel();
public JPanel createorderpanel =new JPanel();
public JPanel recieptpanel =new JPanel();
public JPanel newitempanel =new JPanel();
public JPanel edititempanel =new JPanel();
public JPanel deleteitempanel =new JPanel();

//text areas
public JTextArea itemoqnt = new javax.swing.JTextArea();
public JTextArea listtf = new javax.swing.JTextArea();
public JTextArea listtf2 = new javax.swing.JTextArea();
public JTextArea reciepttf = new javax.swing.JTextArea();
public JTextArea currenttotal = new javax.swing.JTextArea();
public JTextArea newusername = new javax.swing.JTextArea();
public JTextArea newuserpass = new javax.swing.JTextArea();
public JTextArea usernamedel = new javax.swing.JTextArea();
public JTextArea userlist = new javax.swing.JTextArea();
public JTextArea itemoid = new javax.swing.JTextArea();
public JTextArea itemid = new javax.swing.JTextArea();
public JTextArea setname = new javax.swing.JTextArea();
public JTextArea setprice = new javax.swing.JTextArea();
public JTextArea setqnt = new javax.swing.JTextArea();
public JTextArea editid = new javax.swing.JTextArea();
public JTextArea editname = new javax.swing.JTextArea();
public JTextArea editprice = new javax.swing.JTextArea();
public JTextArea editqnt = new javax.swing.JTextArea();
public JTextArea deleteid = new javax.swing.JTextArea();
public JTextArea text = new javax.swing.JTextArea();
public JTextArea text2 = new javax.swing.JTextArea();
public JTextArea setidta = new javax.swing.JTextArea();
    public JTextArea addadminname = new javax.swing.JTextArea();

//labels
public JLabel instructions=new JLabel("For user management click the USER button... ");
public JLabel instructions2=new JLabel("For Inventory management click the Inventory button... ");
public JLabel instructions3=new JLabel("For Orders click the order button...");
public JLabel userlb=new JLabel("Manage Users");
public JLabel inventorylb=new JLabel("Manage Inventory");
public JLabel orderlb=new JLabel("Manage Orders");
public JLabel itemidlb=new JLabel("ITEM ID");
public JLabel itemqntlb=new JLabel("ITEM QNT");
public JLabel currenttotallb=new JLabel("Current Total");
public JLabel newusernamelb=new JLabel("User name");
public JLabel newuserpasslb=new JLabel("Password");
public JLabel usernamelb=new JLabel("Username");
public JLabel setnamelb=new JLabel("Item Name");
public JLabel setpricelb=new JLabel("Set Price ");
public JLabel setqntlb=new JLabel("Set Quantity");
    public JLabel setidlb=new JLabel("Item id");
public JLabel editidlb=new JLabel("ID");
public JLabel editnamelb=new JLabel("new Name");
public JLabel editpricelb=new JLabel("new Price");
public JLabel editqntlb=new JLabel("new Quantity");
public JLabel deleteidlb=new JLabel("ID");
public JLabel namelb=new JLabel("Item Name");
public JLabel idlb=new JLabel("ID");
public JLabel pricelb=new JLabel("Price");
    public JLabel invprice=new JLabel("Price");
    public JLabel invID=new JLabel("ID");
    public JLabel invITem=new JLabel("Item");
    public JLabel invQnt=new JLabel("Quantity");
    public JLabel opprice=new JLabel("Price");
    public JLabel opID=new JLabel("ID");
    public JLabel opITem=new JLabel("Item");
    public JLabel opQnt=new JLabel("Quantity");
    public JLabel upname=new JLabel("Name");
    public JLabel uppassword=new JLabel("Password");
    public JLabel addadminlabel=new JLabel("User Name");
    
//strings
private String dltName;
private String dltName2;
private String srcName2;
private String modName2;
private String modPrice2;
private String ModQuantity2;
private int pass;


//links to other classes
private ReciptFile r2= new ReciptFile();
private Names t ;
private vLabour v ;
private DltItem d;
private DltLabour d2;
private OrdrManagement o = new OrdrManagement();
private PrintWriter pw2;
 private TotalPrice t2;

//constructor for the class
	public RMSystem(){
// dimensions for the frame and functions
		
        setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Restaurant Management System");
		setResizable(false);
		setLayout( new BoxLayout( getContentPane(), BoxLayout.Y_AXIS ));
        
	//initialize all variables
	//add actionlisteners to the buttins
	addoitem.addActionListener(this);
	reset.addActionListener(this);
	print.addActionListener(this);
	newitem.addActionListener(this);
	edititem.addActionListener(this);
	
	
	saveedit.addActionListener(this);
	savedelete.addActionListener(this);
	adduserbtn.addActionListener(this);
	deleteuserbtn.addActionListener(this);
	savedelubtn.addActionListener(this);
	savenewubtn.addActionListener(this);
	ebtn.addActionListener(this);
	obtn.addActionListener(this);
	ibtn.addActionListener(this);
	ubtn.addActionListener(this);
    updateuserview.addActionListener(this);
    updatitemview.addActionListener(this);
    ViewItems.addActionListener(this);
    MakeAdmin.addActionListener(this);
    MakeAdminSave.addActionListener(this);
	
	//set editable status of text areas
	listtf.setEditable(false);
	listtf2.setEditable(false);
	reciepttf.setEditable(false);
	currenttotal.setEditable(false);
	
	//set up for labels
	instructions.setForeground(Color.WHITE);
	instructions2.setForeground(Color.WHITE);
	instructions3.setForeground(Color.WHITE);
	userlb.setVisible(false);
	inventorylb.setVisible(false);
	orderlb.setVisible(false);
	
	//title of the current section in use
	titlepanel.setMaximumSize(new Dimension(800, 50));
	titlepanel.add(userlb);
	titlepanel.add(inventorylb);
	titlepanel.add(orderlb);


	//menu button panel
	panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	panel.setMaximumSize(new Dimension(800, 50));
	panel.add( ubtn);
	ibtn.setVisible(true);
	panel.add(ibtn);
	panel.add(obtn);
	panel.add(ebtn);

	///working methods
	 performFileRelatedTask();
 

	 

	//menu panel main
	menupanel.setMaximumSize(new Dimension(800, 100));
	menupanel.add(panel, BorderLayout.NORTH);
	menupanel.add(titlepanel, BorderLayout.SOUTH);

	//the work panel will display all current work as selected by the buttons at the top
	workpanel.setMaximumSize(new Dimension(800, 700));

	workpanel.setBackground(Color.BLACK);
	workpanel.setVisible(true);

	//panel for the user tab to add and remove users to the system
	/*********************************************************************
	**********************************************************************
	***********************************************************************/
	userpanel1.setMaximumSize(new Dimension(820, 700));
	userpanel1.setBackground(Color.BLACK);
	userpanel1.setLayout(null);
	//components for the user panel....ad users and remove users
	/***************************************/
	savedelubtn.setBounds(70,120,100,50);
	savenewubtn.setBounds(70,140,100,50);
	usernamelb.setBounds(5,5,200,20);
	usernamelb.setForeground(Color.WHITE);
	newuserpasslb.setBounds(5,50,200,20);
	newuserpasslb.setForeground(Color.WHITE);
	newusernamelb.setBounds(5,5,200,20);
	newusernamelb.setForeground(Color.WHITE);
        upname.setBounds(600,0,60,50);
        upname.setForeground(Color.WHITE);
        uppassword.setBounds(700,0,60,50);
        uppassword.setForeground(Color.WHITE);
	usernamedel.setBounds(5,25,200,20);
	newuserpass.setBounds(5,70,200,20);
	newusername.setBounds(5,25,200,20);
	adduserbtn.setBounds(10,50,100,50);
	adduserbtn.addActionListener(this);
	userlist.setBounds(500,40,300,600);
	deleteuserbtn.setBounds(5,200,100,50);
        MakeAdmin.setBounds(5,125,100,50);
	
	adduserpl.setBounds(110,100,300,400);
	adduserpl.setBackground(Color.BLACK);
    updateuserview.setBounds(300,600,100,20);
	adduserpl.setLayout(null);
	adduserpl.add(newusernamelb);
	adduserpl.add(savenewubtn);
	adduserpl.add(newuserpasslb);
	adduserpl.add(newuserpass);
	adduserpl.add(newusername);
      
        makeadminpl.setBounds(110,100,300,400);
        makeadminpl.setBackground(Color.BLACK);
        makeadminpl.setLayout(null);
        addadminlabel.setBounds(5,5,200,20);
        addadminlabel.setForeground(Color.WHITE);
        addadminname.setBounds(5,25,200,20);
        MakeAdminSave.setBounds(70,120,100,50);
        makeadminpl.add(addadminlabel);
        makeadminpl.add(addadminname);
        makeadminpl.add(MakeAdminSave);
        makeadminpl.setVisible(false);
        
	adduserpl.setVisible(false);
	deluserpl.setBounds(110,100,300,400);
	deluserpl.setBackground(Color.BLACK);
	deluserpl.setLayout(null);
	deluserpl.add(usernamedel);
	deluserpl.add(savedelubtn);
	deluserpl.add(usernamelb);
	deluserpl.setVisible(false);
        userpanel1.add(upname);
        userpanel1.add(uppassword);
	userpanel1.add(userlist);
	userpanel1.add(adduserbtn);
	userpanel1.add(deleteuserbtn);
	userpanel1.add(deluserpl);
	userpanel1.add(adduserpl);
        userpanel1.add(makeadminpl);
        userpanel1.add(MakeAdmin);
    userpanel1.add(updateuserview);
	userpanel1.setVisible(false);

	//panel for the inventory tab to manage new products and remaining products and prices
	inventorypanel1.setMaximumSize(new Dimension(820, 700));
	inventorypanel1.setBackground(Color.BLACK);
	inventorypanel1.setLayout(null);
	listtf2.setBounds(450,30,350,600);
	listtf2.setVisible(true);
	inventorypanel1.add(listtf2);
        invITem.setBounds(550,0,50,20);
        invITem.setForeground(Color.WHITE);
        invprice.setBounds(650,0,50,20);
        invprice.setForeground(Color.WHITE);
        invQnt.setBounds(720,0,80,20);
        invQnt.setForeground(Color.WHITE);
        invID.setBounds(450,0,100,20);
        invID.setForeground(Color.WHITE);
    updatitemview.setBounds(200,600,100,20);
    inventorypanel1.add(updatitemview);
    inventorypanel1.add(invITem);
    inventorypanel1.add(invprice);
    inventorypanel1.add(invQnt);
        inventorypanel1.add(invID);
	inventorypanel1.setVisible(false);

	//text areas and buttons used in the order section
	itemidlb.setBounds(0,0,100,20);
	itemidlb.setForeground(Color.WHITE);
	itemoid.setBounds(0,20,100,20);
	itemqntlb.setBounds(0,40,100,20);
	itemqntlb.setForeground(Color.WHITE);
	itemoqnt.setBounds(0,60,100,20);
	currenttotallb.setBounds(0,500,100,20);
	currenttotallb.setForeground(Color.WHITE);
	currenttotal.setBounds(0,530,100,20);
	print.setBounds(0,90,60,20);
	reset.setBounds(60,90,80,20);
	addoitem.setBounds(140,90,80,20);
	
	//all panels that will go into the orderpanel
	/*********************************************************************
	**********************************************************************
	***********************************************************************/
	listpanel.setBounds(0,0,300,700);
	listpanel.setBackground(Color.BLACK);
	listpanel.setLayout(null);
    opID.setBounds(5,0,50,20);
    opID.setForeground(Color.WHITE);
    opITem.setBounds(100,0,50,20);
    opITem.setForeground(Color.WHITE);
    opQnt.setBounds(200,0,100,20);
    opQnt.setForeground(Color.WHITE);
	listtf.setBounds(10,25,290,600);
	listpanel.add(listtf);
    listpanel.add(opID);
    listpanel.add(opITem);
    //listpanel.add(opQnt);
	createorderpanel.setBounds(303,0,218,700);
	createorderpanel.setBackground(Color.BLACK);
	createorderpanel.setLayout(null);
	createorderpanel.add(itemidlb);
	createorderpanel.add(itemoid);
	createorderpanel.add(itemqntlb);
	createorderpanel.add(itemoqnt);
	createorderpanel.add(currenttotallb);
	createorderpanel.add(currenttotal);
	createorderpanel.add(addoitem);
    ViewItems.setBounds(5,450,100,20);
    createorderpanel.add(reset);
	createorderpanel.add(print);
    createorderpanel.add(ViewItems);
	recieptpanel.setBounds(520,0,300,700);
	recieptpanel.setBackground(Color.BLACK);
	recieptpanel.setLayout(null);
	reciepttf.setBounds(0,10,290,600);
	recieptpanel.add(reciepttf);
	
	//order panel to manage orders made linking with the inventory 
	/*********************************************************************
	**********************************************************************
	***********************************************************************/
	orderpanel1.setMaximumSize(new Dimension(820, 700));
	orderpanel1.setBackground(Color.BLACK);
	orderpanel1.setLayout(null);
	orderpanel1.add(listpanel);
	orderpanel1.add(createorderpanel);
	orderpanel1.add(recieptpanel);
	orderpanel1.setVisible(false);
	
	//add components to the inventory panel
	//components of the inventory page excluding the text area with the list
	/*********************************************************************
	**********************************************************************
	***********************************************************************/
	//buttons
	newitem.setBounds(10,100,100,20);
        newitem.addActionListener(this);
	inventorypanel1.add(newitem);
	edititem.setBounds(10,130,100,20);
	edititem.addActionListener(this);

	deleteitem.setBounds(10,160,100,20);
	deleteitem.addActionListener(this);
	inventorypanel1.add(deleteitem);
	//*******panel components********
	//labels
	editidlb.setBounds(5,10,80,20);
	editidlb.setForeground(Color.WHITE);
	idlb.setBounds(5,10,80,20);
	idlb.setForeground(Color.WHITE);
	setnamelb.setBounds(5,40,80,20);
	setnamelb.setForeground(Color.WHITE);
	editnamelb.setBounds(5,40,80,20);
	editnamelb.setForeground(Color.WHITE);
	setpricelb.setBounds(5,70,80,20);
	setpricelb.setForeground(Color.WHITE);
	editpricelb.setBounds(5,70,80,20);
	editpricelb.setForeground(Color.WHITE);
	setqntlb.setBounds(5,100,80,20);
	setqntlb.setForeground(Color.WHITE);
	editqntlb.setBounds(5,100,80,20);
	editqntlb.setForeground(Color.WHITE);
    setidlb.setBounds(5,125,200,20);
    setidlb.setForeground(Color.WHITE);

	//text areas
	setname.setBounds(100,40,200,20);
	setprice.setBounds(100,70,200,20);
	setqnt.setBounds(100,100,200,20);
    setidta.setBounds(100,125,200,20);
	editid.setBounds(100,10,200,20);
	editname.setBounds(100,40,200,20);
	editprice.setBounds(100,70,200,20);
	editqnt.setBounds(100,100,200,20);
	deleteid.setBounds(100,10,200,20);
	//buttons for panels
	savenewitem.setBounds(100,145,100,20);
	savenewitem.addActionListener(this);
	saveedit.setBounds(100,140,100,20);
	saveedit.addActionListener(this);
	savedelete.setBounds(100,140,100,20);
	
	//panels
	newitempanel.setBounds(110,100,300,400);
	newitempanel.setBackground(Color.BLACK);
	newitempanel.setLayout(null);
	newitempanel.add(setnamelb);
	newitempanel.add(setpricelb);
	newitempanel.add(setqntlb);
	newitempanel.add(setname);
	newitempanel.add(setprice);
	newitempanel.add(setqnt);
    
	newitempanel.add(savenewitem);
	newitempanel.setVisible(false);
	edititempanel.setBounds(110,100,300,400);
	edititempanel.setBackground(Color.BLACK);
	edititempanel.setLayout(null);
	edititempanel.add(editidlb);
	edititempanel.add(editnamelb);
	edititempanel.add(editpricelb);
	edititempanel.add(editqntlb);
	edititempanel.add(editid);
	edititempanel.add(editname);
	edititempanel.add(editprice);
	edititempanel.add(editqnt);
	edititempanel.add(saveedit);
	edititempanel.setVisible(false);
	deleteitempanel.setBounds(110,100,300,400);
	deleteitempanel.setBackground(Color.BLACK);
	deleteitempanel.setLayout(null);
	deleteitempanel.add(idlb);
	deleteitempanel.add(deleteid);
	deleteitempanel.add(savedelete);
	deleteitempanel.setVisible(false);
	inventorypanel1.add(newitempanel);
	inventorypanel1.add(edititempanel);
	inventorypanel1.add(deleteitempanel);

	
	//add components to the first screen of the program
	workpanel.setBackground(Color.BLUE);
	workpanel.setVisible(true);
	workpanel.add(instructions);
	workpanel.add(instructions2);
	workpanel.add(instructions3);
	
	//add panels to the main frame
	add(menupanel);
	add(workpanel);
	add(userpanel1);
	add(inventorypanel1);
	add(orderpanel1);
	setVisible(true);
        

	
	}
	
	///helping methods for class
	
	public void performFileRelatedTask()
    {
        t = new Names();
        v = new vLabour();
        d = new DltItem();
        d2 = new DltLabour();
        o = new OrdrManagement();
        listtf.setText(o.getFullNames().toString());

    }
	
	public void showItemList(){
        listtf.setText(o.getFullNames().toString());
        listtf2.setText(t.getFullNames().toString());
        userlist.setText(v.getFullNames().toString());
        text.setText(d.getFullNames().toString());
        text2.setText(d2.getFullNames().toString());
	}

	
	//method for controlling actions of all buttons
	public void actionPerformed(ActionEvent e){
	if(e.getSource()==ebtn){
       // new Login();
        new RMSystem();
	dispose();
	}
	if(e.getSource()==ubtn){
	workpanel.setVisible(false);
	userpanel1.setVisible(true);
	inventorypanel1.setVisible(false);
	orderpanel1.setVisible(false);
	userlb.setVisible(true);
	inventorylb.setVisible(false);
	orderlb.setVisible(false);
	}
	if(e.getSource()==ibtn){
	workpanel.setVisible(false);
	userpanel1.setVisible(false);
	inventorypanel1.setVisible(true);
	orderpanel1.setVisible(false);
	userlb.setVisible(false);
	inventorylb.setVisible(true);
	orderlb.setVisible(false);

	}
	if(e.getSource()==obtn){
	workpanel.setVisible(false);
	userpanel1.setVisible(false);
	inventorypanel1.setVisible(false);
	orderpanel1.setVisible(true);
	userlb.setVisible(false);
	inventorylb.setVisible(false);
	orderlb.setVisible(true);
	}
        if(e.getSource()==MakeAdmin){
            adduserpl.setVisible(false);
            deluserpl.setVisible(false);
            makeadminpl.setVisible(true);
        }
        if(e.getSource()==MakeAdminSave){
try {
PrintWriter pw = new PrintWriter(new FileOutputStream("admin.txt",true));
System.out.println("file created");
String userName = addadminname.getText();


String blank="";


pw.println(userName);

pw.println(blank);

pw.close();

}
catch(Exception a){

}

addadminname.setText("");


JOptionPane.showMessageDialog(this, "User has been added to Admin");
}
	if(e.getSource()==newitem){
	newitempanel.setVisible(true);
	edititempanel.setVisible(false);
	deleteitempanel.setVisible(false);
	}
	if(e.getSource()==edititem){
	newitempanel.setVisible(false);
	edititempanel.setVisible(true);
	deleteitempanel.setVisible(false);
	}
	if(e.getSource()==deleteitem){
	newitempanel.setVisible(false);
	edititempanel.setVisible(false);
	deleteitempanel.setVisible(true);
	}
	if(e.getSource()==adduserbtn){
	adduserpl.setVisible(true);
	deluserpl.setVisible(false);
        makeadminpl.setVisible(false);
	}
	if(e.getSource()==deleteuserbtn){
	adduserpl.setVisible(false);
	deluserpl.setVisible(true);
        makeadminpl.setVisible(false);
	}
	if(e.getSource()==reset){
	itemoid.setText("");
	itemoqnt.setText("");
	reciepttf.setText("");
        currenttotal.setText("");
        o.delete();
        t2 = new TotalPrice();
        
        
        
        try {
            PrintWriter pw1 = new PrintWriter(new FileOutputStream("temp.txt"));
            PrintWriter pw2 = new PrintWriter(new FileOutputStream("order.txt"));
            PrintWriter pw3 = new PrintWriter(new FileOutputStream("totalBill.txt",true));
            pw3.println(t.getFullNames()+"\t");
            
            
            
            pw1.close();;
            pw2.close();
            pw3.close();
        } catch (Exception we) {
        }
	
	}
        
        if(e.getSource()==print){
            
            
            BillManagement billing=new BillManagement();
            billing.setVisible(true);
            
            
            
        }
        if(e.getSource()==updateuserview){
            performFileRelatedTask();
            showItemList();
        }
        if(e.getSource()==updatitemview){
             performFileRelatedTask();
            showItemList();
        }
        
if(e.getSource()==savenewitem){
	  try {
				PrintWriter pw = new PrintWriter(new FileOutputStream("item.txt",true));
			
				String itemName = setname.getText();
		   
				String itemPrice = setprice.getText();
			
				String itemQuantity = setqnt.getText();
			
				pw.println(itemName);
				pw.println(itemPrice);
				pw.println(itemQuantity);
			
			
				  
			
			
				pw.close();
			
			
			
			}
			catch(Exception z){
			
			}
		
			setname.setText("");
			setprice.setText("");
			setqnt.setText("");
			JOptionPane.showMessageDialog(this, "Item has been added");
	
	
	}
	if(e.getSource()==savenewubtn){
		  try {
				PrintWriter pw = new PrintWriter(new FileOutputStream("labour.txt",true));
				System.out.println("file created");
				String userName = newusername.getText();

				String userPass = newuserpass.getText();
				String blank="";
			

				pw.println(userName);
				pw.println(userPass);
				pw.println(blank);

				pw.close();
			
			}
			catch(Exception a){

			}
		
			newusername.setText("");
			newuserpass.setText("");
	
			 JOptionPane.showMessageDialog(this, "User has been added");
	}
	if(e.getSource()==savedelete){
			dltName=deleteid.getText();
			listtf2.setText(t.getFullNames().toString());
			d.setName(dltName);
			d.deleteItem();
			 JOptionPane.showMessageDialog(this, "Item has been removed");
	}

	if(e.getSource()==savedelubtn){
			dltName2=usernamedel.getText();
			d2.setName(dltName2);
			d2.deleteItem();
			usernamedel.setText("");
        userlist.setText(d2.getFullNames().toString());
			JOptionPane.showMessageDialog(this, "Labour has been Deleted");
	}
	if(e.getSource()==addoitem){
	////print
			srcName2=itemoid.getText(); //ID
		   // o.setSrchName(srcName);
			ModQuantity2=itemoqnt.getText(); // Quantity
			//o.setQuantity(ModQuantity);
			if(Integer.decode(ModQuantity2)>o.checkQuantity(Integer.decode(srcName2))){
		
			JOptionPane.showMessageDialog(this, "Sorry , This item is not in stock");
			itemoqnt.setText("");
		
			} else {
				pass =Integer.decode(ModQuantity2);
				o.temp(Integer.decode(srcName2),pass);
				itemoid.setText("");

				itemoqnt.setText("");
				System.out.println("will be modified "+srcName2);
				System.out.println("will be modified "+pass);
			
		   
				 r2 = new ReciptFile();
				reciepttf.setText(r2.getFullNames().toString());
				currenttotal.setText(""+r2.getSum().toString());
				try {
				   pw2 = new PrintWriter(new FileOutputStream("order.txt",true));
					pw2.println(r2.getName());
					pw2.println(r2.getQuantity());
					pw2.println(r2.getMulti());
					pw2.close();
                    
				} catch (Exception k) {
				}
	}
   
	if(e.getSource()==addoitem){
		 // TODO add your handling code here:
			srcName2=itemoid.getText(); //ID
		   // o.setSrchName(srcName);
			ModQuantity2=itemoqnt.getText(); // Quantity
			//o.setQuantity(ModQuantity);
			if(Integer.decode(ModQuantity2)>o.checkQuantity(Integer.decode(srcName2))){
		
			JOptionPane.showMessageDialog(this, "Sorry , This item is not in stock");
			itemoqnt.setText("");
		
			} else {
				pass =Integer.decode(ModQuantity2);
				o.temp(Integer.decode(srcName2),pass);
				itemoid.setText("");

				itemoqnt.setText("");
				System.out.println("will be modified "+srcName2);
				System.out.println("will be modified "+pass);
			
		   
				 r2 = new ReciptFile();
				reciepttf.setText(r2.getFullNames().toString());
				currenttotal.setText("Total price : "+r2.getSum().toString());
				try {
				   pw2= new PrintWriter(new FileOutputStream("order.txt",true));
					pw2.println(r2.getName());
					pw2.println(r2.getQuantity());
					pw2.println(r2.getMulti());
					pw2.close();
				} catch (Exception n) {
				}
				//JOptionPane.showMessageDialog(this, "Order ");
			//}
		
		
		
		
		
		}
        showItemList();
	}
	if(e.getSource()==print){
   
		
			 BillManagement billing=new BillManagement();
						 billing.setVisible(true);
		this.dispose();


	}
	if(e.getSource()==updateuserview){
        showItemList();
	}
	if(e.getSource()==updatitemview){
        showItemList();
	}
	if(e.getSource()==ViewItems){
       showItemList();
	}
	if(e.getSource()==MakeAdminSave){

	}
	if(e.getSource()==MakeAdmin){
        adduserpl.setVisible(false);
        deluserpl.setVisible(false);
        makeadminpl.setVisible(true);
	}
	if(e.getSource()==reset){

	}

	}
	}
}

/********************************************************/
/*********************************************************/
//non admin access to the system


//class RMSystem2 extends JFrame implements ActionListener{
    
//}
/********************************************************/
/*********************************************************/
//additional classes
//class
class Names {

    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private int num=1;

    public Names()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        closeFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }

    private void openFile()
    {
        try
        {
            scan = new Scanner(new File("item.txt"));
            System.out.println("File found!");
        }

        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }

    public void readFile()
    {
        try{
            while(scan.hasNextLine())
        {
            name = scan.nextLine();
            price = scan.nextLine();
            quantity=scan.nextLine();
            fullnames.append(num+"\t"+name + " \t" + price + " \t"+quantity+"\n");
            num++;
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
                
        
    }

    private void closeFile()
    {
        scan.close();
    }
}


/********************************************************/
/*********************************************************/
//view classes for users and for the items in stock 

///view users
class vLabour {

    private Scanner scan;
    private String name;
    private String password;
    private String price;
    private String quantity;
    private StringBuilder fullnames;

    public vLabour()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        closeFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }

    private void openFile()
    {
        try
        {
            scan = new Scanner(new File("labour.txt"));
            System.out.println("File found!");
        }

        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }

    private void readFile()
    {
        try{
        while(scan.hasNextLine())
        {
            name = scan.nextLine();
            password = scan.nextLine();
            quantity=scan.nextLine();
            fullnames.append(name + " \t" + password + " \t"+quantity+"\n");
        }
        
    }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void closeFile()
    {
        scan.close();
    }
}

//view items available


/********************************************************/
/*********************************************************/
//deleting classes for the users and for the stock

//deleting users
class DltLabour {
    
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private String itemName [];
    
    public DltLabour()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        
        closeFile();
        
    }
    
    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    
    private void openFile()
    {
        try
        {
            scan = new Scanner(new File("labour.txt"));
            System.out.println("File found!");
        }
        
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void readFile()
    {
        try{
            while(scan.hasNextLine())
            {
                name = scan.nextLine();
                price = scan.nextLine();
                quantity=scan.nextLine();
                fullnames.append(name + " \t" + price + " \t"+quantity+"\n");
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }    }
    private void closeFile()
    {
        scan.close();
    }
    
    public  void deleteItem(){
        
        String dlt = getName();
        
        System.out.println(dlt+"will be deleted");
        
        
        int c=0,track, cnt=0,temp=0;
        
        try{
            Scanner sc = new Scanner(new FileInputStream("labour.txt"));
            while(sc.hasNextLine()){
                cnt++;
                sc.nextLine();
                
            }
            itemName= new String[cnt];
            sc.close();
            sc = new Scanner(new FileInputStream("labour.txt"));
            while(sc.hasNextLine()){
                itemName[c]=sc.nextLine();
                if(itemName[c].equalsIgnoreCase(dlt)){
                    temp=c;
                    System.out.println("Index will be deleted" +c);
                }
                c++;
                
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("labour.txt"));
            for (int i = 0; i < c; i++) {
                if(i==temp ||i==temp+1 ||i==temp+2){
                    
                }
                else{
                    pw.println(itemName[i]);
                }
                
            }
            System.out.println("Your item has been deleted.");
            pw.close();
        }
        catch (Exception e) {
        }
        
        
        
        
        
    }
    
    
    
    
}

//deleting items in the stock
class DltItem {
    
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private String itemName [];
    
    public DltItem()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        
        closeFile();
        
    }
    
    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    
    private void openFile()
    {
        try
        {
            scan = new Scanner(new File("item.txt"));
            System.out.println("File found!");
        }
        
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void readFile()
    {
        try{
            while(scan.hasNextLine())
        {
            name = scan.nextLine();
            price = scan.nextLine();
            quantity=scan.nextLine();
            fullnames.append(name + " \t" + price + " \t"+quantity+"\n");
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    private void closeFile()
    {
        scan.close();
    }
    
    public  void deleteItem(){
        
        String dlt = getName();
        
        System.out.println(dlt+"will be deleted");
        
        
        int c=0,track, cnt=0,temp=0;
        
        try{
            Scanner sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                cnt++;
                sc.nextLine();
                
            }
            itemName= new String[cnt];
            sc.close();
            sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                itemName[c]=sc.nextLine();
                if(itemName[c].equalsIgnoreCase(dlt)){
                    temp=c;
                    System.out.println("Index will be deleted" +c);
                }
                c++;
                
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("item.txt"));
            for (int i = 0; i < c; i++) {
                if(i==temp ||i==temp+1 ||i==temp+2){
                    
                }
                else{
                    pw.println(itemName[i]);
                }
                
            }
            System.out.println("Your item has been deleted.");
            pw.close();
        }
        catch (Exception e) {
        }
        
        
        
        
        
    }
    
    
    
    
}

/********************************************************/
/*********************************************************/
//classess to handle the totals
//inTotal class
class inTotal {
    public Scanner scan;
    public double total=0;
    public String price;

    public String getTotal() {
        
         try{
              scan = new Scanner(new FileInputStream("order.txt"));
            while(scan.hasNextLine())
            {
                
                
                scan.nextLine();
               scan.nextLine();
               price = scan.nextLine();
               total+=Double.valueOf(price);
               
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf(total);
    }
    
    
}

//the total in the order section
 class inTotalPrice {
    public Scanner scan;
    public double total=0;
    public String price;

    public String getTotal() {
        
         try{
              scan = new Scanner(new FileInputStream("order.txt"));
            while(scan.hasNextLine())
            {
                
                
                scan.nextLine();
               scan.nextLine();
               price = scan.nextLine();
               total+=Double.valueOf(price);
               
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf("Total Price is : "+total);
    }
    
    
    
}


//class for total price
class TotalPrice {
    private Scanner sc;
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private double dPrice;
    private int dQuantity;
    private double multi;
    private PrintWriter pw;
    public TotalPrice()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        closeFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }

    private void openFile()
    {
        try
        {
            
            scan = new Scanner(new File("order.txt"));
            
            System.out.println("File found!");
        }

        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }

    private void readFile()
    {
        try{
            while(scan.hasNextLine())
            {
                
                
                name = scan.nextLine();
                System.out.println(name);
                // price = scan.nextLine();
                
                
                quantity=scan.nextLine();
               // dQuantity=Integer.decode(quantity);
                //multi=dPrice*dQuantity;
                price =scan.nextLine();
                fullnames.append(name + " \t"+quantity+"\t"+price+ "\n");
                
                
                
                
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
                
        
    }

    private void closeFile()
    {
        scan.close();
        
    }   
}


/********************************************************/
/*********************************************************/
//classes to handle the order process up to printing out a recipt

//order management class 
class OrdrManagement {
  //  protected OrderManagement o = new OrderManagement();
    private Scanner scan;
    private String srchName;
private int num=1;
   private String s1,s2;

    private String name;
    private int cngQuantity;
    
    private String price;
    private String ItemId;
    private String quantity;
    private StringBuilder fullnames;
    private String itemName [];
    private StringBuilder reciptName;
    public OrdrManagement()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        
        closeFile();
        
    }
    
    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    public StringBuilder getReciptName()
    {
        return reciptName ;
    }
    private void openFile()
    {
        try
        {
            scan = new Scanner(new File("item.txt"));
            System.out.println("File found!");
        }
        
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }
    
    public void setSrchName(String srchName) {
        this.srchName = srchName;
    }
     public String getSrchName() {
        return srchName;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public String getPrice() {
        return price;
    }
    
    public String getQuantity() {
        return quantity;
    }
    
    
    private void readFile()
            
    {
        try{
            while(scan.hasNextLine())
        {
            name = scan.nextLine();
            price = scan.nextLine();
            quantity=scan.nextLine();
            fullnames.append(num+"\t"+name + " \t"+"\t"+"\n");
            num++;
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    private void closeFile()
    {
        scan.close();
    }
    
    public  void ModifyItem(){
        String srcKey=getSrchName();
        System.out.println(srcKey +" is going to be changed in quantity");
        
        System.out.println(srcKey+"will be modified");
        
        
        int c=0,track, cnt=0,temp=0;
        
        try{
            Scanner sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                cnt++;
                sc.nextLine();
                
            }
            itemName= new String[cnt];
            sc.close();
            sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                itemName[c]=sc.nextLine();
                if(itemName[c].equalsIgnoreCase(srcKey)){
                    temp=c;
                    System.out.println("Index will be deleted" +c);
                }
                c++;
                
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("item.txt"));
            for (int i = 0; i < c; i++) {
                if(i==temp+2){
                    cngQuantity= Integer.decode(itemName[i]);
                    
                    cngQuantity=cngQuantity-Integer.decode(getQuantity());
                    pw.println(cngQuantity);
                    System.out.println("Value has been changed ");
                    
                }
                else{
                    pw.println(itemName[i]);
                }
                
            }
            System.out.println("Your item has been deleted.");
            pw.close();
        }
        catch (Exception e) {
        }
        
      
    }
    
    public int checkQuantity(int n){
        int i=1;
        int quantity;
        int count;
         try{
            Scanner sc = new Scanner(new FileInputStream("item.txt"));
            while(sc.hasNextLine()){
                if(i==n){
                    sc.nextLine();sc.nextLine();
                    quantity=Integer.decode(sc.nextLine());
                    return quantity;
                } else {
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
            }
                i++;
            }
            sc.close();
            }
        catch(Exception e){
            System.out.println(e);
            
        }
         return 0;
    }
    public void temp(int n, int i) {
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("temp.txt",true));
            
         Scanner sc = new Scanner(new FileInputStream("Item.txt"));
            for(int j=1;sc.hasNextLine(); j++){
                if (j==n){
                 s1 = sc.nextLine();
                 pw.println(s1);
                 
                 s2 = sc.nextLine();
                 pw.println(i);
                 sc.nextLine();
                } else {sc.nextLine();sc.nextLine();sc.nextLine();}
            }
            sc.close();
            pw.close();
                
        
        try {
            
            pw.println(s1);
            pw.println(s2);
            pw.close();
            
        } catch (Exception e) {
            System.out.println("New File has been created with values ");
        }
               
        
                    
        } catch (Exception e) {}
        delete();
    }
    public void delete(){
        String name ="";
        String quantity="";
        try {
            Scanner sc= new Scanner(new FileInputStream("temp.txt"));
            while(sc.hasNextLine()){
                name=sc.nextLine();
                quantity =sc.nextLine();
                setSrchName(name);
                setQuantity(quantity);
                ModifyItem();
                
                
            
            }
            System.out.println("End of reading temp file");
            sc.close();
        } catch (Exception e) {
        }
    
    }
    
    public void readRecipt(){
        
        try{
            Scanner sc = new Scanner(new FileInputStream("temp.txt"));
            while(sc.hasNextLine())
            {
                name = sc.nextLine();
                //price = scan.nextLine();
                quantity=sc.nextLine(); // + " \t"+quantity+
                reciptName.append(name + " \t" + quantity +"\n");
            }
          sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    
    
}

//adding a user to the admin list from normal users 


// handling the recipt file
class ReciptFile {
    private Scanner sc;
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private double dPrice;
    private int dQuantity;
    private double multi;
    private double sum=0;
    private PrintWriter pw;
    public ReciptFile()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        closeFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    public String getSum(){
    
        return String.valueOf(sum);
    }

    private void openFile()
    {
        try
        {
            pw = new PrintWriter(new FileOutputStream("order.txt",true));
            scan = new Scanner(new File("temp.txt"));
            sc = new Scanner(new FileInputStream("item.txt"));
            System.out.println("File found!");
        }

        catch(Exception g)
        {
            System.out.println("File not found");
        }
    }

    private void readFile()
    {
        try{
            while(scan.hasNextLine())
            {
                sc = new Scanner(new FileInputStream("item.txt"));
                
                name = scan.nextLine();
                System.out.println(name);
                // price = scan.nextLine();
                while(sc.hasNextLine()){
                    multi=1;
                    if(name.equalsIgnoreCase(sc.nextLine())){
                        price=sc.nextLine();
                        dPrice=Double.valueOf(price);
                        System.out.println(dPrice);
                        sc.nextLine();
                    }
                    
                }
                sc.close();
                
                quantity=scan.nextLine();
                dQuantity=Integer.decode(quantity);
                multi=dPrice*dQuantity;
                sum+=multi;
              
                fullnames.append(name + " \t"+quantity+"\t"+multi+ "\n");
               
             //   write();
                
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
                
        
    }

    private void closeFile()
    {
        scan.close();
        sc.close();
        pw.close();
    }
    
    public void write(){
        try {
               pw = new PrintWriter(new FileOutputStream("order.txt",true));
                pw.println(name);
                pw.println(quantity);
                pw.println(multi);
                pw.close();
        } catch (Exception e) {
        }
    }
    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public double getMulti() {
        return multi;
    }
}  
//final billing of orders
class BillManagement extends javax.swing.JFrame {
    private inTotal it ;
   private OrdrManagement  o;
   
   private TotalPrice t;
    private String name;
    private String quantity ;
    private double totalPrice=0;
    private double sum=0;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public String getQuantity() {
        return quantity;
    }
    
    
    /**
     * Creates new form BillManagement
     */
    public BillManagement() {
        initComponents();
        
        
        display();
        performFileRelatedTask();
    }
    public void display(){
         t = new TotalPrice();
         it = new inTotal();
            text.setText(t.getFullNames().toString());
            
       totalPriceArea.setText(it.getTotal());
    
    }
     private void performFileRelatedTask()
    {
        o = new OrdrManagement();
      //  RestaurentManagement r= new RestaurentManagement();
       // r.setVisible(true);
       // this.dispose();
       
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        totalPriceArea = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        payment = new javax.swing.JButton();
        printB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 204, 255));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        totalPriceArea.setEditable(false);
        totalPriceArea.setBackground(new java.awt.Color(255, 102, 102));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        payment.setText("Payment");
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        printB.setText("Print");
        printB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalPriceArea, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(printB)
                        .addGap(18, 18, 18)
                        .addComponent(payment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalPriceArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payment)
                    .addComponent(backButton)
                    .addComponent(printB))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        
        
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        // TODO add your handling code here:
        o.delete();
        t = new TotalPrice();
        
        
        this.dispose();
        try {
            PrintWriter pw1 = new PrintWriter(new FileOutputStream("temp.txt"));
            PrintWriter pw2 = new PrintWriter(new FileOutputStream("order.txt"));
            PrintWriter pw3 = new PrintWriter(new FileOutputStream("totalBill.txt",true));
            pw3.println(t.getFullNames()+"\t");
            
            
            
            pw1.close();;
            pw2.close();
            pw3.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_paymentActionPerformed

    private void printBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBActionPerformed
        // TODO add your handling code here:
        try {
            
            boolean complete = text.print();
            if(complete){
            
                JOptionPane.showMessageDialog(null, "Done printing");
            }
            else{
                JOptionPane.showMessageDialog(null, "Printing cancel","Printer",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_printBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton payment;
    private javax.swing.JButton printB;
    public javax.swing.JTextArea text;
    private javax.swing.JTextField totalPriceArea;
    // End of variables declaration//GEN-END:variables
}



    //***************************

