const url = "http://localhost:3030/"
document.getElementById("createReimbursement").addEventListener("click", createUser);

async function createUser() {
    //gather the user inputs from the login inputs
    let amnt = document.getElementById("reimb_amount").value;
    let desc = document.getElementById("reimb_description").value;
    let auth = document.getElementById("reimb_author").value;
    let type = document.getElementById("reimb_type_id").value;
    
    //we want to send the user/pass as JSON, so we need a JS object to send
    let reimbursement = {
        reimb_amount:amnt,
        reimb_description:desc,
        reimb_author: auth,
        reimb_status_id: 2,
        reimb_type_id:type
        
    
    }
    console.log(reimbursement)

    let response = await fetch (url + "reimbursement", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(reimbursement), //turn our user object into JSON
        credentials: "include"
    });
    if(response.status === 201) {
        //wipe our login row and welcome the user 
        let message = document.createElement("h2");
        message.innerText = "Reimbursement Created successfully"
        document.body.appendChild(message);
        setTimeout(() => {
            window.location.href="employee.html"; 
        }, 3000);

    }else{
        let message = document.createElement("h2");
        message.innerText = "Reimbursement could not be created"
        document.body.appendChild(message);
    }
        
}