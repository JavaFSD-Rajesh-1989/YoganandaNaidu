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
            <h1>Register</h1>
            <h6>Please fill the below details</h6>
            <form id="register" action="UserServlet" method="post">
                <!-- Hidden field to pass task type -->
                <input type="hidden" name="taskType" value="register">

                <!-- Name input field -->
                <fieldset>
                    <legend>Name</legend>
                    <div class="password-container">
                        <i class="fa fa-user icon"></i>
                        <input type="text" id="name" name="name" class="icon-input" required>
                        <p class="error-message" id="nameError">Please enter your name</p>
                    </div>
                </fieldset>

                <!-- Email input field -->
                <fieldset>
                    <legend>Email</legend>
                    <div class="password-container">
                        <i class="fa fa-envelope icon"></i>
                        <input type="email" id="email" name="email" class="icon-input" required>
                        <p class="error-message" id="emailError">Please enter a valid email</p>
                    </div>
                </fieldset>

                <!-- Password input field -->
                <fieldset>
                    <legend>Create Password</legend>
                    <div class="password-container">
                        <i class="fa fa-lock icon"></i>
                        <input type="password" id="password" name="password" class="icon-input" required>
                        <i class="fa fa-eye toggle-password" id="togglePassword"></i>
                        <p class="error-message" id="passwordError">Please enter a password</p>
                    </div>
                </fieldset>

                <!-- Register button -->
                <button type="submit">REGISTER</button>
                <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
            </form>
        </div>
    </section>

</body>
</html>