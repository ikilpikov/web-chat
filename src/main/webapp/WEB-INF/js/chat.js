const logoutButton = document.getElementById('logout-button');

logoutButton.addEventListener('click', function () {
    window.location.href = 'chat?command=logout';
});

const adminButton = document.getElementById('admin-button');

adminButton.addEventListener('click', function () {
    window.location.href = 'chat?command=show_admin_panel_page';
});