<%@ page contentType="text/html; charset=UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

                <link rel="shortcut icon" type="image/png" href="/favicon.png">

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                    crossorigin="anonymous">

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

                <link rel="stylesheet" href="/styles.css">
                <link href="/custom.css" rel="stylesheet">
                <title>Spring Boot + JSP</title>

            </head>

            <body class="auditoria-bg">

                <div class="container p-4">
                    <div class="row">
                        <div class="col-md-12 d-flex justify-content-end">
                            <a type="button" class="btn btn-primary ml-auto" href="/logout">Cerrar sesión</a>
                        </div>
                    </div>
                </div>

                <div class="container">

                    <div class="title mt-0">
                        <h1 class="fw-medium">Registro de auditoría</h1>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-striped align-middle">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Tipo de operación</th>

                                    <th scope="col">Usuario</th>
                                    <th scope="col">Tipo de usuario</th>
                                    <th scope="col">Fecha operación</th>
                                    <th scope="col">Detalles operación</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${auditoriaList}" varStatus="loop">
                                    <tr>
                                        <th scope="row">${item.id}</th>
                                        <td>${item.operationType}</td>

                                        <td>${item.userName}</td>
                                        <td>${item.userTypeInfo}</td>
                                        <td>${item.operationTime}</td>
                                        <td>${item.operationDetails}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="container p-4">
                        <div class="row">
                            <div class="col-md-12 d-flex justify-content-end">
                                <a type="button" class="btn btn-primary ml-auto" href="/list-users">Atrás</a>
                            </div>
                        </div>
                    </div>

                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
                    crossorigin="anonymous"></script>

                <footer class="footer">
                    <div class="container">
                        <p class="text-muted"><a href="https://www.altia.es/">altia.es</a></p>
                    </div>
                </footer>
            </body>

            </html>