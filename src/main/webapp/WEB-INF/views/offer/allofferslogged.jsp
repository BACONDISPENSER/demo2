<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 04.02.2020
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">

<head>

    <%@ include file="/WEB-INF/views/html/headerMetaTags.jsp" %>

    <title>Give it away!</title>

    <%@ include file="/WEB-INF/views/html/headerLinks.jsp" %>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%@ include file="/WEB-INF/views/html/sidebar.jsp" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <%@ include file="/WEB-INF/views/html/topBar.jsp" %>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Wszystkie Ogłoszenia: ${allOffersLogged.size()} wyników</h1>
                    <%--<a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>--%>
                </div>

                <!-- Content Row -->
                <div class="row">
                    <c:forEach items="${allOffersLogged}" var="alllogged">
                        <div class="col-lg-12">

                            <div class="card mb-4 py-3 border-left-primary">
                                <div class="card-body">
                                    <div class="offer-div">
                                        <div class="offer-inside-div-photo">
                                            <img src="/img/defaultuserimg.png" width="80" height="80"><br>
                                            ${alllogged.created}
                                        </div>
                                        <div class="offer-inside-div">
                                            <h11 class="m-0 font-weight-bold text-primary">${alllogged.title}</h11>
                                            <br>
                                            <b>Lokalizacja:</b><br>
                                                ${alllogged.city}
                                            <c:if test="${not empty alllogged.adress}">
                                                Szczegóły:
                                                ${alllogged.adress}
                                            </c:if>

                                        </div>
                                        <div class="offer-inside-longer-div">
                                            <h11 class="m-0 font-weight-bold text-primary">Opis:</h11>
                                            <br>
                                                ${alllogged.description}

                                        </div>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@ include file="/WEB-INF/views/html/footer.jsp" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<%@ include file="/WEB-INF/views/html/scrollTop.jsp" %>

<!-- Logout Modal-->
<%@ include file="/WEB-INF/views/html/logout.jsp" %>

<%@ include file="/WEB-INF/views/html/scripts.jsp" %>

</body>

</html>