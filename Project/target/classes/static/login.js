const inputs = document.querySelectorAll(".input-field");

const toggle_btn=document.querySelectorAll(".toggle");
const main=document.querySelector("main");

inputs.forEach((inp) => {
    inp.addEventListener("focus" , ()  => {
    inp.classList.add("active");
    });
    inp.addEventListener("blur", () => {
        if (inp.value != "") return;
        inp.classList.remove("active");
    });
    });



    toggle_btn.forEach((btn) => {
        btn.addEventListener("click", () => {
            main.classList.toggle("guest-login-form");
        });
    });



function stu_login() {
    const rollno = document.getElementById('rollno').value;
    const password = document.getElementById('password').value;

    if (rollno && name) {
        // send Details in json to the EndPoint to : )
        fetch('/student', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({rollno: rollno, password: password}) // JSON payload : )
        })

    }
}


function guest_login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (email && password) {
        // send Details in json to the EndPoint to : )
        fetch('/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({email: email, password: password}) // JSON payload : )
        })

    }
}
    