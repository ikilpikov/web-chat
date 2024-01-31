const logoutButton = document.getElementById('logout-button');

logoutButton.addEventListener('click', function () {
    window.location.href = 'chat?command=logout';
});

var messageInput = document.getElementById("message-input");
var savedMessage = localStorage.getItem("savedMessage");

if (savedMessage) {
    messageInput.value = savedMessage;
}

messageInput.addEventListener("input", function () {
    localStorage.setItem("savedMessage", messageInput.value);

});

var inputContainer = document.getElementById("input-container");

inputContainer.addEventListener("submit", function () {
    localStorage.removeItem("savedMessage");
});

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("message-input").focus();
});

const adminButton = document.getElementById('admin-button');

adminButton.addEventListener('click', function () {
    window.location.href = 'chat?command=show_admin_panel_page';
});
