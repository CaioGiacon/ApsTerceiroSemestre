<%@ page import="com.crudapsjava.dao.InformacoesDao"%>
<%@ page import="com.crudapsjava.bean.Informacoes" %>
<jsp:useBean id="c" class="com.crudapsjava.bean.Informacoes"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>

<%
int i = InformacoesDao.updateInformacoes(c);
response.sendRedirect("viewinformacoes.jsp");
%>