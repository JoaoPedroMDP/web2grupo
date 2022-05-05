<%-- 
    Document   : register
    Created on : Mar 3, 2022, 8:42:03 PM
    Author     : Ludimilla
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
        <script type="text/javascript" >
            $(document).ready(function () {
                $("#state").change(function () {
                    $("#city").prop("disabled", false);
                    getCidades();
                });
                $('.cpf').mask('000.000.000-00', {reverse: true});
                $('.zip_code').mask('00000-000', {reverse: true});

            });

            function getCidades() {
                var estadoId = $("#state").val();
                var url = "AJAXServlet";
                $.ajax({
                    url: url,
                    // URL da sua Servlet
                    data: {
                        estadoId: estadoId
                    },
                    // ParÃĒmetro passado para a Servlet
                    dataType: 'json',
                    success: function (data) {
                        //             Se sucesso, limpa e preenche a combo de cidade  
                        $("#city").empty();
                        $.each(data, function (i, obj) {
                            $("#city").append('<option value=' + obj.name + '>' + obj.name + '</option>');
                        });
                    },
                    error: function (request, textStatus, errorThrown) {
                        alert(request.status + ', Error: ' + request.statusText);
                    }
                });
            }
        </script>

    </head>
    <body>
        <!-- Page content (Conteúdo da página)-->

        <div class="container-fluid">
            <!--                    <section class="vh-100 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">-->
            <section class="vh-100 bg-image" style="background-image: linear-gradient(315deg, #63d471 0%, #233329 74%);">

                <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                    <div class="container h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-22 col-md-18 col-lg-15 col-xl-14">
                                <div class="card" style="border-radius: 15px;">
                                    <div class="card-body p-5">
                                       
                                        <c:if test="${requestScope.action == 'update'}">
                                            <h2 class="text-uppercase text-center mb-5">Update account</h2>
                                        </c:if> 
                                        <c:if test="${requestScope.action == 'new'}">
                                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>
                                        </c:if>     
                                        <form action="/web2grupo/UserServlet?id=12&action=${requestScope.action}" name = "cadastroCliente" method="POST">

                                            <div class="row mb-4">
                                                <div class="col">
                                                    <div class="form-outline">
                                                        <input type="text" id="form6Example1"name="name" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${user.name}"/></c:if>" />
                                                            <label class="form-label" for="form6Example1">Name</label>
                                                        </div>
                                                    </div>  
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example2" name="surname" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${user.surname}"/></c:if>"/>
                                                            <label class="form-label" for="form6Example2">Surname</label>
                                                        </div>
                                                    </div>
                                                </div>        

                                            <c:if test="${requestScope.action == 'new'}">
                                                <div class="row mb-4">
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example1"name="email" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${user.email}"/></c:if>" />
                                                                <label class="form-label" for="form6Example1">Email</label>
                                                            </div>
                                                        </div>  
                                                    </div>   
                                            </c:if> 
                                            <div class="row mb-4">
                                                <c:if test="${requestScope.action == 'new'}">
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example1"name="cpf"   maxlength="11"type="text" class="form-control cpf" placeholder="Ex.: 000.000.000-00"  value="<c:if test="${requestScope.action == 'update'}"><c:out value="${user.cpf}"/></c:if>"/>
                                                                <label class="form-label" for="form6Example1">CPF</label>
                                                            </div>
                                                        </div>  
                                                </c:if> 
                                                <div class="col">
                                                    <div class="form-outline">
                                                        <input type="text" id="form6Example2" name="phone" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${user.phone}"/></c:if>"/>
                                                            <label class="form-label" for="form6Example2">Phone</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row mb-4">
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example1"name="password" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${user.password}"/></c:if>" />
                                                            <label class="form-label" for="form6Example1">Password</label>
                                                        </div>
                                                    </div>  
                                                </div>   
                                                <div class="row mb-4">
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example1"name="street" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${address.number}"/></c:if>"/>
                                                            <label class="form-label" for="form6Example1">Street</label>
                                                        </div>
                                                    </div>  
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example2" name="number" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${address.number}"/></c:if>" />
                                                            <label class="form-label" for="form6Example2">Number</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row mb-4">
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example1" name="complement"  value="<c:if test="${requestScope.action == 'update'}"><c:out value="${address.complement}"/></c:if>" />
                                                            <label class="form-label" for="form6Example1">Complement</label>
                                                        </div>
                                                    </div>  
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example2" name="district" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${address.district}"/></c:if>"  />
                                                            <label class="form-label" for="form6Example2">District</label>
                                                        </div>
                                                    </div>
                                                    <div class="col">
                                                        <div class="form-outline">
                                                            <input type="text" id="form6Example2" name="zip_code" maxlength="8" type="text" class="form-control cep" placeholder="Ex.: 00000-000" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${address.zip_code}"/></c:if>" />
                                                            <label class="form-label" for="form6Example2">zip code</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row mb-4">
                                                    <div class="col">
                                                        <select name="state" id="state" type="text" class="form-control" form="form" required>
                                                        <c:choose> 
                                                            <c:when test="${requestScope.action == 'update'}">
                                                                <option selected> <c:out value="${state.name}"/></option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option  selected>Selecionar Estado</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:forEach items="${states}" var="state">
                                                            <option value="${state.id}"><c:out value="${state.name}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                    <label for="state" class="form-label">State</label> 
                                                </div>
                                                <div class="col">
                                                    <select name="city" id="city" type="text" class="form-control" form="form" required <c:if test="${requestScope.action == 'new'}"> disabled </c:if>>
                                                        <option selected value="<c:if test="${requestScope.action == 'update'}">${city.name}</c:if>"><c:choose> <c:when test="${requestScope.action == 'update'}"><c:out value="${changes.cidade}"/></c:when> <c:otherwise>Selecionar Cidade</c:otherwise></c:choose></option>
                                                        </select>
                                                        <label for="city" class="form-label">Cidade</label>
                                                    </div> 
                                                </div>
                                            <c:if test="${requestScope.action == 'new'}">
                                                <div class="d-flex justify-content-center">
                                                    <button class="nav-link active bg-sucess text-white" type="submit">Salvar</button>
                                                    <!--                                        <button class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" type="submit" onclick="window.location = 'profile.jsp'" >Register</button>-->
                                                </div>

                                                <p class="text-center text-muted mt-3 mb-0">Have already an account? <a href="login.jsp" class="fw-bold text-body"><u>Login here</u></a></p>
                                                <p class="text-center text-muted mt-3 mb-0"> <a href="index.jsp" ><u>Voltar</u></a></p>
                                                    </c:if>
                                                    <c:if test="${requestScope.action == 'update'}">
                                                <button class="nav-link active bg-sucess text-white" type="submit">Alterar</button>
                                            </c:if>  
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
