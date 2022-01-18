const url = "http://localhost:3030/"

//add eventListeners to our buttons to give them functionality
//document.getElementById("getUserButton").addEventListener("click", getReimbursements);
//login button listener goes here
document.getElementById("loginButton").addEventListener("click", loginFunction);

// //remember, async returns a promise (which fetch requests return)
// async function getReimbursements() {
    
//     //we will send a fetch request to get our employee data
//     //by default, fetch
//     let response = await fetch(url + "users")//check Javalin handler
   
//     //logging the response in the console just to see the response object
//     console.log(response);


   
   
//     //control flow for if the request is successful
//     if(response.status === 200){

//         let data = await response.json(); //parse the json data from the response into a JS object

//         //loggging the actual data that has been parsed from JSON -> JS
//         console.log(data);


//         //For every Employee object we got back (stored in the data variable), put it in the table
//         for(let employee of data){

//             //create a table row
//             let row = document.createElement("tr");

//             //create a data cell for each employee field 
//             let cell = document.createElement("td");
//             //fill the cell with the approriate employee data
//             cell.innerHTML = employee.employee_id;
//             //add the td element (data cell) to the tr element (table row)
//             row.appendChild(cell);

//             //we will do this^^^ for every column in employees
            
//             let cell2 = document.createElement("td");
//             cell2.innerHTML = employee.f_name;
//             row.appendChild(cell2);

//             let cell3 = document.createElement("td");
//             cell3.innerHTML = employee.l_name;
//             row.appendChild(cell3);


//             let cell4 = document.createElement("td");
//             cell4.innerHTML = employee.role_id;
//             row.appendChild(cell4);


//             //append the tr called row that we created in the for loop to the table body
//             //a new row will be appended for every employee 
//             document.getElementById("employeeBody").appendChild(row);

//         }

//     }

// }
async function loginFunction() {
    
    //gather the user inpupt from the login inputs
    let usern = document.getElementById("ers_username").value;
    let userp = document.getElementById("ers_password").value;
    
    //we want to send the user/pass as JSON, so we need a JS object to send
    let user = {
        ers_username:usern,
        ers_password:userp
    }
    //This object will reflect our DTO in Java... this is the data we want to transfer

    console.log(user)


    //fetch
    //remember the second parameter fetch can take? It is essentailly for configuring our fetch request
    //fetch sens a GET by default, but this second parameter can change that and more!
    let response = await fetch (url + "login", {

        method: "POST",//send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(user),//turn our user object into JSON
        credentials: "include"
        //this last line ensure that the cookie is captured (so that we can have a user session)
        //future fetches will aslo require this "include" value to send the cookie back
    });
    
    console.log(user)
    console.log(response.status);//useful for debug :)

    //control flow based o successful/unsuccessful login
    if(response.status === 202) {
        window.location.href = "manager.html";
        document.getElementById("loginRow").innerText="Welcome!";
    }else if(response.status === 201){
        window.location.href = "employee.html";
    }   
    else {
        document.getElementById("loginRow").innerText="LOGIN FAILED! Refresh the page and try again!";

    }

}

