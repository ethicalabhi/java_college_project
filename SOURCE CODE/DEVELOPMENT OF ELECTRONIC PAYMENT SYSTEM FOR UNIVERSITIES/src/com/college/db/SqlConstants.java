package com.college.db;

public class SqlConstants {

	// ex public static final String
	// _ADD_STATE="insert into state values((select nvl(max(stateid),100)+1 from state),?)";

	public static final String _CHECK_USER = "select l.useridref,l.logintype from logindetails l,userdetails u where loginid=? and password=? and u.status='Active' and u.userid=l.useridref";
	public static final String _CHANGE_PASSWORD = "update logindetails set password=? where loginid=? and password=?";
	public static final String _CHANGE_QUESTION = "update userdetails set forgotpwquestion=?,forgotpwanswer=? where (select loginid from logindetails l,userdetails u where loginid='a' and l.useridref=u.userid )=?";
	public static final String _RECOVER_PASSWORD = "select password from logindetails l where l.loginid=? and l.SECURITYQUESTION=? and l.SECURITYANSWER=?";
	public static final String _NEW_PASSWORD = "update logindetails set password=? where loginid=?";
	public static final String _VIEW_USER = "select u.userid,u.firstname,u.emailid,u.gender,u.faxno,u.photograph,u.status,a.phoneno,a.houseno,a.STREET,a.city,a.DISTRICT,a.STATE,a.COUNTRY,a.PINCODE,l.logintype,l.loginid from userdetails u,addresses a, logindetails l where  u.userid=a.useridref and  status=? and l.logintype=? and u.userid=l.useridref and a.useridref=l.useridref";
	public static final String _VIEW_USER_PROFILE = "select u.userid,u.firstname,u.lastname,u.dob,u.emailid,u.faxno,u.photograph,a.phonetype,a.phoneno,a.addresstype,a.houseno,a.STREET,a.city,a.DISTRICT,a.STATE,a.COUNTRY,a.PINCODE from userdetails u,addresses a, logindetails l where  u.userid=a.useridref  and l.loginid=? and u.userid=l.useridref and a.useridref=l.useridref";
	public static final String _UPDATE_USER_STATUS = "update userdetails set status='Active' where userid=?";
	public static final String _ADD_ANIMAL_TYPE = "insert into Animal_type values((select nvl(max(animaltypeid),100)+1 from Animal_type),?,?)";
	public static final String _VIEW_ANIMAL_TYPE = "select AnimalTypeId,Typename,typedescription from animal_type";
	public static final String _ADD_ANIMAL_NAME = "insert into Animal_Name values((select nvl(max(animalid),100)+1 from Animal_NAME),?,?,?,?)";
	public static final String _VIEW_ANIMAL_NAME = "select AnimalId,animalname,animaldescription,animalimg from animal_Name";
	public static final String _GET_ANIMAL_NAMES = "select a.animaltypeid,a.typename,b.AnimalId,b.animalname "
			+ "from animal_name b,animal_type a where animaltypeidref=? and a.animaltypeid=b.animaltypeidref";
	public static final String _ADD_ANIMAL_FILE = "insert into Animal_blog values(?,?,?,?,?,(select nvl(max(blogid),100)+1 from animal_blog))";
	public static final String _VIEW_ANIMAL_FILE = "select animalid,animalname,animaldescription,animalimg from animal_name";
	public static final String _VIEW_ANIMAL_PHOTO = "select * from animal_Name where animaltypeidref=?";
	public static final String _VIEW_ANIMAL_ALLPHOTO = "select * from animal_blog where animalidref=?";
	public static final String _ADD_NEWSLETTER = "insert into NEWS_LETTER values((select nvl(max(newsid),100)+1 from news_letter),?,?,?,sysdate)";
	public static final String _VIEW_NEWS_LETTER = "select newsId,newsheadlines,newsdescription,newsphotos,newsdate from news_letter";
	public static final String _DELETE_USER = "update userdetails set status='DeActive' where userid=?";
	public static final String _DELETE_NEWS_LETTER = "delete news_letter where newsid=?";
	public static final String _VIEW_DELETE_ALLPHOTOS = "select * from animal_blog where animalidref=? and animaltypeidref=?";
	public static final String _UPDATE_EVENT_STATUS = "update event set eventstatus='Active' where eventid=?";
	public static final String _DELETE_EVETNS = "delete EVENT where eventid=?";
	public static final String _POST_QUERY = "insert into queries (queryid,querytype,useridref,query,qstatus) values((select nvl(max(queryid),100)+1 from queries),?,?,?,'pending')";

	// Notes
	public static final String _USER_FOLDER = "select folderid,foldername,CREATIONDATE from FOLDER_CATAGORY where userid=(select userid from userdetails where userid=?)";
	// contact groups
	public static final String _CONTACT_GROUPS = "select * from contact_group where useridref=?";
	// mails
	public static final String _MAIL_CONTACTS = "select userid, loginid  from userdetails";
	public static final String _SEND_MAIL = "insert into INBOX_MAILS values((select nvl(max(messageid),100)+1 from INBOX_MAILS),?,?,?,?,sysdate)";
	public static final String _SEND_MAIL1 = "insert into OUTBOX_MAILS values((select nvl(max(messageid),100)+1 from OUTBOX_MAILS),?,?,?,?,sysdate)";
	public static final String _VIEW_OUT_MAILS = "select * from OUTBOX_MAILS where frommailid=?";
	public static final String _VIEW_OUT_MAIL = "select * from OUTBOX_MAILS where messageid=?";
	public static final String _VIEW_IN_MAILS = "select * from INBOX_MAILS where tomailid=?";
	public static final String _VIEW_IN_MAIL = "select * from INBOX_MAILS where messageid=?";
	public static final String _VIEW_MAILID = "select loginid from userdetails where userid=?";
	public static final String _DELETE_MAIL = "delete OUTBOX_MAILS where messageid=?";
	public static final String _DELETE_MAIL1 = "delete INBOX_MAILS where messageid=?";
	public static final String _TIPS_SUGGESTION = "delete TIPS_SUGGESTIONS where tipsid=?";
	public static final String _INBOX_ATTACHMENT_FILE = "insert into INBOX_MAIL_ATTACHMENT values((select nvl(max(ATTACHMENTID),10)+1 from INBOX_MAIL_ATTACHMENT),(select max(MESSAGEID) from INBOX_MAILS),?,?)";
	public static final String _OUTBOX_ATTACHMENT_FILE = "insert into OUTBOX_MAIL_ATTACHMENT values((select nvl(max(ATTACHMENTID),10)+1 from OUTBOX_MAIL_ATTACHMENT),(select max(MESSAGEID) from OUTBOX_MAILS),?,?)";

}
