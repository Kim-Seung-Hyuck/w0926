<%--
  Created by IntelliJ IDEA.
  User: zldnl
  Date: 2022-09-27
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../includes/header.jsp"%>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Tables</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                    <li class="breadcrumb-item active">Tables</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-body">
                        ${list}
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
                                <th scope="col">Dou Date</th>
                                <th scope="col">Complete</th>
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
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

<script>
    const myModal = new bootstrap.Modal(document.querySelector("#exampleModal"))

    console.log(myModal)

    myModal.show()

    // myModal.hide()

</script>

<%@include file="../includes/footer.jsp"%>