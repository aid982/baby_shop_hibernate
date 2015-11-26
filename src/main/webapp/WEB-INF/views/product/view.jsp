<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/zoomy.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.8.0.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/zoomy.js"/>"></script>

<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title" id="myModalLabel">Modal title</h4>
</div>
<div class="modal-body">

	<div class="thumbnail">
		<a href="<c:url value="/resources/images/_${product.id}_large.jpg"/>"
			class="zoom"> <img
			src="<c:url value="/resources/images/_${product.id}.jpg" />"
			alt="...">
		</a>
		<div class="caption">
			<h3>${product.name}</h3>
			<p>Цена : ${product.price} грн.</p>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function() {
			$('.zoom').zoomy();
		}(jQuery))
	</script>
	

	<%="<script type=\"text/javascript\">"%>
	<%="$(#Modal_cont\").load(\""%>
	<c:url value="/products/121G088"/> 
	<%="\");"%>
	<%="</script>\""%>


	

</div>
<div class="modal-footer"></div>



