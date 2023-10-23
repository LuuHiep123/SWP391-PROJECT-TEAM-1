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

$(document).ready(function () {
    // Initialize the first DataTable
    $('#example').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
        select: {
            style: 'multi'
        }
    });

    // Initialize the second DataTable

    $('#example1').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
        select: {
            style: 'multi'
        }
    });
});

