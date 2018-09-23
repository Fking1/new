<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 2018/9/12
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="icon" href="/images/icon.jpg">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style/jumbotron-narrow.css">
    <style>
        .all{
            width: 1024px;
        }

        .headerIcon{
            width: 50px;
            height: 50px;
            border-radius: 100%;
        }

        .page{
            text-align: center;
            margin: 30px auto
        }

        .company{
            text-align: center;
        }
    </style>
</head>
<body>
    <%--<div class="container-fluid all">--%>
        <%--<div class="header clearfix">--%>
            <%--<nav>--%>
                <%--<ul class="nav nav-pills pull-right">--%>
                    <%--<li role="presentation" class="active"><a href="/index.jsp">Index</a></li>--%>
                    <%--<li role="presentation"><a href="/register.jsp">Register</a></li>--%>
                    <%--<li role="presentation"><a href="/login.jsp">Login</a></li>--%>
                    <%--&lt;%&ndash;<li role="presentation"><a href="/collection.jsp">Collection</a></li>&ndash;%&gt;--%>
                <%--</ul>--%>
            <%--</nav>--%>
            <%--<img src="images/icon.jpg" class="text-muted headerIcon">--%>
        <%--</div>--%>

        <%--<div class="jumbotron">--%>
            <%--<h1>Jumbotron heading</h1>--%>
            <%--<p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>--%>
            <%--<p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p>--%>
        <%--</div>--%>

        <%--<ul class="nav nav-tabs">--%>
            <%--<li role="presentation" class="active"><a href="#">Home</a></li>--%>
            <%--<li role="presentation"><a href="#">Profile</a></li>--%>
            <%--<li role="presentation"><a href="#">Messages</a></li>--%>
        <%--</ul>--%>

        <%--<div class="row marketing">--%>
            <%--<div class="col-lg-6">--%>
                <%--<div class="item">--%>
                    <%--<h4></h4>--%>
                    <%--<p></p>--%>
                <%--</div>--%>
                <%--<div class="item">--%>
                    <%--<h4></h4>--%>
                    <%--<p></p>--%>
                <%--</div>--%>

                <%--<div class="item">--%>
                    <%--<h4></h4>--%>
                    <%--<p></p>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="col-lg-6">--%>
                <%--<div class="item">--%>
                    <%--<h4></h4>--%>
                    <%--<p></p>--%>
                <%--</div>--%>
                <%--<div class="item">--%>
                    <%--<h4></h4>--%>
                    <%--<p></p>--%>
                <%--</div>--%>

                <%--<div class="item">--%>
                    <%--<h4></h4>--%>
                    <%--<p></p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<nav aria-label="Page navigation"  class="page">--%>
            <%--<ul class="pagination">--%>
                <%--<li onclick="getData(-1,'first')"><a>首页</a></li>--%>
                <%--<li onclick="getData(0,'previous')"><a aria-hidden="true">&laquo;</a></li>--%>
                <%--<li onclick="getData(1,'jump')" class="active"><span>1</span></li>--%>
                <%--<li onclick="getData(2,'jump')"><span>2</span></li>--%>
                <%--<li onclick="getData(3,'jump')"><span>3</span></li>--%>
                <%--<li onclick="getData(4,'jump')"><span>4</span></li>--%>
                <%--<li onclick="getData(5,'jump')"><span>5</span></li>--%>
                <%--<li onclick="getData(6,'next')"><a aria-hidden="true">&raquo;</a></li>--%>
                <%--<li onclick="getData(7,'last')"><a>尾页</a></li>--%>
            <%--</ul>--%>
        <%--</nav>--%>
        <%--<li hidden><span class="currentPage">1</span></li>--%>
        <%--<li hidden><span class="first">1</span></li>--%>
        <%--<footer class="footer company">--%>
            <%--<p>&copy; 2018 NewsCompany, Inc.</p>--%>
        <%--</footer>--%>
    <%--</div>--%>

<script>
    $(function () {
        var condition = "and newsType='national'";
        $(location).attr("href","/exercise/servlet/getNewsList?currentPage=1&condition="+condition);
    });
</script>
</body>
</html>
