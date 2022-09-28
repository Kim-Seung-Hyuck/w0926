<%--
  Created by IntelliJ IDEA.
  User: zldnl
  Date: 2022-09-28
  Time: 오후 5:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Tables - SB Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</head>
<div class="container-fluid px-4">
    <h1 class="mt-4">Tables</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
        <li class="breadcrumb-item active">Tables</li>
    </ol>
    <div class="card mb-4">
        <div class="card-body">
            ${read}
        </div>
    </div>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            DataTable Example
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#tno</th>
                    <th scope="col">Title</th>
                    <th scope="col">memo</th>
                    <th scope="col">Dou Date</th>
                    <th scope="col">Complete</th>
                    <th scope="col">regdate</th>
                    <th scope="col">moddate</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="todo">
                    <tr>
                        <th scope="row">${todo.tno}</th>
                        <td><a href="/todo/" <c:out value="${todo.title}"/></td>
                        <td><c:out value="${todo.dueDate}"/></td>
                        <td>${todo.complete?"END":"NOT YET"}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>