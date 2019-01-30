<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" type="text/css" th:href="@{/webjars/bootstrap/3.3.7/css/bootstrap.min.css}"/>
    <link rel="stylesheet" type="text/css" th:href="@{/css/main.css}"/>

    <title>Forgot Password</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3><i class="glyphicon glyphicon-lock" style="font-size:2em;"></i></h3>
                        <h2 class="text-center">Reset password</h2>
                        <div class="panel-body">

                            <div th:if="${error}">
                                <div class="alert alert-danger">
                                    <span th:text="${error}"></span>
                                </div>
                            </div>

                            <form th:action="@{/reset-password}" th:object="${passwordResetForm}" method="post">

                                <p class="error-message"
                                   th:if="${#fields.hasGlobalErrors()}"
                                   th:each="error : ${#fields.errors('global')}"
                                   th:text="${error}">Validation error</p>

                                <input type="hidden" name="token" th:value="${token}"/>

                                <div class="form-group"
                                     th:classappend="${#fields.hasErrors('password')}? 'has-error':''">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-lock"></i>
                                        </span>
                                        <input id="password"
                                               class="form-control"
                                               placeholder="password"
                                               type="password"
                                               th:field="*{password}"/>
                                    </div>
                                    <p class="error-message"
                                       th:each="error: ${#fields.errors('password')}"
                                       th:text="${error}">Validation error</p>
                                </div>
                                <div class="form-group"
                                     th:classappend="${#fields.hasErrors('confirmPassword')}? 'has-error':''">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-lock"></i>
                                        </span>
                                        <input id="confirmPassword"
                                               class="form-control"
                                               placeholder="Confirm password"
                                               type="password"
                                               th:field="*{confirmPassword}"/>
                                    </div>
                                    <p class="error-message"
                                       th:each="error: ${#fields.errors('confirmPassword')}"
                                       th:text="${error}">Validation error</p>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-block btn-success">Reset password</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    New user? <a href="/" th:href="@{/registration}">Register</a>
                </div>
                <div class="col-md-12">
                    Already registered? <a href="/" th:href="@{/login}">Login</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" th:src="@{/webjars/jquery/3.2.1/jquery.min.js/}"></script>
<script type="text/javascript" th:src="@{/webjars/bootstrap/3.3.7/js/bootstrap.min.js}"></script>

</body>
</html>