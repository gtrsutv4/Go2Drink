<%@page import="com.g2d.domain.Customer" info="會員專區"%>
<%@page pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/subviews/header.jsp">
    <jsp:param name="sub_title" value="<%=this.getServletInfo()%>"/>
</jsp:include>
<div class="page-container">
    <div class="left">
        <img src="image/icon/會員.png" width="200">
        <p><a href="Customer.jsp">會員登入</a></p>
        <p><a href="product_1.jsp">會員註冊</a></p>
        <p><a href="jelly.jsp">忘記密碼</a></p>

    </div>
    <div class="right">
        <div id="main_content"> 							
            <p><img src="image/日本鮮果凍.jpg"> </p>			
        </div>  
    </div>
</div>
<jsp:include page="WEB-INF/subviews/footer.jsp"></jsp:include>