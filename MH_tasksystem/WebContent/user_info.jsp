<%@page import="com.itour.etip.pub.frame.FrmUser;"%>
<%
FrmUser activeUser = FrmUser.getUser();
%>
<script>
var user_name = "<%=activeUser.chinseName%>";
var user_id = "<%=activeUser.userBaseID%>";
</script>