<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 2018/9/20
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
    <link rel="icon" href="/exercise/images/icon.jpg">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/exercise/style/jumbotron-narrow.css">
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
    <div class="container-fluid all">
        <div class="header clearfix">
            <nav>
                <ul class="nav nav-pills pull-right">
                    <li role="presentation" class="active"><a href="/exercise/index.jsp">Index</a></li>
                    <li role="presentation"><a href="/exercise/register.jsp">Register</a></li>
                    <li role="presentation"><a href="/exercise/login.jsp">Login</a></li>
                </ul>
            </nav>
            <img src="/exercise/images/icon.jpg" class="text-muted headerIcon">
        </div>

        <div class="jumbotron">
            <h1>Jumbotron heading</h1>
            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p>
        </div>

        <%--<ul class="nav nav-tabs">--%>
            <%--<li role="presentation" class="active"><a href="#">Home</a></li>--%>
            <%--<li role="presentation"><a href="#">Profile</a></li>--%>
            <%--<li role="presentation"><a href="#">Messages</a></li>--%>
        <%--</ul>--%>
        <%--${sessionScope.newsList}--%>
        <div class="row marketing">
            <div class="col-lg-12">
                    <c:forEach items="${sessionScope.data.newsList}" var="news">
                        <div class="col-lg-6">
                            <div class="item" name="${news.newsId}">
                                <h4>${news.caption}</h4>
                                <p>${news.content}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>
        </div>

        <nav aria-label="Page navigation"  class="page">
            <ul class="pagination">
                <li onclick="getData(1)"><a>首页</a></li>
                <li onclick="getData(${sessionScope.data.pageInfo.page-1>0? sessionScope.data.pageInfo.page-1: 1})"><a aria-hidden="true">&laquo;</a></li>
                <li onclick="getData(${sessionScope.data.pageInfo.page})" class="active"><span>${sessionScope.data.pageInfo.page}</span></li>
                <li onclick="getData(${sessionScope.data.pageInfo.page+1<sessionScope.data.pageInfo.totalPageCount?sessionScope.data.pageInfo.page+1:sessionScope.data.pageInfo.totalPageCount})"><a>${sessionScope.data.pageInfo.page+1}</a></li>
                <li onclick="getData(${sessionScope.data.pageInfo.page+2<sessionScope.data.pageInfo.totalPageCount?sessionScope.data.pageInfo.page+2:sessionScope.data.pageInfo.totalPageCount})"><a>${sessionScope.data.pageInfo.page+2}</a></li>
                <li onclick="getData(${sessionScope.data.pageInfo.page+3<sessionScope.data.pageInfo.totalPageCount?sessionScope.data.pageInfo.page+3:sessionScope.data.pageInfo.totalPageCount})"><a>${sessionScope.data.pageInfo.page+3}</a></li>
                <li onclick="getData(${sessionScope.data.pageInfo.page+4<sessionScope.data.pageInfo.totalPageCount?sessionScope.data.pageInfo.page+4:sessionScope.data.pageInfo.totalPageCount})"><a>${sessionScope.data.pageInfo.page+4}</a></li>
                <li onclick="getData(${sessionScope.data.pageInfo.page+1>sessionScope.data.pageInfo.totalPageCount?sessionScope.data.pageInfo.page:sessionScope.data.pageInfo.page+1})"><a aria-hidden="true">&raquo;</a></li>
                <li onclick="getData(${sessionScope.data.pageInfo.totalPageCount})"><a>尾页</a></li>
            </ul>
        </nav>
        <footer class="footer company">
            <p>&copy; 2018 NewsCompany, Inc.</p>
        </footer>
    </div>

    <script>

        $(".row .col-lg-6").css({
            "padding":"0",
            "margin":"0"
        });

        $(".row .item").css({
            "margin":"10px",
            "padding":"20px 20px",
            "height": "170px",
            "border-radius": "5px",
            "background-color": "#eee",
        });

        $(".row p").css({
            "display": "-webkit-box",
            "overflow": "hidden",
            "white-space": "normal!important",
            "text-overflow": "ellipsis",
            "word-wrap": "break-word",
            "-webkit-line-clamp": "4",
            "-webkit-box-orient": "vertical",
            "text-align": "justify"
        })

        function getData(currentPage) {
            console.log("${sessionScope.data.pageInfo.condition}");
            $(location).attr("href","/exercise/servlet/getNewsList?currentPage="+currentPage+"&condition="+"${sessionScope.data.pageInfo.condition}");
            // 如何使用异步操作 同时又能将数据存储到session当中
        }

        $(".row .item").on("click",function (event) {
            $(location).attr("href","/exercise/servlet/getNewsDetail?newsId="+$(this).attr("name"))
        })

        $(".headerIcon").on("click",function (event) {
            $(location).attr('href', '/userInfo.jsp');
        });
    </script>
</body>
</html>
