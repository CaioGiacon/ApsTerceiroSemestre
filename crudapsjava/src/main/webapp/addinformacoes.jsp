<%@page import="com.crudapsjava.dao.InformacoesDao"%>
<jsp:useBean id="u" class="com.crudapsjava.bean.Informacoes"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	int i = InformacoesDao.salvarInformacoes(u);

	if(i > 0){
		response.sendRedirect("addinformacoes-sucess.jsp");
	}else{
		response.sendRedirect("addinformacoes-error.jsp");
	}



%>