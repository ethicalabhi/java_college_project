/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class GetMessageExample extends HttpServlet
/*    */ {
/*    */   private String smtpHost;
/*    */ 
/*    */   public void init(ServletConfig config)
/*    */     throws ServletException
/*    */   {
/* 21 */     super.init(config);
/*    */ 
/* 23 */     this.smtpHost = config.getInitParameter("smtpHost");
/* 24 */     this.smtpHost = "localhost";
/*    */   }
/*    */ 
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 28 */     doPost(request, response);
/*    */   }
/*    */ 
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 34 */     String username = request.getParameter("username");
/* 35 */     String password = request.getParameter("password");
/* 36 */     String host = "localhost";
/* 37 */     Object obj = null;
/* 38 */     PrintWriter out = response.getWriter();
/* 39 */     System.out.println("ur username is --> "+username +"\n ur password is --> "+ password + "\n Get message example in servlet");
/*    */     try
/*    */     {
/* 44 */       RequestDispatcher rd = request.getRequestDispatcher("/inbox.jsp");
/* 45 */       rd.forward(request, response);
/* 46 */       System.out.println("after forward in getmessage");
/*    */     }
/*    */     catch (Exception e) {
/* 49 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

