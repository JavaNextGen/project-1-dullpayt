const url = "http://localhost:3030/"

document.getElementById("createbtn").addEventListener("click", createUserFunction);

async function createUserFunction() {
    
    //gather the user inpupt from the login inputs
    let usern = document.getElementById("ers_username").value;
    let userp = document.getElementById("ers_password").value;
    let userfn = document.getElementById("user_first_name").value;
    let userln = document.getElementById("user_last_name").value;
    let useremail = document.getElementById("user_email").value;
    let userrole = document.getElementById("user_role_id").value;
    
    //we want to send the user/pass as JSON, so we need a JS object to send
    let user = {
        ers_username:usern,
        ers_password:userp,
        user_first_name:userfn,
        user_last_name:userln,
        user_email:useremail,
        user_role_id:userrole
    }
    //This object will reflect our DTO in Java... this is the data we want to transfer

    console.log(user)


    //fetch
    //remember the second parameter fetch can take? It is essentailly for configuring our fetch request
    //fetch sens a GET by default, but this second parameter can change that and more!
    let response = await fetch (url + "user", {

        method: "POST",//send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(user),//turn our user object into JSON
        credentials: "include"
        //this last line ensure that the cookie is captured (so that we can have a user session)
        //future fetches will aslo require this "include" value to send the cookie back
    });
    
    console.log(user)
    console.log(response.status);//useful for debug :)

    //control flow based o successful/unsuccessful login
    if(response.status != 404) {
        //wipe our login row and welcome the user 
        let message = document.createElement("h2");
        message.innerText = "Employee Created Successfully"
        document.body.appendChild(message);
        setTimeout(() => {
            window.location.href="ERS.html"; 
        }, 3000);

    }else{
        let message = document.createElement("h2");
        message.innerText = "Employee could not be created"
        document.body.appendChild(message);
    }

}
