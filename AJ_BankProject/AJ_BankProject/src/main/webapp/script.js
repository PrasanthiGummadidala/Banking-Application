document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('accountForm');

    form.addEventListener('submit', function(event) 
    {
		
        const username = document.getElementById('username').value;

        
        const lettersOnly = /^[A-Za-z]+$/;

        if (!lettersOnly.test(username)) 
        {
            alert("This Field must be char");
            event.preventDefault();
        }
    });
});