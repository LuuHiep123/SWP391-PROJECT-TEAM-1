const showTextLink = document.querySelector('.show-text');
const hiddenText = document.getElementById('hiddenText');
let isTextVisible = false;

showTextLink.addEventListener('click', () => {
    if (!isTextVisible) {
        hiddenText.style.display = 'block';
        isTextVisible = true;
    } else {
        hiddenText.style.display = 'none';
        isTextVisible = false;
    }
});
