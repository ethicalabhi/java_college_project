
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<h3>
		<center>
			<font color="#017fb6"><b><i>Welcome <%=(String) session.getAttribute("user")%>,Here
						u can send a mail...</i> </b> </font>
		</center>
	</h3>
	<br>
	<br>
	<jsp:include page="StatusMsg.jsp" />
	<form method="post" action="./ComposeMailAction">
		<center>
			<table>
				<tr>
					<td>
						<font color="blue"><b>From :&nbsp;</b> </font>
					</td>
					<td>
						<input type='text' name="from" />
						<br>
					</td>
					<td>
						&nbsp;
						<font color="red"><b></b> </font>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<font color="blue"><b>Password :&nbsp;</b> </font>
					</td>
					<td>
						<input type='password' name="password" />
						<br>
					</td>
					<td>
						&nbsp;
						<font color="red"><b></b> </font>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<font color="blue"><b>To :&nbsp;</b> </font>
					</td>
					<td>
						<input type='text' name="to" />
						<br>
					</td>
					<td>
						&nbsp;
						<font color="red"><b></b> </font>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<font color="blue"><b>Subject :&nbsp;</b> </font>
					</td>
					<td>
						<input type="text" name="subject" size="65" />
						<br>
					</td>
					<td>
						<font color="red"><b> </b> </font>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<font color="blue"><b>Message :&nbsp;</b> </font>
					</td>
					<td>
						<textarea type='text' name="text" cols="49" rows="5"></textarea>
						<br>
					</td>
					<td>
						&nbsp;
						<font color="red"><b></b> </font>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<font color="blue"><b>Attachment :&nbsp;</b> </font>
					</td>
					<td>
						<input type="file" name="attachmentfile" size="65" />
						<br>
					</td>
					<td>
						<font color="red"><b> </b> </font>
						<br>
					</td>
				</tr>
				<tr>
					<tr>
						<td>
							<br>
							<input type="submit" value="send" />
						</td>

					</tr>
			</table>
		</center>
	</form>
</body>