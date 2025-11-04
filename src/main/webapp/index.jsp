<%@ page import="org.hibernate.Session" %>
<%@ page import="lk.jiat.webii.hp.util.HibernateUtil" %>
<%@ page import="lk.jiat.webii.hp.entity.City" %>
<%@ page import="org.hibernate.query.NativeQuery" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
// NativeQuery nativeQuery = hibernateSession.createNativeQuery("SELECT * FROM city", City.class);
// List<City> cities = nativeQuery.list(); Query<City> cityQuery = hibernateSession.createQuery("FROM City", City.class);
    Query<City> cityQuery = hibernateSession.createQuery("FROM City", City.class);
    List<City> cities = cityQuery.getResultList();
    application.setAttribute("cities", cities);
%>

<html>
<head>
    <title>Hibernate Student Portal</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="form-card form">
        <h1>Student Portal</h1>
        <h2>Register New Student</h2>

        <form id="studentForm">
            <label for="name">Student's Name</label>
            <input type="text" id="name" placeholder="Enter full name" required>

            <label for="email">Student's Email</label>
            <input type="email" id="email" placeholder="Enter email" required>

            <label for="lineOne">Address Line One</label>
            <input type="text" id="lineOne" placeholder="Street address" required>

            <label for="lineTwo">Address Line Two</label>
            <input type="text" id="lineTwo" placeholder="Optional">

            <label>Select City</label>
            <select id="cityId" required>
                <option value="0">Select City</option>
                <c:forEach items="${applicationScope.cities}" var="city">
                    <option value="${city.id}">${city.name}</option>
                </c:forEach>
            </select>


            <button type="button" onclick="submitData()">Register</button>
        </form>
    </div>

    <div class="info-panel">
        <h3>Welcome to the Portal</h3>
        <p>Register students easily with a calm and futuristic interface. All inputs are validated and backed by Hibernate ORM. Enjoy the smooth glassy UI with subtle neon highlights.</p>
        <p>This section can also display instructions, statistics, or additional info without breaking the balanced layout.</p>
    </div>
</div>


<script src="assets/js/script.js"></script>
</body>
</html>
