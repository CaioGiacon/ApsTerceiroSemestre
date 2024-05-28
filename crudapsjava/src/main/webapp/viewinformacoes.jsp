<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Visualização de Informações</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <%@ page import="com.crudapsjava.dao.InformacoesDao, com.crudapsjava.bean.*, java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="container">
        <h1>Listagem de Informações</h1>
        
        <% 
            List<Informacoes> list = InformacoesDao.getAllInformacoes();
            request.setAttribute("list", list);
        %>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Mês</th>
                <th>Qtd_petroleo_extraida_mes</th>
                <th>Qtd_carbono_liberado_mes</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach items="${list}" var="informacoes">
                <tr>
                    <td>${informacoes.getId()}</td>
                    <td>${informacoes.getMes()}</td>
                    <td>${informacoes.getQtd_petroleo_extraida_mes()}</td>
                    <td>${informacoes.getQtd_carbono_liberado_mes()}</td>
                    <td><a href="editform.jsp?id=${informacoes.getId()}">Editar</a></td>
                    <td><a href="deleteinformacoes.jsp?id=${informacoes.getId()}">Excluir</a></td>
                </tr>    
            </c:forEach>
        </table>
        <br>
        <a href="addinformacoesform.jsp">Adicionar nova informação</a>
        
    </div>
</body>
</html>

