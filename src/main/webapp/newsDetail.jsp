<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 2018/9/20
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%--上一行非常重要--%>
<html>
<head>
    <title>NewsDetail</title>
    <link rel="icon" href="/exercise/images/icon.jpg">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/exercise/style/jumbotron-narrow.css">
    <link rel="stylesheet" href="https://unpkg.com/gitalk/dist/gitalk.css">
    <script src="https://unpkg.com/gitalk@latest/dist/gitalk.min.js"></script>
    <style>
        .all{
            width: 1024px;
        }

        .headerIcon{
            width: 50px;
            height: 50px;
            border-radius: 100%;
        }

        .news{
            margin: 30px auto;
        }

        .content{
            line-height: 25px;
            text-align: justify;
            text-indent: 2em;
            color: #0D3349;
        }

        .date{
            color: #00AA88;
        }

        .toOriginal{
            width: 18px;
            height: 18px;
        }

        .comment{
            margin: 50px auto;
        }

        p{
            text-align: justify;
        }


        .recommend{
            margin: 100px 50px 50px 0px;
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
            <img src="/exercise/images/icon.jpg" class="text-muted headerIcon img-rounded">
        </div>

        <div class="news center-block col-lg-10">
            <h3 class="text-center text-capitalize">${sessionScope.newsDetail.caption}</h3>

            <blockquote class="blockquote-reverse">
                <p class="content">${sessionScope.newsDetail.content}<a href="${sessionScope.newsDetail.originalUrl}"><img src="/exercise/images/url.png" class="toOriginal"></a></p>
                <footer class="date">${sessionScope.newsDetail.publishDate}</footer>
                <footer class="author">${sessionScope.newsDetail.author}</footer>
            </blockquote>
            <div id="gitalk-container"></div>

        </div>

        <div class="recommend"><h4>新闻推荐</h4></div>

        <%--<div class="col-lg-12">--%>
            <%--<footer class="footer company">--%>
                <%--&lt;%&ndash;<p>&copy; 2018 NewsCompany, Inc.</p>&ndash;%&gt;--%>
            <%--</footer>--%>
        <%--</div>--%>
    </div>

    <script>

        var gitalk = new Gitalk({

            // gitalk的主要参数
            clientID: "48889ba2756b65f6d497",
            clientSecret: "9c491602e3e441fe1e193f619efd1c865ae38285",
            repo: "newsSystem",
            owner: 'Fking1',
            admin: ['Fking1'],
            id: '${sessionScope.newsDetail.newsId}',

        });
        gitalk.render('gitalk-container');

        $(".headerIcon").on("click",function (event) {
            $(location).attr('href', '/userInfo.jsp');
        });
    </script>
</body>
</html>
