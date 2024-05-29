<%@ page contentType="text/html; charset=UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html lang="es">

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
                <meta name="viewport" content="width=device-width,initial-scale=1">
                <title>Iniciar sesión</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
                    crossorigin="anonymous">
                <link rel="shortcut icon" type="image/png" href="/favicon.png">
            </head>

            <body>
                <section class="h-100">
                    <div class="container h-100">
                        <div class="row justify-content-sm-center h-100">
                            <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
                                <div class="text-center my-5">
                                    <img src="https://www.altia.es/themes/custom/rhythm_sub/logo.png" alt="logo"
                                        width="200">
                                </div>
                                <div class="card shadow-lg">
                                    <div class="card-body p-5">
                                        <h1 class="fs-4 card-title fw-bold mb-4">Iniciar sesión</h1>
                                        <form action="/login" method="POST" class="needs-validation" novalidate=""
                                            autocomplete="off">
                                            <div class="mb-3">
                                                <label class="mb-2 text-muted" for="email">Correo electrónico</label>
                                                <input id="email" type="email" class="form-control" name="username"
                                                    value="" required autofocus>
                                                <div class="invalid-feedback">
                                                    Correo electrónico incorrecto
                                                </div>
                                            </div>

                                            <div class="mb-3">
                                                <div class="mb-2 w-100">
                                                    <label class="text-muted" for="password">Contraseña</label>
                                                    <a href="forgot.html" class="float-end">
                                                        Recuperar contraseña
                                                    </a>
                                                </div>
                                                <input id="password" type="password" class="form-control"
                                                    name="password" required>
                                                <div class="invalid-feedback">
                                                    Es necesario introducir una contraseña
                                                </div>
                                            </div>

                                            <div class="d-flex align-items-center">
                                                <div class="form-check">
                                                    <input type="checkbox" name="remember" id="remember"
                                                        class="form-check-input">
                                                    <label for="remember" class="form-check-label">Recordar
                                                        contraseña</label>
                                                </div>
                                                <button type="submit" class="btn btn-primary ms-auto">
                                                    Iniciar sesión
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer py-3 border-0">
                                        <div class="text-center">
                                            ¿No tienes una cuenta? <a href="register.html" class="text-dark">Crear
                                                cuenta</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-center mt-5 text-muted">
                                    Copyright &copy; 1994-2023 &mdash; Altia
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <script>
                    (function () {
                        'use strict'

                        var forms = document.querySelectorAll('.needs-validation')

                        // Loop over them and prevent submission
                        Array.prototype.slice.call(forms)
                            .forEach(function (form) {
                                form.addEventListener('submit', function (event) {
                                    if (!form.checkValidity()) {
                                        event.preventDefault()
                                        event.stopPropagation()
                                    }

                                    form.classList.add('was-validated')
                                }, false)
                            })
                    })()</script>
            </body>

            </html>