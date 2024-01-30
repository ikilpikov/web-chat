const logoutButton = document.getElementById('logout-button');

logoutButton.addEventListener('click', function () {
    window.location.href = 'chat?command=logout';
});
