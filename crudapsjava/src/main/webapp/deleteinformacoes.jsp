<%@page import="com.crudapsjava.dao.InformacoesDao"%>
<jsp:useBean id="u" class="com.crudapsjava.bean.Informacoes"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	InformacoesDao.deletarInformacoes(u);
	response.sendRedirect("viewinformacoes.jsp");
%>