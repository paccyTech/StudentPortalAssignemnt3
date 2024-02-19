<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration-Sign Up</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
  <div id="languageDropdown">
  <p>Change Language</p>
    <select id="languageSelector" onchange="setLanguage(this.value)">
        <option value="en">English</option>
        <option value="fr">French</option>
        <option value="rw">Kinyarwanda</option>
    </select>
</div>
<div class="container" id="loginPage">
    <h2>SignUp</h2>
    <form  id="signupForm" action="SignUpServlet" method="post" onsubmit="return validateForm()">
      <label for="email">Email:</label>
      <input type="text" id="email" name="email" required><br> <!-- Changed id and name attributes to "email" -->
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required><br>
      <label for="phone">Phone number:</label>
      <input type="text" id="phone" name="phone" required><br>
      <input type="submit" value="Sign Up">
    </form>
   
    
    
  </div>
 
  <script src="scripts.js"></script>

</body>
</html>
