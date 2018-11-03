
package cr;
import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cr01 extends javax.swing.JFrame {

    private static ServerSocket sk;
    static Connection con;
    static Statement stm;
    static ResultSet rs;
    Socket link=null;
     String d[]=new String[10],r;
    public Cr01() {
        initComponents();
        try
         {
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost/chatroom","root","rao");
             stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         }
         catch(ClassNotFoundException e)
          {
              System.out.println("Unable to load the driver"+e);
             
          }
         catch(SQLException e)
         {
             System.out.println("Connection not established"+e);
         }
         System.out.println("Opening port \n");
         try
         {
          sk=new ServerSocket(9090);
         // Socket link=null;
         link=sk.accept();
         }
         catch(IOException e)
         {
          System.out.println("Unable to port\n"); 
         }    
         jTextArea1.setText("Welcome");
    }
   /* private void db() throws IOException,SQLException
    {
           String s2="select * from chat";
           rs=stm.executeQuery(s2);
           rs.last();
           rs.relative(-10);
          
           int i=0;
           while(rs.next())
           {
             r=rs.getString(1)+"            "+rs.getString(2)+"\n";
             d[i]=r;
             i=i+1;
           } 
            jTextArea1.setText(d[0]);
           
           for(int j=1;j<i;j++)
           {
            jTextArea1.append(d[j]);
           }
           rs.close();
    }*/
    void send() throws IOException,SQLException
    {
         
         PrintWriter output=new PrintWriter(link.getOutputStream(),true);
         String tm=jTextField1.getText();
         String message="Murali :"+tm;
         String s1="insert into chat values('"+message+"')";
         stm.executeUpdate(s1);
         jTextArea1.append(message);
         output.println(message);
    }
    
    void recieve() throws Exception
    {
        String messagec="";
      //  Socket link=null;
        do
                {
                    try {
                        
                       // link=sk.accept();
                        Scanner input=new Scanner(link.getInputStream());
                        messagec=input.nextLine();
                        String s2="insert into chat values('"+messagec+"')";
                        stm.executeUpdate(s2);
                        jTextArea1.append(messagec);
                    } catch (Exception ex) {
                        Logger.getLogger(Cr01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }while(true);
    }
   /* private  void handleClient() throws IOException,SQLException
     {
       Socket link=null;
       try
       {
           link=sk.accept();
           Scanner input=new Scanner(link.getInputStream());
           PrintWriter output=new PrintWriter(link.getOutputStream(),true);
          // db();
           for(int i=0;i<10;i++)
           {
              output.println(d[i]);
           }
           String message=input.nextLine();
           String s1="insert into chat values(Nikhil,'"+message+"')";
           stm.executeUpdate(s1);
           jTextArea1.append("Nikhil :"+message);
           System.out.println("Nikhil :"+message+"\n");
         
           while(!message.equals("cl"))
           {
           //Scanner s=new Scanner(System.in);
           //String m=s.nextLine();
           String m=jTextField1.getText();
           
           System.out.println("Murali :"+m);
           output.println(m);
           message=input.nextLine();
           System.out.println("Nikhil :"+message);
           }
       }
       catch(IOException e)
       {
           System.out.print(e);
       }
       finally
       {
           try{
           link.close();}
           catch (Exception e)
           {
               System.out.print(e);
           }
       }
   }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("SEND");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try{
             send();
         }
         catch(Exception e)
         {
         }
         
    }//GEN-LAST:event_jButton1ActionPerformed
 
    public static void main(String args[]) throws IOException,SQLException {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Cr01 c=new Cr01();
                c.setVisible(true);
                try { 
                    c.recieve();
                } catch (Exception ex) {
                    Logger.getLogger(Cr01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
