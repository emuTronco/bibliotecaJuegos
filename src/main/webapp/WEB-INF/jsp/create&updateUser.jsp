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

        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

        <link rel="stylesheet" href="/styles.css">
        <link href="/custom.css" rel="stylesheet">
        <title>Spring Boot + JSP</title>

      </head>

      <body>

        <div class="container">

          <div class="title">
            <h1>${titulo}</h1>
          </div>

        </div>

        <div class="container">
          <c:choose>
            <c:when test="${not empty mensajeError}">

              <div class="alert alert-danger" role="alert">
                ${mensajeError}
              </div>

            </c:when>
          </c:choose>
        </div>

        <div class="container">
          <!-- <form>
            <div class="mb-3">
              <label for="examplename_errEmail1" class="form-label">Nombre</label>
              <name_err type="text" class="form-control" id="examplename_errEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
              <label for="examplename_errEmail1" class="form-label">Apellido</label>
              <name_err type="text" class="form-control" id="examplename_errEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
              <label for="examplename_errEmail1" class="form-label">Direccion de correo electrónico</label>
              <name_err type="email" class="form-control" id="examplename_errEmail1" aria-describedby="emailHelp">
              <div id="emailHelp" class="form-text">Nunca compartiremos tu dirreción de correo con terceros</div>
            </div>
            <button type="submit" class="btn btn-primary">Aceptar</button>
          </form> -->
          <form action="${formulario}" method="post" modelAttribute="user" class="needs-validation" novalidate>
            <div class="form-floating mb-3">
              <input type="text" name="name" class="form-control" id="user_name" aria-describedby="userName"
                placeholder="Name" value="${user.name}" required>
              <label for="user_name">Nombre</label>
              <div class="invalid-feedback">
                Introduce un nombre</div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" name="surname" class="form-control" id="user_surname" aria-describedby="userSurname"
                placeholder="Password" value="${user.surname}" required>
              <label for="user_surname">Apellido</label>
              <div class="invalid-feedback">
                Introduce un apellido</div>
            </div>
            <div class="form-floating mb-3">
              <input type="email" name="email" class="form-control" placeholder="name@example.com" id="user_email"
                aria-describedby="userEmail" value="${user.email}" required>
              <label for="user_email">Direccion de correo electrónico</label>
              <div class="invalid-feedback">
                Introduce un correo electrónico</div>
              <div id="emailHelp" class="form-text">Nunca compartiremos tu dirreción de correo con terceros</div>
            </div>

            <div class="mb-3">
              <label for="user_enambled" class="form-label">Habilitado</label>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="enabled" id="enabled1" value="true">
                <label class="form-check-label" for="enabled1">
                  Si
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="enabled" id="enabled2" value="false">
                <label class="form-check-label" for="enabled2">
                  No
                </label>
              </div>
            </div>

            <button type="submit" class="btn btn-primary">Aceptar</button>
          </form>
        </div>

        <div class="container p-4">
          <div class="row">
              <div class="col-md-12 d-flex justify-content-end">
                  <a type="button" class="btn btn-primary ml-auto" href="/list-users">Atrás</a>
              </div>
          </div>
      </div>

        <footer class="footer">
          <div class="container">
            <p class="text-muted"><a href="https://www.altia.es/">altia.es</a></p>
          </div>
        </footer>

      </body>

      <script>

        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (() => {
          'use strict'

          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          const forms = document.querySelectorAll('.needs-validation')

          // Loop over them and prevent submission
          Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
              if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
              }

              form.classList.add('was-validated')
            }, false)
          })
        })()

        var enabledJSP = "${user.enabled}";
        var enabledTrue = document.getElementById('enabled1');
        var enabledFalse = document.getElementById('enabled2');
        if (enabledJSP == "true") {
          enabledTrue.checked = true;
        } else {
          enabledFalse.checked = true;
        }
        /*         var select = document.getElementById('select');
                select.addEventListener('change', function (evt) {
                  this.setCustomValidity('');
                });
                select.addEventListener('invalid', function (evt) {
                  // Required
                  if (this.validity.valueMissing) {
                    this.setCustomValidity('Por favor seleccione el nivel!');
                  }
                }); */

        /*         var name_err = document.getElementById('user_name');
                name_err.addEventListener('user_name', function (evt) {
                  this.setCustomValidity('');
                });
                name_err.addEventListener('invalid', function (evt) {
                  // Required
                  if (this.validity.valueMissing) {
                    this.setCustomValidity('Por favor introduzca un nombre');
                  }
                });
        
                var surname_err = document.getElementById('user_surname');
                surname_err.addEventListener('user_surname', function (evt) {
                  this.setCustomValidity('');
                });
                surname_err.addEventListener('invalid', function (evt) {
                  // Required
                  if (this.validity.valueMissing) {
                    this.setCustomValidity('Por favor introduzca un apellido');
                  }
                }); */
      </script>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>

      </html>