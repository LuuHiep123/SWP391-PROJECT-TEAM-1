/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


