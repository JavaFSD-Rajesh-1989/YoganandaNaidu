<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


   <section class="main-content">
        <div class="form-container">
    <h2>Sign In</h2>
    <form id="loginForm" action="BuyerServlet" method="post">
        <input type="hidden" name="taskType" value="login">
        
                <fieldset>
                    <legend>Email</legend>
                    <div>
                        <i class="fa fa-envelope icon"></i>
                        <input type="email" id="email" name="email"  class="icon-input" required autocomplete="email">
                    </div>
                </fieldset>
        
                <fieldset>
                    <legend>Password</legend>
                    <div class="password-container">
                        <i class="fa fa-lock icon"></i>
                        <input type="password" id="password" name="password"  class="icon-input" required autocomplete="new-password">
                        <i class="fa fa-eye toggle-password" id="togglePassword"></i>
                    </div>
                </fieldset>

                
        <div class="forgot-password"> <a href="forgotPassword.jsp">Forgot Password?</a></div>
        <button id="submit-button" type="submit">Login</button>
        
        <p style="color:red;" id="errorMessage">
            <% if (request.getAttribute("error") != null) { %>
                <%= request.getAttribute("error") %>
            <% } %>
        </p>
    </form>
    <div class="options">
        Not a member..? <a href="register.jsp">Register here!</a>
    </div>
</div>
</section>

</body>
</html>