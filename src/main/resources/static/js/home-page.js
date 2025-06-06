function changeLanguage(lang) {
    window.location.href = '/api/v1/games/change-language?lang=' + lang;
}

function clearFilter() {
    window.location = "/api/v1/games";
}

function goToGameDetails(id) {
    window.location.href = `/api/v1/games/${id}`;
}