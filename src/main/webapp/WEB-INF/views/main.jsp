<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Library</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function addHiddenInput(value) {
            var theForm = document.forms['search_from'];
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'type_of_search';
            input.value = value;
            theForm.appendChild(input);
        }
    </script>
</head>
<body>
    <h2 align="center">Welcome to Online Library</h2>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="" name="search_from">
                <div class="input-group form-group">
                    <input type="text" name="search" class="form-control">
                    <div class="input-group-btn">
                        <button type="submit" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Поиск<span style="margin-left: 10%" class="glyphicon glyphicon-search"></span></button>
                        <ul class="dropdown-menu pull-right">
                            <li><a onclick="addHiddenInput('name');search_from.submit()">Поиск по названию</a></li>
                            <li><a onclick="addHiddenInput('author');search_from.submit()">Поиск по автору</a></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <c:if test="${books != null}">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Книга</th>
                    <th>Автор</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${books == null}">
        <h4 align="center">Not found</h4>
    </c:if>
</body>
</html>
