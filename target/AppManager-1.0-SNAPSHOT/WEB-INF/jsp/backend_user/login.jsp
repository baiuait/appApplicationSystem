<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-16
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login</title>

    <!-- Bootstrap -->
    <link href="statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="statics/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">
    <%--<link href="statics/css/animate.min.css" rel="stylesheet">--%>

    <!-- Custom Theme Style -->
    <link href="statics/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form method="post" action="backendUser/doLogin">
                    <h1>BACKEND USER LOGIN</h1>
                    <div style="color: red">
                        ${requestScope.loginMsg}
                    </div>
                    <div>
                        <input type="text" name="userCode" class="form-control" placeholder="Username" required="" />
                    </div>
                    <div>
                        <input type="password" name="userPassword" class="form-control" placeholder="Password" required="" />
                    </div>
                    <div>
                        <%--<a class="btn btn-default submit" href="index.html">Log in</a>--%>
                        <input type="submit" value="Log in" class="btn btn-default submit">
                        <a class="reset_pass" href="devUser/goLogin">Dev User Login</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">New to site?
                            <a href="#signup" class="to_register"> Create Account </a>
                        </p>
                        <div class="clearfix"></div>
                        <br />
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>