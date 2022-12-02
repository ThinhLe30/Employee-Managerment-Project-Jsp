<%@ page import="com.ngthvu.quanlynhanvienproject.entity.EmployeeView" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ngthvu.quanlynhanvienproject.entity.Salary" %>
<%@ page import="com.ngthvu.quanlynhanvienproject.entity.Employee" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>${pageTitle}</title>
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&family=Varela+Round&display=swap"
          rel="stylesheet"
  />
  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
  />
  <link
          rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
  />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/index.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/form.css" />
  <script src="${pageContext.request.contextPath}/main.js"></script>
</head>

<body>
<div class="container">
  <p>Hello</p>
</div>
</body>

<script>
  function checkDuplicate(form) {
    $.ajax({
      method : 'POST',
      url: '${pageContext.request.contextPath}/employee/checkDuplicate',
      data: {
        phone: $('#phone').val(),
        id: $('#id').val(),
        email: $('#email').val()
      },
      success: function(response) {
        if(response === ("OK")) {
          form.submit();
          return true;
        } else {
          alert(response);
          return false;
        }
      },
      error: function(xhr, status, error) {
        alert(status);
        alert(error);
      }
    });
    return false;
  }

  function previewFile(input) {
    var file = $("input[type=file]").get(0).files[0];
    if(file) {
      var reader = new FileReader();
      reader.onload = function() {
        $(".avatar").attr("src", reader.result);
        $(".avatar").attr("hidden", false);
      }
      reader.readAsDataURL(file);
    }
  }
</script>

</html>