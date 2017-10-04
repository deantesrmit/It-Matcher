<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/poppers.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>
<#include "/menu.html">
<#include "/banner.html">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-offset-5 col-md-3">
            <h4 id ="login">Login to IT Matcher</h4>
            <div class="form-login">
                <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="username" />
                </br>
                <input type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="password" />
                </br>
                <div class="wrapper">
                    <span class="group-btn">
                        <a href="#" class="btn btn-primary btn-md">Login<i class="fa fa-sign-in"></i></a>
                        <p><br/>Forgot my password</p>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/footer.html">
</body>
</html>