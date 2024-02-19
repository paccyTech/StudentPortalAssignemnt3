function validateForm() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var phone = document.getElementById("phone").value;
    
    // Email validation
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email.match(emailPattern)) {
        alert("Please enter a valid email address.");
        return false;
    }
    
    // Password validation
    if (password.length < 6) {
        alert("Password must be at least 6 characters long.");
        return false;
    }
    
    // Phone number validation
    var phonePattern = /^\d{10}$/;
    if (!phone.match(phonePattern)) {
        alert("Please enter a 10-digit phone number.");
        return false;
    }
    
    return true; // Form submission allowed if all validations pass
}

function setLanguage(language) {
    // English
    if (language === 'en') {
        document.getElementById('email').setAttribute('placeholder', 'Email');
        document.querySelector('label[for="email"]').innerText = 'Email:';
        
        document.getElementById('password').setAttribute('placeholder', 'Password');
        document.querySelector('label[for="password"]').innerText = 'Password:';
        
        document.getElementById('phone').setAttribute('placeholder', 'Phone number');
        document.querySelector('label[for="phone"]').innerText = 'Phone number:';
        
        document.getElementById('signupForm').setAttribute('action', 'SignUpServlet');
        document.getElementById('languageDropdown').getElementsByTagName('p')[0].innerText = 'Change Language';
        document.getElementById('loginPage').getElementsByTagName('h2')[0].innerText = 'SignUp';
        document.getElementById('signupForm').getElementsByTagName('input')[4].value = 'Sign Up';
    }
    // French
    else if (language === 'fr') {
        document.getElementById('email').setAttribute('placeholder', 'Adresse e-mail');
        document.querySelector('label[for="email"]').innerText = 'Adresse e-mail :';
        
        document.getElementById('password').setAttribute('placeholder', 'Mot de passe');
        document.querySelector('label[for="password"]').innerText = 'Mot de passe :';
        
        document.getElementById('phone').setAttribute('placeholder', 'Numéro de téléphone');
        document.querySelector('label[for="phone"]').innerText = 'Numéro de téléphone :';
        
        document.getElementById('signupForm').setAttribute('action', 'SignUpServlet');
        document.getElementById('languageDropdown').getElementsByTagName('p')[0].innerText = 'Changer de langue';
        document.getElementById('loginPage').getElementsByTagName('h2')[0].innerText = 'S\'inscrire';
        document.getElementById('signupForm').getElementsByTagName('input')[4].value = 'S\'inscrire';
    }
    // Kinyarwanda
    else if (language === 'rw') {
        document.getElementById('email').setAttribute('placeholder', 'Andika Imeli');
        document.querySelector('label[for="email"]').innerText = 'Andika Imeli :';
        
        document.getElementById('password').setAttribute('placeholder', 'Ijambo ryi ibanga');
        document.querySelector('label[for="password"]').innerText = 'Ijambo ryi ibanga:';
        
        document.getElementById('phone').setAttribute('placeholder', 'Nimero ya telefoni');
        document.querySelector('label[for="phone"]').innerText = 'Nimero ya telefoni :';
        
        document.getElementById('signupForm').setAttribute('action', 'SignUpServlet');
        document.getElementById('languageDropdown').getElementsByTagName('p')[0].innerText = 'Hindura ururimi';
        document.getElementById('loginPage').getElementsByTagName('h2')[0].innerText = 'Kwiyandikisha';
        document.getElementById('signupForm').getElementsByTagName('input')[4].value = 'Kwiyandikisha';
    }
}
