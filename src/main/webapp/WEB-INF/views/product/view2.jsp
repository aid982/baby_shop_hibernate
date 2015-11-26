<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/zoomy.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.8.0.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/zoomy.js"/>"></script>
</br>
${product.name}
</br>
${product.price}

<a href="<c:url value="/resources/images/_${product.id}_large.jpg"/>" class="zoom"> <img
	src="<c:url value="/resources/images/_${product.id}.jpg"/>" alt="This is the Display Image" />
</a>
<script type="text/javascript">
	$(function() {
		$('.zoom').zoomy();
	}(jQuery))
</script>