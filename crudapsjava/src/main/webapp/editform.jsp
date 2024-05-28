<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição das Informações</title>
<link rel="stylesheet" href="index.css">
</head>
<body>

    <%@page import="com.crudapsjava.bean.Informacoes, com.crudapsjava.dao.InformacoesDao" %>

    <%
        String id = request.getParameter("id");
        Informacoes informacoes = InformacoesDao.getRegistroById(Integer.parseInt(id));
    %>
    
    <h1>Edição das Informações</h1>
    <form action="editinformacoes.jsp" method="post">
        <input type="hidden" name="id" value="<%=informacoes.getId()%>"/>
        <table>
            <tr>
                <td>Mês: </td>
                <td><input type="text" name="mes" value="<%=informacoes.getMes()%>"/></td>
            </tr>
            <tr>
                <td>Qtd_petroleo_extraida_mes: </td>
                <td><input type="number" name="qtd_petroleo_extraida_mes" value="<%=informacoes.getQtd_petroleo_extraida_mes()%>"/></td>
            </tr>
            <tr>
                <td>Qtd_carbono_liberado_mes: </td>
                <td><input type="number" name="qtd_carbono_liberado_mes" value="<%=informacoes.getQtd_carbono_liberado_mes()%>"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Editar Informações"></td>
            </tr>
        </table>
    </form>
</body>
</html>
