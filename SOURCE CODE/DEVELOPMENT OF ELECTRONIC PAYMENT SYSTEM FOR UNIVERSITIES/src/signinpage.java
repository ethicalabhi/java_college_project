/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class signinpage extends HttpServlet
/*    */ {
/*    */   public void service(HttpServletRequest req, HttpServletResponse res)
/*    */     throws ServletException, IOException
/*    */   {
/* 13 */     System.out.println("in then signin");
/* 14 */     HttpSession session = req.getSession(true);
/*    */ 
/* 16 */     String value = req.getParameter("option");
/* 17 */     System.out.println("value" + value);
/* 18 */     session.setAttribute("value", value);
/*    */     try
/*    */     {
/* 21 */       if (req.getParameter("submit").equals("submit"))
/*    */       {
/* 23 */         String mes = req.getParameter("option");
/* 24 */         System.out.println(mes + "DF");
/* 25 */         req.setAttribute("rf", mes);
/*    */         try
/*    */         {
/* 32 */           if (mes.equals("gomail"))
/*    */           {
/* 34 */             System.out.println("in go");
/*    */ 
/* 39 */             RequestDispatcher rd = req.getRequestDispatcher("getmailDetail.jsp");
/* 40 */             rd.forward(req, res);
/*    */           }
/*    */         } catch (Exception e) {
/* 42 */           System.out.println(e);
/*    */         }
/*    */       }
/*    */     } catch (Exception e) {
/* 45 */       System.out.println(e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\JAVAPROJECTS\Desktop\j2me\sbank\sbank\WEB-INF\classes\
 * Qualified Name:     signinpage
 * JD-Core Version:    0.6.0
 */