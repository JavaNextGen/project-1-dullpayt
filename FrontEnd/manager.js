const url = "http://localhost:3030/" //putting our base URL in a variable for cleaner code below
var id;
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints
var formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  
    // These options are needed to round to whole numbers if that's what you want.
    //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
    //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
  });
//add eventListeners to our buttons to give them functionality
document.getElementById("getReimbursementButton").addEventListener("click", getReimbursements);
document.getElementById("CreateEmployeeButton").addEventListener("click", postUsers);
document.getElementById("CreateReimbursementButton").addEventListener("click", postReimbursements);


async function getReimbursements() {
    
    //we will send a fetch request to get our employee data
    //by default, fetch requests send GET requests
    let response = await fetch(url + "reimbursement");

    //logging the response in the console just to see the response object
    console.log(response);

    //control flow for is the request is successful
    if(response.status === 201){

        let data = await response.json(); //parse the JSON data from the response into a JS object

        //logging the actual employee data that has been parsed from JSON -> JS
        console.log(data);


        //For every Employee object we got back (stored in the data variable), put it in the table
        for(let reimbursement of data){

            //create a table row
            let row = document.createElement("tr");

            //create a data cell for each employee field
            let cell = document.createElement("td");
            //fill the cell with the appropriate employee data
            cell.innerHTML = reimbursement.reimb_id;
           
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we'll do this^ for every column in employees

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.reimb_amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.reimb_description;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.reimb_author;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            if( reimbursement.reimb_status_id == 1){
                cell5.innerHTML = "PENDING";
            }
            else if( reimbursement.reimb_status_id == 2){
                cell5.innerHTML = "APPROVED";
            }
            else if( reimbursement.reimb_status_id == 3){
                cell5.innerHTML = "DENIED";
            }
            row.appendChild(cell5);

            let cell6 = document.createElement("td");//ADD TO EMPLOYEES DEFINITELY
            if (reimbursement.reimb_type_id == 1){
                cell6.innerHTML = "LODGING";
                }
                else if ( reimbursement.reimb_type_id == 2){
                    cell6.innerHTML = "TRAVEL";
                }
                else if ( reimbursement.reimb_type_id == 3){
                    cell6.innerHTML = "FOOD";
                }
                else if ( reimbursement.reimb_type_id == 4){
                    cell6.innerHTML = "OTHER";
                }
            row.appendChild(cell6);
            let cell7 = document.createElement("td");
            if(reimbursement.reimb_status_id === 1){
            
            let abtn = document.createElement("button");
            
            abtn.innerHTML = "Approve"
            abtn.id = reimbursement.reimb_id
            abtn.style.background = "Yellow"
            abtn.addEventListener("click", function(){
                approveFunction(abtn.id);
            }, false);
            
            let dbtn = document.createElement("button");
            
            dbtn.innerHTML = "Deny"
            dbtn.id = reimbursement.reimb_id
            dbtn.style.background = "Red"
                dbtn.addEventListener("click", function(){
                denyFunction(dbtn.id);
            }, false);
            
            cell7.appendChild(abtn);
            cell7.appendChild(dbtn);
            row.appendChild(cell7);

            

            }
            //append the tr called row that we created in the for loop to the table body
            //a new row will be appended for every employee object that comes in
            document.getElementById("reimbursementBody").appendChild(row);
        }
      
    }


}

async function postUsers() {
    window.location.href = "create.html";
    
    }
    
async function postReimbursements() {
    let response = await fetch(url + "reimbursement");
    console.log(response);
    if(response.status === 201){
        let data = await response.json(); 

        console.log(data);
    }    
}
async function approveFunction(id){


    //we want to send the user/pass as JSON, so we need a JS object to send
    let reimbursement = {
        "reimb_status_id":2,
        "reimb_resolver": 1,
        "reimb_id" : id 
    }
    console.log(reimbursement);
    console.log(JSON.stringify(reimbursement));
    let response = await fetch (url + "reimbursement", {
        
        method: "PUT",//send a Put request (would be a GET if we didn't do this...)
        body: JSON.stringify(reimbursement),//turn our user object into JSON
        credentials: "include"
        //this last line ensure that the cookie is captured (so that we can have a user session)
        //future fetches will aslo require this "include" value to send the cookie back
    });
    var btn = document.getElementById(id);
    btn.remove()
    var btn2 = document.getElementById(id);
    btn2.remove()
}
async function denyFunction(id){

    let reimbursement = {
        "reimb_status_id":3,
        "reimb_resolver": 1,
        "reimb_id" : id 
    }
    console.log(reimbursement);
    let response = await fetch (url + "reimbursement", {

        method: "PUT",//send a Put request (would be a GET if we didn't do this...)
        body: JSON.stringify(reimbursement),//turn our user object into JSON
        credentials: "include"
        //this last line ensure that the cookie is captured (so that we can have a user session)
        //future fetches will aslo require this "include" value to send the cookie back
    });
    var btn = document.getElementById(id);
    btn.remove()
    var btn2 = document.getElementById(id);
    btn2.remove()
}
function gotoRequest(){
    window.location.href = "managerRequest.html";


}
document.getElementById("CreateReimbursementButton").addEventListener("click", gotoRequest);