/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigInteger;
/*    */ import java.security.KeyFactory;
/*    */ import java.security.PrivateKey;
/*    */ import java.security.spec.RSAPrivateKeySpec;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.PreparedStatement;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletConfig;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class SendToMobile extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 38 */     doPost(request, response);
/*    */   }
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/*    */     try
/*    */     {
/* 45 */       HttpSession session = request.getSession();
/* 46 */       String byts = session.getAttribute("pwd").toString();
/*    */ 
               Database db= new Database();
/* 48 */       String cypher = request.getParameter("pass");
/* 49 */       String acno = request.getParameter("acno");
/* 50 */       byte[] cbytes = byts.getBytes("UTF8");
/*    */ 
/* 52 */       byte[] cph = cypher.getBytes();
/*    */ 
/* 56 */       File f = new File("C:/sbank/" + acno + "/private.key");
/* 57 */       FileInputStream in = new FileInputStream(f);
/* 58 */       ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(in));
/*    */ 
/* 60 */       BigInteger m = (BigInteger)oin.readObject();
/* 61 */       BigInteger e = (BigInteger)oin.readObject();

/* 62 */       String sm = "";
/* 63 */       String se = "";
/*    */ 
/* 65 */       RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
/* 66 */       KeyFactory fact = KeyFactory.getInstance("RSA");
/* 67 */       PrivateKey privKey = fact.generatePrivate(keySpec);
    			System.out.println("----------------------");
				System.out.println("Private Key : "+privKey);

/*    */       Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
/*    */       cipher.init(2, privKey);
/* 74 */       byte[] cleartext1 = cipher.doFinal(cbytes);
				
				System.out.println("cleattext1 : "+cleartext1);
/*    */        System.out.println("------------------------");
/* 76 */       int plen = Integer.parseInt(session.getAttribute("plen").toString());
/* 77 */       String plainText = new String(cleartext1);
/* 78 */       int slen = plainText.length();
/* 79 */       String fin = plainText.substring(slen-plen,slen);
/*    */ 
/* 82 */         Connection con=null;
                con=db.getConnection();
                PreparedStatement pst = con.prepareStatement("update customer set pass=? where accno=?");
/* 85 */       pst.setString(1, byts);
/* 86 */       pst.setString(2, acno);

/* 87 */       int j = pst.executeUpdate();
/* 88 */
				if (j > 0) {
/* 89 */        request.setAttribute("pwd","sent");
/*    */       }
/* 91 */       getServletConfig().getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
/*    */     } catch (Exception e) {
/* 93 */       System.out.println(e);
/*    */     }
/*    */   }
/*    */ }
