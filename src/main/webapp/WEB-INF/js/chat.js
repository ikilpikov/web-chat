const sendButton = document.getElementById('send-button');
const messageInput = document.getElementById('message-input');

sendButton.addEventListener('click', function () {
    const messageText = messageInput.value.trim();
    if (messageText !== '') {
        // Здесь можно добавить логику отправки сообщения на сервер и обновления чата
        // После успешной отправки, можно вызвать addMessage("Твое имя", messageText);
        addMessage("Твое имя", messageText);
        messageInput.value = '';
    }
});

const logoutButton = document.getElementById('logout-button');

logoutButton.addEventListener('click', function () {
    window.location.href = 'chat?command=logout';
});

function addMessage(sender, text) {
    const messagesContainer = document.getElementById('messages-container');
    const messageElement = document.createElement('div');
    messageElement.classList.add('message');
    messageElement.innerHTML = `<span class="sender">${sender}:</span> ${text}`;
    messagesContainer.appendChild(messageElement);
}