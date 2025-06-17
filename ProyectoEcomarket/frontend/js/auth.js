function loginUser(event) {
  event.preventDefault();
 
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
 
  fetch('http://localhost:8080/api/login', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ username, password })
  })
  .then(response => {
    if (response.ok) return response.json();
    else throw new Error('Credenciales incorrectas');
  })
  .then(data => {
    localStorage.setItem('token', data.token); // Guardar token JWT si lo usas
    window.location.href = 'home.html';
  })
  .catch(error => alert(error.message));
}