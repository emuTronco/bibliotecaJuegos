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
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

        <link rel="stylesheet" href="/styles.css">
        <link href="/custom.css" rel="stylesheet">
        <title>Registro de auditoría</title>

      </head>

      <body>

        <div class="container">

          <!-- <div class="container p-4">
            <div class="row">
              <div class="col-md-12 d-flex justify-content-end">
                <a type="button" class="btn btn-primary ml-auto" href="/logout">Cerrar sesión</a>
              </div>
            </div>
          </div>

          <div>
            <c:choose>
              <c:when test="${not empty mensajeExito}">

                <div class="d-inline-block alert alert-info" role="alert">
                  ${mensajeExito}
                </div>

              </c:when>
            </c:choose>
          </div> -->

          <div class="hstack gap-1">
            <div class="pt-4">
              <c:choose>
                <c:when test="${not empty mensajeExito}">

                  <div class="d-inline-block alert alert-info" role="alert">
                    ${mensajeExito}
                  </div>

                </c:when>
              </c:choose>
            </div>
            <div class="ms-auto"></div>
            <div class="pt-4">
              <a type="button" class="btn btn-primary ml-auto" href="/logout">Cerrar sesión</a>
            </div>
          </div>

          <div class="title mt-0">
            <h5 class="fw-light">Bienvenido ${rolUsuario}</h5>
            <h1 class="fw-medium">Usuarios</h1>
          </div>

          <c:choose>

            <c:when test="${not empty userList}">

              <div class="table-responsive">
                <table class="table table-striped align-middle">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Nombre</th>
                      <th scope="col">Apellido</th>
                      <th scope="col">Correo</th>
                      <th scope="col">Habilitado</th>
                      <c:choose>
                        <c:when test="${rolUsuario != 'USER'}">
                          <th scope="col">Acciones</th>
                        </c:when>
                      </c:choose>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="item" items="${userList}">
                      <tr>
                        <th scope="row">${item.id}</th>
                        <td>${item.name}</td>
                        <td>${item.surname}</td>
                        <td>${item.email}</td>

                        <c:choose>
                          <c:when test="${item.enabled == true}">
                            <td><input type="checkbox" value="${item.enabled}" checked disabled></td>
                          </c:when>
                          <c:otherwise>
                            <td><input type="checkbox" value="${item.enabled}" disabled></td>
                          </c:otherwise>
                        </c:choose>

                        <c:choose>
                          <c:when test="${rolUsuario != 'USER'}">
                            <div class="botones">
                              <td>
                                <c:choose>
                                  <c:when test="${rolUsuario == 'ADMIN' || rolUsuario == 'UPDATE_USER'}">
                                    <a type="button" id="botonUpdate" class="btn btn-success"
                                      href="/update-user?id=${item.id}">Actualizar</a>
                                  </c:when>
                                </c:choose>
                                <c:choose>
                                  <c:when test="${rolUsuario == 'ADMIN' || rolUsuario == 'DELETE_USER'}">
                                    <button type="button" id="botonDelete" class="btn btn-danger" data-bs-toggle="modal"
                                      data-bs-target="#modalDelete" onclick="establecerID(${item.id})">
                                      Borrar
                                    </button>
                                  </c:when>
                                </c:choose>
                              </td>
                            </div>
                          </c:when>
                        </c:choose>
                      </tr>

                      <!-- Modal -->
                      <div class="modal fade" id="modalDelete" tabindex="-1" aria-labelledby="modalDeleteLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h1 class="modal-title fs-5" id="modalDeleteLabel">Eliminar usuario</h1>
                              <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                              ¿Estás seguro que quieres eliminar este usuario?
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                              <a class="btn btn-danger" id="borrarModal">Confirmar</a>
                            </div>
                          </div>
                        </div>
                      </div>

                      <script type="text/javascript">
                        function establecerID(id) {
                          id = Number(id);
                          var boton = document.getElementById('borrarModal');
                          var ruta = "/delete-user?id=";
                          ruta = ruta.concat(id);
                          boton.setAttribute("href", ruta)
                        };
                      </script>

                    </c:forEach>
                  </tbody>
                </table>
              </div>

              <c:choose>
                <c:when test="${rolUsuario == 'ADMIN'}">
                  <div class="container pb-1">
                    <div class="row">
                      <div class="col-md-12 d-flex justify-content-center">
                        <a type="button" class="btn btn-primary ml-auto" href="/download-csv">Descarga CSV</a>
                      </div>
                    </div>
                  </div>
                </c:when>
              </c:choose>

            </c:when>

            <c:otherwise>
              <b>No hay datos</b>
            </c:otherwise>

          </c:choose>
        </div>

        <div class="container p-2">
          <c:choose>
            <c:when test="${rolUsuario == 'ADMIN' || rolUsuario == 'UPDATE_USER'}">

              <div class="card">
                <h5 class="card-header">Crear usuario</h5>
                <div class="card-body">
                  <p class="card-text">Crea un nuevo usuario en la base de datos</p>
                  <a href="/create-user" class="btn btn-primary">Crear</a>
                </div>
              </div>

            </c:when>
          </c:choose>
        </div>

        <div class="container p-2">
          <c:choose>
            <c:when test="${rolUsuario == 'ADMIN'}">

              <div class="card">
                <h5 class="card-header">Registro de auditoría</h5>
                <div class="card-body">
                  <p class="card-text">Consulta el registro de auditoría con los últimos cambios que han realizado los
                    usuarios</p>
                  <a href="/list-auditoria" class="btn btn-primary">Acceder</a>
                </div>
              </div>

            </c:when>
          </c:choose>
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