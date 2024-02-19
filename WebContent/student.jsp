<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student/Portal</title>
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
<div class="container" id="studentPage">
    <h2>Student Admission</h2>
    <form id="admissionForm" action="StudentServlet" method="post">
      <label for="picture">Upload Picture:</label>
      <input type="file" id="picture" name="picture" accept="image/*" required ><br>
      <label for="certificate">Upload Certificate (PDF):</label>
      <input type="file" id="certificate" name="certificate" accept=".pdf" required ><br>
      <input type="submit" value="Submit">
    </form>
    
  </div>
 

  <script src="scripts.js"></script>
</body>
</html>