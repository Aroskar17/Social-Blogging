
package dbmsproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Comment extends Frame implements ActionListener{
    JFrame f=new JFrame("Comment");
    JFrame frame=new JFrame("Delete Comments");
    JPanel pann= new JPanel();
    JLabel label= new JLabel("Comments");
    Statement stmt=null;
    ResultSet rs=null;
    String query="";
    int cntBlogs = 0 , cntComments = 0 ,users=0,deleteCommentBlogId=57;
    Connector c=new Connector();
    Connection conn=c.getConn();
    Comment()
    {
         display_Comment();
       
        
        
    }
    public void display_Comment()
    {
        JButton btn1,btn2,btn3;
        btn1=new JButton("dkjsf");
         f.setSize(400,400);
        f.setVisible(true);
        pann.setSize(200,200);
     btn1.addActionListener(this);
   
        pann.add(btn1);
        f.add(pann);
        f.addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent e) {
              dispose();
      }
    });
        
        
        
    }
    
        
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String query="SELECT COUNT(userId) from user";
        try {
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next())
              users=rs.getInt("COUNT(userId)");
            query="SELECT COUNT(blogId) FROM blog";
            rs = stmt.executeQuery(query);
            while(rs.next())
                cntBlogs=rs.getInt("COUNT(blogId)");
            rs = stmt.executeQuery(query);
            while(rs.next())
                cntBlogs=rs.getInt("COUNT(blogId)");
System.out.println("Users="+users+"\nBlogs="+cntBlogs);
displayPanel();
  

    
}
catch (SQLException ex){
    
    System.out.println(ex);
   
}
    }
    public void buildModel(int userId,int cid,int blogId,String message,String title,String content)
    {
        JPanel pann= new JPanel();
        JLabel lab = new JLabel("Blog Title");
        
        lab.setText("Top-Left");
        lab.setSize(40,200);
        
        lab.setFont(new Font("Verdana", Font.PLAIN, 18));
        pann.add(lab);
        JLabel comment=new JLabel("Comments");
        lab.setText("Top-Left");
        lab.setSize(40,200);
        lab.setFont(new Font("Verdana", Font.PLAIN, 18));
        BoxLayout layout = new BoxLayout(pann,BoxLayout.Y_AXIS);
        frame.add(pann);
    }
      public void displayPanel()
    {
         JFrame frame = new JFrame("Delete Comments");    
         int framex=400,framey=400;
       
            Scrollbar s = new Scrollbar();    
  
            s.setBounds (framex-30, 0, 20, framey);  
            f.add(s);    
            f.setSize(framex, framey);  
            f.setLayout(null);    
            int userId,cid,blogId;
            String message,title,content;
            try{
                stmt=conn.createStatement();
                query="SELECT * FROM blog join comment ON comment.blogId="+deleteCommentBlogId;
                rs=stmt.executeQuery(query);
             

if (rs != null) {
               

    while (rs.next()) {
         

            userId=rs.getInt("userId");
            cid=rs.getInt("cid");
            blogId=rs.getInt("blogId");
            message=rs.getString("message");
            title=rs.getString("title");
            content=rs.getString("content");
            System.out.println(userId+" "+cid+" "+" "+blogId+" "+message);
           buildModel(userId,cid,blogId,message,title,content);

     
    }
}  
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }

          
            f.setVisible(true);    

    }
    public static void main(String args[])
    {
    
       
        Comment comment=new Comment();
    }

    
    
        
}
