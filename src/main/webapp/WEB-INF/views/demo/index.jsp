<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 10/08/2020
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>List Ajax</title>
    <link rel="stylesheet"
          href="<c:url value="/resources/theme1/css/bootstrap.min.css" />">
    <script type="text/javascript"
            src="<c:url value="/resources/assets/js/jquery-2.1.4.min.js" />"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#comboboxCountry').on('change', function () {
                var countryId = $('#comboboxCountry option:selected').val();
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/demo/loadStates/' + countryId + '.html',
                    success: function (result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for (var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>'
                        }
                        $('#comboboxState').html(s);


                    }
                });

            });

        });
    </script>
</head>
<body>
<h1>Thanh Cong</h1>
<form class="form-group" action="" method="post">
    <table class="table">
        <h2 class="center">Country</h2>
        <td>
            <div class="input-group mb-3">
                <select class="custom-select" id="comboboxCountry">
                    <c:forEach var="country" items="${countries}">
                        <option value="${country.id}">${country.name}</option>
                    </c:forEach>
                </select>
            </div>
        </td>
        <br>
        <h2 class="center">State</h2>
        <td>
            <div class="input-group mb-3">
                <select class="custom-select" id="comboboxState">

                </select>
            </div>
        </td>
    </table>
</form>
</body>
</html>
