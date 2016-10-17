<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	
<%-- header --%> 
	a{text-decoration:none;}
	a:hover{text-decoration:none;}
	a:active{text-decoration: none}
	
	header>div>a{
		font-size:40px; 
		color:#000000;
		text-shadow:2px 2px #000000;
		margin-left:10px;  
	} 
	header>div>a:hover{
		text-decoration:none; 
	} 
	
	#users{
		float:right;
	}
	#users>a{
		color:#000000;
	}
	#users>a:hover{
		text-decoration:none; 
	}
<%-- navbar --%> 
	.navbar {
    	margin-bottom: 0;
    	border-radius: 0;
    	background-color: #ff5555;
    }
    .navbar-header{
    	width:100%
    }
    #mobileNavbar .navbar-toggle{
    	background-color:#ffffff;
    }
    #mobileNavbar>form>a{
    	color: #ff5555; 
    }
    .navbar-default .navbar-toggle .icon-bar{
    	background-color:#ff5555;
    	padding-top:4px; 
    } 
    #mobileNavbar>form>input{
    	background-color: #ffffff; 
    }
    
    .nav{
    	margin-top:-10px;
    }
    #pcNavbar>ul>li>a{
    	color: #ffffff;
    }
    #pcNavbar>ul>li>a:hover{
    	background-color:#ffffff;
    	color:#ff5555;
    	font-size:17px; 
    }
<%-- carousel --%>
	.carousel-inner > .item > img,
  	.carousel-inner > .item > a > img {
    	width: 100%;
    	height:300px;
    	margin: auto;
  	}
<%-- main list --%>
	h3{
		width:100%
	}
	
	.container>.row>.col-sm-4>div{
		border:1px solid;
		border-color:#dddddd;
		font-family:고딕
	}
	.container>.row>.col-sm-4>div>div{
		margin-left:7px;margin-top:7px;
	}
  	
<%-- footer --%>
	#footer {
		background-color:#ddddff;  
	}  	
</style>
<title>admin Page</title> 

<!--header -->
	<header>
		<div class="contatiner-fluid">		
			<a href="admin">관리자 페이지</a>
		</div>
	</header>
<!-- navbar -->	
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header" id="mobileNavbar">
				<form action="main" method="get" autocomplete="on">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#pcNavbar"> 
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
					</button>
				</form>	
			</div>
		
			<div class="collapse navbar-collapse" id="pcNavbar">
				<ul class="nav navbar-nav">
					<li><a href="main">홈 <span class="glyphicon glyphicon-home"></span></a></li>
					<li><a href="javascript:void(0);">회원 관리</a></li>
					<li><a href="addProduct">상품 관리</a></li>
					<li><a href="boardList">게시판 관리</a></li>
					<li><a href="javascript:void(0);">매출 관리</a></li>
					<li><a href="javascript:void(0);">배송 관리</a></li>			
				</ul>
			</div>
		</div>
	</nav>
</head>

<body>

<div align="center">
		<br><br><h1>상품 추가</h1><br><br>
		
		<form name="asd" action="addProduct2">
			 			
			 		<h3>기존상품</h3>
						
							<c:if test="${empty pdList }">
								기존상품 추가 없음 
							</c:if>
							
							<c:if test="${not empty pdList}">
								<table border="1" id="old" style="width: 20%; height: 30%" class="text-center">
									<tr bgcolor="#D9E5FF">
										<td>상품번호</td>
										<td>수량</td>
									</tr>
									<c:forEach var="list" items="${pdList }" varStatus="status">
										<tr id="list_${status.getIndex() }"
										    onmouseover="this.style.backgroundColor='#F6F6F6'"
										    onmouseout="this.style.backgroundColor='#FFFFFF'">
										<td>${list.item_no }</td>
										<td>${list.volume }</td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
							
							<h3>새상품</h3>
							
							<c:if test="${empty new_pdList }">
								새 상품 추가 없음
							</c:if>
							
							<table border="1" id="new" style="width: 50%; height: 30%" class="text-center">
							
							<tr bgcolor="#D9E5FF">
								<td>상품이름</td>
								<td>카테고리</td>
								<td>가격</td>
								<td>수량</td>
								<td>이미지</td>
								<td>상품설명</td>
							</tr>	
							
							<c:if test="${not empty new_pdList}">
								<c:forEach var="newlist" items="${new_pdList }" varStatus="status2">
									<tr id="newlist_${status2.getIndex() }" 
									    onmouseover="this.style.backgroundColor='#F6F6F6'"
										onmouseout="this.style.backgroundColor='#FFFFFF'">
									<td>${newlist.item_name }</td>
									<td>${newlist.category }</td>
									<td>${newlist.price }원</td>
									<td>${newlist.volume }</td>
									<td>${newlist.img }</td>
									<td>${newlist.item_content }</td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
						
					<br><input type="submit" value="상품추가"><br><br>
					
		</form>
		
</div>
<!-- footer -->	
	<footer class="container-fluid text-left" id="footer">
		
		<div style="margin-left:40px;margin-bottom:15px;">
			<br>
			상호 : Flower  |  Tel : 112  |  Fax : 119<br>
			주소 : 대한민국 꽃밭 어디든<br>
			Copyright ⓒ <b>Java Study</b> All rights reserved. 
		</div>
	</footer>
</body>
</html>