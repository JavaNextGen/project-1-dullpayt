const url = "http://localhost:3030/"

document.getElementById("newRequestButton").addEventListener("click", gotoRequest);

function gotoRequest(){
    window.location.href = "newRequest.html";
}
document.getElementById("showPreviousButton").addEventListener("click", getByAuthor);


async function getByAuthor() {
        let body = document.getElementById("requestBody")
        body.remove()
        let newbody = document.createElement("tbody")
        newbody.id = "requestBody"
        document.getElementById("requestTable").appendChild(newbody)
    
        let id = document.getElementById("employeeID").value
    
        let response = await fetch(url + "reimbursement/" + id, {credentials: "include"});
    
        console.log(response);
    
        if(response.status === 200){
            let i = 0;
    
            let data = await response.json(); 
            for(let reimbursement of data){
                
                let row = document.createElement("tr");
    
                let cell = document.createElement("td");
                cell.innerHTML = reimbursement.reimb_id;
                row.appendChild(cell);
    
                let cell2 = document.createElement("td");
                cell2.innerHTML = reimbursement.reimb_author;
                row.appendChild(cell2);
    
                let cell3 = document.createElement("td");
                cell3.innerHTML = reimbursement.reimb_amount;
                row.appendChild(cell3);
    
                let cell4 = document.createElement("td");
                if (reimbursement.reimb_type_id == 1){
                cell4.innerHTML = "TRAVEL";
                }
                else if ( reimbursement.reimb_type_id == 2){
                    cell4.innerHTML = "LODGING";
                }
                else if ( reimbursement.reimb_type_id == 3){
                    cell4.innerHTML = "FOOD";
                }
                else if ( reimbursement.reimb_type_id == 4){
                    cell4.innerHTML = "OTHER";
                }
                row.appendChild(cell4);
    
                let cell5 = document.createElement("td");
                if( reimbursement.reimb_status_id == 1){
                    cell5.innerHTML = "PENDING";
                }
                else if( reimbursement.reimb_status_id  == 2){
                    cell5.innerHTML = "APPROVED";
                }
                else if( reimbursement.reimb_status_id  == 3){
                    cell5.innerHTML = "DENIED";
                }
                row.appendChild(cell5);
    
                let cell6 = document.createElement("td");
                cell6.innerHTML = reimbursement.reimb_resolver;
                row.appendChild(cell6);
    
                newbody.appendChild(row);
                
            }
    
        }
    }
