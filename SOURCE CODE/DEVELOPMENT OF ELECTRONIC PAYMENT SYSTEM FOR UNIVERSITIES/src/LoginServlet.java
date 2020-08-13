/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class LoginServlet extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest req, HttpServletResponse res)
/*    */     throws ServletException, IOException
/*    */   {
	                Database db= new Database();
/*  9 */     System.out.println("in servlet");
/*    */     try
/*    */     {
/* 13 */       String userid = req.getParameter("un");
/* 14 */       System.out.println("userid:" + userid);
/* 15 */       PrintWriter pw = res.getWriter();
/*    */ 
/* 19 */      
                  Connection con=null;
                  con=db.getConnection();
                 
/*    */ 
/* 23 */       Statement st = con.createStatement();
/*    */ 
/* 25 */        ResultSet rs = st.executeQuery("select s.studentname,s.branch,s.paidfee,s.duefee,s.PAYDATE,m.MAILBODY,m.maildate from studentfeerecord s,INBOX_MAILS m where m.TOMAILID=s.studentid and s.studentid='" + userid + "'");
/*    */       // ResultSet rs1 = st.executeQuery("select MAILBODY from INBOX_MAILS where TOMAILID='" + userid + "'");
/* 27 */       if (rs.next())
/*    */       {
	              String sname = rs.getString(1);
                  String branch = rs.getString(2);
/* 29 */          String paid = rs.getString(3);
                  String due = rs.getString(4);
                  String date = rs.getString(5);
                  String message = rs.getString(6);
                  String mdate = rs.getString(7);
/* 30 */           pw.println(sname);
                   pw.println(branch);
                   pw.println(paid);
                   pw.println(due);
                   pw.println(date);
                   pw.println(message);
                   pw.println(mdate);
                  
/*    */       } 
/*    */       else
/*    */       {
/* 35 */         pw.println("invalid");
/*    */       }
                
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 40 */       System.out.println(e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\JAVAPROJECTS\Desktop\j2me\sbank\sbank\WEB-INF\classes\
 * Qualified Name:     LoginServlet
 * JD-Core Version:    0.6.0
 */