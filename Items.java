import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Items implements ActionListener {
	
	String u1, u2, u3;
	int u4, u5, u6, u7;
	
	JFrame frame;
	JFrame frame1;
	JFrame frame2;

	JLabel prodidLabel = new JLabel("PRODUCT ID:");
    JLabel catLabel = new JLabel("CATEGORY:");
    JLabel prodnameLabel = new JLabel("PRODUCT NAME:");
    JLabel prodqtyLabel = new JLabel("QUANTITY:");
    JLabel cpLabel = new JLabel("COST PRICE:");
    JLabel mrpLabel = new JLabel("MRP:");
    JLabel disLabel = new JLabel("DISCOUT:");
    
    JLabel idLabel= new JLabel();
    JLabel categoryLabel= new JLabel();
    JLabel nameLabel= new JLabel();
    JLabel quantityLabel= new JLabel();
    JLabel cpriceLabel= new JLabel();
    JLabel mrLabel= new JLabel();
    JLabel discountLabel= new JLabel();
    
    JTextField quantityTextField= new JTextField();
    JTextField prodidTextField= new JTextField();
    
    JButton checkButton= new JButton("CHECK MY INVENTORY");
	JButton insertButton= new JButton("SCAN AND INSERT IN INVENTORY");
    JButton done1Button= new JButton("DONE");
    JButton done2Button= new JButton("DONE");

    
    Items() 
    {
        
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    
    public void createWindow()
    {
        (this.frame = new JFrame()).setTitle("ITEM UI");
        this.frame.setBounds(20, 20, 520, 300);
        this.frame.getContentPane().setBackground(Color.pink);
        this.frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
    }
    
    public void setLocationAndSize() {
        
        this.checkButton.setBounds(40, 100, 180, 45);
        this.insertButton.setBounds(250, 100, 220, 45);
        
    }
    
    public void addComponentsToFrame() {
        
        this.frame.add(this.checkButton);
        this.frame.add(this.insertButton);
    }
    
    public void actionEvent()
    {
    	checkButton.addActionListener(this);
    	insertButton.addActionListener(this);
    }
    
    public void insert()
    {
    	(this.frame1 = new JFrame()).setTitle("INSERT CONTENT");
        this.frame1.setBounds(20, 20, 480, 300);
        this.frame1.getContentPane().setBackground(Color.orange);
        this.frame1.getContentPane().setLayout(null);
        this.frame1.setVisible(true);
        this.frame1.setDefaultCloseOperation(3);
        this.frame1.setResizable(false);
        
 
        this.prodidLabel.setBounds(40, 70, 80, 70);
        this.prodidTextField.setBounds(250, 93, 165, 23);
        this.done1Button.setBounds(170, 190, 120, 25);
        
        this.frame1.add(this.prodidTextField);
        this.frame1.add(this.prodidLabel);
        this.frame1.add(this.done1Button);
        
        done1Button.addActionListener(this);
       
    }
    
    public void prompt(String a, String b, String c, int d, int e, int f, int g)
    {
    	
    	u1=a;
    	u2=b;
    	u3=c;
    	u4=d;
    	u5=e;
    	u6=f;
    	u7=g;
    	
    	(this.frame2 = new JFrame()).setTitle("SCAN PROMPT");
        this.frame2.setBounds(20, 280, 480, 500);
        this.frame2.getContentPane().setBackground(Color.yellow);
        this.frame2.getContentPane().setLayout(null);
        this.frame2.setVisible(true);
        this.frame2.setDefaultCloseOperation(3);
        this.frame2.setResizable(false);
 
        this.prodidLabel.setBounds(40, 30, 80, 70);
        this.catLabel.setBounds(40, 70, 80, 70);
        this.prodnameLabel.setBounds(40, 110, 120, 70);
        this.prodqtyLabel.setBounds(40, 150, 80, 70);
        this.cpLabel.setBounds(40, 190, 80, 70);
        this.mrpLabel.setBounds(40, 230, 80, 70);
        this.disLabel.setBounds(40, 270, 80, 70);
        
        this.idLabel.setBounds(300, 30, 80, 70);
        this.categoryLabel.setBounds(300, 70, 80, 70);
        this.nameLabel.setBounds(300, 110, 80, 70);
        this.quantityTextField.setBounds(300, 170, 50, 25);
        quantityTextField.setToolTipText("/"+d);
        this.cpriceLabel.setBounds(300, 190, 80, 70);
        this.mrLabel.setBounds(300, 230, 80, 70);
        this.discountLabel.setBounds(300, 270, 80, 70);
        
        idLabel.setText(""+a);
        categoryLabel.setText(""+b);
        nameLabel.setText(""+c);
        cpriceLabel.setText(Integer.toString(e));
        mrLabel.setText(Integer.toString(f));
        discountLabel.setText(Integer.toString(g));
 
        this.done2Button.setBounds(170, 350, 100, 40);
        
        this.frame2.add(this.prodidLabel);
        this.frame2.add(this.idLabel);
        this.frame2.add(this.categoryLabel);
        this.frame2.add(this.catLabel);
        this.frame2.add(this.nameLabel);
        this.frame2.add(this.prodnameLabel);
        this.frame2.add(this.quantityTextField);
        this.frame2.add(this.prodqtyLabel);
        this.frame2.add(this.cpriceLabel);
        this.frame2.add(this.cpLabel);
        this.frame2.add(this.mrLabel);
        this.frame2.add(this.mrpLabel);
        this.frame2.add(this.discountLabel);
        this.frame2.add(this.disLabel);
        
        this.frame2.add(this.done2Button);
      
        done2Button.addActionListener(this);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	 if(e.getSource()==insertButton)
         {
      	   frame.setVisible(false);
             	insert();   
         }
    	 
    	 if(e.getSource()==done1Button)
         {
      	   try 
             {
      		   	Connection connectiona=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase4?verifyServerCertificate=false&useSSL=true","root","Sayandutta057");
      		   	Statement stmt=connectiona.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from dataset");  
				while(rs.next())
				{
					String pidd = rs.getString(1);
					String catg = rs.getString(2);
					String pnme = rs.getString(3);
					int pqty = rs.getInt(4);
					int pcp = rs.getInt(5);
					int pmrp = rs.getInt(6);
					int pdis = rs.getInt(7);
					
					if(prodidTextField.getText().equals(pidd))
					{
						
				        prompt(pidd,catg,pnme,pqty,pcp,pmrp,pdis);
						
					}	
					
				}  
     		    	    
             }
             
             catch (SQLException e1) 
             {
                 e1.printStackTrace();
             }
             
             frame1.setVisible(false);
             frame.setVisible(true);  
         }
    	 
    	 if(e.getSource()==done2Button)
         {
      	   try 
             {
      		   	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase6?verifyServerCertificate=false&useSSL=true","root","Sayandutta057");
				PreparedStatement Pstatement=connection.prepareStatement("insert into inventory values(?,?,?,?,?,?,?)");
     		    
				
		        int mqty = Integer.parseInt(quantityTextField.getText());             
		        
				
				Pstatement.setString(1,u1);
				Pstatement.setString(2,u2);
				Pstatement.setString(3,u3);
				Pstatement.setInt(4,mqty);
				Pstatement.setInt(5,u5);
				Pstatement.setInt(6,u6);
				Pstatement.setInt(7,u7);
				
				Pstatement.executeUpdate();
				JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
             }
             
             catch (SQLException e1) 
             {
                 e1.printStackTrace();
             }
             
             frame2.setVisible(false);
             frame.setVisible(true);  
         }
    	 
    	 if(e.getSource()==checkButton)
         {
    		 try 
             {
    			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase6?verifyServerCertificate=false&useSSL=true","root","Sayandutta057");    
  				Statement stmt=con.createStatement();  
  				ResultSet rs=stmt.executeQuery("select * from inventory");  
  	
  		        
  				while(rs.next())
  				{
  					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getInt(7));
  				}
             }
    		 catch (SQLException e1) 
             {
                System.out.println(e1.getMessage());
             }
         }
    }
    
    public static void main(String[] args)
    {
    	new Items();
    }
}
    
